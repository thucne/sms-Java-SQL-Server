/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoool.management.system.Finance_Group;

import schoool.management.system.Arrangement_Group.Registration;
import schoool.management.system.Tool_Group.Checking_Input_Data;
import schoool.management.system.Tool_Group.ConnectionClass;
import schoool.management.system.Menu_Group.Welcome_Admin;
import schoool.management.system.Menu_Group.Welcome_Staff;
import schoool.management.system.Menu_Group.Welcome_Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author PC
 */
public class Student_Fee_Information extends javax.swing.JFrame {
    DefaultTableModel model;
    private static boolean showTime = true;
    private static int role = 0;
    private static String ID = null;
    private static int real_ID = 0;

    public static int getReal_ID() {
        return real_ID;
    }

    public static void setReal_ID(int real_ID) {
        Student_Fee_Information.real_ID = real_ID;
    }

    public static int getRole() {
        return role;
    }

    public static void setRole(int role) {
        Student_Fee_Information.role = role;
    }

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        Student_Fee_Information.ID = ID;
    }

    /**
     * Creates new form Student_Fee_Information
     */
    public Student_Fee_Information() {
        JLabel background = new JLabel(new ImageIcon("src/images/school theme 4.1.jpg"));
        setContentPane(background);
        initComponents();
        groupPaymentStatus = new ButtonGroup();
        groupPaymentStatus.add(btnYes);
        groupPaymentStatus.add(btnNo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        if (role == 0) {
            btnRun.setEnabled(false);
        }
    }

    public ArrayList<Fee> feeArrayList() {
        ArrayList<Fee> feeArrayList = new ArrayList<>();
        try {
            Connection connection = ConnectionClass.connection();
            String sql = "SELECT * FROM Student_fee_information";
            Statement preparedStatement = connection.createStatement();
            ResultSet rs = preparedStatement.executeQuery(sql);
            Fee student_Fee;
            while (rs.next()) {
                student_Fee = new Fee(
                        rs.getInt("fee_ID"),
                        rs.getInt("student_ID"),
                        rs.getDouble("fee"),
                        rs.getString("payment_status"),
                        rs.getString("day_of_payment"));
                feeArrayList.add(student_Fee);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return feeArrayList;
    }

    public void show_fee() {
        ArrayList<Fee> list = feeArrayList();
        model = (DefaultTableModel) tableShowFee.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getFee_ID();
            row[1] = list.get(i).getStudent_ID();
            row[2] = list.get(i).getFee();
            row[3] = list.get(i).getPayment_status();
            row[4] = list.get(i).getDay_of_payment();
            model.addRow(row);
        }
    }

    public void show_only() {
        ArrayList<Fee> fees = new ArrayList<>();
        try {
            Connection connection = ConnectionClass.connection();
            Statement st;
            ResultSet rs;
            String findStudentID = "SELECT * FROM Student WHERE student_ID = "
                    + real_ID;
            st = connection.createStatement();
            rs = st.executeQuery(findStudentID);
            int studentID;
            if (rs.next()) {
                studentID = rs.getInt("student_ID");
            } else {
                return;
            }
            String sql = "SELECT * FROM Student_fee_information WHERE student_ID = "
                    + studentID;
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            Fee fee;
            while (rs.next()) {
                fee = new Fee(
                        rs.getInt("fee_ID"),
                        rs.getInt("student_ID"),
                        rs.getDouble("fee"),
                        rs.getString("payment_status"),
                        rs.getString("day_of_payment"));
                fees.add(fee);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        model = (DefaultTableModel) tableShowFee.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < fees.size(); i++) {
            row[0] = fees.get(i).getFee_ID();
            row[1] = fees.get(i).getStudent_ID();
            row[2] = fees.get(i).getFee();
            row[3] = fees.get(i).getPayment_status();
            row[4] = fees.get(i).getDay_of_payment();
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupPaymentStatus = new javax.swing.ButtonGroup();
        txtStudentID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboboxWhatToDo = new javax.swing.JComboBox<>();
        btnYes = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btnNo = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFee = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDayOfPayment = new javax.swing.JTextField();
        btnRun = new javax.swing.JButton();
        btnBrowse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableShowFee = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtStudentID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel6.setText("Fee ID :");

        txtID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel10.setText("Payment Status:");

        comboboxWhatToDo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboboxWhatToDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Update", "Add" }));

        btnYes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnYes.setText("Yes");
        btnYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel2.setText("What to do:");

        btnNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNo.setText("No");

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel9.setText("Fee:");

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel7.setText("Student ID: ");

        txtFee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel11.setText("Day Of Payment: ");

        txtDayOfPayment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDayOfPayment.setText("2020-05-12");

        btnRun.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnRun.setText("Run");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        btnBrowse.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        jLabel1.setText("Note: ");

        jLabel3.setText("- In this function, you are only able to modify or add a set of detail.");

        jLabel4.setText("- Fee ID is unique field, browse all to help you fill a unique value.");

        jLabel5.setText("- Update by Fee ID.");

        tableShowFee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fee ID", "Student ID", "Fee ", "Payment Status", "Day Of Payment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableShowFee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableShowFeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableShowFee);

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel8.setText("Student Fee Information");

        btnMenu.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 10)); // NOI18N
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBrowse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRun))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnYes)
                                .addGap(39, 39, 39)
                                .addComponent(btnNo))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtFee, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtStudentID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(comboboxWhatToDo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDayOfPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnMenu)
                .addGap(222, 222, 222)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMenu)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboboxWhatToDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(btnYes)
                            .addComponent(btnNo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtDayOfPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBrowse)
                            .addComponent(btnRun)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnYesActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // TODO add your handling code here:
        if (role == 0) {
            if (showTime) {
                show_only();
                showTime = false;
            } else {
                model.setRowCount(0);
                show_only();
            }
        } else {
            if (showTime) {
                show_fee();
                showTime = false;
            } else {
                model.setRowCount(0);
                show_fee();
            }
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        showTime = true;
        dispose();
        if (role == 0) {
            Welcome_Student.main(new String[]{});
        } else if (role == 1) {
            Welcome_Staff.main(new String[]{});
        } else {
            Welcome_Admin.main(new String[]{});
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void tableShowFeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableShowFeeMouseClicked
        // TODO add your handling code here:
        int i = tableShowFee.getSelectedRow();
        TableModel model = tableShowFee.getModel();
        txtID.setText(model.getValueAt(i, 0).toString());
        txtStudentID.setText(model.getValueAt(i, 1).toString());
        txtFee.setText(model.getValueAt(i, 2).toString());
        String temp = model.getValueAt(i, 3).toString();

        if (temp.equals("Yes")) {
            btnYes.setSelected(true);
        } else if (temp.equals("No")) {
            btnNo.setSelected(true);
        }
        txtDayOfPayment.setText(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_tableShowFeeMouseClicked

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        // TODO add your handling code here:
        if (comboboxWhatToDo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "You need to choose an action!",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String doing = comboboxWhatToDo.getSelectedItem().toString();

        if (doing.equals("Add")) {
            if (txtID.getText().length() == 0 || txtStudentID.getText().length() == 0
                    || txtFee.getText().length() == 0 || txtDayOfPayment.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No field can be empty!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    if (Checking_Input_Data.Check("fee_ID", txtID.getText(),
                            "Student_fee_information", false)
                            && !Checking_Input_Data.Check("student_ID", txtStudentID.getText(),
                            "Student", "This Student does not exist in the database!", true)) {
                        try {
                            Double.parseDouble(txtFee.getText());
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
                                    "Error salary input, it must be something like\"100.50\"!",
                                    "Warning!", JOptionPane.WARNING_MESSAGE);
                            txtFee.selectAll();
                            txtFee.replaceSelection("");
                            return;
                        }

                        LocalDate now = LocalDate.now();

                        String inputDate = txtDayOfPayment.getText();
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate dayOfPayment;

                        try {
                            dayOfPayment = LocalDate.parse(inputDate, dateTimeFormatter);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
                                    "Invalid day type! (yyyy-MM-dd)", "Warning!",
                                    JOptionPane.WARNING_MESSAGE);
                            txtDayOfPayment.selectAll();
                            txtDayOfPayment.replaceSelection("");
                            return;
                        }

                        if (dayOfPayment.isAfter(now)) {
                            JOptionPane.showMessageDialog(null, "Day of payment cannot be after today!",
                                    "Warning!", JOptionPane.WARNING_MESSAGE);
                            txtDayOfPayment.selectAll();
                            txtDayOfPayment.replaceSelection("");
                            return;
                        }

                        Connection connection = ConnectionClass.connection();
                        String insertQuery = "INSERT INTO Student_fee_information VALUES (? ,? ,? ,? ,? )";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                        preparedStatement.setString(1, txtID.getText());
                        preparedStatement.setString(2, txtStudentID.getText());
                        preparedStatement.setString(3, txtFee.getText());

                        if (dayOfPayment.isAfter(now.minusMonths(18))) {
                            preparedStatement.setString(4, "Yes");
                        } else if (!dayOfPayment.isAfter(now.minusMonths(18))) {
                            preparedStatement.setString(4, "No");
                        }
                        preparedStatement.setString(5, txtDayOfPayment.getText());
                        preparedStatement.executeUpdate();
                        if (showTime) {
                            show_fee();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_fee();
                        }
                        JOptionPane.showMessageDialog(null, "Insert completed!");
                        connection.close();

                    } else {
                        txtID.selectAll();
                        txtID.replaceSelection("");
                        txtStudentID.selectAll();
                        txtStudentID.replaceSelection("");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else if (doing.equals("Update")) {
            if (txtID.getText().length() == 0 || txtFee.getText().length() == 0 || txtDayOfPayment.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No field can be empty!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    if (!Checking_Input_Data.Check("fee_ID", txtID.getText(),
                            "Student_fee_information", true)) {
                        try {
                            Double.parseDouble(txtFee.getText());
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
                                    "Error salary input, it must be something like\"100.50\"!",
                                    "Warning!", JOptionPane.WARNING_MESSAGE);
                            txtFee.selectAll();
                            txtFee.replaceSelection("");
                            return;
                        }

                        LocalDate now = LocalDate.now();

                        String inputDate = txtDayOfPayment.getText();
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate dayOfPayment = null;

                        try {
                            dayOfPayment = LocalDate.parse(inputDate, dateTimeFormatter);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
                                    "Invalid day type! (yyyy-MM-dd)", "Warning!",
                                    JOptionPane.WARNING_MESSAGE);
                            txtDayOfPayment.selectAll();
                            txtDayOfPayment.replaceSelection("");
                            return;
                        }

                        if (dayOfPayment.isAfter(now)) {
                            JOptionPane.showMessageDialog(null, "Day of payment cannot be after today!",
                                    "Warning!", JOptionPane.WARNING_MESSAGE);
                            txtDayOfPayment.selectAll();
                            txtDayOfPayment.replaceSelection("");
                            return;
                        }

                        Connection connection = ConnectionClass.connection();
                        String updateQuery =
                                "UPDATE Student_fee_information SET fee = ?, payment_status = ?, day_of_payment = ? WHERE fee_ID = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                        preparedStatement.setString(1, txtFee.getText());
                        if (dayOfPayment.isAfter(now.minusMonths(18))) {
                            preparedStatement.setString(2, "Yes");
                        } else if (!dayOfPayment.isAfter(now.minusMonths(18))) {
                            preparedStatement.setString(2, "No");
                        }
                        preparedStatement.setString(3, txtDayOfPayment.getText());
                        preparedStatement.setString(4, txtID.getText());

                        preparedStatement.executeUpdate();
                        if (showTime) {
                            show_fee();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_fee();
                        }
                        JOptionPane.showMessageDialog(null,
                                "Update completed! \nTip: Fee ID, Student ID cannot be changed.");
                        connection.close();
                    } else {
                        txtID.selectAll();
                        txtID.replaceSelection("");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btnRunActionPerformed

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
            java.util.logging.Logger.getLogger(Student_Fee_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Fee_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Fee_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Fee_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Fee_Information().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnMenu;
    private javax.swing.JRadioButton btnNo;
    private javax.swing.JButton btnRun;
    private javax.swing.JRadioButton btnYes;
    private javax.swing.JComboBox<String> comboboxWhatToDo;
    private javax.swing.ButtonGroup groupPaymentStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableShowFee;
    private javax.swing.JTextField txtDayOfPayment;
    private javax.swing.JTextField txtFee;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtStudentID;
    // End of variables declaration//GEN-END:variables
}
