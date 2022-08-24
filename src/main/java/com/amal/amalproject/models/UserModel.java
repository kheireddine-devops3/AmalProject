package com.amal.amalproject.models;

import com.amal.amalproject.entities.User;
import com.amal.amalproject.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel implements IUserModel {
    Connection connection = DBConnection.getConnection();

    @Override
    public User addUser(User user) {

        try {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO USER(ID,FIRSTNAME,LASTNAME) VALUES (NULL,?,?)");

            ps.setString(1,user.getFirstName());
            ps.setString(2,user.getLastName());

            int n = ps.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
        	/*
        	 * INSERT INTO `amal`.`user` (`id_user`, `nom_user`, `prenom_user`, `date_naissance_user`, `photo_user`, `email_user`, `telephone_user`, `sexe_user`, `adresse_user`, `mot_de_passe`, `login`) VALUES ('2', 'asma', 'chaouachi', '2022-08-02', '', 'asma.chaouachi@hotmail.com', '21278255', 'femme', 'tunis', 'azsde', 'asmaaa');
        	 */
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user;");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id_user");
                String firstName = resultSet.getString("nom_user");
                String lastName = resultSet.getString("prenom_user");

                users.add(new User(id, firstName, lastName));

            }

        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return users;
    }
}
