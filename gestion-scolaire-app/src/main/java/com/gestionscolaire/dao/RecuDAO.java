package com.gestionscolaire.dao;

import com.gestionscolaire.ConnexionBD;
import com.gestionscolaire.entites.Recu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecuDAO {

    public int ajouter(Recu recu) throws SQLException {
        String sql = "INSERT INTO recu (nom, prenom, email, montant, parent_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, recu.getNom());
            stmt.setString(2, recu.getPrenom());
            stmt.setString(3, recu.getEmail());
            stmt.setDouble(4, recu.getMontant());
            stmt.setInt(5, recu.getParentId());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public List<Recu> listerParParent(int parentId) throws SQLException {
        List<Recu> liste = new ArrayList<>();
        String sql = "SELECT * FROM recu WHERE parent_id = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, parentId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Recu r = new Recu();
                    r.setId(rs.getInt("id"));
                    r.setNom(rs.getString("nom"));
                    r.setPrenom(rs.getString("prenom"));
                    r.setEmail(rs.getString("email"));
                    r.setMontant(rs.getDouble("montant"));
                    r.setParentId(rs.getInt("parent_id"));
                    liste.add(r);
                }
            }
        }
        return liste;
    }
}
