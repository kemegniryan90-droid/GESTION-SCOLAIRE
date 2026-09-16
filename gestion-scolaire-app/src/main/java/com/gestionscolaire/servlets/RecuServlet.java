package com.gestionscolaire.servlets;

import com.gestionscolaire.dao.RecuDAO;
import com.gestionscolaire.entites.Recu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouter-recu")
public class RecuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String parentIdStr = request.getParameter("parentId");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String montantStr = request.getParameter("montant");

        try {
            int parentId = Integer.parseInt(parentIdStr);
            double montant = Double.parseDouble(montantStr);

            Recu recu = new Recu(nom, prenom, email, montant, parentId);

            RecuDAO dao = new RecuDAO();
            int id = dao.ajouter(recu);

            out.println("<h1>Recu ajoute avec succes !</h1>");
            out.println("<p>ID genere : " + id + "</p>");
            out.println("<p>Montant : " + montant + " FCFA</p>");

        } catch (SQLException e) {
            out.println("<h1>Erreur lors de l'ajout</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }
}
