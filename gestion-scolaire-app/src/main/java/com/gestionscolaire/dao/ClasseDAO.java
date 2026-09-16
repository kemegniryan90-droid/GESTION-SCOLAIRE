package com.gestionscolaire.dao;

import com.gestionscolaire.ConnexionBD;
import com.gestionscolaire.entites.Classe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClasseDAO {

    public int ajouter(Classe classe) throws SQLException {
        String sql = "INSERT INTO classe (nom, nombre_etudiant) VALUES (?, ?)";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, classe.getNom());
            stmt.setInt(2, classe.getNombreEtudiant());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public List<Classe> listerToutes() throws SQLException {
        List<Classe> classes = new ArrayList<>();
        String sql = "SELECT * FROM classe";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Classe c = new Classe();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setNombreEtudiant(rs.getInt("nombre_etudiant"));
                classes.add(c);
            }
        }
        return classes;
    }
}
