/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wonderworld.atm_simulator.graphics;

import wonderworld.atm_simulator.BankAccount;
import wonderworld.atm_simulator.CreateReceipt;
import wonderworld.atm_simulator.Deposit;
import wonderworld.atm_simulator.Log;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kanel
 */
public class DepositScreen extends javax.swing.JFrame {

    /**
     * Creates new form DepositScrn
     */
    public DepositScreen() {
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

        depositMsg = new javax.swing.JLabel();
        depositField = new javax.swing.JTextField();
        depositButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        depositMsg.setText("Enter the amount you want to deposit");

        depositButton.setText("Deposit");
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        jLabel3.setText("KK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(depositMsg))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(depositButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(depositField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(78, 78, 78)
                .addComponent(depositMsg)
                .addGap(27, 27, 27)
                .addComponent(depositField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depositButton)
                    .addComponent(cancelButton))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositButtonActionPerformed
       int depositAmount;
       int dialogButton = 0;
       if(depositField.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Please enter the number first.");
       }
       else{
           depositAmount = Integer.parseInt(depositField.getText());
           Deposit put = new Deposit();
           put.setAmount(depositAmount);
           BankAccount.addBalance(put.getAmount());
           try {
               Log.addLog(put,BankAccount.getAccountName());
           } catch (IOException ex) {
               Logger.getLogger(DepositScreen.class.getName()).log(Level.SEVERE, null, ex);
           }
           dialogButton = JOptionPane.showConfirmDialog (null, "Do you want to print the receipt?","WARNING", dialogButton);
           if (dialogButton == JOptionPane.YES_OPTION) {
               this.setVisible(false);
               CreateReceipt create =  new CreateReceipt();
               create.createReceipt(put);
           }
           else
           {
               this.setVisible(false);
           }            
       } 
        
    }//GEN-LAST:event_depositButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed

        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton depositButton;
    private javax.swing.JTextField depositField;
    private javax.swing.JLabel depositMsg;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
