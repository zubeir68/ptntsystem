package com.patientsystem.com;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public static void main(String[] args) {
        DbConnection obj = new DbConnection();

        Connection connection = null;

        connection = obj.get_connection();

        System.out.println(connection);
    }

    public Connection get_connection() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient_system", "", "");
        }catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}
