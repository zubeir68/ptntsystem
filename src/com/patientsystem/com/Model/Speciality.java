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
public class Speciality {
    
    private int id;
    private String specialityName;
    private String description;
    
    public Speciality(int Id, String SpecialityName, String Description) {
        this.id = Id;
        this.specialityName = SpecialityName;
        this.description = Description;
    }
    
    public int getId() {
        return id;
    }
    
    public String getSpeciality() {
        return specialityName;
    }
    
    public String getDescription() {
        return description;
    }
    
}
