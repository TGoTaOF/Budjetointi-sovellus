
package ui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
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
public class TallennaKuuntelijaTest {
    
    public TallennaKuuntelijaTest() {
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
            JFrame frame = new JFrame();
            TallennaKuuntelija tallenna = new TallennaKuuntelija(frame);
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
    
    @Test
    public void NappiinLiittaminenOnnistuu() {
        try {
            JFrame frame = new JFrame();
            TallennaKuuntelija tallenna = new TallennaKuuntelija(frame);
            JButton nappi = new JButton("");
            nappi.addActionListener(tallenna);
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
}
