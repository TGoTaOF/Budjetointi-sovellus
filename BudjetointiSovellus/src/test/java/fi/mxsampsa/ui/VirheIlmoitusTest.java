/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.mxsampsa.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
public class VirheIlmoitusTest {
    private VirheIlmoitus ilmoitus;
    
    public VirheIlmoitusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        JPanel panel = new JPanel();
        ilmoitus = new VirheIlmoitus(panel);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void virheetonSyöte() {
        assertEquals(false, ilmoitus.virheellinenSyote("asd"));
    }
}
