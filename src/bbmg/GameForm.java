/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbmg;

//import bbmg.Message;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;



/**
 *
 * @author Mimi
 */
public class GameForm extends javax.swing.JFrame {

    
    public GameForm() {
        
        initComponents();
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnReplay = new javax.swing.JButton();
        gamePanel1 = new bbmg.GamePanel();
        txScore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Memory Game");
        setMaximumSize(new java.awt.Dimension(1150, 565));
        setPreferredSize(new java.awt.Dimension(1150, 565));

        jLabel2.setText("Enter name:");

        txName.setToolTipText("");
        txName.setMaximumSize(new java.awt.Dimension(6, 20));
        txName.setName(""); // NOI18N

        jLabel3.setText("Score:");

        btnStart.setText("START");
        btnStart.setName(""); // NOI18N
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jScrollPane1.setEnabled(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(1);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jTextArea1.setMaximumSize(new java.awt.Dimension(104, 64));
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.getAccessibleContext().setAccessibleName("");

        btnReplay.setText("PLAY Again");
        btnReplay.setActionCommand("");
        btnReplay.setName(""); // NOI18N
        btnReplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplayActionPerformed(evt);
            }
        });

        txScore.setText(String.valueOf(gamePanel1.getScore()));
        txScore.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txName, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addGap(20, 20, 20)
                        .addComponent(btnReplay))
                    .addComponent(txScore)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                .addComponent(gamePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txScore)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStart)
                            .addComponent(btnReplay)))
                    .addComponent(gamePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel2.getAccessibleContext().setAccessibleName("lbname");
        txName.getAccessibleContext().setAccessibleName("Name");
        jLabel3.getAccessibleContext().setAccessibleName("lbbet");
        btnStart.getAccessibleContext().setAccessibleName("Start");
        btnReplay.getAccessibleContext().setAccessibleName("End");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        //name has not been entered
        if (txName.getText().isEmpty()){
            Message.infoBox("Please enter your name!", "No name");
        return;
        }
        
        btnStart.setEnabled(false);
        txName.setEnabled(false);
        gamePanel1.setVisible(true);
        
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnReplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplayActionPerformed
        
        btnStart.setEnabled(true);
        txName.setEnabled(true);
        gamePanel1.setVisible(false);
        gamePanel1.reset();

    }//GEN-LAST:event_btnReplayActionPerformed


    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReplay;
    private javax.swing.JButton btnStart;
    private bbmg.GamePanel gamePanel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txName;
    private javax.swing.JLabel txScore;
    // End of variables declaration//GEN-END:variables

    
}
