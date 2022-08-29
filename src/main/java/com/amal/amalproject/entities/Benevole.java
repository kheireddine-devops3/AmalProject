package com.amal.amalproject.entities;

public class Benevole extends User {
    private String profession;


    /* Start Section Constructors */
    public Benevole() {
    }
    /* End Section Constructors */


    /* Start Section Getters & Setters */
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    /* End Section Getters & Setters */


    /* Start Section ToString */
    @Override
    public String toString() {
        return "Benevole{" +
                "profession='" + profession + '\'' +
                ", user={" + super.toString() + '}' +
                '}';
    }
    /* End Section ToString */
}
