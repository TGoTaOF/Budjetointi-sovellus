package fi.mxsampsa.budjetointisovellus;

import java.time.LocalDate;
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

    private Budjetti budjetti;

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
        budjetti = new Budjetti();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void LuontiJaPalautusToimiiTyhjana() {
        assertEquals(false, budjetti.haeMap().toString().contains("testi"));
    }

    @Test
    public void LisaaArvoToimii() {
        budjetti.lisaaArvo("testi", 2);
        assertEquals(true, budjetti.haeMap().toString().contains("testi"));
    }

    @Test
    public void haeArvoToimii() {
        budjetti.lisaaArvo("testi", 2);
        assertEquals(2, budjetti.haeArvo("testi"));
    }

    @Test
    public void muokkaaArvoaToimii() {
        budjetti.lisaaArvo("testi", 2);
        budjetti.muokkaaArvoa("testi", 5);
        assertEquals(5, budjetti.haeArvo("testi"));
    }

    @Test
    public void poistaKenttaToimii() {
        budjetti.lisaaArvo("testi", 2);
        budjetti.poistaKentta("testi");
        assertEquals(false, budjetti.haeMap().toString().contains("testi"));
    }

    @Test
    public void summaToimii() {
        budjetti.lisaaArvo("testi1", 2);
        budjetti.lisaaArvo("testi2", 3);
        budjetti.lisaaArvo("testi3", 7);
        budjetti.lisaaArvo("testi4", 5);
        assertEquals(17, budjetti.summa());
    }

    @Test
    public void summaToimiiNegatiivisillakin() {
        budjetti.lisaaArvo("testi1", 2);
        budjetti.lisaaArvo("testi2", -3);
        budjetti.lisaaArvo("testi3", 7);
        budjetti.lisaaArvo("testi4", -5);
        assertEquals(1, budjetti.summa());
    }

    @Test
    public void menotSummaToimii() {
        budjetti.lisaaArvo("testi1", 2);
        budjetti.lisaaArvo("testi2", -3);
        budjetti.lisaaArvo("testi3", 7);
        budjetti.lisaaArvo("testi4", 5);
        assertEquals(-3, budjetti.menotSumma());
    }

    @Test
    public void tulotSummaToimii() {
        budjetti.lisaaArvo("testi1", 2);
        budjetti.lisaaArvo("testi2", 3);
        budjetti.lisaaArvo("testi3", -7);
        budjetti.lisaaArvo("testi4", 5);
        assertEquals(10, budjetti.tulotSumma());
    }

    @Test
    public void haeMapToimii() {
        assertEquals(true, budjetti.haeMap().isEmpty());
    }

    @Test
    public void budjetinValintaEiTuotaOngelmia() {
        try {
            budjetti.valitseBudjetti("test", "testaaja");
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void budjetinAvausEiTuotaOngelmia() {
        try {
            budjetti.valitseBudjetti("test", "testaaja");
            budjetti.avaaBudjetti("-");
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void budjetinTallennusEiTuotaOngelmia() {
        try {
            budjetti.valitseBudjetti("test", "testaaja");
            budjetti.avaaBudjetti("-");
            budjetti.tallennaBudjetti("-");
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void budjetinSulkeminenEiTuotaOngelmia() {
        try {
            budjetti.valitseBudjetti("test", "testaaja");
            budjetti.avaaBudjetti("-");
            budjetti.tallennaBudjetti("-");
            budjetti.suljeBudjetti();
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }

    @Test
    public void haeToiminnotToimii() {
        budjetti.valitseBudjetti("test", "testaaja");
        budjetti.avaaBudjetti("-");
        assertEquals(true, budjetti.budjetinNimi().contains("test"));
        assertEquals("testaaja", budjetti.budjetinTekija());
        assertEquals((String) LocalDate.now().toString(), (String) budjetti.budjetinLuontiPaiva());
    }
}
