package budjetointisovellus;

import java.util.HashMap;

/**
 * Luokka Budjetin Kenttien ja arvojen käsittelyyn.
 * 
 * @author mxsampsa
 */
public class Budjetti {
    
    private HashMap<String, Integer> mappi;
    
    /**
     * Alustaa budjetin.
     */
    public Budjetti(HashMap<String, Integer> map) {
        this.mappi = map;
    }
    
    /**
     * Lisää budjettiin kentän ja sen arvon.
     */
    public void lisaaArvo(String kentta, int arvo) {
        this.mappi.put(kentta, arvo);
    }
    
    /**
     * Muokkaa yhden budjetin kentän arvoa.
     */
    public void muokkaaArvoa(String kentta, int uusiArvo) {
        for (String s : this.mappi.keySet()) {
            if (s.equals(kentta)) {
                this.mappi.replace(kentta, uusiArvo);
            }
        }
    }
    
    /**
     * Poistaa tietyn kentän budjetista.
     */
    public void poistaKentta(String kentta) {
        this.mappi.remove(kentta);
    }
    
    /**
     * Hakee tietyn budjetin kentän arvon.
     */
    public int haeArvo(String kentta) {
        return this.mappi.get(kentta);
    }
    
    /**
     * Palauttaa budjetin kaikki arvot yhteenlaskettuna.
     */
    public int summa() {
        int palautus = 0;
        for (String kentta : this.mappi.keySet()) {
            palautus += this.mappi.get(kentta);
        }
        return palautus;
    }
    
    /**
     * Palauttaa HashMapin jossa budjetin kentät ja arvot.
     */
    public HashMap<String, Integer> haeMap() {
        return this.mappi;
    }
}
