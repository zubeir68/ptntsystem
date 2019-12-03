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
        this.lastname = Lastname;
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
}
