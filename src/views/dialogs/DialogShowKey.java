package views.dialogs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import models.FileModel;
import models.KeyModel;
import views.component.DESForm;

public class DialogShowKey extends javax.swing.JDialog {

    private DefaultTableModel tableModel;
    private KeyModel keyTarget;
    private String type;

    public DialogShowKey(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadData();
    }

    public void setType(String type) {
        this.type = type;
        loadData();
    }

    public KeyModel getKeyTarget() {
        return keyTarget;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKeys = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jBCancel = new javax.swing.JButton();
        jBApply = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("List Key");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTableKeys.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Name", "Key", "Size", "Mode", "Padding"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableKeys.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handlerShowDetail(evt);
            }
        });
        jScrollPane1.setViewportView(jTableKeys);
        if (jTableKeys.getColumnModel().getColumnCount() > 0) {
            jTableKeys.getColumnModel().getColumn(0).setResizable(false);
            jTableKeys.getColumnModel().getColumn(2).setResizable(false);
        }

        jBCancel.setText("Back");
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });

        jBApply.setText("Apply");
        jBApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBApplyActionPerformed(evt);
            }
        });

        jBDelete.setText("Delete");
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jBCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBApply, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBApply, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(324, 324, 324))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jBCancelActionPerformed

    private void jBApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBApplyActionPerformed
        int selectedRow = jTableKeys.getSelectedRow();
        if (selectedRow >= 0) {
            String name = (String) tableModel.getValueAt(selectedRow, 1);
            String key = (String) tableModel.getValueAt(selectedRow, 2);
            int keySize = (int) tableModel.getValueAt(selectedRow, 3);
            String mode = (String) tableModel.getValueAt(selectedRow, 4);
            String padding = (String) tableModel.getValueAt(selectedRow, 5);
            keyTarget = new KeyModel(name, key, keySize, mode, padding);
            dispose();
        }
    }//GEN-LAST:event_jBApplyActionPerformed

    private void handlerShowDetail(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_handlerShowDetail
        if (evt.getClickCount() == 2) { // Kiểm tra xem người dùng đã click đúp
            int selectedRow = jTableKeys.getSelectedRow();
            if (selectedRow >= 0) {
                String name = (String) tableModel.getValueAt(selectedRow, 1);
                String key = (String) tableModel.getValueAt(selectedRow, 2);
                int keySize = (int) tableModel.getValueAt(selectedRow, 3);
                String mode = (String) tableModel.getValueAt(selectedRow, 4);
                String padding = (String) tableModel.getValueAt(selectedRow, 5);
                DialogShowDetailKey dialog = new DialogShowDetailKey((JFrame) SwingUtilities.getWindowAncestor(this), true);
                dialog.setName(name);
                dialog.setKey(key);
                dialog.setKeySize(keySize);
                dialog.setMode(mode);
                dialog.setPadding(padding);

                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_handlerShowDetail

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        int option = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc chắn muốn xóa key?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION
        );
        if (option == JOptionPane.YES_OPTION) {
            FileModel file = new FileModel();
            String pathFile = file.path(type + ".txt");
            File f = new File(pathFile);
            if (f.exists()) {
                List<KeyModel> listKey = file.loadKeyModels(pathFile);
                int selectedRow = jTableKeys.getSelectedRow();
                KeyModel keyDelete = null;
                if (selectedRow >= 0) {
                    String name = (String) tableModel.getValueAt(selectedRow, 1);
                    String key = (String) tableModel.getValueAt(selectedRow, 2);
                    int keySize = (int) tableModel.getValueAt(selectedRow, 3);
                    String mode = (String) tableModel.getValueAt(selectedRow, 4);
                    String padding = (String) tableModel.getValueAt(selectedRow, 5);
                    keyDelete = new KeyModel(name, key, keySize, mode, padding);
                }
                listKey.remove(keyDelete);
                file.saveKeyModels(listKey, pathFile);
                loadData();
            }
        }

    }//GEN-LAST:event_jBDeleteActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogShowKey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogShowKey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogShowKey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogShowKey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogShowKey dialog = new DialogShowKey(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void loadData() {
        FileModel file = new FileModel();
        String pathFile = file.path(type + ".txt");
        File f = new File(pathFile);
        if (f.exists()) {
            List<KeyModel> listKey = file.loadKeyModels(pathFile);

            tableModel = (DefaultTableModel) jTableKeys.getModel();

            // Xóa tất cả các hàng hiện có trong bảng
            tableModel.setRowCount(0);

            // Thêm dữ liệu mới vào bảng
            for (int i = 0; i < listKey.size(); i++) {
                KeyModel keyModel = new KeyModel(listKey.get(i).getName(), listKey.get(i).getKey(), 
                        listKey.get(i).getKeySize(), listKey.get(i).getMode(), listKey.get(i).getPadding());
                tableModel.addRow(new Object[]{i, keyModel.getName(), keyModel.getKey(), keyModel.getKeySize(), keyModel.getMode(), keyModel.getPadding()});

            }

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBApply;
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableKeys;
    // End of variables declaration//GEN-END:variables
}
