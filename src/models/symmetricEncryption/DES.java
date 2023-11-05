package models.symmetricEncryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.spec.IvParameterSpec;

public class DES {

    private SecretKey key;
    private int keySize;
    private String paddingMode;

    public void setPaddingMode(String padding, String mode) {
        this.paddingMode = "/" + mode + "/" + padding + "Padding";
    }

    public SecretKey createKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        key = keyGenerator.generateKey();
        return key;
    }

    public void setKey(String s) {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(s);
            key = new SecretKeySpec(keyBytes, "DES");
        } catch (IllegalArgumentException e) {
            key = null;
            System.out.println("Khóa không hợp lệ.");
        }
    }

    public byte[] encrypt(String text) throws Exception {
        if (key == null) {
            return new byte[]{};
        }
        Cipher cipher = Cipher.getInstance("DES" + paddingMode);
        if(paddingMode.contains("ECB")) cipher.init(Cipher.ENCRYPT_MODE, key);
        else cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(new byte[8]));
        byte[] plainText = text.getBytes("UTF-8");
        byte[] cipherText = cipher.doFinal(plainText);
        return cipherText;
    }

    public String encryptBase64(String text) throws Exception {
        System.out.println("encrypt: " + paddingMode);
        if (key == null) {
            return "";
        }
        Cipher cipher = Cipher.getInstance("DES" + paddingMode);
        if(paddingMode.contains("ECB")) cipher.init(Cipher.ENCRYPT_MODE, key);
        else cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(new byte[8]));
        
        byte[] plainText = text.getBytes("UTF-8");
        byte[] cipherText = cipher.doFinal(plainText);
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public void encryptFile(String sourceFile, String desFile) throws Exception {

        if (key == null) {
            throw new FileNotFoundException("key not found");
        }
        File file = new File(sourceFile);
        if (file.isFile()) {
            Cipher cipher = Cipher.getInstance("DES" + paddingMode);
        if(paddingMode.contains("ECB")) cipher.init(Cipher.ENCRYPT_MODE, key);
        else cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(new byte[8]));
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(desFile);
            byte[] input = new byte[64];
            int bytesRead;
            while ((bytesRead = fis.read(input)) != -1) {
                byte[] output = cipher.update(input);
                if (output != null) {
                    fos.write(output);
                }
            }
            fos.flush();
            fis.close();
            fos.close();
        }
    }

    public void decryptFile(String sourceFile, String desFile) throws Exception {
        if (key == null) {
            throw new FileNotFoundException("key not found");
        }
        File file = new File(sourceFile);
        if (file.isFile()) {
            Cipher cipher = Cipher.getInstance("DES" + paddingMode);
        if(paddingMode.contains("ECB")) cipher.init(Cipher.DECRYPT_MODE, key);
        else cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(new byte[8]));
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(desFile);
            byte[] input = new byte[64];
            int bytesRead;
            while ((bytesRead = fis.read(input)) != -1) {
                byte[] output = cipher.update(input);
                if (output != null) {
                    fos.write(output);
                }
            }
            fos.flush();
            fis.close();
            fos.close();
        }
    }

    public String decrypt(byte[] text) throws Exception {

        if (key == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("DES" + paddingMode);
        if(paddingMode.contains("ECB")) cipher.init(Cipher.DECRYPT_MODE, key);
        else cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(new byte[8]));

        byte[] plainText = cipher.doFinal(text);
        String output = new String(plainText, "UTF-8");
        return output;
    }

    public String decryptBase64(String text) throws Exception {
        System.out.println("decrypt: " + paddingMode);
        if (key == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("DES" + paddingMode);
        if(paddingMode.contains("ECB")) cipher.init(Cipher.DECRYPT_MODE, key);
        else cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(new byte[8]));

        byte[] p = Base64.getDecoder().decode(text.getBytes());
        return new String(cipher.doFinal(p), "UTF-8");
    }

    public String getKey() {
        if (key != null) {
            byte[] keyBytes = key.getEncoded();
            return Base64.getEncoder().encodeToString(keyBytes);
        } else {
            return null;
        }
    }
}
