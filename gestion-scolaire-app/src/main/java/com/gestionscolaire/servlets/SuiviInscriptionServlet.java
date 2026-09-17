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

@WebServlet("/suivi")
public class SuiviInscriptionServlet extends HttpServlet {

    private final EtudiantDAO etudiantDAO = new EtudiantDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("suivi.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        try {
            Etudiant etudiant = etudiantDAO.trouverParEmail(email);
            if (etudiant == null) {
                request.setAttribute("erreur", "Aucune inscription trouvee pour cet email.");
            } else {
                request.setAttribute("etudiant", etudiant);
            }
        } catch (SQLException e) {
            throw new ServletException("Erreur lors de la recherche", e);
        }

        request.getRequestDispatcher("suivi.jsp").forward(request, response);
    }
}
