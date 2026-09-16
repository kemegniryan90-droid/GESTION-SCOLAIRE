package com.gestionscolaire.servlets;

import com.gestionscolaire.dao.ClasseDAO;
import com.gestionscolaire.entites.Classe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouter-classe")
public class ClasseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nom = request.getParameter("nom");

        try {
            Classe classe = new Classe(nom);

            ClasseDAO dao = new ClasseDAO();
            int id = dao.ajouter(classe);

            out.println("<h1>Classe ajoutee avec succes !</h1>");
            out.println("<p>ID genere : " + id + "</p>");
            out.println("<p>Nom : " + nom + "</p>");

        } catch (SQLException e) {
            out.println("<h1>Erreur lors de l'ajout</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }
}
