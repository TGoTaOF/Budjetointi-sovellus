package fi.mxsampsa.budjetointisovellus;

import java.io.File;
import java.util.HashMap;

/**
 * Luokka Budjetin kenttien ja arvojen käsittelyyn.
 * 
 * @author mxsampsa
 */
public class Budjetti {
    private HashMap<String, Integer> mappi;
    public HashMap<String, Integer> tulot;
    public HashMap<String, Integer> menot;
    private TiedostonKasittelija kasittelija;
    private boolean budjettiAvattuna;
    /**
     * Alustaa budjetin.
     */
    public Budjetti() {
        this.mappi = new HashMap<>();
        this.menot = new HashMap<>();
        this.tulot = new HashMap<>();
        this.budjettiAvattuna = false;
    }
    /**
     * Lisää budjettiin kentän ja sen arvon.
     * @param kentta merkintä budjetissa.
     * @param arvo merkinnän arvo.
     */
    public void lisaaArvo(String kentta, int arvo) {
        this.mappi.put(kentta, arvo);
        if (arvo < 0) {
            this.menot.put(kentta, arvo);
        } else {
            this.tulot.put(kentta, arvo);
        }
    }
    /**
     * Muokkaa yhden budjetin kentän arvoa.
     * @param kentta merkintä budjetissa.
     * @param uusiArvo merkinnän uusi arvo.
     */
    public void muokkaaArvoa(String kentta, int uusiArvo) {
        if (this.mappi.get(kentta) < 0) {
            this.menot.replace(kentta, uusiArvo);
        } else {
            this.tulot.replace(kentta, uusiArvo);
        }
        this.mappi.containsKey(kentta);
        this.mappi.replace(kentta, uusiArvo);
    }
    /**
     * Poistaa tietyn kentän budjetista.
     * @param kentta merkintä budjetissa.
     */
    public void poistaKentta(String kentta) {
        if (this.mappi.get(kentta) < 0) {
            this.menot.remove(kentta);
        } else {
            this.tulot.remove(kentta);
        }
        this.mappi.remove(kentta);
    }
    /**
     * Hakee tietyn budjetin kentän arvon.
     * @param kentta merkintä budjetissa.
     * @return merkinnän arvon.
     */
    public int haeArvo(String kentta) {
        return this.mappi.get(kentta);
    }
    /**
     * Palauttaa budjetin kaikki arvot yhteenlaskettuna.
     * @return koko budjetin saldon.
     */
    public int summa() {
        int palautus = 0;
        for (Integer arvo : this.mappi.values()) {
            palautus = palautus + arvo;
        }
        return palautus;
    }
    /**
     * Palauttaa budjetin kaikki menot yhteenlaskettuna.
     * @return menojen summan.
     */
    public int menotSumma() {
        int palautus = 0;
        for (Integer arvo : this.menot.values()) {
            palautus = palautus + arvo;
        }
        return palautus;
    }
    /**
     * Palauttaa budjetin kaikki tulot yhteenlaskettuna.
     * @return tulojen summan.
     */
    public int tulotSumma() {
        int palautus = 0;
        for (Integer arvo : this.tulot.values()) {
            palautus = palautus + arvo;
        }
        return palautus;
    }
    /**
     * Palauttaa HashMapin jossa budjetin kentät ja arvot.
     * @return kaikki merkinnät ja arvot mappina.
     */
    public HashMap<String, Integer> haeMap() {
        return this.mappi;
    }
    /**
     * Saa käyttöjärjestelmältä parametrit, joiden pohjalta alustetaan tiedostonkäsittelijä.
     * @param parametrit joko valmis tiedosto tai parametrit uuden tiedoston luomiseen.
     */
    public void valitseBudjetti(Object... parametrit) { //Aion uudelleen nimetä tai siirtää toiseen luokkaan!
        if (parametrit.length == 1) {
            this.kasittelija = new TiedostonKasittelija((File) parametrit[0]);
        } else {
            this.kasittelija = new TiedostonKasittelija((String) parametrit[0], (String) parametrit[1]);
        }
    }
    /**
     * Avaa valitun budjetin tiedostonkäsittelijään.
     * @param salasana salasana budjetin avaamiseen.
     */
    public void avaaBudjetti(String salasana) { //Aion uudelleen nimetä tai siirtää toiseen luokkaan!
        this.kasittelija.lueTiedosto(salasana);
        this.budjettiAvattuna = true;
    }
    /**
     * Kutsuu tiedostonKäsittelijää tallentamaan budjetin.
     * @param salasana salasana budjetin tallentamiseen.
     */
    public void tallennaBudjetti(String salasana) { //Aion uudelleen nimetä tai siirtää toiseen luokkaan!
        this.kasittelija.tallenna(salasana, this.mappi);
    }
    /**
     * Sulkee nykyisen budjetin.
     */
    public void suljeBudjetti() { 
        this.kasittelija = null;
        this.mappi = new HashMap<>();
        this.menot = new HashMap<>();
        this.tulot = new HashMap<>();
        this.budjettiAvattuna = false;
    }
    /**
     * Palauttaa budjetin nimen.
     * @return nimi.
     */
    public String budjetinNimi() {
        return this.kasittelija.haeBudjetinNimi();
    }
    /**
     * Palauttaa budjetin tekijän.
     * @return tekijä.
     */
    public String budjetinTekija() {
        return this.kasittelija.haeTekija();
    }
    /**
     * Palauttaa budjetin luonti päivän.
     * @return luontipäivä.
     */
    public String budjetinLuontiPaiva() {
        return this.kasittelija.haeLuontiPaiva();
    }
    /**
     * Palauttaa budjetin viimeisen muokkauspäivän.
     * @return viimeinen muokkauspäivä.
     */
    public String viimeinenMuokkausPaiva() {
        return this.kasittelija.viimeksiMuokattu();
    }
}
