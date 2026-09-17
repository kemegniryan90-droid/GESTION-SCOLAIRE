package com.gestionscolaire.dao;

import com.gestionscolaire.ConnexionBD;
import com.gestionscolaire.entites.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {

    public int ajouter(Etudiant etudiant) throws SQLException {
        String sql = "INSERT INTO etudiant (nom, prenom, email, date_naissance) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, etudiant.getNom());
            stmt.setString(2, etudiant.getPrenom());
            stmt.setString(3, etudiant.getEmail());
            stmt.setDate(4, java.sql.Date.valueOf(etudiant.getDateNaissance()));

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public List<Etudiant> listerTous() throws SQLException {
        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                etudiants.add(mapperEtudiant(rs));
            }
        }
        return etudiants;
    }

    public List<Etudiant> listerParStatut(String statut) throws SQLException {
        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "SELECT * FROM etudiant WHERE statut = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, statut);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    etudiants.add(mapperEtudiant(rs));
                }
            }
        }
        return etudiants;
    }

    public Etudiant trouverParEmail(String email) throws SQLException {
        String sql = "SELECT * FROM etudiant WHERE email = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapperEtudiant(rs);
                }
            }
        }
        return null;
    }

    public void modifierStatut(int id, String statut) throws SQLException {
        String sql = "UPDATE etudiant SET statut = ? WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, statut);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    private Etudiant mapperEtudiant(ResultSet rs) throws SQLException {
        Etudiant e = new Etudiant();
        e.setId(rs.getInt("id"));
        e.setNom(rs.getString("nom"));
        e.setPrenom(rs.getString("prenom"));
        e.setEmail(rs.getString("email"));
        e.setStatut(rs.getString("statut"));

        java.sql.Date date = rs.getDate("date_naissance");
        if (date != null) {
            e.setDateNaissance(date.toLocalDate());
        }

        return e;
    }
}
