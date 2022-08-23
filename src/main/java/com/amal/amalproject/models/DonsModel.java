package com.amal.amalproject.models;


import com.amal.amalproject.entities.dons;
import com.amal.amalproject.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonsModel implements IDonsModel{
    Connection connection = DBConnection.getConnection();

    @Override
    public dons addDons(dons DON) {
        try {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO `dons`(`id_dons`, `libele_dons`, `description_dons`, `photo_produit_dons`, `type_dons`, `id_compte`) VALUES (NULL,?,?,?,?,?,NULL)");


            ps.setString(2,dons.getLibele_dons());
            ps.setString(2,dons.getDescription_dons());
            ps.setString(2,dons.getPhoto_produit_dons());
            ps.setString(2,dons.getType_dons());

            int n = ps.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return null;

    }

    @Override
    public dons removeDons(dons DON) {
        return null;
    }

    @Override
    public dons modifyDOns(dons DON) {
        return null;
    }

    @Override
    public List<dons> getAllDons() {
        List<dons> dons = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM dons;");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                int idDon = resultSet.getInt("id_dons");
                String libelledons = resultSet.getString("libelledons");
                String descDons = resultSet.getString("description_dons");
                String imgProduit = resultSet.getString("photo_produit_dons");
                String typeDons = resultSet.getString("type_dons");


                dons.add(new dons(idDon, libelledons, descDons,imgProduit,typeDons));

            }

        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return dons;
    }
}
