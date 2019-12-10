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
public class Appointment {
    
    private int id;
    private int doctorId;
    private int patientId;
    private String appDate;
    private String startTime;
    private String endTime;
    
    public Appointment(int Id, int DoctorId, int PatientId, String AppDate, String StartTime, String EndTime) {
        this.id = Id;
        this.doctorId = DoctorId;
        this.patientId = PatientId;
        this.appDate = AppDate;
        this.startTime = StartTime;
        this.endTime = EndTime;
    }
    
    public int getId() {
        return id;
    }
    
    public int getDoctor() {
        return doctorId;
    }
    
    public int getPatient() {
        return patientId;
    }
    
    public String getAppDate() {
        return appDate;
    }
    
    public String getStartTime() {
        return startTime;
    }
    
    public String getEndTime() {
        return endTime;
    }
    
}
