package fi.mxsampsa.budjetointisovellus;

import fi.mxsampsa.ui.LogiikkaKehys;

/**
 * Pääluokka, suoritus alkaa täältä. Käynnistää käyttöliittymän.
 *
 * @author mxsampsa
 */
public class Main {

    /**
     * Suorituksen aloittava Main-metodi.
     *
     * @param args main
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LogiikkaKehys kehys = new LogiikkaKehys();
                kehys.setVisible(true);
            }
        });
    }
}
