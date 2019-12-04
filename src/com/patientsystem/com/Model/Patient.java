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
public class Patient {
    
    private int id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String dateOfBirth;
    private String gender;
    private int residencenumber;
    private int cellnumber;
    private String address;
    private String email;
    private String city;
    private String country;
    private String healthcardnumber;
    private String insuredornot;
    private String insurancetype;
    private String insurancename;
    private String insurancenumber;
    private String dateofregistration;
    private int doctor;
    private int historyid;
    
    public Patient(int Id, String Firstname, String Middlename, String Lastname, String DateOfBirth, String Gender, int ResidenceNumber, int CellNumber, String Address, String Email, String City, String Country, String HealthCardNumber, String InsuredOrNot, String InsuranceType, String InsuranceName, String InsuranceNumber, String DateOfRegistration, int Doctor, int HistoryId) {
        this.id = Id;
        this.firstname = Firstname;
        this.middlename = Middlename;
        this.lastname = Lastname;
        this.dateOfBirth = DateOfBirth;
        this.gender = Gender;
        this.residencenumber = ResidenceNumber;
        this.cellnumber = CellNumber;
        this.address = Address;
        this.email = Email;
        this.city = City;
        this.country = Country;
        this.healthcardnumber = HealthCardNumber;
        this.insuredornot = InsuredOrNot;
        this.insurancetype = InsuranceType;
        this.insurancename = InsuranceName;
        this.insurancenumber = InsuranceNumber;
        this.dateofregistration = DateOfRegistration;
        this.doctor = Doctor;
        this.historyid = HistoryId;
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
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public String getGender() {
        return gender;
    }
    
    public int getResidenceNumber() {
        return residencenumber;
    }
    
    public int getCellNumber() {
        return cellnumber;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getCountry() {
        return country;
    }
    
    public String getHealthCardNumber() {
        return healthcardnumber;
    }
    
    public String getInsuredOrNot() {
        return insuredornot;
    }
    
    public String getInsuranceType() {
        return insurancetype;
    }
    
    public String getInsuranceName() {
        return insurancename;
    }
    
    public String getInsuranceNumber() {
        return insurancenumber;
    }
    
    public String getDateOfRegistration() {
        return dateofregistration;
    }
    
    public int getDoctor() {
        return doctor;
    }
    
    public int getHistoryId() {
        return historyid;
    }
}
