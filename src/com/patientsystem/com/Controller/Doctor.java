package com.patientsystem.com.Controller;

import java.sql.*;
import com.patientsystem.com.DbConnection;

public class Doctor {
	
	public ResultSet get() {
		
		try {
			DbConnection db = new DbConnection();
			Connection connection = db.get_connection();
			
			String query = "SELECT * FROM doctor";
			
			Statement st = connection.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			return rs;
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	public void create(int specId, String firstname , String middlename, String lastname, String gender, int resNum, int cellNum, String address, String email) {
		DbConnection db = new DbConnection();
		Connection connection = db.get_connection();

		String query = "insert into doctor (Specialty_id, First_Name, Middle_Name, Last_Name, Gender, Residence_Number, Cell_Number, Address, Email, Date_Employed, User_Name, Password) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement pst = connection.prepareStatement(query);
			//pst.setString(1, speciality);
			//pst.setString(2, description);

			pst.execute();
		} catch(Exception e ) {
			System.out.println(e);
		}

	}
}
