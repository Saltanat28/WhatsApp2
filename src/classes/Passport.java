package classes;

import enums.Country;
import enums.Gender;

import java.time.LocalDate;

public class Passport {
    private long id;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private Country country;
    private Gender gender;

    public Passport(long id, String name, String lastName, LocalDate dateOfBirth, Country country, Gender gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "\nid=" + id +
                ", \nname='" + name + '\'' +
                ", \nlastName='" + lastName + '\'' +
                ", \ndateOfBirth=" + dateOfBirth +
                ", \ncountry=" + country +
                ", \ngender=" + gender +
                "\n**********************\n";
    }
}
