package com.gestionscolaire.servlets;

import com.gestionscolaire.dao.MatiereDAO;
import com.gestionscolaire.entites.Matiere;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouter-matiere")
public class MatiereServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nom = request.getParameter("nom");
        String coefficientStr = request.getParameter("coefficient");

        try {
            int coefficient = Integer.parseInt(coefficientStr);
            Matiere matiere = new Matiere(nom, coefficient);

            MatiereDAO dao = new MatiereDAO();
            int id = dao.ajouter(matiere);

            out.println("<h1>Matiere ajoutee avec succes !</h1>");
            out.println("<p>ID genere : " + id + "</p>");
            out.println("<p>Nom : " + nom + " (coefficient " + coefficient + ")</p>");

        } catch (SQLException e) {
            out.println("<h1>Erreur lors de l'ajout</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }
}
