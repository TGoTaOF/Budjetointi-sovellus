package fi.mxsampsa.budjetointisovellus;

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
    private String salasana;
    
    /**
     * Salaus luokan alustus annetulla salasanalla
     * <p>
     * Salasanan oltava 16 numeroinen ja koostua numeroista 1-9
     * <p>
     * Käyttäjä voi kuitenkin antaa mitä vain, mutta se täytetään 16 numeroiseksi.
     * 
     * @param salasana salasana jolla salaus tai purku tapahtuu.
     * 
     * @throws java.lang.Exception heitetään jotta kutsuva metodi ei jatka omaa suoritustaan.
     */
    public Salaus(String salasana) throws Exception { 
        this.salasana = salasana;
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
     * @param tiedosto salattava tiedosto.
     * @return tiedosto salattuna.
     * @throws java.lang.Exception kertoo epäonnistumisesta kutsujalle.
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
     * @param tiedosto tiedosto jonka salaus pitää purkaa.
     * @return tiedosto purettuna.
     * @throws java.lang.Exception kertoo epäonnistumisesta kutsujalle.
     */
    public String puraSalaus(String tiedosto) throws Exception {
        try {
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(tiedosto);
            byte[] utf8 = dcipher.doFinal(dec);
            String palautus = new String(utf8, "UTF-8");
            if (palautus.contains(this.salasana)) {
                return palautus;
            } else {
                throw new Exception();
            }
        } catch (IOException | BadPaddingException | IllegalBlockSizeException e) {
            throw e;
        }
    }
}