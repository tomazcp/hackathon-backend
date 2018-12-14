package org.academiadecodigo.hackathon.dto;

public class ProfessionalDto {

    private Integer id;
    private String name;
    private String email;
    private String gender;
    private String superPower;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ProfessionalDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", superPower='" + superPower + '\'' +
                '}';
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }
}
