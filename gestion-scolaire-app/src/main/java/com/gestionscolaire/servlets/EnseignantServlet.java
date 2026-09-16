package com.gestionscolaire.servlets;

import com.gestionscolaire.dao.EnseignantDAO;
import com.gestionscolaire.entites.Enseignant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouter-enseignant")
public class EnseignantServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

        try {
            Enseignant enseignant = new Enseignant(nom, prenom, email);
            enseignant.setMotDePasse(motDePasse);

            EnseignantDAO dao = new EnseignantDAO();
            int id = dao.ajouter(enseignant);

            out.println("<h1>Enseignant ajoute avec succes !</h1>");
            out.println("<p>ID genere : " + id + "</p>");
            out.println("<p>Nom : " + nom + " " + prenom + "</p>");

        } catch (SQLException e) {
            out.println("<h1>Erreur lors de l'ajout</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }
}
