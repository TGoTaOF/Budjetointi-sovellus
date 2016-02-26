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
        budjetti.lisaaArvo("testi", 2.0);
        assertEquals(true, budjetti.haeMap().toString().contains("testi"));
    }

    @Test
    public void haeArvoToimii() {
        budjetti.lisaaArvo("testi", 2.0);
        assertEquals(true, Math.abs(2.0 - budjetti.haeArvo("testi")) == 0.0);
    }

    @Test
    public void muokkaaArvoaToimii() {
        budjetti.lisaaArvo("testi", 2.0);
        budjetti.muokkaaArvoa("testi", 5.0);
        assertEquals(true, Math.abs(5.0 - budjetti.haeArvo("testi")) == 0.0);
    }

    @Test
    public void poistaKenttaToimii() {
        budjetti.lisaaArvo("testi", 2.0);
        budjetti.poistaKentta("testi");
        assertEquals(false, budjetti.haeMap().toString().contains("testi"));
    }

    @Test
    public void summaToimii() {
        budjetti.lisaaArvo("testi1", 2.0);
        budjetti.lisaaArvo("testi2", 3.0);
        budjetti.lisaaArvo("testi3", 7.0);
        budjetti.lisaaArvo("testi4", 5.0);
        assertEquals(true, Math.abs(17.0 - budjetti.summa()) == 0.0);
    }

    @Test
    public void summaToimiiNegatiivisillakin() {
        budjetti.lisaaArvo("testi1", 2.0);
        budjetti.lisaaArvo("testi2", -3.0);
        budjetti.lisaaArvo("testi3", 7.0);
        budjetti.lisaaArvo("testi4", -5.0);
        assertEquals(true, Math.abs(1.0 - budjetti.summa()) == 0.0);
    }

    @Test
    public void menotSummaToimii() {
        budjetti.lisaaArvo("testi1", 2.0);
        budjetti.lisaaArvo("testi2", -3.0);
        budjetti.lisaaArvo("testi3", 7.0);
        budjetti.lisaaArvo("testi4", 5.0);
        assertEquals(true, Math.abs(-3.0 - budjetti.menotSumma()) == 0.0);
    }

    @Test
    public void tulotSummaToimii() {
        budjetti.lisaaArvo("testi1", 2.0);
        budjetti.lisaaArvo("testi2", 3.0);
        budjetti.lisaaArvo("testi3", -7.0);
        budjetti.lisaaArvo("testi4", 5.0);
        assertEquals(true, Math.abs(10.0 - budjetti.tulotSumma()) == 0.0);
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
        try {
            budjetti.valitseBudjetti("test", "testaaja");
            budjetti.avaaBudjetti("-");
            assertEquals(true, budjetti.budjetinNimi().contains("test"));
            assertEquals("testaaja", budjetti.budjetinTekija());
            assertEquals((String) LocalDate.now().toString(), (String) budjetti.budjetinLuontiPaiva());
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
}
