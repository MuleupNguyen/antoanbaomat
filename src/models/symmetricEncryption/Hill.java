package models.symmetricEncryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import utils.Alphabet;

import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

public class Hill {

    public static String createKey() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (true) {
            for (int i = 0; i < 4; i++) {

                sb.append(Alphabet.valueInEnglish(random.nextInt(Alphabet.sizeEnglish)));
            }
            int[][] keyArray = convertStringToMatrix(sb.toString());
            if (checkKey(keyArray)) {
                break;
            } else {
                sb.setLength(0);
            }
        }
        return sb.toString();
    }

    public static int[][] convertStringToMatrix(String s) {
        int[][] result = new int[2][2];
        for (int i = 0; i < s.length(); i++) {

            int number = Alphabet.indexInEnglish(s.charAt(i));
            if (i <= 1) {
                result[0][i] = number;
            } else {
                result[1][i - 2] = number;
            }
        }
        return result;
    }

    public static boolean checkKey(int[][] keyMatrix) {
        //tìm detK
        int detK = keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0];
        //det(K))^-1
        int detKInverse = modInverse(detK, Alphabet.sizeEnglish); // Tính định thức nghịch đảo
        if (detKInverse == -1) {
            return false;
        }
        // kiểm tra K có khả nghịch không
        return findGCD(detK, Alphabet.sizeEnglish) == 1;
    }

    public static String encrypt(String input, int[][] keyMatrix) {
        StringBuilder encryptedText = new StringBuilder();
        // thêm kí tự l vào cuối chuỗi nếu chuỗi lẻ
        if (input.length() % 2 != 0) {
            input = input + "l";
        }

        String newText = input.replace("\n", "ppppp");
        for (int i = 0; i < newText.length(); i += 2) {
            int char1 = Alphabet.indexInEnglish(newText.charAt(i));
            int char2 = Alphabet.indexInEnglish(newText.charAt(i + 1));
            String s1 = Alphabet.valueInEnglish((char1 * keyMatrix[0][0] + char2 * keyMatrix[1][0]) % Alphabet.sizeEnglish);
            String s2 = Alphabet.valueInEnglish((char1 * keyMatrix[0][1] + char2 * keyMatrix[1][1]) % Alphabet.sizeEnglish);
            encryptedText.append(s1);
            encryptedText.append(s2);
        }
        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText, int[][] keyMatrix) {
        String decryptedText = null;
        //tìm detK
        int detK = keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0];
        //det(K))^-1
        int detKInverse = modInverse(detK, Alphabet.sizeEnglish); // Tính định thức nghịch đảo
        if (detKInverse == -1) {
            return null;
        }
        // kiểm tra K có khả nghịch không
        if (findGCD(detK, Alphabet.sizeEnglish) != 1) {
            return null;
        }

        int[][] pk = {{keyMatrix[1][1], (-keyMatrix[0][1] + Alphabet.sizeEnglish)},
        {(-keyMatrix[1][0] + Alphabet.sizeEnglish), keyMatrix[0][0]}};

        // ma trận nghịch đảo của k
        int[][] key = new int[2][2];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                key[i][j] = (pk[i][j] * detKInverse) % Alphabet.sizeEnglish;
            }
        }
        decryptedText = encrypt(encryptedText, key);
        //xóa kí tự l cuối nếu có
        if ("l".equals(decryptedText.charAt(decryptedText.length() - 1) + "")) {
            decryptedText = decryptedText.substring(0, decryptedText.length() - 1);
        }

        String newText = decryptedText.replace("ppppp", "\n");
        return newText;
    }

    public static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return -1; // Không có nghịch đảo
    }

    // Hàm tìm ước chung lớn nhất sử dụng thuật toán Euclid
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void encryptFile(String sourceFile, String desFile, String key) throws Exception {
        if (key == null) {
            throw new FileNotFoundException("Key not found");
        }

        int[][] keyMatrix = convertStringToMatrix(key);

        File file = new File(sourceFile);
        if (file.isFile()) {
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(desFile);

            byte[] input = new byte[64];
            int bytesRead;
            int keyIndex = 0;

            while ((bytesRead = fis.read(input)) != -1) {
                String content = new String(input, 0, bytesRead);
                String encryptedContent = encrypt(content, keyMatrix);
                fos.write(encryptedContent.getBytes());
            }

            fos.flush();
            fos.close();
            fis.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Hill hill = new Hill();
        hill.encryptFile("D://file.rar", "D://file-copy.rar", "PSkK");
    }

}
