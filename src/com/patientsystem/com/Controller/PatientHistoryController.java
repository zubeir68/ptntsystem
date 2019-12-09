/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patientsystem.com.Controller;

import com.patientsystem.com.DbConnection;
import com.patientsystem.com.Model.PatientHistory;
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
public class PatientHistoryController {
    
    public ArrayList<PatientHistory> get(int id) {
        
        ArrayList<PatientHistory> histList = new ArrayList<PatientHistory>();
        
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            
            String query = String.format("SELECT * FROM patient_history WHERE Patient_id = %d", id);
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
                
            PatientHistory ph;
            
            while(rs.next()) {
                ph = new PatientHistory(rs.getInt("History_id"), rs.getDate("Visit_Date").toString(), rs.getString("Blood_Group"), rs.getString("Blood_Pressure_sys"), rs.getString("Blood_Pressure_dia"), rs.getFloat("Height"), rs.getFloat("Weight"), rs.getString("Symptoms"), rs.getString("Medical_Tests_Prescribed"), rs.getString("Diagnosis"), rs.getString("Prescription"));
                
                histList.add(ph);
            }
            
            return histList;
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public Boolean create(int patientId, String bloodGroup, String bloodGroupSys, String bloodGroupDia, float height, float weight, String symptoms, String medicalTestsPrescribed, String diagnosis, String prescription) {
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            
            String query = "insert into patient_history (Patient_id, Visit_Date, Blood_Group, Blood_Pressure_sys, Blood_Pressure_dia, Height, Weight, Symptoms, Medical_Tests_Prescribed, Diagnosis, Prescription) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTime().getTime());
            
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, patientId);
            pst.setDate(2, date);
            pst.setString(3, bloodGroup);
            pst.setString(4, bloodGroupSys);
            pst.setString(5, bloodGroupDia);
            pst.setFloat(6, height);
            pst.setFloat(7, weight);
            pst.setString(8, symptoms);
            pst.setString(9, medicalTestsPrescribed);
            pst.setString(10, diagnosis);
            pst.setString(11, prescription);
            
            pst.execute();
            
            return true;
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public Boolean update(int id, String bloodGroup, int bloodPressureSys, int bloodPressureDia, float height, float weight, String symptoms, String medicalTests, String diagnosis,  String prescription) {
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            
            String query = String.format("update patient_history set Blood_Group = '%s', Blood_Pressure_Sys  = %d, Blood_Pressure_dia = %d, Height = %f, Weight = %f , Symptoms = '%s', Medical_Tests_Prescribed = '%s', Diagnosis = '%s', Prescription = '%s' where History_id = %d", bloodGroup, bloodPressureSys, bloodPressureDia, height, weight, symptoms, medicalTests, diagnosis, prescription, id);
            
            Statement st = connection.createStatement();
            st.executeUpdate(query);
            
            return true;
            
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public void delete(int id) {
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            String query = String.format("delete from patient_history where History_id = %d", id);
            
            Statement st = connection.createStatement();
            st.execute(query);
            
        } catch(Exception e) {
            System.out.println(e);
            JOptionPane.showConfirmDialog(null, "Something went wrong");
        }
    } 
    
}
