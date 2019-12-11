/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patientsystem.com.Controller;

import com.patientsystem.com.DbConnection;
import com.patientsystem.com.Model.Appointment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author zumo
 */
public class AppointmentController {
    
    public ArrayList<Appointment> get(int id) {
        
        ArrayList<Appointment> appList = new ArrayList<Appointment>();
        DbConnection db = new DbConnection();
        Connection connection = db.get_connection();
        
        Statement st;
        ResultSet rs;
        String query = String.format("SELECT * FROM appointment WHERE Patient_id = %d ORDER BY App_Date, Start_Time", id);
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Appointment appointment;
            
            while(rs.next()) {
                appointment = new Appointment(rs.getInt("Appointment_id"), rs.getInt("Doctor_id"), rs.getInt("Patient_id"), rs.getDate("App_Date").toString(), rs.getTime("Start_Time").toString(), rs.getTime("End_Time").toString());
                
                appList.add(appointment);
                
            }
            
            
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return appList;
    }
    
    public ArrayList<Appointment> getByDoctor(int id) {
        
        ArrayList<Appointment> appList = new ArrayList<Appointment>();
        DbConnection db = new DbConnection();
        Connection connection = db.get_connection();
        
        Statement st;
        ResultSet rs;
        String query = String.format("SELECT * FROM appointment WHERE Doctor_id = %d ORDER BY App_Date, Start_Time", id);
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Appointment appointment;
            
            while(rs.next()) {
                appointment = new Appointment(rs.getInt("Appointment_id"), rs.getInt("Doctor_id"), rs.getInt("Patient_id"), rs.getDate("App_Date").toString(), rs.getTime("Start_Time").toString(), rs.getTime("End_Time").toString());
                
                appList.add(appointment);
                
            }
            
            
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return appList;
    }
    
    public Boolean create(int doctorId, int patientId, String appDate, String slot) {
        try{
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            Date sqlDate = Date.valueOf(appDate);
            String[] times = slot.split("-");
            LocalTime st = LocalTime.parse(times[0]);
            LocalTime et = LocalTime.parse(times[1]);
            
            Time startTime = Time.valueOf(st);
            Time endTime = Time.valueOf(et);
            
            String query = "insert into appointment (Doctor_id, Patient_id, App_Date, Start_Time, End_Time) values (?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(query);
            
            pst.setInt(1, doctorId);
            pst.setInt(2, patientId);
            pst.setDate(3, sqlDate);
            pst.setTime(4, startTime);
            pst.setTime(5, endTime);
            
            pst.execute();
            
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void delete(int id) {
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            String query = String.format("DELETE FROM appointment WHERE Appointment_id = %d", id);
            Statement st = connection.createStatement();
            st.execute(query);
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }        
    };
    
    public Boolean timeSlotAvailable(int id, String appDate, String slot)  {
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            Date sqlDate = Date.valueOf(appDate);
            String[] times = slot.split("-");
            LocalTime st = LocalTime.parse(times[0]);
            LocalTime et = LocalTime.parse(times[1]);
            Time startTime = Time.valueOf(st);
            Time endTime = Time.valueOf(et);
            
            String query = String.format("select * from appointment where Doctor_id = %d and App_Date = '%s' and Start_Time = '%s'", id, sqlDate.toString(), startTime.toString());
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next()) {
                return false;
            }
            
            return true;
            
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    
    
}
