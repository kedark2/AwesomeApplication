/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wonderworld.GraphicalFrame;

import simpleCalculator.CalculatorFrame;
import wonderworld.simplegame.QuizGame;

/**
 *
 * @author kanel
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atmButton = new javax.swing.JButton();
        calculatorButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        simpleGameButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atmButton.setText("AccessATM");
        atmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atmButtonActionPerformed(evt);
            }
        });
        getContentPane().add(atmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 144, 40));

        calculatorButton.setText("AccessCalculator");
        calculatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculatorButtonActionPerformed(evt);
            }
        });
        getContentPane().add(calculatorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 140, 40));

        jLabel1.setBackground(new java.awt.Color(0, 0, 204));
        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 0));
        jLabel1.setText("Wanna Exit? Press Exit Button :)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 236, 66, 30));

        simpleGameButton.setText("Play Quiz Game");
        simpleGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpleGameButtonActionPerformed(evt);
            }
        });
        getContentPane().add(simpleGameButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 140, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\kanel\\Documents\\Atm_Simulator\\8.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 210, 240));

        jLabel3.setText("Developed By Kedar");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void calculatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculatorButtonActionPerformed
        new CalculatorFrame().setVisible(true);
        
    }//GEN-LAST:event_calculatorButtonActionPerformed

    private void atmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atmButtonActionPerformed

        new wonderworld.atm_simulator.graphics.WelcomeScreen().setVisible(true);

    }//GEN-LAST:event_atmButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void simpleGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpleGameButtonActionPerformed

        new QuizGame().QuizGame();
    }//GEN-LAST:event_simpleGameButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atmButton;
    private javax.swing.JButton calculatorButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton simpleGameButton;
    // End of variables declaration//GEN-END:variables
}
