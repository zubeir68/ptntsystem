package com.patientsystem.com.Controller;

import com.patientsystem.com.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SpecialityController {
    
    
    public String[] getSpecialityNames() {
        DbConnection db = new DbConnection();
        
        try {
            Connection connection = db.get_connection();
       
            ArrayList<String> ar = new ArrayList<String>();
        
            Statement st = connection.createStatement();
            String query = "SELECT Speciality_Name FROM speciality";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                ar.add(rs.getString("Speciality_Name"));
            }
            
            String[] specialities = new String[ar.size()];
            specialities = ar.toArray(specialities);
            
            return specialities;
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public int getSpecialityId(String name) {
        DbConnection db = new DbConnection();
        
        try {
            Connection connection = db.get_connection();
            
            String query = String.format("SELECT Speciality_Id FROM speciality WHERE Speciality_Name = '%s' ", name);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()) {
                return rs.getInt("Speciality_Id");
            }
            
            return -1;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return -1;
        }
    }

    public void create(String speciality, String description) {
        DbConnection db = new DbConnection();
        Connection connection = db.get_connection();

        String query = "insert into speciality (Speciality_Name, Description) values (?, ?)";
        String getId = "SELECT LAST_INSERT_ID()";

        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, speciality);
            pst.setString(2, description);

            pst.execute();
        } catch(Exception e ) {
            System.out.println(e);
        }

    }
    
    
}
