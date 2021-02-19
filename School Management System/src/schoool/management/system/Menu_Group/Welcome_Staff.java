/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoool.management.system.Menu_Group;

import schoool.management.system.Arrangement_Group.Class_Allocation;
import schoool.management.system.Arrangement_Group.Classroom_Assignment;
import schoool.management.system.Arrangement_Group.Registration;
import schoool.management.system.Login_Group.Login;
import schoool.management.system.Finance_Group.Staff_Salary;

import javax.swing.*;

/**
 *
 * @author PC
 */
public class Welcome_Staff extends javax.swing.JFrame {
    public static String user = null;

    public static void setUser(String user) {
        Welcome_Admin.user = user;
    }
    /**
     * Creates new form Welcome_Staff
     */
    public Welcome_Staff() {
        JLabel background = new JLabel(new ImageIcon("src/images/oops 1.png"));
        setContentPane(background);
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        lbStaffName.setText(user);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSignOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbStaffName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnRegistration = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnAssignment = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnSalary = new javax.swing.JButton();
        btnClassAllocation = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(916, 410));

        btnSignOut.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 10)); // NOI18N
        btnSignOut.setText("Sign Out");
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel1.setText("Welcome ");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel2.setText("You have accessed as a staff.");

        lbStaffName.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        lbStaffName.setText("Katy Perry!");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        jLabel3.setText("What do you want?");

        btnRegistration.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnRegistration.setText("Registration");
        btnRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrationActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 16)); // NOI18N
        jLabel8.setText("Financial");

        btnAssignment.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnAssignment.setText("Classroom Assignment");
        btnAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignmentActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 16)); // NOI18N
        jLabel7.setText("Arrangement");

        btnSalary.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnSalary.setText("Staff Salary");
        btnSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalaryActionPerformed(evt);
            }
        });

        btnClassAllocation.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnClassAllocation.setText("Class Allocation");
        btnClassAllocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassAllocationActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel4.setText("INTERNATIONAL UNIVERSITY");

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel5.setText("OFFICE OF STUDENT AFFAIRS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSignOut)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnClassAllocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegistration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnAssignment))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel3)))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbStaffName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addGap(10, 10, 10)
                .addComponent(btnSignOut)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalary))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistration)
                        .addGap(18, 18, 18)
                        .addComponent(btnClassAllocation)))
                .addGap(18, 18, 18)
                .addComponent(btnAssignment)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Login.main(new String[]{});
    }//GEN-LAST:event_btnSignOutActionPerformed

    private void btnRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrationActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Registration.main(new String[]{});
        Registration.setRole(1);
    }//GEN-LAST:event_btnRegistrationActionPerformed

    private void btnAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignmentActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Classroom_Assignment.main(new String[]{});
        Classroom_Assignment.setRole(1);
    }//GEN-LAST:event_btnAssignmentActionPerformed

    private void btnClassAllocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassAllocationActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Class_Allocation.main(new String[]{});
        Class_Allocation.setRole(1);
    }//GEN-LAST:event_btnClassAllocationActionPerformed

    private void btnSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalaryActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Staff_Salary.main(new String[]{});
        Staff_Salary.setRole(1);
    }//GEN-LAST:event_btnSalaryActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Welcome_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome_Staff().setVisible(true);
            }
        });
    }

    public JLabel getLbStaffName() {
        return lbStaffName;
    }

    public void setLbStaffName(String s) {
        user = s;
        this.lbStaffName.setText(user);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignment;
    private javax.swing.JButton btnClassAllocation;
    private javax.swing.JButton btnRegistration;
    private javax.swing.JButton btnSalary;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbStaffName;
    // End of variables declaration//GEN-END:variables
}