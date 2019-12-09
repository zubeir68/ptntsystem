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
public class PatientHistory {
    
    int id;
    String visitDate;   
    String bloodGroup;
    String bloodPressureSys;
    String bloodPressureDia;
    float height;
    float weight;
    String symptoms;
    String medicalTests;
    String diagnosis;
    String prescription;
    
    public PatientHistory(int Id, String VisitDate, String BloodGroup, String BloodGroupSys, String BloodPressureDia, float Height, float Weight, String Symptoms, String MedicalTests, String Diagnosis, String Prescription) {
        this.id = Id;
        this.visitDate = VisitDate;
        this.bloodGroup = BloodGroup;
        this.bloodPressureSys = BloodGroupSys;
        this.bloodPressureDia = BloodPressureDia;
        this.height = Height;
        this.weight = Weight;
        this.symptoms = Symptoms;
        this.medicalTests = MedicalTests;
        this.diagnosis = Diagnosis;
        this.prescription = Prescription;
    }
    
    public int getId() {
        return id;
    }
    
    public String getVisitDate() {
        return visitDate;
    }
    
    public String getBloodGroup() {
        return bloodGroup;
    }
    
    public String getBloodPressureSys() {
        return bloodPressureSys;
    }
    
    public String getBloodPressureDia() {
        return bloodPressureDia;
    }
    
    public float getHeight() {
        return height;
    }
    
    public float getWeight() {
        return weight;
    }
    
    public String getSymptoms() {
        return symptoms;
    }
    
    public String getMedicalTests() {
        return medicalTests;
    }
    
    public String getDiagnosis() {
        return diagnosis;
    }
    
    public String getPrescription() {
        return prescription;
    }
    
    
}
