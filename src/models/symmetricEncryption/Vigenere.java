package models.symmetricEncryption;

import utils.Alphabet;

import java.util.Random;

public class Vigenere {

    public static String createKeyEnglish(int size) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            sb.append(Alphabet.valueInEnglish2(random.nextInt(Alphabet.sizeEnglish2)));
        }
        return sb.toString();

    }

    public static String createKeyVN(int size) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            sb.append(Alphabet.valueInVN2(random.nextInt(Alphabet.sizeVN2)));
        }
        return sb.toString();

    }

    public static String encryptEnglish(String text, String key) {
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

    public static String decryptEnglish(String text, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                int k = Alphabet.indexInEnglish2(key.charAt(j % key.length()));
                int index = Alphabet.indexInEnglish2(c);
                if(index -k < 0) index += Alphabet.sizeEnglish2;

                String character = Alphabet.valueInEnglish2((index - k) % Alphabet.sizeEnglish2);
                result.append(character);
                j++;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String encryptVN(String text, String key) {
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

    public static String decryptVN(String text, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                int k = Alphabet.indexInVN2(key.charAt(j % key.length()));
                int index = Alphabet.indexInVN2(c);
                if(index -k < 0) index += Alphabet.sizeVN2;

                String character = Alphabet.valueInVN2((index - k) % Alphabet.sizeVN2);
                result.append(character);
                j++;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Vigenere vigenere = new Vigenere();
        String key = vigenere.createKeyEnglish(100);
        String text = "Hello How are you to day timestamp";
        String textEncrypt = vigenere.encryptEnglish(text, key);
        String textDecrypt = vigenere.decryptEnglish(textEncrypt, key);
        System.out.println(key);
        System.out.println(textEncrypt);
        System.out.println(textDecrypt);

    }
}