package com.gestionscolaire.servlets;

import com.gestionscolaire.dao.NoteDAO;
import com.gestionscolaire.entites.Note;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouter-note")
public class NoteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String etudiantIdStr = request.getParameter("etudiantId");
        String matiereIdStr = request.getParameter("matiereId");
        String valeurStr = request.getParameter("valeur");
        String appreciation = request.getParameter("appreciation");

        try {
            int etudiantId = Integer.parseInt(etudiantIdStr);
            int matiereId = Integer.parseInt(matiereIdStr);
            double valeur = Double.parseDouble(valeurStr);

            Note note = new Note(valeur, etudiantId, matiereId);
            note.setAppreciation(appreciation);

            NoteDAO dao = new NoteDAO();
            int id = dao.ajouter(note);

            out.println("<h1>Note ajoutee avec succes !</h1>");
            out.println("<p>ID genere : " + id + "</p>");
            out.println("<p>Valeur : " + valeur + "/20</p>");

        } catch (SQLException e) {
            out.println("<h1>Erreur lors de l'ajout</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }
}
