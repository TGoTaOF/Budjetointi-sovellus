package fi.mxsampsa.ui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Luokka ilmoittaa virheellisyydestä ponnahdusikkunalla.
 * <p>
 * Esim. käyttäjän antaessa virheellisen syötteen. Ei kuitenkaan sulje ohjelmaa.
 *
 * @author Sampsa
 */
public class VirheIlmoitus {

    private JPanel kehys;

    /**
     * Luokan alustus.
     *
     * @param parametriKehys kehys ponnahdusikkunan "vanhemmaksi"(parent).
     */
    public VirheIlmoitus(JPanel parametriKehys) {
        this.kehys = parametriKehys;
    }
    
    /**
     * Katsoo onko käyttäjän syöte epäkelpo.
     * <p>
     * a-ö ja 0-9 kelpaa.
     * @param syote käyttäjän syöte.
     * @return kelpaako vai ei.
     */
    public boolean virheellinenSyote(String syote) {
        if (syote == null || syote.isEmpty()) {
            return true;
        }
        String sallitut = "abcdefghijklmnopqrstuvwxyzåäö1234567890";
        for (int i = 0; i < syote.length(); i++) {
            if (!sallitut.contains("" + syote.charAt(i))) {
                JOptionPane.showMessageDialog(this.kehys,
                        "Virheellinen syöte!",
                        "Virheellinen syöte!",
                        JOptionPane.WARNING_MESSAGE);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Ilmoittaa mikäli tapahtui virhe salasanaa kysyvässä guissa.
     * <p>
     * metodia kutsutaan vain poikkeuksen tapahtuessa.
     * @return palauttaa aina true.
     */
    public boolean virheSalasanaaKysyttaessa() {
        JOptionPane.showMessageDialog(this.kehys,
                "Jotain meni vikaan! :/\nOliko oikea salasana?",
                "Jotain meni vikaan!",
                JOptionPane.WARNING_MESSAGE);
        return true;
    }
    
    /**
     * Ilmoittaa mikäli käyttäjän syöte ei ollut luku.
     * <p>
     * metodia kutsutaan vain poikkeuksen tapahtuessa.
     * @return /palauttaa aina true.
     */
    public boolean syoteEiLuku() {
        JOptionPane.showMessageDialog(this.kehys,
                "Ei syötetty lukua!",
                "Ei syötetty lukua!",
                JOptionPane.WARNING_MESSAGE);
        return true;
    }
    
    /**
     * Ilmoittaa mikäli uuden budjetin luominen ei onnistunut.
     * <p>
     * metodia kutsutaan vain poikkeuksen tapahtuessa.
     * @return /palauttaa aina true.
     */
    public boolean uudenBudjetinLuominenEpaonnistui() {
        JOptionPane.showMessageDialog(this.kehys,
                "Jotain meni vikaan uutta budjettia luodessa! :/",
                "Virhe havaittiin!",
                JOptionPane.WARNING_MESSAGE);
        return true;
    }
    
    /**
     * Ilmoittaa mikäli budjetin tallentaminen ei onnistunut.
     * <p>
     * metodia kutsutaan vain poikkeuksen tapahtuessa.
     * @return /palauttaa aina true.
     */
    public boolean budjetinTallentaminenEpaonnistui() {
        JOptionPane.showMessageDialog(this.kehys,
                "Jotain meni vikaan budjettia tallennettaessa! :/",
                "Virhe havaittiin!",
                JOptionPane.WARNING_MESSAGE);
        return true;
    }
    
    /**
     * Ilmoittaa jos olemassa olevan budjetin avaus ei onnistunut.
     * <p>
     * metodia kutsutaan vain poikkeuksen tapahtuessa.
     * @return /palauttaa aina true.
     */
    public boolean budjetinAvaaminenEpaonnistui() {
        JOptionPane.showMessageDialog(this.kehys,
                "Jotain meni vikaan olemassa olevaa budjettia avattaessa! :/",
                "Virhe havaittiin!",
                JOptionPane.WARNING_MESSAGE);
        return true;
    }
    
    public void eiRiviaValittuna() {
        JOptionPane.showMessageDialog(this.kehys,
                "Valitse rivi ennen poistoa.",
                "Valitse rivi!",
                JOptionPane.WARNING_MESSAGE);
    }
}
