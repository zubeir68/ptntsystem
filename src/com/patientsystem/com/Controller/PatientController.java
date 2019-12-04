/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patientsystem.com.Controller;

import com.patientsystem.com.DbConnection;
import com.patientsystem.com.Model.Patient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
                patient = new Patient(rs.getInt("Patient_Id"), rs.getString("First_Name"), rs.getString("Middle_Name"), rs.getString("Last_Name"), rs.getDate("Date_Of_Birth").toString(), rs.getString("Gender"), rs.getInt("Residence_Number"), rs.getInt("Cell_Number"), rs.getString("Address"), rs.getString("Email"), rs.getString("City"), rs.getString("Country"), rs.getString("Health_Card_Number"), rs.getString("Insured_Or_Not"), rs.getString("Insurance_Type"), rs.getString("Insurance_Name"), rs.getString("Insurance_Number"), rs.getDate("Date_Of_Registration").toString(), rs.getInt("Doctor_id"), rs.getInt("History_id"));
                
                patList.add(patient);
                
            }
            
            
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return patList;
    }
    
}
