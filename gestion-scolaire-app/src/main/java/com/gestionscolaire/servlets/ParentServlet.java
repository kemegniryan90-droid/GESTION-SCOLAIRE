package com.gestionscolaire.servlets;

import com.gestionscolaire.dao.ParentDAO;
import com.gestionscolaire.entites.Parent;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouter-parent")
public class ParentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

        try {
            Parent parent = new Parent(nom, prenom, telephone, email);
            parent.setMotDePasse(motDePasse);

            ParentDAO dao = new ParentDAO();
            int id = dao.ajouter(parent);

            out.println("<h1>Parent ajoute avec succes !</h1>");
            out.println("<p>ID genere : " + id + "</p>");
            out.println("<p>Nom : " + nom + " " + prenom + "</p>");

        } catch (SQLException e) {
            out.println("<h1>Erreur lors de l'ajout</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }
}
