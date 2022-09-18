package com.amal.amalproject.models;

import com.amal.amalproject.entities.Rapport;
import com.amal.amalproject.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class RapportModel implements IRapportModel{

    Statement state;
    Connection connection = DBConnection.getConnection();

    @Override
    public Rapport addRapport(Rapport rapport) {
        try {

            PreparedStatement ps = connection.prepareStatement
                    ("INSERT INTO `dons`(`id_rapport` , `nom`, `prenom`, `mail`, `numTel`, `sujet`, `description`) VALUES (?,?,?,?,?,?,? )");



            ps.setInt(1,rapport.getId_rapport());
            ps.setString(2,rapport.getNom());
            ps.setString(3,rapport.getPrenom());
            ps.setString(4,rapport.getMail());
            ps.setString(5,rapport.getNumTel());
            ps.setString(6,rapport.getSujet());
            ps.setString(7,rapport.getDescription());





            int n = ps.executeUpdate();


        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }


}
