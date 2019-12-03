package com.patientsystem.com.Controller;

import java.sql.*;
import com.patientsystem.com.DbConnection;
import java.util.Calendar;

public class Doctor {
    
    private int id;
    private String speciality;
    private String firstname;
    private String middlename;
    private String lastname;
    private String gender;
    private int residenceNumber;
    private int cellNumber;
    private String address;
    private String email;
    private String dateEmployed;
    private String username;
    private String password;
    
    public Doctor(int Id, String Speciality, String Firstname, String Middlename, String Lastname, String Gender, int ResidenceNumber, int CellNumber, String Address, String Email, String DateEmployed, String Username, String Password) {
        this.id = Id;
        this.speciality = Speciality;
        this.firstname = Firstname;
        this.middlename = Middlename;
        this.gender = Gender;
        this.residenceNumber = ResidenceNumber;
        this.cellNumber = CellNumber;
        this.address = Address;
        this.email = Email;
        this.dateEmployed = DateEmployed;
        this.username = Username;
        this.password = Password;
    }   
    
    public int getId() {
        return id;
    }
    
    public String getSpeciality() {
        return speciality;
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public String getMiddlename() {
        return middlename;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public String getGender() {
        return gender;
    }
    
    public int getResidenceNumber() {
        return residenceNumber;
    }
    
    public int getCellNumber() {
        return cellNumber;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getDateEmployed() {
        return dateEmployed;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
	
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
}
