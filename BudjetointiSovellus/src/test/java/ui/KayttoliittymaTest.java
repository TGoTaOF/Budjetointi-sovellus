package ui;

import javax.swing.JFrame;
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
public class KayttoliittymaTest {
    
    public KayttoliittymaTest() {
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
    public void eiAiheutaPoikkeusta() {
        try {
            Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
    
    @Test
    public void testRun() {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        try {
            kayttoliittyma.run();
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
}
