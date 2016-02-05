package budjetointisovellus;

import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author mxsampsa
 * koodin idea on javan mallikoodeista.
 */
public class Salaus {
    
    private Cipher ecipher;
    private Cipher dcipher;
    private SecretKey key;
    
    public Salaus(String salasana) throws Exception { //Salasanan oltava 16 numeroinen ja koostua numeroista 1-9.
        if (salasana.length() < 16) {
            String numeroita = "1234567891234567"; //Käyttäjä voi antaa mitä vain, mutta se täytetään 16 numeroiseksi.
            int apu = salasana.length();
            for (int i = 0; i < 16-apu; i++) {
                salasana += numeroita.charAt(apu);
            }
        }
        this.key = new SecretKeySpec(salasana.getBytes(), "AES");
        try {
            ecipher = Cipher.getInstance("AES");
            dcipher = Cipher.getInstance("AES");
            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public String salaa(String tiedosto) throws Exception {
        try {
            byte[] utf8 = tiedosto.getBytes("UTF-8");
            byte[] enc = ecipher.doFinal(utf8);
            return new sun.misc.BASE64Encoder().encode(enc);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public String puraSalaus(String tiedosto) throws Exception {
        try {
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(tiedosto);
            byte[] utf8 = dcipher.doFinal(dec);
            return new String(utf8, "UTF-8");
        } catch (Exception e) {
            throw e;
        }
    }
    
    /*try {
        String mykey ="1736567891234567";
        Salaus encrypter = new Salaus(mykey);
        String original = "Testing encryption";
        System.out.println("Before Encryption   : " + original);
        String encrypted = encrypter.salaa(original);
        System.out.println("After Encryption   : " + encrypted);
        String decrypted = encrypter.puraSalaus(encrypted);
        System.out.println("After Decryption   : " + decrypted);
    } catch (Exception e) {
    }*/
}