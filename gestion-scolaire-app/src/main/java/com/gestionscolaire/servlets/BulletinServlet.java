package com.gestionscolaire.servlets;

import com.gestionscolaire.dao.BulletinDAO;
import com.gestionscolaire.entites.Bulletin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouter-bulletin")
public class BulletinServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String etudiantIdStr = request.getParameter("etudiantId");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String moyenneStr = request.getParameter("moyenne");
        String annee = request.getParameter("annee");
        String trimestre = request.getParameter("trimestre");

        try {
            int etudiantId = Integer.parseInt(etudiantIdStr);
            double moyenne = Double.parseDouble(moyenneStr);

            Bulletin bulletin = new Bulletin(nom, prenom, moyenne, annee, trimestre, etudiantId);

            BulletinDAO dao = new BulletinDAO();
            int id = dao.ajouter(bulletin);

            out.println("<h1>Bulletin ajoute avec succes !</h1>");
            out.println("<p>ID genere : " + id + "</p>");
            out.println("<p>Moyenne : " + moyenne + "/20</p>");

        } catch (SQLException e) {
            out.println("<h1>Erreur lors de l'ajout</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }
}
