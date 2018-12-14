package org.academiadecodigo.hackathon.persistence.model;

import java.util.Date;

public class Appointment extends AbstractModel {

    private Patient patient;
    private Professional professional;
    private Date date;

    public Appointment(Patient patient, Professional professional) {
        this.patient = patient;
        this.professional = professional;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
