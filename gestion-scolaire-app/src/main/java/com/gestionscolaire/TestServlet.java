package com.gestionscolaire;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try (Connection conn = ConnexionBD.getConnection()) {
            out.println("<h1>Connexion a la base reussie !</h1>");
            out.println("<p>Base de donnees : " + conn.getCatalog() + "</p>");
        } catch (SQLException e) {
            out.println("<h1>Erreur de connexion</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }
}
