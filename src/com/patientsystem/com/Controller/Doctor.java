package com.patientsystem.com.Controller;

import java.sql.*;
import com.patientsystem.com.DbConnection;

public class Doctor {
	
	public ResultSet get() {
		DbConnection db = new DbConnection();
		Connection connection = db.get_connection();
		
		String query = "SELECT * FROM doctor";
		
		
	}
}
