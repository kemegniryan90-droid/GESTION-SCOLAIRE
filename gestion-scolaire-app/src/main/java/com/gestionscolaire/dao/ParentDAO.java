package com.gestionscolaire.dao;

import com.gestionscolaire.ConnexionBD;
import com.gestionscolaire.entites.Parent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ParentDAO {

    public int ajouter(Parent parent) throws SQLException {
        String sql = "INSERT INTO parent (nom, prenom, telephone, email, mot_de_passe) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, parent.getNom());
            stmt.setString(2, parent.getPrenom());
            stmt.setString(3, parent.getTelephone());
            stmt.setString(4, parent.getEmail());
            stmt.setString(5, parent.getMotDePasse());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public List<Parent> listerTous() throws SQLException {
        List<Parent> liste = new ArrayList<>();
        String sql = "SELECT * FROM parent";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Parent p = new Parent();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setTelephone(rs.getString("telephone"));
                p.setEmail(rs.getString("email"));
                p.setMotDePasse(rs.getString("mot_de_passe"));
                liste.add(p);
            }
        }
        return liste;
    }
}
