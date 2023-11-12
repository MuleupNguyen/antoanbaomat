package models.asymmetricEncryption;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSA {

    KeyPair keyPair;
    PublicKey publicKey;
    PrivateKey privateKey;

    public void genKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        keyPair = keyPairGenerator.generateKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();

    }

    public String getPublicKeyAsString() {
        // Lấy publicKey từ đối tượng RSA của bạn
        PublicKey publicKey = this.publicKey;

        // Chuyển publicKey thành dạng byte[]
        byte[] publicKeyBytes = publicKey.getEncoded();

        // Chuyển publicKey thành chuỗi để chia sẻ
        String publicKeyString = Base64.getEncoder().encodeToString(publicKeyBytes);

        return publicKeyString;
    }

    public String getPrivateKeyAsString() {
        // Lấy publicKey từ đối tượng RSA của bạn
        PrivateKey privateKey = this.privateKey;

        // Chuyển privateKey thành dạng byte[]
        byte[] privateKeyBytes = privateKey.getEncoded();

        // Chuyển publicKey thành chuỗi để chia sẻ
        String privateKeyString = Base64.getEncoder().encodeToString(privateKeyBytes);

        return privateKeyString;
    }

    // Hàm để thiết lập PublicKey từ chuỗi
    public void setKey(String publicKeyString, String privateKeyString) throws Exception {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyString);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        // Chuyển khóa công khai
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicK = keyFactory.generatePublic(publicKeySpec);
        this.publicKey = publicK;

        // Chuyển khóa riêng tư
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        PrivateKey privateK = keyFactory.generatePrivate(privateKeySpec);
        this.privateKey = privateK;
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] output = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(output);
    }

    public String decrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] output = cipher.doFinal(Base64.getDecoder().decode(data));
        return new String(output, StandardCharsets.UTF_8);
    }

    public void fileEncrypt(String inputPath, String outputPath) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        byte[] iv = new byte[16];
        IvParameterSpec spec = new IvParameterSpec(iv);
        SecretKey secretKey = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, spec);

        CipherInputStream inputStream = new CipherInputStream(new BufferedInputStream(new FileInputStream(inputPath)), cipher);
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outputPath)));

        String keyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        dataOutputStream.writeUTF(encrypt(keyString));
        dataOutputStream.writeLong(new File(inputPath).length());
        dataOutputStream.writeUTF(Base64.getEncoder().encodeToString(iv));

        byte[] buff = new byte[1024];
        int i;
        while ((i = inputStream.read(buff)) != -1) {
            dataOutputStream.write(buff, 0, i);
        }
        inputStream.close();
        dataOutputStream.flush();
        dataOutputStream.close();
    }

    public void fileDecrypt(String inputPath, String outputPath) throws Exception {
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(inputPath)));
        String keyString = dis.readUTF();
        long size = dis.readLong();
        byte[] iv = Base64.getDecoder().decode(dis.readUTF());

        SecretKey secretKey = new SecretKeySpec(Base64.getDecoder().decode(decrypt(keyString)), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        CipherInputStream cis = new CipherInputStream(dis, cipher);
        BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(outputPath));

        byte[] buff = new byte[1024];
        int i;
        while ((i = cis.read(buff)) != -1) {
            bof.write(buff, 0, i);
        }
        cis.close();
        bof.close();
    }

    public static void main(String[] args) throws Exception {
        RSA rsa = new RSA();
//        rsa.genKey();
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6AV/TxgMJj/vp+EERR2zTR2K6aqP2ZgPyUaw0eT3IR0/jqRWPW+KlAKtJCvQCNStuqVeKdrfv9utk+nJUxedoxImEFq11tIQwnYQZtzZYuoFYCTCbBnLKSQbaE35sC2s+4mJG67kbvwPVvo8d3e3tEnnquNr2dQA0WV8GTdLcXjukMPqLESwLb5udY2V2MLIypXWq0Fi8PqUkkTboR1FdXewH0tneQme/tG9PPjuAZ07IjaWixzPNfEXkcsiwUa9W4Q5uwH7OAYrqXH3HHpQQRO+uXjQPYOyR85Ogf9kTt3uqPWnNEY9awI0/zTZCw3kIxm+lzhaLzApuNED6rnIIQIDAQAB";
        String privateKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDoBX9PGAwmP++n4QRFHbNNHYrpqo/ZmA/JRrDR5PchHT+OpFY9b4qUAq0kK9AI1K26pV4p2t+/262T6clTF52jEiYQWrXW0hDCdhBm3Nli6gVgJMJsGcspJBtoTfmwLaz7iYkbruRu/A9W+jx3d7e0Seeq42vZ1ADRZXwZN0txeO6Qw+osRLAtvm51jZXYwsjKldarQWLw+pSSRNuhHUV1d7AfS2d5CZ7+0b08+O4BnTsiNpaLHM818ReRyyLBRr1bhDm7Afs4BiupcfccelBBE765eNA9g7JHzk6B/2RO3e6o9ac0Rj1rAjT/NNkLDeQjGb6XOFovMCm40QPqucghAgMBAAECggEAbLDuk7HTNzPqY/2gT3R7Y1u8kHwLSUbX1lVcTedx8bxO4taPY9ZV18JtM62mlgxzmiUPuJHFEY6qgMkbO+arPRIqbKzh1FGx8jb2tgkteQ3iGMj/nz5yEsLMaA9nMaYkC+3BIgvLDUbdNMSjAOA/WaDpev9wramH/JALE5D4sZ2ttqMET++HcuxAzDtY3IR4qDJOvohmc1GgDq3qHZgGTVRdPzs10ctXNFJ0uZosPNUlyFlIH6Bo6l0fYI4m5SKzdot/uifzqQYzM3arPxBQDG88jndKMvAuf3eWcL+oDt2SM7Aeg9cVrNog1YaSYaHDQGa3YUOajVUMRAdasr01hQKBgQD9mMwLZ4avHhqmxdn3tfwXnxq4J6cg1OYdvgJEKleQkH/26gwbXCMuN4OAQIndYldhUS4P+bk70r/JH40BiHUDTfv/mJox7pZaWI/VHg+sT+mXW2z7+129zxbz5DAbHPODsePPDgogsacwhHOSsL1aQyWxpgjhIEnRG/1OINg3awKBgQDqOFw9s9/wR8CAB5aOq0hlVYP7xvnzbhae5sFQO3nitiIWJvWo4OlmlVgeczVJ8wE4Td5Jig4ToIN3vbwnakDQw82zfMFxeXNzi0mGLtmmWHwJr1B9theAL5ZCX6dfBVMU/jz2AoQcW5DaeRvhsnnsaM4NyvZBdSqXedEcXA49owKBgQDCT9nIw0KH2+E/+EnTbDYFQ3wNrxR4K6lHENhbsrX1p0LlxuAP9sFeIFs6YjlA0KFzh+hrhUVReWJKkUpR6mT+azqz1hIQQGgkQcez3JzVw0WRHBSd3zUswwkrR6U0oTJVrnCHrpJECtu4aUTFGXd9OgYf4MDc/wiQmYm126TQkQKBgQDhXE1UiUhFV6SfC64PpDrKVdfiX/eMBDb7uafzXObP/tMZYW8piQ7KR5Q76Doz5v8bf8EMHSuiMuWMRyFNA21N8bhwpO80EdnGKRUbaOS+q5DdeLQH4TcHfcIkJwlR4juojV92jcEzz962d6UeKq4pjEYG+2yqWuQaT3mmweRp5QKBgQC/bxeht1L9A6nuItHffpMxkYQoGQbP+1wBCqio69CfkbrPffkM1d87VHkbQ95Aefs3Vv5VE8Yquuf6ixztL1WRT9qCK2gIoIVcfy14hpXA7L/HKxKhNXR+mUyCb9awpVAF+WwukEutQQ6H29PL+EZ1F2bo4TIGVOt8qEquGlSVcQ==";
        rsa.setKey(publicKey, privateKey);
        System.out.println(rsa.getPublicKeyAsString());
        System.out.println(rsa.getPrivateKeyAsString());
        String planText = rsa.encrypt("Below is the tool for encryption and decryption");
        System.out.println(planText);
        System.out.println(rsa.decrypt(planText));
        System.out.println();
    }
}
