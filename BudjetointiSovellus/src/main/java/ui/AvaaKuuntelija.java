
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
 * Käyttöliittymän "tapahtuman kuuntelija".
 * <p>
 * "Avaa" nappia painettaessa avaa tiedoston valitsemis ikkunan.
 * 
 * @author Sampsa
 */
public class AvaaKuuntelija implements ActionListener {
    
    public AvaaKuuntelija() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser valitsija = new JFileChooser();
        File sovelluskansio = new File(System.getProperty("user.dir"));
        valitsija.setCurrentDirectory(sovelluskansio);
        if (valitsija.showOpenDialog(valitsija) == JFileChooser.APPROVE_OPTION) {
            File tiedosto = valitsija.getSelectedFile();
        }
    }
    
}
