package com.amal.amalproject.models;

import com.amal.amalproject.entities.*;
import com.amal.amalproject.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserModel implements IUserModel {
    Connection connection = DBConnection.getConnection();

    @Override
    public Compte login(String username, String password) {
        Compte compte = null;
        try {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `compte` WHERE `login` = ? AND `password` = ?;");
            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                compte = new Compte();

                compte.setCompteId(resultSet.getInt("id_compte"));
                compte.setLogin(resultSet.getString("login"));
                compte.setPassword(resultSet.getString("password"));
                compte.setRole(resultSet.getString("role"));
                compte.setStatus(resultSet.getString("status"));

                System.out.println("SUCCESS-GET-COMPTE-BY-LOGIN");

            } else {
                System.out.println("ERROR-GET-COMPTE-BY-LOGIN");
            }

            ps.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return compte;
    }

    @Override
    public Compte addCompte(Compte compte) {
        try {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO `compte` (`id_compte`, `login`, `password`, `role`, `status`) VALUES (NULL, ?, ?, ?, ?);");
            ps.setString(1,compte.getLogin());
            ps.setString(2,compte.getPassword());
            ps.setString(3,compte.getRole());
            ps.setString(4,compte.getStatus());


            int n = ps.executeUpdate();

            if(n == 1) {
                System.out.println("SUCCESS-ADD-COMPTE");
            } else {
                System.out.println("ERROR-ADD-COMPTE");
            }

            ps.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return compte;
    }

    @Override
    public Compte getCompteByLogin(String login) {
        Compte compte = null;
        try {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `compte` WHERE `login` = ?");
            ps.setString(1,login);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                compte = new Compte();

                compte.setCompteId(resultSet.getInt("id_compte"));
                compte.setLogin(resultSet.getString("login"));
                compte.setPassword(resultSet.getString("password"));
                compte.setRole(resultSet.getString("role"));
                compte.setStatus(resultSet.getString("status"));

                System.out.println("SUCCESS-GET-COMPTE-BY-LOGIN");

            } else {
                System.out.println("ERROR-GET-COMPTE-BY-LOGIN");
                System.out.println(resultSet.next());
            }

            ps.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return compte;
    }

    @Override
    public User addUser(User user) {

        try {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO `user` (`id_user`, `nom_user`, `prenom_user`, `date_naissance_user`, `photo_user`, `email_user`, `telephone_user`, `sexe_user`, `adresse_user`) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");

            ps.setInt(1,user.getUserId());
            ps.setString(2,user.getNom());
            ps.setString(3,user.getPrenom());
            ps.setDate(4,user.getDateNaissance() != null ? Date.valueOf(user.getDateNaissance()) : null);
            ps.setString(5,user.getPhoto());
            ps.setString(6,user.getEmail());
            ps.setString(7,user.getTelephone());
            ps.setString(8,user.getSexe());
            ps.setString(9,user.getAdresse());


            int n = ps.executeUpdate();

            if(n == 1) {
                System.out.println("SUCCESS-ADD-USER");
            } else {
                System.out.println("ERROR-ADD-USER");
            }

            ps.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return user;
    }

    @Override
    public User editUser(User userUpdated, int userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user;");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                User user = new User();
                user.setUserId(resultSet.getInt("id_user"));
                user.setNom(resultSet.getString("nom_user"));
                user.setPrenom(resultSet.getString("prenom_user"));
                user.setEmail(resultSet.getString("email_user"));
                user.setSexe(resultSet.getString("sexe_user"));

                users.add(user);

            }

            ps.close();
        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return users;
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        try {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `user` WHERE `id_user` = ?");
            ps.setInt(1,userId);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                user = new User();

                user.setUserId(resultSet.getInt("id_user"));
                user.setNom(resultSet.getString("nom_user"));
                user.setPrenom(resultSet.getString("prenom_user"));
                user.setDateNaissance(resultSet.getDate("date_naissance_user").toLocalDate());
                user.setPhoto(resultSet.getString("photo_user"));
                user.setEmail(resultSet.getString("email_user"));
                user.setTelephone(resultSet.getString("telephone_user"));
                user.setSexe(resultSet.getString("sexe_user"));
                user.setAdresse(resultSet.getString("adresse_user"));

                System.out.println("SUCCESS-GET-USER-BY-ID");

            } else {
                System.out.println("ERROR-GET-USER-BY-ID");
            }

            ps.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return user;
    }

    @Override
    public Medecin addMedecin(Medecin medecin) {
        try {

            Compte compte = this.addCompte(medecin.getCompte());
            System.out.println(compte);
            Compte savedCompte = this.getCompteByLogin(compte.getLogin());
            System.out.println(savedCompte);
            User user = this.addUser(medecin);
            medecin.setUserId(savedCompte.getCompteId());
            User savedUser = this.getUserById(user.getUserId());
            System.out.println(savedUser);
            medecin.setUserId(savedUser.getUserId());

            PreparedStatement ps = connection.prepareStatement("INSERT INTO `medecin` (`id_user`,`matricule`, `specialite`, `id_ordre`, `cin`, `Assurance`) VALUES (?, ?, ?, ?, ?, ?);");

            ps.setInt(1,medecin.getUserId());
            ps.setString(2,medecin.getMatricule());
            ps.setString(3,medecin.getSpecialite());
            ps.setInt(4,500);
            ps.setString(5,"98989898");
            ps.setString(6,medecin.getAssurance());

            int n = ps.executeUpdate();

            if(n == 1) {
                System.out.println("SUCCESS-ADD-DOCTOR");
            } else {
                System.out.println("ERROR-ADD-DOCTOR");
            }

            ps.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return medecin;
    }

    @Override
    public Organization addOrganization(Organization organization) {
        try {

            Compte compte = this.addCompte(organization.getCompte());
            Compte savedCompte = this.getCompteByLogin(compte.getLogin());
            System.out.println(savedCompte);

            organization.setUserId(savedCompte.getCompteId());

            PreparedStatement ps = connection.prepareStatement("INSERT INTO `organisation` (`matricule_fiscale`, `nom_organisation`, `forme_juridique`, `num_tel`, `email`, `adresse`, `id_compte`) VALUES (?, ?, ?, ?, ?, ?, ?);");

            ps.setString(1,organization.getMatriculeFiscale());
            ps.setString(2,organization.getNom());
            ps.setString(3,organization.getFormJuridique());
            ps.setString(4,organization.getNumPhone());
            ps.setString(5,organization.getEmail());
            ps.setString(6,organization.getAdresse());
            ps.setInt(7,organization.getUserId());

            int n = ps.executeUpdate();

            if(n == 1) {
                System.out.println("SUCCESS-ADD-ORGANIZATION");
            } else {
                System.out.println("ERROR-ADD-ORGANIZATION");
            }

            ps.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return organization;
    }

    @Override
    public Beneficier addBeneficier(Beneficier beneficier) {
        try {

            Compte compte = this.addCompte(beneficier.getCompte());
            Compte savedCompte = this.getCompteByLogin(compte.getLogin());
            System.out.println(savedCompte);
            beneficier.setUserId(savedCompte.getCompteId());
            User user = this.addUser(beneficier);
            User savedUser = this.getUserById(user.getUserId());
            System.out.println(savedUser);
            beneficier.setUserId(savedUser.getUserId());

            PreparedStatement ps = connection.prepareStatement("INSERT INTO `beneficier` (`carte_handicap`, `date_expiration`, `id_user`) VALUES (?, ?, ?);");

            ps.setString(1,beneficier.getCarteHandicapNumber());
            ps.setDate(2,beneficier.getDateExpiration() != null ? Date.valueOf(beneficier.getDateExpiration()) : null);
            ps.setInt(3,beneficier.getUserId());

            int n = ps.executeUpdate();

            if(n == 1) {
                System.out.println("SUCCESS-ADD-BENEFICIER");
            } else {
                System.out.println("ERROR-ADD-BENEFICIER");
            }

            ps.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return beneficier;
    }
}
