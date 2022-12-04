package Java_3.domain;

import java.util.Date;
import java.util.UUID;

public class Employee {
    private UUID id;
    private String name;
    private String surName;
    private Date departureDate;
    private Date dateOfLoseTaxResidence;

    public Employee(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public Employee(UUID id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDateOfLoseTaxResidence() {
        return dateOfLoseTaxResidence;
    }

    public void setDateOfLoseTaxResidence(Date dateOfLoseTaxResidence) {
        this.dateOfLoseTaxResidence = dateOfLoseTaxResidence;
    }
}
