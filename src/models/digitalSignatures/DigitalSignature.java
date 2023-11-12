package models.digitalSignatures;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class DigitalSignature {

    PublicKey publicKey;
    PrivateKey privateKey;

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

    public void setPrivateKey(String privateKeyString) throws Exception {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyString);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        // Chuyển khóa riêng tư
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        PrivateKey privateK = keyFactory.generatePrivate(privateKeySpec);
        this.privateKey = privateK;
    }

    public void setPublicKey(String publicKeyString) throws Exception {

        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        // Chuyển khóa công khai
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicK = keyFactory.generatePublic(publicKeySpec);
        this.publicKey = publicK;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    private static byte[] sign(String filePath, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(privateKey);

        FileInputStream fis = new FileInputStream(filePath);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) >= 0) {
            signature.update(buffer, 0, len);
        }
        fis.close();

        return signature.sign();
    }

    private static boolean verify(String filePath, byte[] signature, PublicKey publicKey) throws Exception {
        Signature sig = Signature.getInstance("SHA1withRSA");
        sig.initVerify(publicKey);

        FileInputStream fis = new FileInputStream(filePath);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) >= 0) {
            sig.update(buffer, 0, len);
        }
        fis.close();

        return sig.verify(signature);
    }

    public static void main(String[] args) throws Exception {
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDDyL8OVoh9JmTWtwOhxuGDvpNoSkw8WSsohGlpd5nttL3l8xcpHT/DNsyZRzqXPZ0ZVRWlssVDu6Uw2RKTV9x3GOWuJhHF4EwQ5Zd/zTWS3Kun4Eoh/U0aRSKyXqcNnVrsfk4bWnKegrwobA4KD/F4SRS2mlUQvzHWKo1j4VAF7DTHJK2J9EsXojgIivIc6/MDL+lUviHKUJDQHwXcoOZhcIa1GdCYK+tlFVh2KsOvL8YtuhMFxGh+HPVo9lym9D0Tps56eGli9Z/kQgHux4hzlq1kYs46cGMCTWhW0+paAsjFF+6RCXbrFchLbFzALEOjuZUsXNg/bZoNMHkoAU1XAgMBAAECggEAC4bdrMfueEPS6wtSZOtzKpEFV74MF/99+YA2PpXik6qxBYFW6z5EG0e2Kw4VBoODpNKsGBna4F6DXslg/RjOq5plJ2gpYreOcu45ibY4wcFJP/SGGNMzf2jznoHRHw2VJVhYW+bq2adD0bNu7iu7IURYOloCyR4gnoXZ1jgVQIvpwNttmNFVaa0CI0No5WTyC5vf7/nv8O/TNsTxbEQS93j/DoeLD+uKUi8TAl4vdgYfqWuhzcOBam0AqJbWH4mcDUCSfqjOkeIIpsdl2zCSFSSHTCe0cJABOupa7tZoHzQcNrE2w/2q5LCKMUjgMl7w3qIGLjECbi5ku4p7oTK4UQKBgQDgytF5YyUrgoomabyy/B47QyNwHyzRbUmaJ8Cq3tWsdfK1WJpekvke361TdQQOeIdz2lkPr+Xi/S40iPUbBhjgC1ujAXOiEQPv9284ppboPgS+WE0cIe3Jv26qPLK8GyR44SDFtF1j5g4+mWM8j22Dpnf7TCWt5+cNlLJAgmXQsQKBgQDe9vjXlMisI1Bo6j0zkEbwE0DRde68avnAHTp7a9Sh0PSCvQawDqVlvBVOH2z7ECMvF64o5Q8K3Z/18lEoQkwDxYpQ2ApvoUFNJZR6OURHlrHZxVNTZpqyR4I7Ub0yyHTs4XL3SYTWdEw/f3mE0o5u8QWzvKQQ4pnDC6Lu22RAhwKBgErFS63ru4ZgcmFalGiYkdm2eEgoJnk2t9+tz1lGq54k0WleomJI0tJhJj73UjUaBDwV6b/dC0NYYZEZ6SVm/skvHfj3V6YVsNCV5gna56EyV9OUfXmZE4YixcWcUPter+ABSixY1SOQdzZ9QNP5BT1gFtKgvnu9Ak6zIiNw/DrRAoGAbV/v4Ck/a5oDNwQ5M5NCCUEYmeflTg6YJ5Lu/l5+N0b+uyepITJ+FnL2bJVj66EV8WMHb042W9kuQAM3pq0nBu6flFr2e546H3Mg6/gts4SMCE0RPCdoGa6Uhy7oxgGpwg4yTHaHMIBqavfIj8yOTIP1jR8ryJCwZwrNSajb+/8CgYEAqA0Oby/AM6QFcaXy3dF3DgKeF0Jhox/8jrpJL+cKfVmSl55pgypTITp7l3R//D0q0IMMr86g8XAzrNJhQvVdA9nf/757Fah9hdMw5JN6njcupyOxyhGYL31oZ4DJu1kO4qpmca9Nj379/mNsDLjdYLE4JTZK95ToArdveQB+3tE=";
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw8i/DlaIfSZk1rcDocbhg76TaEpMPFkrKIRpaXeZ7bS95fMXKR0/wzbMmUc6lz2dGVUVpbLFQ7ulMNkSk1fcdxjlriYRxeBMEOWXf801ktyrp+BKIf1NGkUisl6nDZ1a7H5OG1pynoK8KGwOCg/xeEkUtppVEL8x1iqNY+FQBew0xyStifRLF6I4CIryHOvzAy/pVL4hylCQ0B8F3KDmYXCGtRnQmCvrZRVYdirDry/GLboTBcRofhz1aPZcpvQ9E6bOenhpYvWf5EIB7seIc5atZGLOOnBjAk1oVtPqWgLIxRfukQl26xXIS2xcwCxDo7mVLFzYP22aDTB5KAFNVwIDAQAB";
        DigitalSignature digitalSignature = new DigitalSignature();
        digitalSignature.setPrivateKey(privateKey);
        digitalSignature.setPublicKey(publicKey);

        // File to be signed
        String filePath = "D://file-Copy.rar"; // Replace with your file path

        // Generate digital signature
        byte[] signature = sign(filePath, digitalSignature.getPrivateKey());

        // Verify the signature
        boolean isVerified = verify(filePath, signature, digitalSignature.getPublicKey());

        System.out.println("Signature verification result: " + isVerified);

    }

}
