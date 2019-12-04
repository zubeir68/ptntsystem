/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patientsystem.com.Controller;

import com.patientsystem.com.DbConnection;
import com.patientsystem.com.Model.Receptionist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author zumo
 */
public class ReceptionistController {
    
    public ArrayList<Receptionist> get() {
        ArrayList<Receptionist> recList = new ArrayList<Receptionist>();
        DbConnection db = new DbConnection();
        Connection connection = db.get_connection();
        
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM receptionist";
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            
            Receptionist receptionist;
            
            while(rs.next()) {
                receptionist = new Receptionist(rs.getInt("Rec_id"), rs.getString("First_Name"), rs.getString("Middle_Name"), rs.getString("Last_Name"), rs.getString("User_Name"), rs.getString("Password"), rs.getInt("Contact_Number"), rs.getString("Email"), rs.getString("Address"));
                
                recList.add(receptionist);
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return recList;
        
    }
    
    public void create(String firstname , String middlename, String lastname, String address, String email, String username, String password, int contactnumber) {
        DbConnection db = new DbConnection();
        try {
            Connection connection = db.get_connection();
            String query = "insert into receptionist (First_Name, Middle_Name, Last_Name, User_Name, Password, Contact_Number, Email, Address) values (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, firstname);
            pst.setString(2, middlename);
            pst.setString(3, lastname);
            pst.setString(4, username);
            pst.setString(5, password);
            pst.setInt(6, contactnumber);
            pst.setString(7, email);
            pst.setString(8, address);
            
            pst.execute();
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }
    
    
    public void update(int id, String firstname , String middlename, String lastname, String username, String password, int contactnumber, String email, String address) {
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            
            String query = String.format("update receptionist set First_Name = '%s', Middle_Name = '%s', Last_Name = '%s', User_Name = '%s', Password = '%s', Contact_Number = %d, Email = '%s', Address = '%s' where Rec_id = %d", firstname, middlename, lastname, username, password, contactnumber, email, address, id);
            
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
            String query = String.format("delete from receptionist where Rec_id = %d", id);
            Statement st = connection.createStatement();
            st.execute(query);
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }
    
}
