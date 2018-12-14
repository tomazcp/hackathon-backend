package org.academiadecodigo.hackathon.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient extends AbstractModel {

    private String name;
    private String email;
    private String password;
    private String gender;
    private  State state;

    @ManyToOne
    private Professional professional;

    /**
     * Gets the name of the patient
     *
     * @return the patient name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the patient
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of the patient
     *
     * @return the patient email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the patient
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the patient professional
     *
     * @return the professional
     */
    public Professional getProfessional() {
        return professional;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", state=" + state +
                ", professional=" + professional +
                '}';
    }

}
