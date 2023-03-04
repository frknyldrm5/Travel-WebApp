package be.thomasmore.travelwebapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Client {
    @Id
    private Integer id;
    private String name;
    private String birthDate;
    private String gender;
    private String startDate;

    public Client(String name, String birthDate, String gender, String startDate) {
        this.name = name;
        this.birthDate = birthDate;
        if (gender.equals("M") || gender.equals("F")) this.gender=gender;
        this.startDate = startDate;
    }

    public Client() {
    }

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


}
