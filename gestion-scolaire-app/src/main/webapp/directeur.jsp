<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.gestionscolaire.entites.Etudiant" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Espace Directeur</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body class="dashboard-body">

    <div class="dashboard-sidebar">
        <h2><i class="fa-solid fa-graduation-cap"></i> EcoleManager</h2>
        <a href="index.jsp"><i class="fa-solid fa-house"></i> Accueil</a>
    </div>

    <div class="dashboard-main">
        <div class="dashboard-topbar">
            <h1>Inscriptions en attente</h1>
        </div>

        <%
            List<Etudiant> etudiants = (List<Etudiant>) request.getAttribute("etudiants");
        %>

        <% if (etudiants == null || etudiants.isEmpty()) { %>
            <p>Aucune inscription en attente pour le moment.</p>
        <% } else { %>
            <table style="width:100%; background:#fff; border-radius:12px; overflow:hidden; box-shadow:0 2px 8px rgba(0,0,0,0.06);">
                <tr style="background:#7b5cf5; color:#fff; text-align:left;">
                    <th style="padding:12px;">Nom</th>
                    <th style="padding:12px;">Prenom</th>
                    <th style="padding:12px;">Email</th>
                    <th style="padding:12px;">Date de naissance</th>
                    <th style="padding:12px;">Actions</th>
                </tr>
                <% for (Etudiant e : etudiants) { %>
                    <tr style="border-bottom:1px solid #eee;">
                        <td style="padding:12px;"><%= e.getNom() %></td>
                        <td style="padding:12px;"><%= e.getPrenom() %></td>
                        <td style="padding:12px;"><%= e.getEmail() %></td>
                        <td style="padding:12px;"><%= e.getDateNaissance() %></td>
                        <td style="padding:12px;">
                            <form method="post" action="directeur" style="display:inline;">
                                <input type="hidden" name="id" value="<%= e.getId() %>">
                                <input type="hidden" name="action" value="valider">
                                <button type="submit" style="background:#2ecc8f; color:#fff; border:none; padding:6px 12px; border-radius:6px; cursor:pointer;">Valider</button>
                            </form>
                            <form method="post" action="directeur" style="display:inline;">
                                <input type="hidden" name="id" value="<%= e.getId() %>">
                                <input type="hidden" name="action" value="rejeter">
                                <button type="submit" style="background:#ff6f91; color:#fff; border:none; padding:6px 12px; border-radius:6px; cursor:pointer;">Rejeter</button>
                            </form>
                        </td>
                    </tr>
                <% } %>
            </table>
        <% } %>
    </div>

</body>
</html>
