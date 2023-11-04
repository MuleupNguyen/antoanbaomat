package models.symmetricEncryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import utils.Alphabet;

import java.util.Random;
import javax.crypto.Cipher;

public class Vigenere {

    public String createKeyEnglish(int size) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            sb.append(Alphabet.valueInEnglish2(random.nextInt(Alphabet.sizeEnglish2)));
        }
        return sb.toString();

    }

    public String createKeyVN(int size) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            sb.append(Alphabet.valueInVN2(random.nextInt(Alphabet.sizeVN2)));
        }
        return sb.toString();

    }

    public String encryptEnglish(String text, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                int k = Alphabet.indexInEnglish2(key.charAt(j % key.length()));
                int index = Alphabet.indexInEnglish2(c);
                String character = Alphabet.valueInEnglish2(((index + k) % Alphabet.sizeEnglish2));
                result.append(character);
                j++;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public void encryptFile(String sourceFile, String desFile, String key) throws Exception {
        if (key == null) {
            throw new FileNotFoundException("Key not found");
        }

        File file = new File(sourceFile);
        if (file.isFile()) {
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(desFile);

            byte[] input = new byte[64];
            int bytesRead;
            int keyIndex = 0;

            while ((bytesRead = fis.read(input)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    byte b = input[i];
                    int k = Alphabet.indexInEnglish2(key.charAt(keyIndex % key.length()));

                    // Mã hóa byte sử dụng thuật toán Vigenère
                    byte encryptedByte = (byte) ((b + k) % 256);
                    fos.write(encryptedByte);
                    keyIndex++;
                }
            }
            fos.flush();
            fos.close();
            fis.close();
        }
    }

    public void decryptFile(String sourceFile, String desFile, String key) throws Exception {
        if (key == null) {
            throw new FileNotFoundException("Key not found");
        }

        File file = new File(sourceFile);
        if (file.isFile()) {
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(desFile);

            byte[] input = new byte[64];
            int bytesRead;
            int keyIndex = 0;

            while ((bytesRead = fis.read(input)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    byte b = input[i];
                    int k = Alphabet.indexInEnglish2(key.charAt(keyIndex % key.length()));

                    // Giải mã byte sử dụng thuật toán Vigenère
                    byte decryptedByte = (byte) ((b - k) % 256);
                    fos.write(decryptedByte);
                    keyIndex++;
                }
            }
            fos.flush();
            fos.close();
            fis.close();
        }
    }

    public String decryptEnglish(String text, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                int k = Alphabet.indexInEnglish2(key.charAt(j % key.length()));
                int index = Alphabet.indexInEnglish2(c);
                if (index - k < 0) {
                    index += Alphabet.sizeEnglish2;
                }

                String character = Alphabet.valueInEnglish2((index - k) % Alphabet.sizeEnglish2);
                result.append(character);
                j++;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public String encryptVN(String text, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                int k = Alphabet.indexInVN2(key.charAt(j % key.length()));
                int index = Alphabet.indexInVN2(c);
                String character = Alphabet.valueInVN2(((index + k) % Alphabet.sizeVN2));
                result.append(character);
                j++;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public String decryptVN(String text, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                int k = Alphabet.indexInVN2(key.charAt(j % key.length()));
                int index = Alphabet.indexInVN2(c);
                if (index - k < 0) {
                    index += Alphabet.sizeVN2;
                }

                String character = Alphabet.valueInVN2((index - k) % Alphabet.sizeVN2);
                result.append(character);
                j++;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        Vigenere vigenere = new Vigenere();
        String key = vigenere.createKeyEnglish(100);
        System.out.println(key);

    }
}
