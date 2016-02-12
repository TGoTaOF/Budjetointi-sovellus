package budjetointisovellus;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Luokka budjetin salaamiseen ennen tallentamista ja salauksen purkamiseen luettaessa.
 * <p>
 * Salaustapa: Cipher ja AES
 * <p>
 * koodin idea on javan mallikoodeista (Lähinnä vain Cipherin käyttö). 
 * 
 * @author mxsampsa
 */
public class Salaus {
    
    private Cipher ecipher;
    private Cipher dcipher;
    private SecretKey key;
    
    /**
     * Salaus luokan alustus annetulla salasanalla
     * <p>
     * Salasanan oltava 16 numeroinen ja koostua numeroista 1-9
     * <p>
     * Käyttäjä voi kuitenkin antaa mitä vain, mutta se täytetään 16 numeroiseksi.
     */
    public Salaus(String salasana) throws Exception { 
        if (salasana.length() < 16) {
            String numeroita = "1234567891234567"; 
            int apu = salasana.length();
            for (int i = 0; i < 16 - apu; i++) {
                salasana += numeroita.charAt(apu);
            }
        }
        this.key = new SecretKeySpec(salasana.getBytes(), "AES");
        try {
            ecipher = Cipher.getInstance("AES");
            dcipher = Cipher.getInstance("AES");
            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw e;
        }
    }
    
    /**
     * Salaa budjetin sisällön(teksti-muodon).
     */
    public String salaa(String tiedosto) throws Exception {
        try {
            byte[] utf8 = tiedosto.getBytes("UTF-8");
            byte[] enc = ecipher.doFinal(utf8);
            return new sun.misc.BASE64Encoder().encode(enc);
        } catch (UnsupportedEncodingException | BadPaddingException | IllegalBlockSizeException e) {
            throw e;
        }
    }
    
    /**
     * Purkaa budjetin (teksti-muodon) salauksen.
     */
    public String puraSalaus(String tiedosto) throws Exception {
        try {
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(tiedosto);
            byte[] utf8 = dcipher.doFinal(dec);
            return new String(utf8, "UTF-8");
        } catch (IOException | BadPaddingException | IllegalBlockSizeException e) {
            throw e;
        }
    }
}