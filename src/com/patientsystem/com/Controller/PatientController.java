/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patientsystem.com.Controller;

import com.patientsystem.com.DbConnection;
import com.patientsystem.com.Model.Patient;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
/**
 *
 * @author zumo
 */
public class PatientController {
    
    public ArrayList<Patient> get() {
        
        ArrayList<Patient> patList = new ArrayList<Patient>();
        DbConnection db = new DbConnection();
        Connection connection = db.get_connection();
        
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM patient";
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Patient patient;
            
            while(rs.next()) {
                patient = new Patient(rs.getInt("Patient_Id"), rs.getString("First_Name"), rs.getString("Middle_Name"), rs.getString("Last_Name"), rs.getDate("Date_Of_Birth").toString(), rs.getString("Gender"), rs.getInt("Residence_Number"), rs.getInt("Cell_Number"), rs.getString("Address"), rs.getString("Email"), rs.getString("City"), rs.getString("Country"), rs.getString("Health_Card_Number"), rs.getString("Insured_Or_Not"), rs.getString("Insurance_Type"), rs.getString("Insurance_Name"), rs.getString("Insurance_Number"), rs.getDate("Date_Of_Registration").toString(), rs.getInt("Doctor_id"));
                
                patList.add(patient);
                
            }
            
            
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return patList;
    }
    
    public void create(String firstname, String middlename, String lastname, Date dateOfBirth, String gender, int residenceNumber, int cellNumber, String address, String email, String city, String country, String healthCardNumber, String insured, String insuranceType, String insuranceName, String insuranceNumber, int doctorId) {
        
        String query = "insert into patient (First_Name, Middle_Name, Last_Name, Date_Of_Birth, Gender, Residence_Number, Cell_Number, Address, Email, City, Country, Health_Card_Number, Insured_Or_Not, Insurance_Type, Insurance_Name, Insurance_Number, Date_Of_Registration, Doctor_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try { 
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTime().getTime());
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, firstname);
            pst.setString(2, middlename);
            pst.setString(3, lastname);
            pst.setDate(4, dateOfBirth);
            pst.setString(5, gender);
            pst.setInt(6, residenceNumber);
            pst.setInt(7, cellNumber);
            pst.setString(8, address);
            pst.setString(9, email);
            pst.setString(10, city);
            pst.setString(11, country);
            pst.setString(12, healthCardNumber);
            pst.setString(13, insured);
            pst.setString(14, insuranceType);
            pst.setString(15, insuranceName);
            pst.setString(16, insuranceNumber);
            pst.setDate(17, date);
            pst.setInt(18, doctorId);
            
            pst.execute();
            
            
        } catch(Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void update(int id, String firstname, String middlename, String lastname, Date dateOfBirth, String gender, int residenceNumber, int cellNumber, String address, String email, String city, String country, String healthCardNumber, String insured, String insuranceType, String insuranceName, String insuranceNumber, int doctorId) {
        try {
            String query = "update patient set First_Name = ?, Middle_Name = ?, Last_Name = ?, Date_of_Birth = ?, Gender = ?, Residence_Number = ?, Cell_Number = ?, Address = ?, Email = ?, City = ?, Country = ?, Health_Card_Number = ?, Insured_Or_Not = ?, Insurance_Type = ?, Insurance_Name = ?, Insurance_Number = ?, Doctor_id = ? where Patient_id = ?";
            
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            
            PreparedStatement pst = connection.prepareStatement(query);
            
            pst.setString(1, firstname);
            pst.setString(2, middlename);
            pst.setString(3, lastname);
            pst.setDate(4, dateOfBirth);
            pst.setString(5, gender);
            pst.setInt(6, residenceNumber);
            pst.setInt(7, cellNumber);
            pst.setString(8, address);
            pst.setString(9, email);
            pst.setString(10, city);
            pst.setString(11, country);
            pst.setString(12, healthCardNumber);
            pst.setString(13, insured);
            pst.setString(14, insuranceType);
            pst.setString(15, insuranceName);
            pst.setString(16, insuranceNumber);
            pst.setInt(17, doctorId);
            pst.setInt(18, id);
            
            pst.execute();
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }
    
    public void delete(int id) {
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            String query = String.format("DELETE FROM patient WHERE Patient_id = %d", id);
            Statement st = connection.createStatement();
            st.execute(query);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
