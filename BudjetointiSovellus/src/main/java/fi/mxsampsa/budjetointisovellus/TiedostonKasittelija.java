package fi.mxsampsa.budjetointisovellus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Luokka tiedoston(.txt) käsittelyyn.
 * <p>
 * Budjetin salausksen purku tapahtuu tiedoston lukuvaiheessa ja salaus tallennus vaiheessa.
 * <p>
 * Budjetti tiedostojen muoto, numerot=rivinumeroja: 1.Tekijä, 2.Luontipäivä, 3.ViimeksiKäytetty, 4.SalausAvain, 5.Merkintä:arvo, 6.Merkintä2:arvo2, jne...
 * @author mxsampsa
 */
public class TiedostonKasittelija {
    private File tiedosto;
    private String tekija;
    private String luontiPaiva;
    private String salaus;
    private Salaus salaaja;
    public HashMap<String, Integer> mappi;
    /**
     * Alustus olemassa olevan budjetin avaamiseen.
     * @param tiedosto alustusta varten.
     */
    public TiedostonKasittelija(File tiedosto) {
        this.tiedosto = tiedosto;
    }
    /**
     * Alustus uuden budjetin luomiseen.
     * @param budjetinNimi budjetin nimi.
     * @param tekija tekijän nimi.
     */
    public TiedostonKasittelija(String budjetinNimi, String tekija) { 
        try {
            if (System.getProperty("os.name").startsWith("Windows") && !budjetinNimi.isEmpty()) {
                budjetinNimi += ".txt";
            }
            this.tiedosto = new File(budjetinNimi);
            this.tiedosto.createNewFile();
            try (FileWriter kirjoittaja = new FileWriter(this.tiedosto)) {
                kirjoittaja.write(tekija + "\n" + LocalDate.now() + "\n" + viimeksiMuokattu() + "\n-");
            }
        } catch (IOException e) {
            System.out.println("Ei voitu luoda uutta tiedostoa!");
        }
    }
    /**
     * Lukee tiedoston HashMap muotoon salauksen mahdollisen tarkistuksen ja purkamisen jälkeen.
     * @param salasana salasana salauksen purkua varten.
     * @return error/toimii
     */
    public String lueTiedosto(String salasana) { 
        this.mappi = new HashMap<String, Integer>();
        try {
            String tarkistettava = lukemisenValmistelu(salasana);
            try (Scanner lukija = new Scanner(tarkistettava)) {
                this.tekija = lukija.nextLine();
                this.luontiPaiva = lukija.nextLine();
                lukija.nextLine();
                lukija.nextLine();
                while (lukija.hasNextLine()) {
                    String[] osat = lukija.nextLine().split(":");
                    this.mappi.put(osat[0], Integer.parseInt(osat[1]));
                }
            }
            return "onnistui";
        } catch (Exception e) {
            return "Jotain meni vikaan :/";
        }
    }
    /**
    * Valmistelee tiedoston luettavaksi.
    * <p>
    * Pyytää salausta tarvittaessa purkamaan salauksen.
    */
    private String lukemisenValmistelu(String salasana) throws Exception {
        this.mappi = new HashMap<>();
        if (this.salaus == null || (this.salaus.equals("-") && !this.salaus.equals(salasana))) {
            this.salaus = salasana;
        }
        String tarkistettava;
        try (Scanner tiedostonHakija = new Scanner(this.tiedosto, "UTF-8")) {
            tarkistettava = "";
            if (tiedostonHakija.hasNextLine()) {
                tarkistettava = tiedostonHakija.nextLine();
            }
            while (tiedostonHakija.hasNextLine()) {
                tarkistettava = tarkistettava + "\n" + tiedostonHakija.nextLine();
            }
            if (onkoSalattu(tarkistettava)) {
                this.salaaja = new Salaus(salasana);
                tarkistettava = this.salaaja.puraSalaus(tarkistettava);
            }
            tiedostonHakija.close();
            return tarkistettava;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Tarkistaa onko tiedosto salattu.
     * @param tarkistettava teksti joka tarkistetaan salauksen varalta.
     * @return palauttaa totuusarvon true mikäli on salattu.
     */
    public boolean onkoSalattu(String tarkistettava) { 
        Scanner lukija = new Scanner(tarkistettava);
        int i = 0;
        while (i < 3 && lukija.hasNextLine()) {
            String apu = lukija.nextLine();
            i++;
        }
        if (lukija.hasNextLine() && lukija.nextLine().equals("-")) {
            if (this.salaus == null || this.salaus.equals("-")) {
                this.salaus = "-";
            }
            return false;
        } else {
            return true;
        }
    }
    /**
     * Palauttaa budjetin nimen.
     * @return budjetin nimi.
     */
    public String haeBudjetinNimi() {
        return this.tiedosto.getName();
    }
    /**
     * Palauttaa budjetin tekijän.
     * @return tekijä.
     */
    public String haeTekija() {
        return this.tekija;
    }
    /**
     * Palauttaa budjetin luontipäivän.
     * @return milloin luotu.
     */
    public String haeLuontiPaiva() {
        return this.luontiPaiva;
    }
    /**
     * Palauttaa ajan jolloin tiedostoa viimeksi muokattu.
     * @return koska viimeksi muokattu.
     */
    public String viimeksiMuokattu() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(this.tiedosto.lastModified());
    }
    /**
     * Talletusta varten budjetti tekstiksi.
     * @return budjetti tekstimuodossa.
     */
    public String palautaTekstina() { 
        String palautus = this.tekija + "\n" + this.luontiPaiva + "\n" + viimeksiMuokattu() + "\n" + this.salaus;
        if (this.mappi.isEmpty()) {
            return palautus;
        } else {
            for (String s : this.mappi.keySet()) {
                palautus = palautus + "\n" + s + ":" + this.mappi.get(s);
            }
            return palautus;
        }
    }
    /**
     * Tallennetaan tiedostoksi Salauksella tai ilman.
     * <p>
     * Jos salasana "-" ei salata.
     * @param salasana salausta varten
     * @param map mappi budjetin kentistä ja arvoista
     */
    public void tallenna(String salasana, HashMap<String, Integer> map) {
        this.mappi = map;
        String tallennettava = palautaTekstina();
        if (!this.salaus.equals("-") || !this.salaus.equals(salasana)) {
            try {
                this.salaaja = new Salaus(salasana);
                this.salaus = salasana;
                tallennettava = this.salaaja.salaa(palautaTekstina());
            } catch (Exception e) {
                System.out.println("Salaus salasanalla ei onnistunut");
            }
        }
        try {
            FileWriter kirjoittaja = new FileWriter(this.tiedosto);
            kirjoittaja.write(tallennettava);
            kirjoittaja.close();
        } catch (IOException e) {
            System.out.println("Ei voitu tallentaa");
        }
    }
}