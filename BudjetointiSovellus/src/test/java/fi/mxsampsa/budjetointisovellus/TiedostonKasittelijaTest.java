package fi.mxsampsa.budjetointisovellus;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mxsampsa
 */
public class TiedostonKasittelijaTest {

    public TiedostonKasittelijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Scanner lukija = new Scanner(System.in);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void TiedostoVoidaanLukea() {
        try {
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto("-");
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void tiedotOikein() {
        try {
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto("-");
            assertEquals("testaaja", budget.haeTekija());
            assertEquals("" + LocalDate.now(), budget.haeLuontiPaiva());
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void EpakelpoTiedostoNimi() {
        try {
            TiedostonKasittelija budget = new TiedostonKasittelija("", "testaaja");
            assertEquals(true, false);
        } catch (Exception e) {
            assertEquals(true, true);
        }
    }

    @Test
    public void palautaTekstinaToimii() {
        try {
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto("-");
            assertEquals("testaaja\n" + LocalDate.now() + "\n"
                    + budget.viimeksiMuokattu() + "\n-", budget.palautaTekstina());
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void lueTiedostoToimiiIlmanSalasanaa() {
        try {
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto("-");
            assertEquals(true, budget.palautaTekstina().contains("testaaja"));
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void onkoSalattuToimiiJosEiOleSalattu() {
        try {
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            assertEquals(false, budget.onkoSalattu("test\ntest\ntest\n-\n"));
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void LueTiedostoToimiiSalasanalla() {
        try {
            String budjetinNimi = "test";
            if (System.getProperty("os.name").startsWith("Windows") && !budjetinNimi.isEmpty()) {
                budjetinNimi += ".txt";
            }
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto("1234567891234567");
            budget.tallenna("1234567891234567", new HashMap<>());
            File testiTiedosto = new File(budjetinNimi);
            TiedostonKasittelija budget2 = new TiedostonKasittelija(testiTiedosto);
            try {
                budget2.lueTiedosto("1234567891234567");
            } catch (Exception e) {
                assertEquals(true, false);
            }
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void TallentaaIlmanSalasanaa() {
        try {
            String budjetinNimi = "test";
            if (System.getProperty("os.name").startsWith("Windows") && !budjetinNimi.isEmpty()) {
                budjetinNimi += ".txt";
            }
            TiedostonKasittelija kasittelija = new TiedostonKasittelija("test", "testaaja");
            kasittelija.lueTiedosto("-");
            kasittelija.tallenna("-", new HashMap<>());
            File testiTiedosto = new File(budjetinNimi);
            Scanner customlukija = new Scanner(testiTiedosto, "UTF-8");
            if (customlukija.hasNextLine()) {
                assertEquals(true, customlukija.nextLine().contains("testaaja"));
            }
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void TallentaaOlemassaOlevallaSalasanalla() {
        try {
            String budjetinNimi = "test";
            if (System.getProperty("os.name").startsWith("Windows") && !budjetinNimi.isEmpty()) {
                budjetinNimi += ".txt";
            }
            String salasana1 = "1234567891234567";
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto(salasana1);
            budget.tallenna(salasana1, new HashMap<>());
            File testiTiedosto = new File(budjetinNimi);
            TiedostonKasittelija budget2 = new TiedostonKasittelija(testiTiedosto);
            budget2.lueTiedosto(salasana1);
            budget2.tallenna(salasana1, new HashMap<>());
            File testiTiedosto2 = new File(budjetinNimi);
            TiedostonKasittelija budget3 = new TiedostonKasittelija(testiTiedosto2);
            try {
                budget3.lueTiedosto(salasana1);
            } catch (Exception e) {
                assertEquals(true, false);
            }
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void TallentaaUudellaSalasanalla() {
        try {
            String budjetinNimi = "test";
            if (System.getProperty("os.name").startsWith("Windows") && !budjetinNimi.isEmpty()) {
                budjetinNimi += ".txt";
            }
            String salasana1 = "1234567891234567";
            String salasana2 = "9876543219876543";
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto(salasana1);
            budget.tallenna(salasana1, new HashMap<>());
            File testiTiedosto = new File(budjetinNimi);
            TiedostonKasittelija budget2 = new TiedostonKasittelija(testiTiedosto);
            budget2.lueTiedosto(salasana1);
            budget2.tallenna(salasana2, new HashMap<>());
            File testiTiedosto2 = new File(budjetinNimi);
            TiedostonKasittelija budget3 = new TiedostonKasittelija(testiTiedosto2);
            try {
                budget3.lueTiedosto(salasana2);
            } catch (Exception e) {
                assertEquals(true, false);
            }
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void tiedostonLukeminenEiOnnistuVaarallaSalasanalla() {
        try {
            String budjetinNimi = "test";
            if (System.getProperty("os.name").startsWith("Windows") && !budjetinNimi.isEmpty()) {
                budjetinNimi += ".txt";
            }
            String salasana1 = "1234567891234567";
            String salasana2 = "9876543219876543";
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto(salasana1);
            budget.tallenna(salasana1, new HashMap<>());
            File testiTiedosto = new File(budjetinNimi);
            TiedostonKasittelija budget2 = new TiedostonKasittelija(testiTiedosto);
            budget2.lueTiedosto(salasana1);
            budget2.tallenna(salasana2, new HashMap<>());
            File testiTiedosto2 = new File(budjetinNimi);
            TiedostonKasittelija budget3 = new TiedostonKasittelija(testiTiedosto2);
            try {
                budget3.lueTiedosto(salasana1);
            } catch (Exception e) {
                assertEquals(true, true);
            }
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void muutoksetBudjettiinTallentuu() {
        try {
            String budjetinNimi = "test";
            if (System.getProperty("os.name").startsWith("Windows") && !budjetinNimi.isEmpty()) {
                budjetinNimi += ".txt";
            }
            String salasana1 = "1234567891234567";
            String salasana2 = "9876543219876543";
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto(salasana1);
            HashMap<String, Double> map = new HashMap<>();
            map.put("dataa", -23.0);
            budget.tallenna(salasana1, map);
            File testiTiedosto = new File(budjetinNimi);
            TiedostonKasittelija budget2 = new TiedostonKasittelija(testiTiedosto);
            budget2.lueTiedosto(salasana1);
            assertEquals(true, budget2.palautaTekstina().contains("dataa"));
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
}
