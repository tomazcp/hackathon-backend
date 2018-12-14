package org.academiadecodigo.hackathon.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professional")
public class Professional extends AbstractModel {

    private String name;
    private String gender;
    private String email;
    private String phone;
    private String superPower;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "professional"
    )
    private List<Patient> patients = new ArrayList<>();

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Appointment> appointments = new ArrayList<>();

    /**
     * Gets the first name of the professional
     *
     * @return the professional last name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the first name of the professional
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the email of the professional
     *
     * @return the professional email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the professional
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone of the professional
     *
     * @return the professional phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone of the professional
     *
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the professional's patients
     *
     * @return the patients
     */
    public List<Patient> getPatients() {
        return patients;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
        appointment.setProfessional(null);
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    @Override
    public String toString() {
        return "Professional{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", patients=" + patients +
                ", super power=" + superPower +
                '}';
    }
}
