package com.gestionscolaire.dao;

import com.gestionscolaire.ConnexionBD;
import com.gestionscolaire.entites.Note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {

    public int ajouter(Note note) throws SQLException {
        String sql = "INSERT INTO note (appreciation, valeur, etudiant_id, matiere_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, note.getAppreciation());
            stmt.setDouble(2, note.getValeur());
            stmt.setInt(3, note.getEtudiantId());
            stmt.setInt(4, note.getMatiereId());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public List<Note> listerParEtudiant(int etudiantId) throws SQLException {
        List<Note> liste = new ArrayList<>();
        String sql = "SELECT * FROM note WHERE etudiant_id = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, etudiantId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Note n = new Note();
                    n.setId(rs.getInt("id"));
                    n.setAppreciation(rs.getString("appreciation"));
                    n.setValeur(rs.getDouble("valeur"));
                    n.setEtudiantId(rs.getInt("etudiant_id"));
                    n.setMatiereId(rs.getInt("matiere_id"));
                    liste.add(n);
                }
            }
        }
        return liste;
    }
}
