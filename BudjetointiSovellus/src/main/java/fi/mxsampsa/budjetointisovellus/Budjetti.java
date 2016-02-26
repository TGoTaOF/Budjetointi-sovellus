package fi.mxsampsa.budjetointisovellus;

import java.io.File;
import java.util.HashMap;

/**
 * Luokka Budjetin kenttien ja arvojen käsittelyyn.
 *
 * @author mxsampsa
 */
public class Budjetti {

    private HashMap<String, Double> mappi;
    public HashMap<String, Double> tulot;
    public HashMap<String, Double> menot;
    public TiedostonKasittelija kasittelija;
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
     *
     * @param kentta merkintä budjetissa.
     * @param arvo merkinnän arvo.
     */
    public void lisaaArvo(String kentta, Double arvo) {
        this.mappi.put(kentta, arvo);
        if (arvo < 0) {
            this.menot.put(kentta, arvo);
        } else {
            this.tulot.put(kentta, arvo);
        }
    }
    /**
     * Poistaa tietyn kentän budjetista.
     *
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
     * Palauttaa budjetin kaikki arvot yhteenlaskettuna.
     *
     * @return koko budjetin saldon.
     */
    public Double summa() {
        Double palautus = 0.0;
        for (Double arvo : this.mappi.values()) {
            palautus = palautus + arvo;
        }
        return palautus;
    }
    /**
     * Palauttaa budjetin kaikki menot yhteenlaskettuna.
     *
     * @return menojen summan.
     */
    public Double menotSumma() {
        Double palautus = 0.0;
        for (Double arvo : this.menot.values()) {
            palautus = palautus + arvo;
        }
        return palautus;
    }
    /**
     * Palauttaa budjetin kaikki tulot yhteenlaskettuna.
     *
     * @return tulojen summan.
     */
    public Double tulotSumma() {
        Double palautus = 0.0;
        for (Double arvo : this.tulot.values()) {
            palautus = palautus + arvo;
        }
        return palautus;
    }
    /**
     * Palauttaa HashMapin jossa budjetin kentät ja arvot.
     *
     * @return kaikki merkinnät ja arvot mappina.
     */
    public HashMap<String, Double> haeMap() {
        return this.mappi;
    }
    /**
     * Palauttaa budjetin nimen.
     *
     * @return nimi.
     */
    public String budjetinNimi() {
        return this.kasittelija.haeBudjetinNimi();
    }
    /**
     * Palauttaa budjetin tekijän.
     *
     * @return tekijä.
     */
    public String budjetinTekija() {
        return this.kasittelija.haeTekija();
    }
    /**
     * Palauttaa budjetin luonti päivän.
     *
     * @return luontipäivä.
     */
    public String budjetinLuontiPaiva() {
        return this.kasittelija.haeLuontiPaiva();
    }
    /**
     * Palauttaa budjetin viimeisen muokkauspäivän.
     *
     * @return viimeinen muokkauspäivä.
     */
    public String viimeinenMuokkausPaiva() {
        return this.kasittelija.viimeksiMuokattu();
    }
    /**
     * Saa käyttöjärjestelmältä parametrit, joiden pohjalta alustetaan
     * tiedostonkäsittelijä.
     *
     * @param parametrit joko valmis tiedosto tai parametrit uuden tiedoston
     * luomiseen.
     * @throws java.lang.Exception kutsujan pitää tietää jos menee vikaan.
     */
    public void valitseBudjetti(Object... parametrit) throws Exception {
        if (parametrit.length == 1) {
            this.kasittelija = new TiedostonKasittelija((File) parametrit[0]);
        } else {
            this.kasittelija = new TiedostonKasittelija((String) parametrit[0], (String) parametrit[1]);
        }
    }
    /**
     * Avaa valitun budjetin tiedostonkäsittelijään.
     *
     * @param salasana salasana budjetin avaamiseen.
     * @throws java.lang.Exception kutsujan pitää tietää jos menee vikaan.
     */
    public void avaaBudjetti(String salasana) throws Exception {
        this.kasittelija.lueTiedosto(salasana);
        this.mappi = new HashMap<>(this.kasittelija.mappi);
        lajitteleMenoihinJaTuloihin(this.kasittelija.mappi);
        this.budjettiAvattuna = true;
    }
    /**
     * Lajittelee päämapin arvot menoihin ja tuloihin.
     *
     * @param map mappi jossa kaikki merkinnät ja arvot.
     */
    public void lajitteleMenoihinJaTuloihin(HashMap<String, Double> map) {
        if (map.isEmpty()) {
            return;
        }
        for (String s : this.mappi.keySet()) {
            if (map.get(s) < 0) {
                this.menot.put(s, map.get(s));
            } else {
                this.tulot.put(s, map.get(s));
            }
        }
    }
    /**
     * Kutsuu tiedostonKäsittelijää tallentamaan budjetin.
     *
     * @param salasana salasana budjetin tallentamiseen.
     * @throws java.lang.Exception kutsujan pitää tietää jos menee vikaan.
     */
    public void tallennaBudjetti(String salasana) throws Exception {
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
}