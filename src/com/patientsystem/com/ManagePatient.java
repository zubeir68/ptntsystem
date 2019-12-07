/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patientsystem.com;

import com.patientsystem.com.Controller.DoctorController;
import com.patientsystem.com.Controller.PatientController;
import com.patientsystem.com.Model.Patient;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.text.SimpleDateFormat;  

/**
 *
 * @author zumo
 */
public class ManagePatient extends javax.swing.JFrame {

    /**
     * Creates new form ManagePatient
     */
    public ManagePatient() {
        initComponents();
        displayPat();
        displayDoctors();
    }
    
    public void displayPat() {
        PatientController pat = new PatientController();
        
        ArrayList<Patient> list = pat.get();
        DefaultTableModel model = (DefaultTableModel)patTable.getModel();
        Object[] row = new Object[20];
        DoctorController dc = new DoctorController();
        
        for(int i = 0; i < list.size(); i++) {
            
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getFirstname();
            row[2] = list.get(i).getMiddlename();
            row[3] = list.get(i).getLastname();
            row[4] = list.get(i).getDateOfBirth();
            row[5] = list.get(i).getGender();
            row[6] = list.get(i).getResidenceNumber();
            row[7] = list.get(i).getCellNumber();
            row[8] = list.get(i).getAddress();
            row[9] = list.get(i).getEmail();
            row[10] = list.get(i).getCity();
            row[11] = list.get(i).getCountry();
            row[12] = list.get(i).getHealthCardNumber();
            row[13] = list.get(i).getInsuredOrNot();
            row[14] = list.get(i).getInsuranceType();
            row[15] = list.get(i).getInsuranceName();
            row[16] = list.get(i).getInsuranceNumber();
            row[17] = list.get(i).getDateOfRegistration();
            row[18] = dc.getOneDoctor(list.get(i).getDoctor());
            
            model.addRow(row);
        }
        
    }
    
