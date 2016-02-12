package budjetointisovellus;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    
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
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(outContent));
    }
    
    @After
    public void tearDown() {
        System.setOut(null);
        System.setErr(null);
    }
    
    @Test
    public void TiedostoVoidaanLukea() {
        TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
        assertEquals("onnistui", budget.lueTiedosto("-"));
    }
    
    @Test
    public void tiedotOikein() {
        TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
        budget.lueTiedosto("-");
        assertEquals("testaaja", budget.haeTekija());
        assertEquals("" + LocalDate.now(), budget.haeLuontiPaiva());
    }
    
    @Test
    public void EpakelpoTiedostoNimi() {
        TiedostonKasittelija budget = new TiedostonKasittelija("", "testaaja");
        assertEquals("Ei voitu luoda uutta tiedostoa!", outContent.toString().trim());
    }
    
    @Test
    public void palautaTekstinaToimii() {
        TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
        budget.lueTiedosto("-");
        assertEquals("testaaja\n" + LocalDate.now() + "\n" 
                + budget.viimeksiMuokattu() + "\n-", budget.palautaTekstina());
    }
    
    @Test
    public void lueTiedostoToimiiIlmanSalasanaa() {
        TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
        budget.lueTiedosto("-");
        assertEquals(true, budget.palautaTekstina().contains("testaaja"));
    }
    
    @Test
    public void onkoSalattuToimiiJosEiOleSalattu() {
        TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
        assertEquals(false, budget.onkoSalattu("test\ntest\ntest\n-\n"));
    }
    
    @Test
    public void LueTiedostoToimiiSalasanalla() {
        try {
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto("1234567891234567");
            budget.tallenna("1234567891234567", new HashMap<>());
            File testiTiedosto = new File("test.txt");
            TiedostonKasittelija budget2 = new TiedostonKasittelija(testiTiedosto);
            assertEquals("onnistui", budget2.lueTiedosto("1234567891234567"));
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
    
    @Test
    public void TallentaaIlmanSalasanaa() {
        try {
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto("-");
            budget.tallenna("-", new HashMap<>());
            File testiTiedosto = new File("test.txt");
            Scanner customlukija = new Scanner(testiTiedosto, "UTF-8");
            if (customlukija.hasNextLine()) {
                assertEquals(true, customlukija.nextLine().contains("testaaja")); 
            }
        } catch (FileNotFoundException e) {
            assertEquals(true, false);
        }
    }
    
    @Test
    public void TallentaaOlemassaOlevallaSalasanalla() {
        try {
            String salasana1 = "1234567891234567";
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto(salasana1);
            budget.tallenna(salasana1, new HashMap<>());
            File testiTiedosto = new File("test.txt");
            TiedostonKasittelija budget2 = new TiedostonKasittelija(testiTiedosto);
            budget2.lueTiedosto(salasana1);
            budget2.tallenna(salasana1, new HashMap<>());
            File testiTiedosto2 = new File("test.txt");
            TiedostonKasittelija budget3 = new TiedostonKasittelija(testiTiedosto2);
            assertEquals("onnistui", budget3.lueTiedosto(salasana1));
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
    
    @Test
    public void TallentaaUudellaSalasanalla() {
        try {
            String salasana1 = "1234567891234567";
            String salasana2 = "9876543219876543";
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto(salasana1);
            budget.tallenna(salasana1, new HashMap<>());
            File testiTiedosto = new File("test.txt");
            TiedostonKasittelija budget2 = new TiedostonKasittelija(testiTiedosto);
            budget2.lueTiedosto(salasana1);
            budget2.tallenna(salasana2, new HashMap<>());
            File testiTiedosto2 = new File("test.txt");
            TiedostonKasittelija budget3 = new TiedostonKasittelija(testiTiedosto2);
            assertEquals("onnistui", budget3.lueTiedosto(salasana2));
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
    
    @Test
    public void tiedostonLukeminenEiOnnistuVaarallaSalasanalla() {
        try {
            String salasana1 = "1234567891234567";
            String salasana2 = "9876543219876543";
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto(salasana1);
            budget.tallenna(salasana1, new HashMap<>());
            File testiTiedosto = new File("test.txt");
            TiedostonKasittelija budget2 = new TiedostonKasittelija(testiTiedosto);
            budget2.lueTiedosto(salasana1);
            budget2.tallenna(salasana2, new HashMap<>());
            File testiTiedosto2 = new File("test.txt");
            TiedostonKasittelija budget3 = new TiedostonKasittelija(testiTiedosto2);
            assertEquals("Tiedoston salauksen varmennus epäonnistui", budget3.lueTiedosto(salasana1));
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
    
    @Test
    public void muutoksetBudjettiinTallentuu() {
        try {
            String salasana1 = "1234567891234567";
            String salasana2 = "9876543219876543";
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto(salasana1);
            HashMap<String, Integer> map = new HashMap<>();
            map.put("dataa", -23);
            budget.tallenna(salasana1, map);
            File testiTiedosto = new File("test.txt");
            TiedostonKasittelija budget2 = new TiedostonKasittelija(testiTiedosto);
            budget2.lueTiedosto(salasana1);
            assertEquals(true, budget2.palautaTekstina().contains("dataa"));
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
}
