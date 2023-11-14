package models.digitalSignatures;

import models.hashs.MD5;
import models.hashs.SHA1;
import models.hashs.SHA256;
import models.hashs.SHA512;

public class DigitalSignature {

    public boolean verify(String hash, String codeHash, String sourcePath) throws Exception {
        String codeHashFile = null;
        switch (hash) {
            case "MD5":
                MD5 md5 = new MD5();
                codeHashFile = md5.checkFile(sourcePath);
                break;
            case "SHA1":
                SHA1 sha1 = new SHA1();
                codeHashFile = sha1.checkFile(sourcePath);
                break;
            case "SHA-256":
                SHA256 sha256 = new SHA256();
                codeHashFile = sha256.checkFile(sourcePath);
                 break;
            case "SHA-512":
                SHA512 sha512 = new SHA512();
                codeHashFile = sha512.checkFile(sourcePath);
                 break;
            default:
                throw new AssertionError();

        }
        System.out.println(codeHashFile);
        return codeHashFile.equals(codeHash);

    }

}
