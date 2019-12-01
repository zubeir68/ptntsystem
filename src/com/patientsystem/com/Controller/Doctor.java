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
}
