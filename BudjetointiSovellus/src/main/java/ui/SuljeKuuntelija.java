
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Käyttöliittymän "tapahtuman kuuntelija".
 * <p>
 * "Sulje" nappia painettaessa kysyy tallennetaanko budjetti.
 * 
 * @author Sampsa
 */
public class SuljeKuuntelija implements ActionListener {
    private JFrame frame;
    
    public SuljeKuuntelija(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n = JOptionPane.showConfirmDialog(
            frame,
            "Haluatko tallentaa ennen sulkemista",
            "Tallennetaanko?",
            JOptionPane.YES_NO_OPTION);
    }
    
}
