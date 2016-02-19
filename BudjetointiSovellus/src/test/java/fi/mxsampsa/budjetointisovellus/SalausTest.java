package fi.mxsampsa.budjetointisovellus;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sampsa
 */
public class SalausTest {
    
    public SalausTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        File file = new File("test");
        file.deleteOnExit();
        File file2 = new File(".txt");
        file2.deleteOnExit();
        File file3 = new File("test.txt");
        file3.deleteOnExit();
    }

    @Test
    public void salausToimii() {
        try {
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto("-");
            Salaus salaaja = new Salaus("1234567891234567");
            assertEquals(false, salaaja.salaa(budget.palautaTekstina()).contains("testaaja"));
        } catch (Exception e) {
            assertEquals(true, false);
        }
    } 
    
    @Test
    public void salauksenPurkuToimii() {
        try {
            String salasana = "1234567891234567";
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto("-");
            Salaus salaaja = new Salaus(salasana);
            salaaja.salaa(budget.palautaTekstina());
            budget.lueTiedosto(salasana);
            assertEquals(true, budget.palautaTekstina().contains("testaaja"));
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
    
    @Test
    public void salausToimiiKayttajanVajaallaSalasanalla() {
        try {
            String salasana = "123456";
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto("-");
            Salaus salaaja = new Salaus(salasana);
            salaaja.salaa(budget.palautaTekstina());
            budget.lueTiedosto(salasana);
            assertEquals(true, budget.palautaTekstina().contains("testaaja"));
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
    
    @Test
    public void salausToimiiIlmanTiedostonKasittelijaa() {
        try {
            String salattava = "ayayay!!!";
            Salaus salaaja = new Salaus("123");
            salattava = salaaja.salaa(salattava);
            assertEquals(false, salattava.contains("ayayay"));
        } catch (Exception e) {
            assertEquals(true, false);
        }
    } 
}
