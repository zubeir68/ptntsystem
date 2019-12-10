package com.patientsystem.com.Controller;

import com.patientsystem.com.DbConnection;
import com.patientsystem.com.Model.Speciality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SpecialityController {
    
    public ArrayList<Speciality> getAll() {
        try {
            ArrayList<Speciality> ls = new ArrayList<Speciality>();
            String query = "select * from speciality";
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            
            Speciality speciality;
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                speciality = new Speciality(rs.getInt("Speciality_id"), rs.getString("Speciality_Name"), rs.getString("Description"));
                ls.add(speciality);
            }
            return ls;
            
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
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
    
    public void update(int id, String name, String description) {
        try {
            
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            
            String query = String.format("UPDATE speciality SET Speciality_Name  = '%s', Description = '%s' where Speciality_id = %d", name, description, id);
            
            Statement st = connection.createStatement();
            st.executeUpdate(query);
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }
    
    public void delete(int id) {
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            String query = String.format("DELETE FROM speciality WHERE Speciality_id = %d", id);
            Statement st = connection.createStatement();
            st.execute(query);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
