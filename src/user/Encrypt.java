package user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class Encrypt {
     public static void main(String args[]) {
         System.out.println(decrypt("KXi+esjmJWPk+08MgN6GRg=="));
         System.out.println(encrypt("rahulkharatmol"));
     }

    public static String encrypt(String password) {
        try {
            DESKeySpec keySpec = new DESKeySpec("ECOMMERCE".getBytes("UTF8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);
            @SuppressWarnings("restriction")
            sun.misc.BASE64Encoder base64encoder = new BASE64Encoder();
            Cipher cipher = Cipher.getInstance("DES"); // cipher is not thread safe
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cleartext = password.getBytes("UTF8");
            @SuppressWarnings("restriction")
            String encrypedPwd = base64encoder.encode(cipher.doFinal(cleartext));
            return encrypedPwd;
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
        }
        return "";
    }

    public static String decrypt(String encryptedPwd) {
        try {
            DESKeySpec keySpec = new DESKeySpec("ECOMMERCE".getBytes("UTF8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);

            @SuppressWarnings("restriction")
            sun.misc.BASE64Decoder base64decoder = new BASE64Decoder 	();
            Cipher cipher = Cipher.getInstance("DES"); // cipher is not thread safe
            cipher.init(Cipher.DECRYPT_MODE, key);
            @SuppressWarnings("restriction")
            byte[] encrypedPwdBytes = base64decoder.decodeBuffer(encryptedPwd);
            byte[] plainTextPwdBytes = (cipher.doFinal(encrypedPwdBytes));
            return new String(plainTextPwdBytes);
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | IOException | IllegalBlockSizeException | BadPaddingException ex) {
        }
        return "";
    }
}