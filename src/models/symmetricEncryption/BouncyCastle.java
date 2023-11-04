
package models.symmetricEncryption;

import java.security.Provider;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class BouncyCastle {
        public static void main(String[] args) {
        // Thêm Bouncy Castle Provider vào danh sách Security Providers
        Provider bcProvider = new BouncyCastleProvider();
        Security.addProvider(bcProvider);
        
        
    }
}
