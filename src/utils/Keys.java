
package utils;

public class Keys {
    public static boolean checkKey(String key, int length) {
        char eq = '=';
        return key.length() == length &&  eq == key.charAt(length-1);
    }

}
