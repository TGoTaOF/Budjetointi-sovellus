/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mxsampsa.ui;

import fi.mxsampsa.budjetointisovellus.Budjetti;

/**
 *
 * @author Sampsa
 */
public class SalausUI extends javax.swing.JDialog {

    private Budjetti budjetti;
    private String komento;
    private UIKehys kutsuja;

    /**
     * Creates new form SalausUI
     */
    public SalausUI(java.awt.Frame parent, boolean modal, Budjetti parametriBudjetti, String s, UIKehys kutsuja) {
        super(parent, modal);
        initComponents();
        this.budjetti = parametriBudjetti;
        this.komento = s;
        this.kutsuja = kutsuja;
        paivita();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        napitKehys = new javax.swing.JPanel();
        Nappi1 = new javax.swing.JButton();
        Nappi2 = new javax.swing.JButton();
        Nappi3 = new javax.swing.JButton();
        Nappi4 = new javax.swing.JButton();
        Nappi5 = new javax.swing.JButton();
        Nappi6 = new javax.swing.JButton();
        Nappi7 = new javax.swing.JButton();
        Nappi8 = new javax.swing.JButton();
        Nappi9 = new javax.swing.JButton();
        Nappi0 = new javax.swing.JButton();
        NappiTakaisin = new javax.swing.JButton();
        lisaKehys = new javax.swing.JPanel();
        nappiOK = new javax.swing.JButton();
        nappiPeruuta = new javax.swing.JButton();
        salasana = new javax.swing.JLabel();
        salasanaTeksti = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 450));
        setPreferredSize(new java.awt.Dimension(300, 450));

        Nappi1.setText("1");
        Nappi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nappi1ActionPerformed(evt);
            }
        });

        Nappi2.setText("2");
        Nappi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nappi2ActionPerformed(evt);
            }
        });

        Nappi3.setText("3");
        Nappi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nappi3ActionPerformed(evt);
            }
        });

        Nappi4.setText("4");
        Nappi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nappi4ActionPerformed(evt);
            }
        });

        Nappi5.setText("5");
        Nappi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nappi5ActionPerformed(evt);
            }
        });

        Nappi6.setText("6");
        Nappi6.setPreferredSize(new java.awt.Dimension(73, 49));
        Nappi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nappi6ActionPerformed(evt);
            }
        });

        Nappi7.setText("7");
        Nappi7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nappi7ActionPerformed(evt);
            }
        });

        Nappi8.setText("8");
        Nappi8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nappi8ActionPerformed(evt);
            }
        });

        Nappi9.setText("9");
        Nappi9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nappi9ActionPerformed(evt);
            }
        });

        Nappi0.setText("0");
        Nappi0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nappi0ActionPerformed(evt);
            }
        });

        NappiTakaisin.setText("C");
        NappiTakaisin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappiTakaisinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout napitKehysLayout = new javax.swing.GroupLayout(napitKehys);
        napitKehys.setLayout(napitKehysLayout);
        napitKehysLayout.setHorizontalGroup(
            napitKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(napitKehysLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(napitKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Nappi7, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(Nappi4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nappi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(napitKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nappi0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(napitKehysLayout.createSequentialGroup()
                        .addGroup(napitKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Nappi5, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(Nappi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Nappi8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(napitKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(napitKehysLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(NappiTakaisin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Nappi9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nappi3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nappi6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        napitKehysLayout.setVerticalGroup(
            napitKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(napitKehysLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(napitKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nappi2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(Nappi3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nappi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(napitKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Nappi6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nappi4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nappi5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(napitKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Nappi8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(Nappi7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nappi9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(napitKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nappi0, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NappiTakaisin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        nappiOK.setText("OK");
        nappiOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappiOKActionPerformed(evt);
            }
        });

        nappiPeruuta.setText("Peruuta");
        nappiPeruuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappiPeruutaActionPerformed(evt);
            }
        });

        salasana.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        salasana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salasana.setText("-");
        salasana.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout lisaKehysLayout = new javax.swing.GroupLayout(lisaKehys);
        lisaKehys.setLayout(lisaKehysLayout);
        lisaKehysLayout.setHorizontalGroup(
            lisaKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lisaKehysLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lisaKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(lisaKehysLayout.createSequentialGroup()
                        .addComponent(nappiOK, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nappiPeruuta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(salasana, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lisaKehysLayout.setVerticalGroup(
            lisaKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lisaKehysLayout.createSequentialGroup()
                .addComponent(salasana, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lisaKehysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nappiOK, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(nappiPeruuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        salasanaTeksti.setText("4-numeroinen salasana:");
        salasanaTeksti.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lisaKehys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(napitKehys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(salasanaTeksti, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salasanaTeksti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(napitKehys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lisaKehys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Nappi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nappi1ActionPerformed
        if (salasanaOnViiva()) {
            salasana.setText("1");
        } else if (!salasananPituusNelja()) {
            salasana.setText(salasana.getText() + "1");
        }
        paivita();
    }//GEN-LAST:event_Nappi1ActionPerformed

    private void Nappi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nappi2ActionPerformed
        if (salasanaOnViiva()) {
            salasana.setText("2");
        } else if (!salasananPituusNelja()) {
            salasana.setText(salasana.getText() + "2");
        }
        paivita();
    }//GEN-LAST:event_Nappi2ActionPerformed

    private void Nappi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nappi3ActionPerformed
        if (salasanaOnViiva()) {
            salasana.setText("3");
        } else if (!salasananPituusNelja()) {
            salasana.setText(salasana.getText() + "3");
        }
        paivita();
    }//GEN-LAST:event_Nappi3ActionPerformed

    private void Nappi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nappi4ActionPerformed
        if (salasanaOnViiva()) {
            salasana.setText("4");
        } else if (!salasananPituusNelja()) {
            salasana.setText(salasana.getText() + "4");
        }
        paivita();
    }//GEN-LAST:event_Nappi4ActionPerformed

    private void Nappi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nappi5ActionPerformed
        if (salasanaOnViiva()) {
            salasana.setText("5");
        } else if (!salasananPituusNelja()) {
            salasana.setText(salasana.getText() + "5");
        }
        paivita();
    }//GEN-LAST:event_Nappi5ActionPerformed

    private void Nappi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nappi6ActionPerformed
        if (salasanaOnViiva()) {
            salasana.setText("6");
        } else if (!salasananPituusNelja()) {
            salasana.setText(salasana.getText() + "6");
        }
        paivita();
    }//GEN-LAST:event_Nappi6ActionPerformed

    private void Nappi7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nappi7ActionPerformed
        if (salasanaOnViiva()) {
            salasana.setText("7");
        } else if (!salasananPituusNelja()) {
            salasana.setText(salasana.getText() + "7");
        }
        paivita();
    }//GEN-LAST:event_Nappi7ActionPerformed

    private void Nappi8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nappi8ActionPerformed
        if (salasanaOnViiva()) {
            salasana.setText("8");
        } else if (!salasananPituusNelja()) {
            salasana.setText(salasana.getText() + "8");
        }
        paivita();
    }//GEN-LAST:event_Nappi8ActionPerformed

    private void Nappi9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nappi9ActionPerformed
        if (salasanaOnViiva()) {
            salasana.setText("9");
        } else if (!salasananPituusNelja()) {
            salasana.setText(salasana.getText() + "9");
        }
        paivita();
    }//GEN-LAST:event_Nappi9ActionPerformed

    private void Nappi0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nappi0ActionPerformed
        if (salasanaOnViiva()) {
            salasana.setText("0");
        } else if (!salasananPituusNelja()) {
            salasana.setText(salasana.getText() + "0");
        }
        paivita();
    }//GEN-LAST:event_Nappi0ActionPerformed

    private void NappiTakaisinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappiTakaisinActionPerformed
        if (this.salasana.getText().equals("-")) {
        } else if (this.salasana.getText().length() > 1) {
            String apu = "";
            for (int i = 0; i < this.salasana.getText().length() - 1; i++) {
                apu = apu + this.salasana.getText().charAt(i);
            }
            this.salasana.setText(apu);
        } else {
            this.salasana.setText("-");
        }
        paivita();
    }//GEN-LAST:event_NappiTakaisinActionPerformed

    private void nappiOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappiOKActionPerformed
        try {
            switch (this.komento) {
                case "tallenna":
                    this.budjetti.tallennaBudjetti(this.salasana.getText());
                    break;
                case "avaa":
                    this.budjetti.avaaBudjetti(this.salasana.getText());
                    break;
            }
        } catch (Exception e) {
            this.kutsuja.sattuikoVirhe = true;
        } finally {
            this.dispose();
        }
    }//GEN-LAST:event_nappiOKActionPerformed

    private void nappiPeruutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappiPeruutaActionPerformed
        this.kutsuja.keskeytetty = true;
        this.dispose();
    }//GEN-LAST:event_nappiPeruutaActionPerformed

    public void paivita() {
        if (salasananPituusNelja()) {
            this.nappiOK.setEnabled(true);
        } else {
            this.nappiOK.setEnabled(false);
        }
    }

    public boolean salasananPituusNelja() {
        return this.salasana.getText().length() >= 4;
    }

    public boolean salasanaOnViiva() {
        return this.salasana.getText().equals("-");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Nappi0;
    private javax.swing.JButton Nappi1;
    private javax.swing.JButton Nappi2;
    private javax.swing.JButton Nappi3;
    private javax.swing.JButton Nappi4;
    private javax.swing.JButton Nappi5;
    private javax.swing.JButton Nappi6;
    private javax.swing.JButton Nappi7;
    private javax.swing.JButton Nappi8;
    private javax.swing.JButton Nappi9;
    private javax.swing.JButton NappiTakaisin;
    private javax.swing.JPanel lisaKehys;
    private javax.swing.JPanel napitKehys;
    private javax.swing.JButton nappiOK;
    private javax.swing.JButton nappiPeruuta;
    private javax.swing.JLabel salasana;
    private javax.swing.JLabel salasanaTeksti;
    // End of variables declaration//GEN-END:variables
}
