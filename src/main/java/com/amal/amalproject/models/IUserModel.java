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
    List<Compte> getAllComptes();
    List<Organization> getAllOrganizations();
    List<Medecin> getAllMedecins();
    List<Beneficier> getAllBeneficiers();
    User getUserById(int userId);
    Medecin addMedecin(Medecin medecin);
    Organization addOrganization(Organization organization);
    Beneficier addBeneficier(Beneficier beneficier);
    Benevole addBenevole(Benevole benevole);
    boolean existsCompteByLogin(String login);
    boolean existsUserByEmail(String email);
    boolean existsUserByTelephone(String telephone);
    boolean existsMedecinByCIN(String cin);
    boolean existsMedecinByMatricule(String matricule);
}
