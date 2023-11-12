package models.symmetricEncryption;

public class Test {

    public static void main(String[] args) throws Exception {
        DES des = new DES(56);
        des.createKey();
        String key = des.getKey();
        System.out.println(key);
//
//        byte[] bytes = key.getBytes();
//        int bitCount = bytes.length * 8;
//        System.out.println(bitCount);

        DES des1 = new DES(56);
        des1.setKey("abcdefthftf=");
        System.out.println(des1.encryptBase64("Nguyne DU Lao"));
    }
}
