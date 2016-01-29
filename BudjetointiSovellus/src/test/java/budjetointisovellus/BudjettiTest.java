package budjetointisovellus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import budjetointisovellus.Budjetti;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
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
public class BudjettiTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    
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
        Budjetti budget = new Budjetti("Jotain", "testaaja");
        assertEquals("onnistui", budget.lueTiedosto());
    }
    
    @Test
    public void tiedotOikein() {
        Budjetti budget = new Budjetti("Jotain", "testaaja");
        budget.lueTiedosto();
        assertEquals("testaaja", budget.getTekija());
        assertEquals("" + LocalDate.now(), budget.getLuontiPaiva());
    }
    
    @Test
    public void EpakelpoTiedostoNimi() {
        Budjetti budget = new Budjetti("", "testaaja");
        assertEquals("Ei voitu luoda uutta tiedostoa!", outContent.toString().trim());
    }
    
    @Test
    public void palautaTekstinaToimii() {
        Budjetti budget = new Budjetti("uusi", "testaaja");
        budget.lueTiedosto();
        assertEquals("testaaja\n" + LocalDate.now() + "\n" 
                + budget.viimeksiMuokattu() ,budget.palautaTekstina());
    }
}
