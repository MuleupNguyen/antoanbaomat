package views.component;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import models.FileModel;
import models.KeyModel;
import models.symmetricEncryption.Vigenere;
import views.dialogs.DialogAddKey;
import views.dialogs.DialogShowKey;

public class VigenereFileForm extends javax.swing.JPanel {

    private String sourceFile;
    private String desFile;

    public VigenereFileForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCBSizeKey = new javax.swing.JComboBox<>();
        jButtonDelete = new javax.swing.JButton();
        jButtonCreateKey = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTFKey = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jButtonUpKey = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButtonEncrypt = new javax.swing.JButton();
        jButtonDecrypt = new javax.swing.JButton();
        jBClearInput = new javax.swing.JButton();
        jBClearOutput = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jBFileOutput = new javax.swing.JButton();
        jBFileInput = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CIPHER FILE  Vigenere");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Key size :");

        jCBSizeKey.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "56", "" }));
        jCBSizeKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSizeKeyActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(220, 53, 69));
        jButtonDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.setBorderPainted(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonCreateKey.setBackground(new java.awt.Color(25, 135, 84));
        jButtonCreateKey.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCreateKey.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCreateKey.setText("Create");
        jButtonCreateKey.setBorderPainted(false);
        jButtonCreateKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateKeyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBSizeKey, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCreateKey, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCreateKey, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBSizeKey, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Key :");
        jLabel3.setPreferredSize(new java.awt.Dimension(37, 22));

        jTFKey.setToolTipText("");
        jTFKey.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTFKey.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTFKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFKeyActionPerformed(evt);
            }
        });

        jButtonSave.setBackground(new java.awt.Color(25, 135, 84));
        jButtonSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonSave.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSave.setText("Save");
        jButtonSave.setBorderPainted(false);
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonUpKey.setBackground(new java.awt.Color(25, 135, 84));
        jButtonUpKey.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonUpKey.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpKey.setText("Keys");
        jButtonUpKey.setBorderPainted(false);
        jButtonUpKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpKeyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTFKey, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonUpKey, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTFKey))
                    .addComponent(jButtonUpKey, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Input:");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jButtonEncrypt.setBackground(new java.awt.Color(25, 135, 84));
        jButtonEncrypt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonEncrypt.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEncrypt.setText("Encrypt");
        jButtonEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncryptActionPerformed(evt);
            }
        });

        jButtonDecrypt.setBackground(new java.awt.Color(25, 135, 84));
        jButtonDecrypt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonDecrypt.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDecrypt.setText("Decrypt");
        jButtonDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecryptActionPerformed(evt);
            }
        });

        jBClearInput.setBackground(new java.awt.Color(220, 53, 69));
        jBClearInput.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBClearInput.setForeground(new java.awt.Color(255, 255, 255));
        jBClearInput.setText("Clear Input");
        jBClearInput.setActionCommand("Clear input");
        jBClearInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClearInputActionPerformed(evt);
            }
        });

        jBClearOutput.setBackground(new java.awt.Color(220, 53, 69));
        jBClearOutput.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBClearOutput.setForeground(new java.awt.Color(255, 255, 255));
        jBClearOutput.setText("Clear output");
        jBClearOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClearOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBClearOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBClearInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDecrypt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEncrypt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonEncrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDecrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jBClearInput, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBClearOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Output:");

        jBFileOutput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBFileOutput.setText("OUTPUT");
        jBFileOutput.setEnabled(false);
        jBFileOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFileOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBFileOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBFileOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jBFileInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBFileInput.setText("DROP FILE HERE");
        jBFileInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFileInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jBFileInput, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBFileInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCBSizeKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSizeKeyActionPerformed
        String selectedOption = jCBSizeKey.getSelectedItem().toString();
    }//GEN-LAST:event_jCBSizeKeyActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        jTFKey.setText("");
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonCreateKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateKeyActionPerformed
        int keySize = Integer.parseInt(jCBSizeKey.getSelectedItem().toString());
        Vigenere vigenere = new Vigenere();
        jTFKey.setText(vigenere.createKeyEnglish(keySize));

    }//GEN-LAST:event_jButtonCreateKeyActionPerformed

    private void jTFKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFKeyActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        String key = jTFKey.getText().trim();
        int keySize = Integer.parseInt(jCBSizeKey.getSelectedItem().toString());
        if (key.isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập key.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            DialogAddKey dialog = new DialogAddKey((JFrame) SwingUtilities.getWindowAncestor(this), true);
            dialog.setType("Vigenere");
            dialog.setKey(key);
            dialog.setKeySize(keySize);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);

        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonUpKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpKeyActionPerformed
        DialogShowKey dialog = new DialogShowKey((JFrame) SwingUtilities.getWindowAncestor(this), true);
        dialog.setType("Vigenere");
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        KeyModel keyTarget = dialog.getKeyTarget();
        if (keyTarget != null) {
            jTFKey.setText(keyTarget.getKey());
        }
    }//GEN-LAST:event_jButtonUpKeyActionPerformed

    private void jButtonEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncryptActionPerformed
        String key = jTFKey.getText().trim();
        if (key.isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập key.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            if (sourceFile == null || desFile == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn file.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                Vigenere vigenere = new Vigenere();

                try {
                    vigenere.encryptFile(sourceFile, desFile, key);
                    File f = new File(desFile);
                    if (f.exists()) {
                        jBFileOutput.setText(f.getName());
                        jBFileOutput.setEnabled(true);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(VigenereFileForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }//GEN-LAST:event_jButtonEncryptActionPerformed

    private void jButtonDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecryptActionPerformed
        String key = jTFKey.getText().trim();
        if (key.isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập key.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
             Vigenere vigenere = new Vigenere();
            try {
                File fSource = new File(sourceFile);
                FileModel fileModel = new FileModel();

                String fileDecrypt = fSource.getParent() + File.separator + fileModel.addDecryptSuffix(fSource.getName());
                vigenere.decryptFile(sourceFile, fileDecrypt, key);
                File f = new File(fileDecrypt);
                if (f.exists()) {
                    desFile = fileDecrypt;
                    jBFileOutput.setText(f.getName());
                    jBFileOutput.setEnabled(true);
                }
            } catch (Exception ex) {
                Logger.getLogger(AESFileForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonDecryptActionPerformed

    private void jBClearInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClearInputActionPerformed
        sourceFile = null;
        jBFileInput.setText("DROP FILE HERE");
    }//GEN-LAST:event_jBClearInputActionPerformed

    private void jBClearOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClearOutputActionPerformed
        desFile = null;
        jBFileOutput.setText("INPUT");
        jBFileOutput.setEnabled(false);
    }//GEN-LAST:event_jBClearOutputActionPerformed

    private void jBFileOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFileOutputActionPerformed

        File f = new File(desFile);
        if (f.exists()) {
            try {
                Desktop.getDesktop().open(f.getParentFile());
            } catch (IOException ex) {
                Logger.getLogger(DESFileForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBFileOutputActionPerformed

    private void jBFileInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFileInputActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        int returnValue = fileChooser.showOpenDialog(this);

        // Kiểm tra nếu người dùng đã chọn một tệp
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            sourceFile = selectedFile.getAbsolutePath();
            FileModel fileModel = new FileModel();
            String nameFileCipher = fileModel.addCipherSuffix(selectedFile.getName());
            desFile = selectedFile.getParent() + File.separator + nameFileCipher;
            jBFileInput.setText(selectedFile.getName());
        }
    }//GEN-LAST:event_jBFileInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBClearInput;
    private javax.swing.JButton jBClearOutput;
    private javax.swing.JButton jBFileInput;
    private javax.swing.JButton jBFileOutput;
    private javax.swing.JButton jButtonCreateKey;
    private javax.swing.JButton jButtonDecrypt;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEncrypt;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpKey;
    private javax.swing.JComboBox<String> jCBSizeKey;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTFKey;
    // End of variables declaration//GEN-END:variables
}
