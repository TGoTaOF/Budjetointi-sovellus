package budjetointisovellus;

import java.util.HashMap;

/**
 *
 * @author mxsampsa
 */
public class Budjetti {
    
    private HashMap<String, Integer> mappi;
    
    public Budjetti(HashMap<String, Integer> map) {
        this.mappi = map;
    }
    
    public void lisaaArvo(String kentta, int arvo) {
        this.mappi.put(kentta, arvo);
    }
    
    public void muokkaaArvoa(String kentta, int uusiArvo) {
        for (String s : this.mappi.keySet()) {
            if (s.equals(kentta)) {
                this.mappi.replace(kentta, uusiArvo);
            }
        }
    }
    
    public void poistaKentta(String kentta) {
        this.mappi.remove(kentta);
    }
    
    public int haeArvo(String kentta) {
        return this.mappi.get(kentta);
    }
    
    public int summa() {
        int palautus = 0;
        palautus = this.mappi.values().stream().map((i) -> i).reduce(palautus, Integer::sum);
        return palautus;
    }
    
    public HashMap<String, Integer> haeMap() {
        return this.mappi;
    }
}
