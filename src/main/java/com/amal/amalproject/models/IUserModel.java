package com.amal.amalproject.models;

import com.amal.amalproject.entities.*;

import java.util.List;

public interface IUserModel {
    Compte login(String username, String password);
    Compte addCompte(Compte compte);
    Compte getCompteByLogin(String login);
    User addUser(User user);
    User editUser(User userUpdated,int userId);
    List<User> getAllUsers();
    User getUserById(int userId);
    Medecin addMedecin(Medecin medecin);
    Organization addOrganization(Organization organization);
    Beneficier addBeneficier(Beneficier beneficier);
}
