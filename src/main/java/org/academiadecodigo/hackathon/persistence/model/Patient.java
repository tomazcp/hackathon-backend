package org.academiadecodigo.hackathon.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient extends AbstractModel {

    private String name;
    private String email;
    private String phone;
    private String password;
    private Gender gender;
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
     * Gets the phone of the patient
     *
     * @return the patient phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone of the patient
     *
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {

        // printing recipients with lazy loading
        // and no session will cause issues
        return "Customer{" +
                "firstName='" + name + '\'' +
                "gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", professional=" + professional +
                "} " + super.toString();
    }

}
