package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Sovelluksen käyttöliittymä.
 * 
 * @author mxsampsa
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    
    /**
     * 
     */
    public Kayttoliittyma() {
    }
    
    /**
     * Määrittelee/luo/"avaa" sovelluksen ikkunan. 
     */
    @Override
    public void run() {
        frame = new JFrame("Budjetointi-sovellus");
        frame.setPreferredSize(new Dimension(600, 800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Luo komponentit käyttöliittymään.
     */
    private void luoKomponentit(Container container) {
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
        buttons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JButton uusi = new JButton("Uusi");
        UusiKuuntelija uusija = new UusiKuuntelija(frame);
        uusi.addActionListener(uusija);
        
        JButton avaa = new JButton("Avaa");
        AvaaKuuntelija avaaja = new AvaaKuuntelija();
        avaa.addActionListener(avaaja);
        
        JButton tallenna = new JButton("Tallenna");
        TallennaKuuntelija tallentaja = new TallennaKuuntelija(frame);
        tallenna.addActionListener(tallentaja);
        
        JButton sulje = new JButton("Sulje");
        SuljeKuuntelija sulkija = new SuljeKuuntelija(frame);
        sulje.addActionListener(sulkija);
        
        buttons.add(uusi);
        buttons.add(Box.createRigidArea(new Dimension(10, 0)));
        buttons.add(avaa);
        buttons.add(Box.createRigidArea(new Dimension(10, 0)));
        buttons.add(tallenna);
        buttons.add(Box.createRigidArea(new Dimension(10, 0)));
        buttons.add(sulje);
        
        JPanel budjetti = new JPanel();
        budjetti.setLayout(new BoxLayout(budjetti, BoxLayout.Y_AXIS));
        budjetti.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        container.add(buttons, BorderLayout.PAGE_START);
    }

    /**
     * Palauttaa kehyksen.
     */
    public JFrame getFrame() {
        return frame;
    }
}