package org.academiadecodigo.hackathon.persistence.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "appointment")
public class Appointment extends AbstractModel {

    @OneToOne
    private Patient patient;
    @OneToOne
    private Professional professional;
    private String date;

    public Appointment() {
    }

//    public Appointment(Patient patient, Professional professional, String date) {
//        this.patient = patient;
//        this.professional = professional;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
