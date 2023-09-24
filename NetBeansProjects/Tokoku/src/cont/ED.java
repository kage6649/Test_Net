/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cont;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author eater48
 */
public class ED {
    private static SecretKeySpec secret;
    private static byte [] key;
    private static final String AG = "AES";
    final String ss = "secrete";
    
    public void ppsecret(String mykey){
        MessageDigest sha = null;
        try {
            key = mykey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secret = new SecretKeySpec(key, AG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String enc(String encr,String secret){
        try {
            ppsecret(secret);
            Cipher cp = Cipher.getInstance(AG);
            cp.init(Cipher.ENCRYPT_MODE,ED.secret);
            return Base64.getEncoder().encodeToString(cp.doFinal(encr.getBytes("UTF-8")));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String dec(String decr,String seceret){
        try {
            ppsecret(seceret);
            Cipher cp = Cipher.getInstance(AG);
            cp.init(Cipher.DECRYPT_MODE,ED.secret);
            return new String(cp.doFinal(Base64.getDecoder().decode(decr)));
                        
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return null;
    }
    public String inec(String pass){
        ED ed = new ED();
        String fenc = ed.enc(pass, ss);
        return fenc;
    }
    public String inde(String pass){
         ED ed = new ED();
        String fdec = ed.dec(pass, ss);
        return fdec;
    }
    
}

