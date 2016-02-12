package budjetointisovellus;

import javax.swing.SwingUtilities;
import ui.Kayttoliittyma;

/**
 * Pääluokka, suoritus alkaa täältä. Käynnistää käyttöliittymän.
 * 
 * @author mxsampsa
 */
public class Main {
    
    /**
     * Suorituksen aloittava metodi.
     */
    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
