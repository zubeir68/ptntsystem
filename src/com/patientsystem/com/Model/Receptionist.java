/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patientsystem.com.Model;

/**
 *
 * @author zumo
 */
public class Receptionist {
    
    private int id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String username;
    private String password;
    private int contactNumber;
    private String email;
    private String address;
    
    public Receptionist(int Id, String Firstname, String Middlename, String Lastname, String Username, String Password, int ContactNumber, String Email, String Address) {
        this.id = Id;
        this.firstname = Firstname;
        this.middlename = Middlename;
        this.lastname = Lastname;
        this.username = Username;
        this.password = Password;
        this.contactNumber = ContactNumber;
        this.email = Email;
        this.address = Address;
    }
    
    public int getId() {
        return id;
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
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public int getContactNumber() {
        return contactNumber;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getAddress() {
        return address;
    }
}
