
package ui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
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
public class AvaaKuuntelijaTest {
    
    public AvaaKuuntelijaTest() {
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
    public void luontiOnnistuu() {
        try {
            AvaaKuuntelija avaa = new AvaaKuuntelija();
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
    
    @Test
    public void NappiinLiittaminenOnnistuu() {
        try {
            AvaaKuuntelija avaa = new AvaaKuuntelija();
            JButton nappi = new JButton("");
            nappi.addActionListener(avaa);
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
}
