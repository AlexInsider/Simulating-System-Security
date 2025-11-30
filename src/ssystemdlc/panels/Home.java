package ssystemdlc.panels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ssystemdlc.Main;
import ssystemdlc.SecurityLayer;
import ssystemdlc.db.Db_conn;

public class Home extends javax.swing.JFrame {
    Connection conn = new Db_conn().con();
    
    private DefaultTableModel contentTable = new DefaultTableModel(new String[]{"Username", "Password", "Role"}, 0);
    SecurityLayer sl = new SecurityLayer();
    
    String selectedUser[] = new String[3];
    String role;
    
    public Home(String privilege) {
        initComponents();
        
        this.setLocationRelativeTo(null);
        privilegeLabel.setText("Privilege [ " +privilege +" ]");
        
        cTable.setModel(contentTable);
        
        contentTable.setRowCount(0);
        this.setTitle("Logged In As: " +Main.getUser().getUsername());
        
        sl.checkIntrution();
        updateContentTable();
    }
    
    public void updateContentTable(){
        String role = Main.getUser().getRole();
        this.role = role;
        int cTableRow = 0;
        String query = "";
        if(role.equals("Student")){
            query = "SELECT * FROM users WHERE Username = ?";
            panel.remove(addBtn);
            panel.remove(editBtn);
            panel.remove(deleteBtn);
            panel.revalidate();
            panel.repaint();
        }else if(role.equals("Teacher")){
            query = "SELECT * FROM users WHERE NOT Role = 'Admin'";
            panel.remove(addBtn);
            panel.remove(deleteBtn);
            panel.revalidate();
            panel.repaint();
        }else if(role.equals("Admin")){
            query = "SELECT * FROM users;";
        }else{
            JOptionPane.showMessageDialog(this, "Invalid Role!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            if(role.equals("Student")) pst.setString(1, Main.getUser().getUsername());
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                contentTable.setRowCount(cTableRow+1);
                contentTable.setValueAt(rs.getString(2), cTableRow, 0);
                contentTable.setValueAt(rs.getString(3), cTableRow, 1);
                contentTable.setValueAt(rs.getString(4), cTableRow, 2);
                cTableRow++;
            }
            
            editBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
            
            if(cTable.isEditing()) cTable.getCellEditor().stopCellEditing();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        privilegeLabel = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cTable = new javax.swing.JTable();
        logoutBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel.setBackground(new java.awt.Color(18, 52, 86));
        panel.setForeground(new java.awt.Color(18, 52, 86));

        privilegeLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        privilegeLabel.setForeground(new java.awt.Color(255, 255, 255));
        privilegeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        privilegeLabel.setText("Privilege");

        editBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editBtn.setText("EDIT");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        cTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Username", "Password"
            }
        ));
        cTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cTable);

        logoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logoutBtn.setText("LOGOUT");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(privilegeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(privilegeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(editBtn)
                    .addComponent(deleteBtn)
                    .addComponent(logoutBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        CustomComponent edit = new CustomComponent("Edit", selectedUser[0], selectedUser[1], role, selectedUser[2], this, this, true);
        edit.setVisible(true);
    }//GEN-LAST:event_editBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        this.dispose();
        Main.resetUser();
        
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        CustomComponent add = new CustomComponent("Add", null, null, role, null, this, this, true);
        add.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int confirmValue = JOptionPane.showConfirmDialog(this, "Are You Sure to Delete This User? (" +selectedUser[0] + ")", "This Action Cannot Be Undone!", JOptionPane.WARNING_MESSAGE);
        
        if(confirmValue == 0){
            String query = "DELETE FROM users WHERE Username = ?";
            try{
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, selectedUser[0]);
                pst.execute();
                updateContentTable();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void cTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cTableMouseClicked
        int row = cTable.getSelectedRow();
        
        editBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        
        String username = cTable.getValueAt(row, 0).toString();
        String password = cTable.getValueAt(row, 1).toString();
        String usrRole = cTable.getValueAt(row, 2).toString();
        
        selectedUser[0] = username;
        selectedUser[1] = password;
        selectedUser[2] = usrRole;
    }//GEN-LAST:event_cTableMouseClicked

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Home().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTable cTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel privilegeLabel;
    // End of variables declaration//GEN-END:variables
}