    public void displayDoctors() {
        DoctorController dc = new DoctorController();
        String[] docs = dc.getDoctorInfo();
        DefaultComboBoxModel model = new DefaultComboBoxModel(docs);
        tDoctor.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tFirstname = new java.awt.TextField();
        jLabel5 = new javax.swing.JLabel();
        tMiddlename = new java.awt.TextField();
        jLabel6 = new javax.swing.JLabel();
        tLastname = new java.awt.TextField();
        jLabel7 = new javax.swing.JLabel();
        tDateOfBirth = new java.awt.TextField();
        jLabel8 = new javax.swing.JLabel();
        tGender = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tResidenceNumber = new java.awt.TextField();
        jLabel10 = new javax.swing.JLabel();
        tCellNumber = new java.awt.TextField();
        jLabel11 = new javax.swing.JLabel();
        tAddress = new java.awt.TextField();
        jLabel12 = new javax.swing.JLabel();
        tEmail = new java.awt.TextField();
        jLabel13 = new javax.swing.JLabel();
        tCity = new java.awt.TextField();
        jLabel14 = new javax.swing.JLabel();
        tCountry = new java.awt.TextField();
        jLabel15 = new javax.swing.JLabel();
        jlabel34 = new javax.swing.JLabel();
        tHealthCardNumber = new java.awt.TextField();
        jLabel16 = new javax.swing.JLabel();
        tInsured = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        tInsuranceType = new java.awt.TextField();
        jLabel18 = new javax.swing.JLabel();
        tInsuranceName = new java.awt.TextField();
        jLabel19 = new javax.swing.JLabel();
        tInsuranceNumber = new java.awt.TextField();
        jLabel21 = new javax.swing.JLabel();
        insertButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tDoctor = new javax.swing.JComboBox<>();
        resetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Patient Manager");

        patTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Firstname", "Middlename", "Lastname", "Date of Birth", "Gender", "Residence Number", "Cell Number", "Address", "Email", "City", "Country", "Health Card Number", "Insured or Not", "Insurance Type", "Insurance Name", "Insurance Number", "Date of Registration", "Doctor Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(patTable);

        jLabel2.setText("Id: ");

        idLabel.setText("None");

        jLabel4.setText("Firstname: ");

        jLabel5.setText("Middlename: ");

        jLabel6.setText("Lastname: ");

        jLabel7.setText("Date of Birth (YYYY-MM-DD): ");

        jLabel8.setText("Gender: ");

        tGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE" }));

        jLabel9.setText("Residence Number: ");

        jLabel10.setText("Cell Number:");

        jLabel11.setText("Address: ");

        jLabel12.setText("Email: ");

        jLabel13.setText("City: ");

        jLabel14.setText("Country: ");

        jlabel34.setText("Health Card Number:");

        jLabel16.setText("Insured: ");

        tInsured.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));
        tInsured.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tInsuredActionPerformed(evt);
            }
        });

        jLabel17.setText("Insurance Type: ");

        jLabel18.setText("Insurance Name: ");

        jLabel19.setText("Insurance Number:");

        jLabel21.setText("Doctor");

        insertButton.setText("Insert");
        insertButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertButtonMouseClicked(evt);
            }
        });
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonMouseClicked(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        jButton1.setText("Patient History");

        resetButton.setText("Reset Fields");
        resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetButtonMouseClicked(evt);
            }
        });
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel8)
                                                            .addComponent(jLabel4))
                                                        .addGap(51, 51, 51)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(tFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(tGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel12)
                                                        .addGap(83, 83, 83)
                                                        .addComponent(tEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGap(29, 29, 29)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel13))
                                                .addGap(2, 2, 2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tInsuranceName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                                .addComponent(jLabel19)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(resetButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(insertButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(updateButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(deleteButton)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tResidenceNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                            .addComponent(tCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tMiddlename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel15))
                                    .addComponent(tInsuranceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabel34)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tDoctor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tCellNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(153, 153, 153)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tHealthCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(156, 156, 156)
                                        .addComponent(jLabel16)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tInsured, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tInsuranceType, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(214, 214, 214))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(idLabel))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(tFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(tMiddlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(4, 4, 4))
                            .addComponent(tLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(tCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(tGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tResidenceNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tCellNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(tAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(tInsured, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17))
                                    .addComponent(tInsuranceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tHealthCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jlabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(1, 1, 1))
                            .addComponent(tEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel13))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel18)
                                .addComponent(tInsuranceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tInsuranceNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(jButton1)
                    .addComponent(resetButton))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tInsuredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tInsuredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tInsuredActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertButtonActionPerformed

    private void patTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patTableMouseClicked
        // TODO add your handling code here:
        int i = patTable.getSelectedRow();
        TableModel model = patTable.getModel();
        idLabel.setText(model.getValueAt(i, 0).toString());
        tFirstname.setText(model.getValueAt(i, 1).toString());
        tMiddlename.setText(model.getValueAt(i, 2).toString());
        tLastname.setText(model.getValueAt(i, 3).toString());
        tDateOfBirth.setText(model.getValueAt(i, 4).toString());
        tGender.setSelectedItem(model.getValueAt(i, 5).toString());
        tResidenceNumber.setText(model.getValueAt(i, 6).toString());
        tCellNumber.setText(model.getValueAt(i, 7).toString());
        tAddress.setText(model.getValueAt(i, 8).toString());
        tEmail.setText(model.getValueAt(i, 9).toString());
        tCity.setText(model.getValueAt(i, 10).toString());
        tCountry.setText(model.getValueAt(i, 11).toString());
        tHealthCardNumber.setText(model.getValueAt(i, 12).toString());
        tInsured.setSelectedItem(model.getValueAt(i, 13));
        tInsuranceType.setText(model.getValueAt(i, 14).toString());
        tInsuranceName.setText(model.getValueAt(i, 15).toString());
        tInsuranceNumber.setText(model.getValueAt(i, 16).toString());
        tDoctor.setSelectedItem(model.getValueAt(i, 17).toString());
    }//GEN-LAST:event_patTableMouseClicked

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetButtonActionPerformed

    private void resetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetButtonMouseClicked
        // TODO add your handling code here:
        idLabel.setText("None");
        tFirstname.setText("");
        tMiddlename.setText("");
        tLastname.setText("");
        tDateOfBirth.setText("");
        tResidenceNumber.setText("");
        tCellNumber.setText("");
        tAddress.setText("");
        tEmail.setText("");
        tCity.setText("");
        tCountry.setText("");
        tHealthCardNumber.setText("");
        tInsuranceType.setText("");
        tInsuranceName.setText("");
        tInsuranceNumber.setText("");
    }//GEN-LAST:event_resetButtonMouseClicked

    private void insertButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertButtonMouseClicked
        // TODO add your handling code here:
        try{
            PatientController pc = new PatientController();
		
            Date sqlDate = Date.valueOf(tDateOfBirth.getText());
            
            pc.create(tFirstname.getText(), tMiddlename.getText(), tLastname.getText(), sqlDate, tGender.getSelectedItem().toString(), Integer.parseInt(tResidenceNumber.getText()), Integer.parseInt(tCellNumber.getText()), tAddress.getText(), tEmail.getText(), tCity.getText(), tCountry.getText(), tHealthCardNumber.getText(), tInsured.getSelectedItem().toString(), tInsuranceType.getText(), tInsuranceName.getText(), tInsuranceNumber.getText(), Integer.parseInt(tDoctor.getSelectedItem().toString().substring(0, 1)));
            
            JOptionPane.showMessageDialog(null, "Successfully created new patient");
            
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_insertButtonMouseClicked

    private void updateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseClicked
        // TODO add your handling code here:
        try {
            if(idLabel.getText() != "None") {
                PatientController pc = new PatientController();
                
                Date sqlDate = Date.valueOf(tDateOfBirth.getText());
                
                pc.update(Integer.parseInt(idLabel.getText()), tFirstname.getText(), tMiddlename.getText(), tLastname.getText(), sqlDate, tGender.getSelectedItem().toString(), Integer.parseInt(tResidenceNumber.getText()), Integer.parseInt(tCellNumber.getText()), tAddress.getText(), tEmail.getText(), tCity.getText(), tCountry.getText(), tHealthCardNumber.getText(), tInsured.getSelectedItem().toString(), tInsuranceType.getText(), tInsuranceName.getText(), tInsuranceNumber.getText(), Integer.parseInt(tDoctor.getSelectedItem().toString().substring(0, 1)));
                JOptionPane.showMessageDialog(null, "Successfully update table");
                
            } else {
                JOptionPane.showMessageDialog(null, "Please select a doctor in the table");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }//GEN-LAST:event_updateButtonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        // TODO add your handling code here:
        try {
            if(idLabel.getText() != "None") {
                PatientController pc = new PatientController();
                pc.delete(Integer.parseInt(idLabel.getText()));
            
                JOptionPane.showMessageDialog(null, "Successfully deleted doctor");
            } else {
                JOptionPane.showMessageDialog(null, "Please select a doctor in the table");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }//GEN-LAST:event_deleteButtonMouseClicked

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
            java.util.logging.Logger.getLogger(ManagePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagePatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JButton insertButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel34;
    private javax.swing.JTable patTable;
    private javax.swing.JButton resetButton;
    private java.awt.TextField tAddress;
    private java.awt.TextField tCellNumber;
    private java.awt.TextField tCity;
    private java.awt.TextField tCountry;
    private java.awt.TextField tDateOfBirth;
    private javax.swing.JComboBox<String> tDoctor;
    private java.awt.TextField tEmail;
    private java.awt.TextField tFirstname;
    private javax.swing.JComboBox<String> tGender;
    private java.awt.TextField tHealthCardNumber;
    private java.awt.TextField tInsuranceName;
    private java.awt.TextField tInsuranceNumber;
    private java.awt.TextField tInsuranceType;
    private javax.swing.JComboBox<String> tInsured;
    private java.awt.TextField tLastname;
    private java.awt.TextField tMiddlename;
    private java.awt.TextField tResidenceNumber;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
