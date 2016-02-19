/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mxsampsa.ui;

import fi.mxsampsa.budjetointisovellus.Budjetti;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Sampsa
 */
public class UIKehys extends javax.swing.JPanel {

    private Budjetti budjetti;
    private boolean onkoBudjettiAvattuna;
    private VirheIlmoitus virheIlmoitus;

    /**
     * Creates new form UIKehys
     *
     * @param parametriBudjetti
     */
    public UIKehys(Budjetti parametriBudjetti) {
        initComponents();
        this.budjetti = parametriBudjetti;
        this.onkoBudjettiAvattuna = false;
        this.virheIlmoitus = new VirheIlmoitus(this);
        paivitaKaikki();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uusiNappi = new javax.swing.JButton();
        avaaNappi = new javax.swing.JButton();
        tallennaNappi = new javax.swing.JButton();
        suljeNappi = new javax.swing.JButton();
        tulotTeksti = new javax.swing.JLabel();
        menotTeksti = new javax.swing.JLabel();
        tulotYhteensaTeksti = new javax.swing.JLabel();
        menotYhteensaTeksti = new javax.swing.JLabel();
        saldoTeksti = new javax.swing.JLabel();
        menotKehys = new javax.swing.JPanel();
        merkinta = new javax.swing.JTextField();
        arvo = new javax.swing.JTextField();
        lisaaNappi = new javax.swing.JButton();
        PoistaNappi = new javax.swing.JButton();
        tulotKehys = new javax.swing.JPanel();
        budjetinNimi = new javax.swing.JLabel();
        tekijanNimi = new javax.swing.JLabel();
        luontiPaivaTeksti = new javax.swing.JLabel();
        viimeksiMuokattuTeksti = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));

        uusiNappi.setText("Uusi");
        uusiNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uusiNappiActionPerformed(evt);
            }
        });

        avaaNappi.setText("Avaa");
        avaaNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avaaNappiActionPerformed(evt);
            }
        });

        tallennaNappi.setText("Tallenna");
        tallennaNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tallennaNappiActionPerformed(evt);
            }
        });

        suljeNappi.setText("Sulje nykyinen");
        suljeNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suljeNappiActionPerformed(evt);
            }
        });

        tulotTeksti.setText("Tulot");

        menotTeksti.setText("Menot");

        tulotYhteensaTeksti.setText("Tulot yhteensä: ");

        menotYhteensaTeksti.setText("Menot yhteensä: ");

        saldoTeksti.setText("Saldo: ");

        menotKehys.setPreferredSize(new java.awt.Dimension(260, 400));

        lisaaNappi.setText("Lisää");

        PoistaNappi.setText("Poista");

        javax.swing.GroupLayout menotKehysLayout = new javax.swing.GroupLayout(menotKehys);
        menotKehys.setLayout(menotKehysLayout);
        menotKehysLayout.setHorizontalGroup(
            menotKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menotKehysLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PoistaNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menotKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lisaaNappi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menotKehysLayout.createSequentialGroup()
                        .addComponent(merkinta, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arvo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        menotKehysLayout.setVerticalGroup(
            menotKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menotKehysLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menotKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(merkinta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PoistaNappi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lisaaNappi)
                .addContainerGap(337, Short.MAX_VALUE))
        );

        tulotKehys.setPreferredSize(new java.awt.Dimension(260, 400));

        javax.swing.GroupLayout tulotKehysLayout = new javax.swing.GroupLayout(tulotKehys);
        tulotKehys.setLayout(tulotKehysLayout);
        tulotKehysLayout.setHorizontalGroup(
            tulotKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        tulotKehysLayout.setVerticalGroup(
            tulotKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        budjetinNimi.setText("Budjetin nimi: -");

        tekijanNimi.setText("Tekijä: -");

        luontiPaivaTeksti.setText("Luonti päivä: -");

        viimeksiMuokattuTeksti.setText("Viimeksi muokattu: -");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(uusiNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(avaaNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                        .addComponent(tallennaNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186)
                        .addComponent(suljeNappi)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(budjetinNimi, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tekijanNimi, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tulotTeksti, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(255, 255, 255)
                                        .addComponent(menotTeksti, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(361, 361, 361)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(menotKehys, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(luontiPaivaTeksti)
                                    .addComponent(viimeksiMuokattuTeksti))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(116, 116, 116))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tulotKehys, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(menotYhteensaTeksti, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tulotYhteensaTeksti, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saldoTeksti, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uusiNappi)
                    .addComponent(avaaNappi)
                    .addComponent(suljeNappi)
                    .addComponent(tallennaNappi))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(budjetinNimi)
                    .addComponent(luontiPaivaTeksti))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viimeksiMuokattuTeksti)
                    .addComponent(tekijanNimi))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tulotTeksti, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menotTeksti))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menotKehys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tulotKehys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tulotYhteensaTeksti)
                    .addComponent(menotYhteensaTeksti)
                    .addComponent(saldoTeksti))
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void uusiNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uusiNappiActionPerformed
        String s = (String) JOptionPane.showInputDialog(
                this,
                "Uuden budjetin nimi:\n(a-ö ja 0-9 kelpaavat)",
                "Uusi budjetti",
                JOptionPane.PLAIN_MESSAGE,
                null, null, "");
        if (!this.virheIlmoitus.virheellinenSyote(s)) {
            String s2 = (String) JOptionPane.showInputDialog(
                    this,
                    "Tekijän nimi:\n(a-ö ja 0-9 kelpaavat)",
                    "Uusi budjetti",
                    JOptionPane.PLAIN_MESSAGE,
                    null, null, "");
            if (!this.virheIlmoitus.virheellinenSyote(s)) {
                this.budjetti.valitseBudjetti(s, s2);
                this.budjetti.avaaBudjetti("-");
                this.onkoBudjettiAvattuna = true;
            }
        }
        paivitaKaikki();
    }//GEN-LAST:event_uusiNappiActionPerformed

    private void avaaNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avaaNappiActionPerformed
        JFileChooser valitsija = new JFileChooser();
        File sovelluskansio = new File(System.getProperty("user.dir"));
        valitsija.setCurrentDirectory(sovelluskansio);
        if (valitsija.showOpenDialog(valitsija) == JFileChooser.APPROVE_OPTION) {
            File tiedosto = valitsija.getSelectedFile();
            this.budjetti.valitseBudjetti(tiedosto);
            this.budjetti.avaaBudjetti("-");
            this.onkoBudjettiAvattuna = true;
        }
        
        paivitaKaikki();
    }//GEN-LAST:event_avaaNappiActionPerformed

    private void suljeNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suljeNappiActionPerformed
        int n = JOptionPane.showConfirmDialog(
                this,
                "Haluatko tallentaa ennen sulkemista?",
                "Tallennetaanko?",
                JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            tallennaNappi.doClick();
        }
        this.budjetti.suljeBudjetti();
        this.onkoBudjettiAvattuna = false;
        paivitaKaikki();
    }//GEN-LAST:event_suljeNappiActionPerformed

    private void tallennaNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tallennaNappiActionPerformed
        int n = JOptionPane.showConfirmDialog(
                this,
                "Tallennetaanko uudella salasanalla?",
                "Tallenna",
                JOptionPane.YES_NO_OPTION); 
        if (n == 0) {
            salasananKysynta();
        }
        paivitaKaikki();
    }//GEN-LAST:event_tallennaNappiActionPerformed

    public void paivitaKaikki() {
        menotYhteensaTeksti.setText("Menot Yhteensä: " + this.budjetti.menotSumma());
        tulotYhteensaTeksti.setText("Tulot Yhteensä: " + this.budjetti.tulotSumma());
        saldoTeksti.setText("Saldo: " + this.budjetti.summa());
        if (this.onkoBudjettiAvattuna == true) {
            avaaNappi.setEnabled(false);
            uusiNappi.setEnabled(false);
            tallennaNappi.setEnabled(true);
            suljeNappi.setEnabled(true);
            budjetinNimi.setText("Budjetin nimi: " + this.budjetti.budjetinNimi());
            tekijanNimi.setText("Tekijä: " + this.budjetti.budjetinTekija());
            luontiPaivaTeksti.setText("Luonti päivä: " + this.budjetti.budjetinLuontiPaiva());
            viimeksiMuokattuTeksti.setText("Viimeksi muokattu: " + this.budjetti.viimeinenMuokkausPaiva());
        } else {
            avaaNappi.setEnabled(true);
            uusiNappi.setEnabled(true);
            tallennaNappi.setEnabled(false);
            suljeNappi.setEnabled(false);
            budjetinNimi.setText("Budjetin nimi: -");
            tekijanNimi.setText("Tekijä: -");
            luontiPaivaTeksti.setText("Luonti päivä: -");
            viimeksiMuokattuTeksti.setText("Viimeksi muokattu: -");
        }
    }

    public boolean salasananKysynta() {
        try {
            SalausUIKehys kehys = new SalausUIKehys(this.budjetti);
            kehys.setVisible(true);
            //May need run();
            return true;
        } catch (Exception e) {
            return this.virheIlmoitus.virheSalasanaaKysyttaessa();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PoistaNappi;
    private javax.swing.JTextField arvo;
    private javax.swing.JButton avaaNappi;
    private javax.swing.JLabel budjetinNimi;
    private javax.swing.JButton lisaaNappi;
    private javax.swing.JLabel luontiPaivaTeksti;
    private javax.swing.JPanel menotKehys;
    private javax.swing.JLabel menotTeksti;
    private javax.swing.JLabel menotYhteensaTeksti;
    private javax.swing.JTextField merkinta;
    private javax.swing.JLabel saldoTeksti;
    private javax.swing.JButton suljeNappi;
    private javax.swing.JButton tallennaNappi;
    private javax.swing.JLabel tekijanNimi;
    private javax.swing.JPanel tulotKehys;
    private javax.swing.JLabel tulotTeksti;
    private javax.swing.JLabel tulotYhteensaTeksti;
    private javax.swing.JButton uusiNappi;
    private javax.swing.JLabel viimeksiMuokattuTeksti;
    // End of variables declaration//GEN-END:variables
}
