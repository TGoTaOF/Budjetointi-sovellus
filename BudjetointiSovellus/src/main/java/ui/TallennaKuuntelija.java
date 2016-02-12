
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Käyttöliittymän "tapahtuman kuuntelija".
 * <p>
 * "Tallenna" nappia painettaessa kysyy tallennetaanko salasanalla.
 * 
 * @author Sampsa
 */
public class TallennaKuuntelija implements ActionListener {
    private JFrame frame;
    
    public TallennaKuuntelija(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n = JOptionPane.showConfirmDialog(
            frame,
            "Tallennetaanko uudella salasanalla?",
            "Tallenna",
            JOptionPane.YES_NO_OPTION);
        if (n == 1) {
            String s = (String) JOptionPane.showInputDialog(
                    frame,
                    "Uusi salasana:",
                    "Uusi salasana",
                    JOptionPane.PLAIN_MESSAGE,
                    null, null, "");
        }
    }
    
}
