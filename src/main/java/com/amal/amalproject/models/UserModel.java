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
