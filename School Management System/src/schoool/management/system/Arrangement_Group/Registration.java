/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoool.management.system.Arrangement_Group;

import schoool.management.system.Menu_Group.Welcome_Admin;
import schoool.management.system.Menu_Group.Welcome_Staff;
import schoool.management.system.Menu_Group.Welcome_Student;
import schoool.management.system.Tool_Group.Checking_Input_Data;
import schoool.management.system.Tool_Group.ConnectionClass;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Registration extends javax.swing.JFrame {
    /*
       CREATE TABLE Check_student_enrollment(
	enrollment_ID		   INT					PRIMARY KEY ,
	student_ID			   INT					REFERENCES Student (student_ID),
	subject_name	       VARCHAR(255),
	subject_ID		       VARCHAR(255)			REFERENCES Subject (subject_ID),
	UNIQUE (student_ID, subject_name)
)
     */
    DefaultTableModel model;
    private static boolean showTime = true;
    private static int role = 0;
    private static String ID = null;
    private static int real_ID = 0;

    public static int getReal_ID() {
        return real_ID;
    }

    public static void setReal_ID(int real_ID) {
        Registration.real_ID = real_ID;
    }

    public static int getRole() {
        return role;
    }

    public static void setRole(int role) {
        Registration.role = role;
    }

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        Registration.ID = ID;
    }
    /**
     * Creates new form Register_A_Course
     */
    public Registration() {
        JLabel background = new JLabel(new ImageIcon("src/images/school theme 2.2.jpg"));
        setContentPane(background);
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public ArrayList<Register> registerArrayList() {
        ArrayList<Register> registerArrayList = new ArrayList<>();
        try {
            Connection connection = ConnectionClass.connection();
            String sql = "SELECT * FROM Check_student_enrollment";
            Statement preparedStatement = connection.createStatement();
            ResultSet rs = preparedStatement.executeQuery(sql);
            Register register;
            while (rs.next()) {
                register = new Register(
                        rs.getInt("enrollment_ID"),
                        rs.getInt("student_ID"),
                        rs.getString("subject_name"),
                        rs.getString("subject_ID"));
                registerArrayList.add(register);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return registerArrayList;
    }

    public ArrayList<Register> registerArrayList(String i, boolean sign) {
        ArrayList<Register> registerArrayList = new ArrayList<>();
        try {
            Connection connection = ConnectionClass.connection();
            String sql;
            Statement statement;
            ResultSet rs;
            if (sign){
                sql = "SELECT * FROM Check_student_enrollment WHERE subject_name = '" + i + "'";
            } else {
                sql = "SELECT * FROM Check_student_enrollment WHERE subject_ID = '" + i + "'";
            }
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            Register register;
            while (rs.next()) {
                register = new Register(
                        rs.getInt("enrollment_ID"),
                        rs.getInt("student_ID"),
                        rs.getString("subject_name"),
                        rs.getString("subject_ID"));
                registerArrayList.add(register);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return registerArrayList;
    }

    public void show_register(int check, String string) {
        ArrayList<Register> list;
        if (check == 0) {
            list = registerArrayList();
        } else if (check == 1){
            list = registerArrayList(string, true);
        } else if (check == 2){
            list = registerArrayList(string, false);
        } else {
            return;
        }
        model = (DefaultTableModel) tableShowInfo.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getEnrollment_ID();
            row[1] = list.get(i).getStudent_ID();
            row[2] = list.get(i).getSubject_name();
            row[3] = list.get(i).getSubject_ID();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboboxWhatToDo = new javax.swing.JComboBox<>();
        txtEnrollmentID = new javax.swing.JTextField();
        txtSubjectID = new javax.swing.JTextField();
        txtStudentID = new javax.swing.JTextField();
        txtSubjectName = new javax.swing.JTextField();
        btnBrowseName = new javax.swing.JButton();
        btnBrowseID = new javax.swing.JButton();
        btnBrowseAll = new javax.swing.JButton();
        btnRun = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableShowInfo = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel1.setText("Registration ");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel2.setText("What to do:");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel3.setText("Enrollment ID:");

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel4.setText("Student ID:");

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel5.setText("Subject Name:");

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel6.setText("Subject ID:");

        comboboxWhatToDo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboboxWhatToDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Add", "Remove" }));

        txtEnrollmentID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSubjectID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtStudentID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSubjectName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnBrowseName.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnBrowseName.setText("Browse");
        btnBrowseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseNameActionPerformed(evt);
            }
        });

        btnBrowseID.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnBrowseID.setText("Browse");
        btnBrowseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseIDActionPerformed(evt);
            }
        });

        btnBrowseAll.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnBrowseAll.setText("Browse All");
        btnBrowseAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseAllActionPerformed(evt);
            }
        });

        btnRun.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnRun.setText("Run");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        tableShowInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enrollment ID", "Student ID", "Subject Name", "Subject ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableShowInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableShowInfoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableShowInfo);

        jLabel7.setText("Note:");

        jLabel8.setText("- You can browse the detail of courses by browsing by Name or ID.");

        jLabel9.setText("- Enrollment ID is unique, browse all to help you fill a unique value.");

        jLabel10.setText("- If you're student, you are just allowed to edit your registration only.");

        jLabel11.setText("- Only students who paid fee before the due day can enroll new courses.");

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
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnBrowseAll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRun))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboboxWhatToDo, 0, 200, Short.MAX_VALUE)
                                        .addComponent(txtEnrollmentID))
                                    .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBrowseName)
                            .addComponent(btnBrowseID))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMenu)
                        .addGap(296, 296, 296)
                        .addComponent(jLabel1)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnMenu))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboboxWhatToDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtEnrollmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBrowseName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBrowseID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBrowseAll)
                            .addComponent(btnRun)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseNameActionPerformed
        // TODO add your handling code here:
        if (showTime) {
            show_register(1, txtSubjectName.getText());
            showTime = false;
        } else {
            model.setRowCount(0);
            show_register(1, txtSubjectName.getText());
        }
    }//GEN-LAST:event_btnBrowseNameActionPerformed

    private void btnBrowseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseIDActionPerformed
        // TODO add your handling code here:
        if (showTime) {
            show_register(2, txtSubjectID.getText());
            showTime = false;
        } else {
            model.setRowCount(0);
            show_register(2, txtSubjectID.getText());
        }
    }//GEN-LAST:event_btnBrowseIDActionPerformed

    private void btnBrowseAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseAllActionPerformed
        // TODO add your handling code here:
        if (showTime) {
            show_register(0, "");
            showTime = false;
        } else {
            model.setRowCount(0);
            show_register(0, "");
        }
    }//GEN-LAST:event_btnBrowseAllActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        showTime = true;
        dispose();
        if (role == 0){
            Welcome_Student.main(new String[]{});
        } else if (role == 1){
            Welcome_Staff.main(new String[]{});
        } else {
            Welcome_Admin.main(new String[]{});
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void tableShowInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableShowInfoMouseClicked
        // TODO add your handling code here:
        int i = tableShowInfo.getSelectedRow();
        TableModel model = tableShowInfo.getModel();
        txtEnrollmentID.setText(model.getValueAt(i, 0).toString());
        txtStudentID.setText(model.getValueAt(i, 1).toString());
        txtSubjectName.setText(model.getValueAt(i, 2).toString());
        txtSubjectID.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_tableShowInfoMouseClicked

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        // TODO add your handling code here:
        if (comboboxWhatToDo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "You need to choose an action!",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String doing = comboboxWhatToDo.getSelectedItem().toString();

        if (doing.equals("Add")){
            if (txtEnrollmentID.getText().length() == 0 || txtStudentID.getText().length() == 0
                    || txtSubjectName.getText().length() == 0 || txtSubjectID.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No field can be empty!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    if (Checking_Input_Data.Check("enrollment_ID", txtEnrollmentID.getText(),
                            "Check_student_enrollment", false)
                            && !Checking_Input_Data.Check("student_ID", txtStudentID.getText(), "Student", true)){

                        Connection con = ConnectionClass.connection();

                        Statement statement;
                        ResultSet resultSet;

                        String dayOfPayment = null;
                        String isPaid = "SELECT * FROM Student_fee_information WHERE student_ID = " + txtStudentID.getText();
                        statement = con.createStatement();
                        resultSet = statement.executeQuery(isPaid);
                        if (resultSet.next()){
                            dayOfPayment = resultSet.getString("payment_status");
                        }

                        if (dayOfPayment.equals("No")){
                            JOptionPane.showMessageDialog(null, "Pay the fee(s) first!",
                                    "Warning!", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        int userID;
                        if (role == 0){
                            String findStudent = "SELECT * FROM Student WHERE student_ID = "
                                    + txtStudentID.getText();
                            statement = con.createStatement();
                            resultSet = statement.executeQuery(findStudent);
                            if (resultSet.next()){
                                userID = resultSet.getInt("student_ID");
                                System.out.println(userID);
                                System.out.println(real_ID);
                            } else {

                                return;
                            }
                            if (!(userID == real_ID)){
                                JOptionPane.showMessageDialog(null,
                                        "You're allowed to add your own information only! ",
                                        "Warning!", JOptionPane.WARNING_MESSAGE);
                                txtEnrollmentID.selectAll();
                                txtEnrollmentID.replaceSelection("");
                                return;
                            }
                        }
                        String checkUnique =
                                "SELECT * FROM Check_student_enrollment WHERE student_ID = "
                                        +txtStudentID.getText()
                                        +" AND subject_name = '"
                                        +txtSubjectName.getText() +"'";
                        statement = con.createStatement();
                        resultSet = statement.executeQuery(checkUnique);
                        if (resultSet.next()){
                            JOptionPane.showMessageDialog(null,
                                    "One student cannot enroll 2 classes \nthat have the same name!",
                                    "Warning!", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        con.close();

                        Connection connection = ConnectionClass.connection();
                        String insertQuery = "INSERT INTO Check_student_enrollment VALUES (? ,? ,? ,?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                        preparedStatement.setString(1, txtEnrollmentID.getText());
                        preparedStatement.setString(2, txtStudentID.getText());
                        preparedStatement.setString(3, txtSubjectName.getText());
                        preparedStatement.setString(4, txtSubjectID.getText());

                        preparedStatement.executeUpdate();
                        if (showTime) {
                            show_register(0, "");
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_register(0,"");
                        }
                        JOptionPane.showMessageDialog(null, "Insert completed!");
                        connection.close();
                    } else {
                        txtEnrollmentID.selectAll();
                        txtEnrollmentID.replaceSelection("");
                    }
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else if (doing.equals("Remove")){
            if (txtEnrollmentID.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Enrollment ID cannot be empty!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    if (!Checking_Input_Data.Check("enrollment_ID", txtEnrollmentID.getText(),
                            "Check_student_enrollment", true)){
                        Connection connection = ConnectionClass.connection();

                        Statement statement;
                        ResultSet resultSet;
                        int studentID;
                        if (role == 0){
                            String findStudentID =
                                    "SELECT * FROM Check_student_enrollment WHERE enrollment_ID = "
                                            + txtEnrollmentID.getText();
                            statement = connection.createStatement();
                            resultSet = statement.executeQuery(findStudentID);

                            if (resultSet.next()){
                                studentID = resultSet.getInt("student_ID");
                            } else {
                                return;
                            }
                            System.out.println(studentID);
                            System.out.println(ID);
                            if (!(studentID == real_ID)){
                                JOptionPane.showMessageDialog(null,
                                        "You're allowed to delete your own information only! ",
                                        "Warning!", JOptionPane.WARNING_MESSAGE);
                                System.out.println("USERNAME NOT YOU");
                                txtEnrollmentID.selectAll();
                                txtEnrollmentID.replaceSelection("");
                                return;
                            }
                        }

                        String insertQuery = "DELETE FROM Check_student_enrollment WHERE enrollment_ID = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                        preparedStatement.setString(1, txtEnrollmentID.getText());

                        preparedStatement.executeUpdate();
                        if (showTime) {
                            show_register(0, "");
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_register(0,"");
                        }
                        JOptionPane.showMessageDialog(null, "Remove completed!");
                        connection.close();
                    } else {
                        txtEnrollmentID.selectAll();
                        txtEnrollmentID.replaceSelection("");
                    }
                } catch (SQLException e){
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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseAll;
    private javax.swing.JButton btnBrowseID;
    private javax.swing.JButton btnBrowseName;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRun;
    private javax.swing.JComboBox<String> comboboxWhatToDo;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableShowInfo;
    private javax.swing.JTextField txtEnrollmentID;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtSubjectID;
    private javax.swing.JTextField txtSubjectName;
    // End of variables declaration//GEN-END:variables
}
