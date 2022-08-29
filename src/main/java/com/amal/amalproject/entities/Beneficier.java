package com.amal.amalproject.entities;

import java.time.LocalDate;

public class Beneficier extends User {
    private String carteHandicapNumber;
    private LocalDate dateExpiration;

    /* Start Section Constructors */
    public Beneficier() {
    }
    /* End Section Constructors */


    /* Start Section Getters & Setters */
    public String getCarteHandicapNumber() {
        return carteHandicapNumber;
    }

    public void setCarteHandicapNumber(String carteHandicapNumber) {
        this.carteHandicapNumber = carteHandicapNumber;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
    /* End Section Getters & Setters */


    /* Start Section ToString */
    @Override
    public String toString() {
        return "Beneficier{" +
                "carteHandicapNumber='" + carteHandicapNumber + '\'' +
                ", dateExpiration=" + dateExpiration +
                ", user={" + super.toString() + '}' +
                '}';
    }
    /* End Section ToString */
}
