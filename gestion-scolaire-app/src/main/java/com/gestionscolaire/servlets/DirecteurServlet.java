package com.gestionscolaire.servlets;

import com.gestionscolaire.dao.EtudiantDAO;
import com.gestionscolaire.entites.Etudiant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/directeur")
public class DirecteurServlet extends HttpServlet {

    private final EtudiantDAO etudiantDAO = new EtudiantDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Etudiant> enAttente = etudiantDAO.listerParStatut("en_attente");
            request.setAttribute("etudiants", enAttente);
        } catch (SQLException e) {
            throw new ServletException("Erreur lors de la recuperation des inscriptions", e);
        }
        request.getRequestDispatcher("directeur.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String action = request.getParameter("action");

        try {
            int id = Integer.parseInt(idParam);
            String nouveauStatut = "valider".equals(action) ? "valide" : "rejete";
            etudiantDAO.modifierStatut(id, nouveauStatut);
        } catch (NumberFormatException | SQLException e) {
            throw new ServletException("Erreur lors de la mise a jour du statut", e);
        }

        response.sendRedirect("directeur");
    }
}
