package com.amal.amalproject.models;

import com.amal.amalproject.entities.Compte;
import com.amal.amalproject.entities.Medecin;
import com.amal.amalproject.entities.Organization;
import com.amal.amalproject.entities.User;

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
}
