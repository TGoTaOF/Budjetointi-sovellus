package budjetointisovellus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author mxsampsa
 */
public class Budjetti {

    private File tiedosto;
    private String tekija;
    private String luontiPaiva;
    private HashMap<String, Integer> mappi;

    public Budjetti(File tiedosto) { //olemassa olevan budjetin avaamiseen
        this.tiedosto = tiedosto;
        try {
            this.tiedosto.createNewFile();
        } catch (Exception e) {
        }
    }

    public Budjetti(String budjetinNimi, String tekija) { //uuden budjetin luomiseen
        try {
            this.tiedosto = new File(budjetinNimi);
            this.tiedosto.createNewFile();
            FileWriter kirjoittaja = new FileWriter(this.tiedosto);
            kirjoittaja.write(tekija + "\n" + LocalDate.now() + "\n" + viimeksiMuokattu());
            kirjoittaja.close();
        } catch (Exception e) {
            System.out.println("Ei voitu luoda uutta tiedostoa!");
        }
    }

    public String lueTiedosto() { //lukee tiedoston HashMap muotoon
        try {
            Scanner lukija = new Scanner(this.tiedosto, "UTF-8");
            this.mappi = new HashMap<String, Integer>();
            this.tekija = lukija.nextLine();
            this.luontiPaiva = lukija.nextLine();
            String paiva = lukija.nextLine();
            while (lukija.hasNextLine()) {
                String[] osat = lukija.nextLine().split(":");
                this.mappi.put(osat[0], Integer.parseInt(osat[1]));
            }
            lukija.close();
            return "onnistui";
        } catch (Exception e) {
            return "Tiedostoa ei voitu lukea";
        }
    }

    public String getTekija() {
        return this.tekija;
    }

    public String getLuontiPaiva() {
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
                + viimeksiMuokattu();
        for (String s : this.mappi.keySet()) {
            palautus = palautus + "\n" + s + ":" + this.mappi.get(s);
        }
        return palautus;
    }

    public void tallenna() { //Tallennetaan tiedostoksi
        try {
            FileWriter kirjoittaja = new FileWriter(this.tiedosto);
            kirjoittaja.write(palautaTekstina());
            kirjoittaja.close();
        } catch (Exception e) {
            System.out.println("Ei voitu tallentaa");
        }
    }
}
//Budjetti tiedostojen muoto, numerot=rivinumeroja:

//1.Tekijä
//2.Luontipäivä
//3.ViimeksKäytetty
//4.Merkintä:arvo
//5.Merkintä2:arvo2
//jne...
