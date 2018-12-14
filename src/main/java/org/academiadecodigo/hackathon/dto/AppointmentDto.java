package org.academiadecodigo.hackathon.dto;

import org.academiadecodigo.hackathon.persistence.model.Patient;
import org.academiadecodigo.hackathon.persistence.model.Professional;


public class AppointmentDto {


    private Integer id;

    private Integer professionalId;

    private Integer patientId;

    private String date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "AppointmentDto{" +
                "id=" + id +
                ", professionalId=" + professionalId +
                ", patientId=" + patientId +
                ", date='" + date + '\'' +
                '}';
    }
}

