package com.amal.amalproject.entities;

public class Compte {
    private int compteId;
    private String login;
    private String password;
    private String role;
    private String status;


    /* Start Section Constructor */
    public Compte() {
    }
    /* End Section Constructor */


    /* Start Section Getters & Setters */
    public int getCompteId() {
        return compteId;
    }

    public void setCompteId(int compteId) {
        this.compteId = compteId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    /* End Section Getters & Setters */


    /* Start Section ToString */

    @Override
    public String toString() {
        return "Compte{" +
                "compteId=" + compteId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
    /* End Section ToString */
}
