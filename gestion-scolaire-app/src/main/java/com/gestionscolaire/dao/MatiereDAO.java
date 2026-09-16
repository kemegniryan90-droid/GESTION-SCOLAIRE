package com.gestionscolaire.dao;

import com.gestionscolaire.ConnexionBD;
import com.gestionscolaire.entites.Matiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatiereDAO {

    public int ajouter(Matiere matiere) throws SQLException {
        String sql = "INSERT INTO matiere (nom, coefficient) VALUES (?, ?)";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, matiere.getNom());
            stmt.setInt(2, matiere.getCoefficient());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public List<Matiere> listerToutes() throws SQLException {
        List<Matiere> liste = new ArrayList<>();
        String sql = "SELECT * FROM matiere";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Matiere m = new Matiere();
                m.setId(rs.getInt("id"));
                m.setNom(rs.getString("nom"));
                m.setCoefficient(rs.getInt("coefficient"));
                liste.add(m);
            }
        }
        return liste;
    }
}
