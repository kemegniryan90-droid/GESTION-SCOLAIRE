package com.gestionscolaire.servlets;

import com.gestionscolaire.dao.EtudiantDAO;
import com.gestionscolaire.entites.Etudiant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/inscrire")
public class InscriptionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String dateNaissanceStr = request.getParameter("dateNaissance");

        try {
            LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr);
            Etudiant etudiant = new Etudiant(nom, prenom, email, dateNaissance);

            EtudiantDAO dao = new EtudiantDAO();
            int id = dao.ajouter(etudiant);

            out.println("<h1>Etudiant inscrit avec succes !</h1>");
            out.println("<p>ID genere : " + id + "</p>");
            out.println("<p>Nom : " + nom + " " + prenom + "</p>");

        } catch (SQLException e) {
            out.println("<h1>Erreur lors de l'inscription</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }
}
