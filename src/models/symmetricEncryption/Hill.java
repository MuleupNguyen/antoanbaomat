package models.symmetricEncryption;

import utils.Alphabet;

import java.util.*;

public class Hill {

    static String language;
    static int sizeLang = 0;

    public Hill(String language) {
        this.language = language;
        if (language.equals("English")) {
            this.sizeLang = Alphabet.sizeEnglish2;
        }
        if (language.equals("Việt Nam")) {
            this.sizeLang = Alphabet.sizeVN2;
        }
    }

    public String createKey() {

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (true) {
            for (int i = 0; i < 4; i++) {
                sb.append(valueInLang(random.nextInt(sizeLang)));

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

    public String valueInLang(int index) {
        if (language.equals("English")) {
            return Alphabet.valueInEnglish2(index);
        }
        if (language.equals("Việt Nam")) {
            return Alphabet.valueInVN2(index);
        }
        return "";
    }

    public int indexInLang(char s) {
        if (language.equals("English")) {
            return Alphabet.indexInEnglish2(s);
        }
        if (language.equals("Việt Nam")) {
            return Alphabet.indexInVN2(s);
        }
        return 0;
    }

    public int[][] keyInverse(int[][] keyMatrix) {
        //tìm detK
        int detK = keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0];
        //det(K))^-1
        int detKInverse = modInverse(detK, sizeLang); // Tính định thức nghịch đảo
        if (detKInverse == -1) {
            return null;
        }
        // kiểm tra K có khả nghịch không
        if (findGCD(detK, sizeLang) != 1) {
            return null;
        }

        int[][] pk = {{keyMatrix[1][1], (-keyMatrix[0][1] + sizeLang)},
        {(-keyMatrix[1][0] + sizeLang), keyMatrix[0][0]}};

        // ma trận nghịch đảo của k
        int[][] key = new int[2][2];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                key[i][j] = (pk[i][j] * detKInverse) % sizeLang;
            }
        }
        return key;
    }

    public int[][] convertStringToMatrix(String s) {
        int[][] result = new int[2][2];
        for (int i = 0; i < s.length(); i++) {

            int number = indexInLang(s.charAt(i));
            if (i <= 1) {
                result[0][i] = number;
            } else {
                result[1][i - 2] = number;
            }
        }
        return result;
    }

    public boolean checkKey(int[][] keyMatrix) {
        //tìm detK
        int detK = keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0];
        //det(K))^-1
        int detKInverse = modInverse(detK, sizeLang); // Tính định thức nghịch đảo
        if (detKInverse == -1) {
            return false;
        }
        // kiểm tra K có khả nghịch không
        return findGCD(detK, sizeLang) == 1;
    }

    public String encrypt(String input, int[][] keyMatrix) {
        if (input.isEmpty()) {
            return "";
        }
        StringBuilder encryptedText = new StringBuilder();
        // thêm kí tự l vào cuối chuỗi nếu chuỗi lẻ
        int i = 0;
        Queue<Character> queueNotLetter = new LinkedList<>();
        Queue<Character> queue = new LinkedList();
        while (true) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                queue.add(c);
            } else {
                queueNotLetter.add(c);
            }
            // Trường hợp vị lẻ ở cuối
            if (queue.size() == 1 && input.length() - 1 == i) {
                queue.add('q');
            }
            if (queue.isEmpty()) {
                encryptedText.append(queueNotLetter.poll());

            } // Trường hợp đủ hai kí tự
            else if (queue.size() == 2) {
                char c1 = queue.poll();
                char c2 = queue.poll();
                int char1 = indexInLang(c1);
                int char2 = indexInLang(c2);
                String s1 = valueInLang((char1 * keyMatrix[0][0] + char2 * keyMatrix[1][0]) % sizeLang);
                String s2 = valueInLang((char1 * keyMatrix[0][1] + char2 * keyMatrix[1][1]) % sizeLang);
                if (queueNotLetter.isEmpty()) {
                    encryptedText.append(s1);
                    encryptedText.append(s2);
                } else {
                    encryptedText.append(s1);
                    while (!queueNotLetter.isEmpty()) {
                        encryptedText.append(queueNotLetter.poll());

                    }
                    encryptedText.append(s2);

                }
            }

            if (i == input.length() - 1) {
                break;
            }
            i++;

        }

        return encryptedText.toString();
    }

    public String decrypt(String encryptedText, int[][] keyMatrix) {
        String decryptedText = null;

        int[][] key = keyInverse(keyMatrix);
        decryptedText = encrypt(encryptedText, key);
        //xóa kí tự l cuối nếu có
        if ("q".equals(decryptedText.charAt(decryptedText.length() - 1) + "")) {
            decryptedText = decryptedText.substring(0, decryptedText.length() - 1);
        }

        return decryptedText;
    }

    public int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return -1; // Không có nghịch đảo
    }

    // Hàm tìm ước chung lớn nhất sử dụng thuật toán Euclid
    public int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
