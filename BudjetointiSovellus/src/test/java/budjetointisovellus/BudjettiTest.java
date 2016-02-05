package budjetointisovellus;

import java.util.HashMap;
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
public class BudjettiTest {
    
    public BudjettiTest() {
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
    }

    @Test
    public void LuontiJaPalautusToimii() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("testi", 2);
        Budjetti budjetti = new Budjetti(map);
        assertEquals(true, budjetti.haeMap().toString().contains("testi"));
    }
    
    @Test
    public void LisaaArvoToimii() {
        HashMap<String, Integer> map = new HashMap<>();
        Budjetti budjetti = new Budjetti(map);
        budjetti.lisaaArvo("testi", 2);
        assertEquals(true, budjetti.haeMap().toString().contains("testi"));
    }
    
    @Test
    public void haeArvoToimii() {
        HashMap<String, Integer> map = new HashMap<>();
        Budjetti budjetti = new Budjetti(map);
        budjetti.lisaaArvo("testi", 2);
        assertEquals(2, budjetti.haeArvo("testi"));
    }
    
    @Test
    public void muokkaaArvoaToimii() {
        HashMap<String, Integer> map = new HashMap<>();
        Budjetti budjetti = new Budjetti(map);
        budjetti.lisaaArvo("testi", 2);
        budjetti.muokkaaArvoa("testi", 5);
        assertEquals(5, budjetti.haeArvo("testi"));
    }
    
    @Test
    public void poistaKenttaToimii() {
        HashMap<String, Integer> map = new HashMap<>();
        Budjetti budjetti = new Budjetti(map);
        budjetti.lisaaArvo("testi", 2);
        budjetti.poistaKentta("testi");
        assertEquals(false, budjetti.haeMap().toString().contains("testi"));
    }
    
    @Test
    public void summaToimii() {
        HashMap<String, Integer> map = new HashMap<>();
        Budjetti budjetti = new Budjetti(map);
        budjetti.lisaaArvo("testi1", 2);
        budjetti.lisaaArvo("testi2", 3);
        budjetti.lisaaArvo("testi3", 7);
        budjetti.lisaaArvo("testi4", 5);
        assertEquals(17, budjetti.summa());
    }
    
    @Test
    public void summaToimiiNegatiivisillakin() {
        HashMap<String, Integer> map = new HashMap<>();
        Budjetti budjetti = new Budjetti(map);
        budjetti.lisaaArvo("testi1", 2);
        budjetti.lisaaArvo("testi2", -3);
        budjetti.lisaaArvo("testi3", 7);
        budjetti.lisaaArvo("testi4", -5);
        assertEquals(1, budjetti.summa());
    }
}
