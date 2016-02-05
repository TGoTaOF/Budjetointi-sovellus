package budjetointisovellus;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author mxsampsa
 */
public class TiedostonKasittelija {

    private File tiedosto;
    private String tekija;
    private String luontiPaiva;
    private String salaus;
    private Salaus salaaja;
    private HashMap<String, Integer> mappi;

    public TiedostonKasittelija(File tiedosto) { //olemassa olevan budjetin avaamiseen
        this.tiedosto = tiedosto;
    }

    public TiedostonKasittelija(String budjetinNimi, String tekija) { //uuden budjetin luomiseen
        try {
            if (System.getProperty("os.name").startsWith("Windows") && !budjetinNimi.isEmpty()) {
                budjetinNimi += ".txt";
            }
            this.tiedosto = new File(budjetinNimi);
            this.tiedosto.createNewFile();
            FileWriter kirjoittaja = new FileWriter(this.tiedosto);
            kirjoittaja.write(tekija + "\n" + LocalDate.now() + "\n" + viimeksiMuokattu() + "\n-");
            kirjoittaja.close();
        } catch (Exception e) {
            System.out.println("Ei voitu luoda uutta tiedostoa!");
        }
    }

    public String lueTiedosto(String salasana) { //lukee tiedoston HashMap muotoon salauksen mahdollisen tarkistuksen ja purkamisen jälkeen.
        this.mappi = new HashMap<String, Integer>();
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
        } catch (Exception e) {
            return "Tiedoston salauksen varmennus epäonnistui";
        }
        try {
            Scanner lukija = new Scanner(tarkistettava);
            this.tekija = lukija.nextLine();
            this.luontiPaiva = lukija.nextLine();
            lukija.nextLine();
            lukija.nextLine();
            while (lukija.hasNextLine()) {
                String[] osat = lukija.nextLine().split(":");
                this.mappi.put(osat[0], Integer.parseInt(osat[1]));
            }
            lukija.close();
            return "onnistui";
        } catch (Exception e) {
            return "Jotain meni vikaan :/";
        }
    }
    
    public boolean onkoSalattu(String tarkistettava) { //Tarkistaa onko tiedosto salattu.
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
    
    public HashMap<String, Integer> haeMappi() {
        return this.mappi;
    }

    public String haeTekija() {
        return this.tekija;
    }
    
    public String haeSalasana() { //metodin läsnä olo "lopullisessa" toteutuksessa ei ole vielä aivan varma. Käyttöliittymä saattaa tarvita... 
        return this.salaus;
    }

    public String haeLuontiPaiva() {
        return this.luontiPaiva;
    }

    public String viimeksiMuokattu() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(this.tiedosto.lastModified());
    }

    public void tulosta() { //omia testauksia varten- ei saa välittää tästä!!!
        System.out.println(palautaTekstina());
    }

    public String palautaTekstina() { // talletusta varten tekstiksi
        String palautus = this.tekija + "\n"
                + this.luontiPaiva + "\n"
                + viimeksiMuokattu() + "\n"
                + this.salaus;
        if (this.mappi.isEmpty()) {
            return palautus;
        } else {
            for (String s : this.mappi.keySet()) {
            palautus = palautus + "\n" + s + ":" + this.mappi.get(s);
        }
        return palautus; 
        }
        
    }

    public void tallenna(String salasana, HashMap<String, Integer> map) { //Tallennetaan tiedostoksi Salauksella tai ilman
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
        } catch (Exception e) {
            System.out.println("Ei voitu tallentaa");
        }
    }
}
//Budjetti tiedostojen muoto, numerot=rivinumeroja:

//1.Tekijä
//2.Luontipäivä
//3.ViimeksiKäytetty
//4.SalausAvain
//5.Merkintä:arvo
//6.Merkintä2:arvo2
//jne...
