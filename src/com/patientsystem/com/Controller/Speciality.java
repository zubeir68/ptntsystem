package com.patientsystem.com.Controller;

import com.patientsystem.com.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Speciality {

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
