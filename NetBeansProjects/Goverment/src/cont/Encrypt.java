/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cont;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/**
 *
 * @author eater48
 */
public class Encrypt {
    private static SecretKeySpec secretkey;
    private static byte[] key;
    private static final String ALGORITHM = "AES";
    
    public void PrepareSecreateKey(String mykey){
        MessageDigest sha = null;
        try {
            key = mykey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretkey = new SecretKeySpec(key, ALGORITHM);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String encrypt(String strToEncrypt, String secret){
        try {
            PrepareSecreateKey(secret);
            Cipher ciper = Cipher.getInstance(ALGORITHM);
            ciper.init(Cipher.ENCRYPT_MODE, secretkey);
            return Base64.getEncoder().encodeToString(ciper.doFinal(strToEncrypt.getBytes("UTF-8")));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String decrypt(String strToDecrypt, String secret){
        try {
            PrepareSecreateKey(secret);
            Cipher ciper = Cipher.getInstance(ALGORITHM);
            ciper.init(ciper.DECRYPT_MODE, secretkey);
            return new String(ciper.doFinal(Base64.getDecoder().decode(strToDecrypt)));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
