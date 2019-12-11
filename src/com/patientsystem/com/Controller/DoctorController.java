package com.patientsystem.com.Controller;

import java.sql.*;
import com.patientsystem.com.DbConnection;
import com.patientsystem.com.Model.Doctor;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class DoctorController {
	
    public ArrayList<Doctor> get() {
		
        ArrayList<Doctor> docsList = new ArrayList<Doctor>();
        DbConnection db = new DbConnection();
        Connection connection = db.get_connection();
        
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM doctor";
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Doctor doctor;
            
            while(rs.next()) {
                String query2 = String.format("SELECT * FROM speciality WHERE Speciality_id = %d ", rs.getInt("Specialty_id"));
                Statement st2 = connection.createStatement();
                ResultSet rs2 = st2.executeQuery(query2);
                String spec;
                
                if(rs2.next()) {
                    spec = rs2.getString("Speciality_Name");
                    doctor = new Doctor(rs.getInt("Doctor_id"), spec, rs.getString("First_Name"), rs.getString("Middle_Name"), rs.getString("Last_Name"), rs.getString("Gender"), rs.getInt("Residence_Number"), rs.getInt("Cell_Number"), rs.getString("Address"), rs.getString("Email"), rs.getDate("Date_Employed").toString(), rs.getString("User_Name"), rs.getString("Password"));
                
                    docsList.add(doctor);
                } 
                
                
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return docsList;
    }

	public void create(int specId, String firstname , String middlename, String lastname, String gender, int resNum, int cellNum, String address, String email, String username, String password) {
		DbConnection db = new DbConnection();
		Connection connection = db.get_connection();

		String query = "insert into doctor (Specialty_id, First_Name, Middle_Name, Last_Name, Gender, Residence_Number, Cell_Number, Address, Email, Date_Employed, User_Name, Password) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			Calendar calendar = Calendar.getInstance();
			Date date = new Date(calendar.getTime().getTime());

			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, specId);
			pst.setString(2, firstname);
			pst.setString(3, middlename);
			pst.setString(4, lastname);
			pst.setString(5, gender);
			pst.setInt(6, resNum);
			pst.setInt(7, cellNum);
			pst.setString(8, address);
			pst.setString(9, email);
			pst.setDate(10, date);
			pst.setString(11, username);
			pst.setString(12, password);

			pst.execute();
		} catch(Exception e ) {
			System.out.println(e);
		}
	}
        
    public void update(int id, int specId, String firstname , String middlename, String lastname, String gender, int resNum, int cellNum, String address, String email, String username, String password) {
        try {
            
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            
            String query = String.format("UPDATE doctor SET Specialty_Id = %d, First_Name = '%s', Middle_Name = '%s', Last_Name = '%s', Gender = '%s', Residence_Number = %d, Cell_Number = %d, Address = '%s', Email = '%s', User_Name = '%s', Password = '%s' WHERE Doctor_id = %d", specId, firstname, middlename, lastname, gender, resNum, cellNum, address, email, username, password, id);
            
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
            String query = String.format("DELETE FROM doctor WHERE Doctor_id = %d", id);
            Statement st = connection.createStatement();
            st.execute(query);
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }        
    }
    
    public String getPassword(String id) {
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            String query = String.format("SELECT Password FROM doctor WHERE Doctor_id = %s", id);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()) {
                return rs.getString("Password");
            }
            return null;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public String[] getDoctorInfo() {
        DbConnection db = new DbConnection();
        
        try {
            Connection connection = db.get_connection();
            
            ArrayList<String> ar = new ArrayList<String>();
            Statement st = connection.createStatement();
            String query = "SELECT Doctor_id, Last_Name from doctor";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                ar.add(String.format("%d : %s", rs.getInt("Doctor_id"), rs.getString("Last_Name")));
            }
            
            String[] dinfo = new String[ar.size()];
            dinfo =  ar.toArray(dinfo);
            
            return dinfo;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public String getOneDoctor(int id) {
        DbConnection db = new DbConnection();
        
        try {
            Connection connection = db.get_connection();
            String query = String.format("SELECT Doctor_id, Last_Name from doctor WHERE Doctor_id = %d", id);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()) {
                return String.format("%d : %s", rs.getInt("Doctor_id"), rs.getString("Last_Name"));
            }
            return null;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public int getByUsername(String username) {
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();
            Statement st;
            ResultSet rs;
            String query = String.format("select Doctor_id from doctor where User_Name = '%s'", username);
            
            st = connection.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()) {
                return rs.getInt("Doctor_id");
            }
            return 0;
            
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
