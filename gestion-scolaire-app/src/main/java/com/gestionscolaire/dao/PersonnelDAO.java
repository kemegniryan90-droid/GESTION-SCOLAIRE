package com.gestionscolaire.dao;

import com.gestionscolaire.ConnexionBD;
import com.gestionscolaire.entites.Personnel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonnelDAO {

    public int ajouter(Personnel personnel) throws SQLException {
        String sql = "INSERT INTO personnel (nom, prenom, email, mot_de_passe) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, personnel.getNom());
            stmt.setString(2, personnel.getPrenom());
            stmt.setString(3, personnel.getEmail());
            stmt.setString(4, personnel.getMotDePasse());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public List<Personnel> listerTous() throws SQLException {
        List<Personnel> liste = new ArrayList<>();
        String sql = "SELECT * FROM personnel";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Personnel p = new Personnel();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setMotDePasse(rs.getString("mot_de_passe"));
                liste.add(p);
            }
        }
        return liste;
    }
}
