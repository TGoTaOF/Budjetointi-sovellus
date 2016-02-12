
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Käyttöliittymän "tapahtuman kuuntelija".
 * <p>
 * "Uusi" nappia painettaessa kysyy nimen uudelle budjetille.
 * 
 * @author Sampsa
 */
public class UusiKuuntelija implements ActionListener {
    private JFrame frame;
    
    public UusiKuuntelija(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = (String) JOptionPane.showInputDialog(
                    frame,
                    "Uuden budjetin nimi:",
                    "Uusi budjetti",
                    JOptionPane.PLAIN_MESSAGE,
                    null, null, "");
    }
    
}
