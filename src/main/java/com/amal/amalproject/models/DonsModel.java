package com.amal.amalproject.models;


import com.amal.amalproject.entities.Dons;
import com.amal.amalproject.utils.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DonsModel implements IDonsModel{

    Statement state;
    Connection connection = DBConnection.getConnection();




    @Override
    public void addDons(Dons DON) {
        try {

            PreparedStatement ps = connection.prepareStatement
                    ("INSERT INTO `dons`(`id_dons` , `libele_dons`, `description_dons`, `photo_produit_dons`, `type_dons`, `id_compte`) VALUES (?,?,?,?,?,NULL )");



            ps.setInt(1,DON.getId_dons());
            ps.setString(2,DON.getLibele_dons());
            ps.setString(3,DON.getDescription_dons());
            ps.setString(4,DON.getPhoto_produit_dons());
            ps.setString(5,DON.getType_dons());





            int n = ps.executeUpdate();


        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void removeDons(Dons DON) {


    }

    public ObservableList<Dons> getAllDons() {
        ObservableList<Dons> dons = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM dons;");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                int idDon = resultSet.getInt("id_dons");
                String libelledons = resultSet.getString("libele_dons");
                String descDons = resultSet.getString("description_dons");
                String imgProduit = resultSet.getString("photo_produit_dons");
                String typeDons = resultSet.getString("type_dons");


                dons.add(new Dons(idDon, libelledons, descDons,imgProduit,typeDons));

            }

        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return dons;
    }

    @Override
    public void modifyDons(Dons DON) {

        try {

            PreparedStatement ps = connection.prepareStatement
                    /*("UPDATE dons set   libele_dons = " +"'"+DON.getLibele_dons()+"'" +
                            ", description_dons = " +"'"+ DON.getDescription_dons()+"'" +
                            ", photo_produit_dons = "+"'"+DON.getPhoto_produit_dons()+"'"+
                            ", type_dons= " +"'"+DON.getType_dons()+"'"+", WHERE id_dons = "+DON.getId_dons()

                    );*/
                            ("UPDATE `dons` SET `id_dons`=?,`libele_dons`=?,`description_dons`=?,`photo_produit_dons`=?,`type_dons`=?,`id_compte`=? WHERE id_dons="+DON.getId_dons());


            int n = ps.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
