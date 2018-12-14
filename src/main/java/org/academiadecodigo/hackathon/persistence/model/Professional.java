package org.academiadecodigo.hackathon.persistence.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professional")
public class Professional extends AbstractModel {

    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String phone;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "professional"
    )
    private List<Patient> patients;
    private List<Appointment> appointments;

    /**
     * Gets the first name of the professional
     *
     * @return the professional last name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the professional
     *
     * @param firstName the name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the professional
     *
     * @return the professional last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the professional
     *
     * @param lastName the name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

}
