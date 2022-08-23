package com.amal.amalproject.entities;

import java.util.Objects;

public class compte {
    private int id_compte;
    private String login;
    private String password;
    private String role;
    private String status;

    public compte() {
    }

    public compte(int id_compte, String login, String password, String role, String status) {
        this.id_compte = id_compte;
        this.login = login;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof compte)) return false;
        compte compte = (compte) o;
        return getId_compte() == compte.getId_compte() && Objects.equals(getLogin(), compte.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_compte(), getLogin());
    }

    @Override
    public String toString() {
        return "compte{" +
                "id_compte=" + id_compte +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
