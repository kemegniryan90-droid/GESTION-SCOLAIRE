package com.gestionscolaire.dao;

import com.gestionscolaire.ConnexionBD;
import com.gestionscolaire.entites.Bulletin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BulletinDAO {

    public int ajouter(Bulletin bulletin) throws SQLException {
        String sql = "INSERT INTO bulletin (nom, prenom, moyenne, annee, trimestre, etudiant_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, bulletin.getNom());
            stmt.setString(2, bulletin.getPrenom());
            stmt.setDouble(3, bulletin.getMoyenne());
            stmt.setString(4, bulletin.getAnnee());
            stmt.setString(5, bulletin.getTrimestre());
            stmt.setInt(6, bulletin.getEtudiantId());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public List<Bulletin> listerParEtudiant(int etudiantId) throws SQLException {
        List<Bulletin> liste = new ArrayList<>();
        String sql = "SELECT * FROM bulletin WHERE etudiant_id = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, etudiantId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Bulletin b = new Bulletin();
                    b.setId(rs.getInt("id"));
                    b.setNom(rs.getString("nom"));
                    b.setPrenom(rs.getString("prenom"));
                    b.setMoyenne(rs.getDouble("moyenne"));
                    b.setAnnee(rs.getString("annee"));
                    b.setTrimestre(rs.getString("trimestre"));
                    b.setEtudiantId(rs.getInt("etudiant_id"));
                    liste.add(b);
                }
            }
        }
        return liste;
    }
}
