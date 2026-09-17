<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.gestionscolaire.entites.Etudiant" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Suivi d'inscription</title>
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
            <h1>Suivi d'inscription</h1>
        </div>

        <div style="background:#fff; border-radius:12px; padding:24px; max-width:500px; box-shadow:0 2px 8px rgba(0,0,0,0.06);">
            <form method="post" action="suivi">
                <label for="email">Entrez l'email utilise lors de l'inscription :</label><br><br>
                <input type="email" id="email" name="email" required style="width:100%; padding:10px; border:1px solid #ddd; border-radius:6px;">
                <br><br>
                <button type="submit" style="background:#7b5cf5; color:#fff; border:none; padding:10px 20px; border-radius:6px; cursor:pointer;">Rechercher</button>
            </form>

            <%
                String erreur = (String) request.getAttribute("erreur");
                Etudiant etudiant = (Etudiant) request.getAttribute("etudiant");
            %>

            <% if (erreur != null) { %>
                <p style="color:#ff6f91; margin-top:16px;"><%= erreur %></p>
            <% } %>

            <% if (etudiant != null) { %>
                <div style="margin-top:20px; padding-top:20px; border-top:1px solid #eee;">
                    <p><strong>Nom :</strong> <%= etudiant.getNom() %></p>
                    <p><strong>Prenom :</strong> <%= etudiant.getPrenom() %></p>
                    <p><strong>Email :</strong> <%= etudiant.getEmail() %></p>
                    <p><strong>Statut :</strong>
                        <%
                            String statut = etudiant.getStatut();
                            String couleur = "en_attente".equals(statut) ? "#f4b740" : "valide".equals(statut) ? "#2ecc8f" : "#ff6f91";
                        %>
                        <span style="color:<%= couleur %>; font-weight:bold;"><%= statut %></span>
                    </p>
                </div>
            <% } %>
        </div>
    </div>

</body>
</html>
