<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter une note</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Ajouter une note</h1>

    <form action="ajouter-note" method="post">
        <label>ID Etudiant :</label>
        <input type="number" name="etudiantId" required><br><br>

        <label>ID Matiere :</label>
        <input type="number" name="matiereId" required><br><br>

        <label>Valeur (sur 20) :</label>
        <input type="number" step="0.01" min="0" max="20" name="valeur" required><br><br>

        <label>Appreciation :</label>
        <input type="text" name="appreciation"><br><br>

        <button type="submit">Ajouter</button>
    </form>
</body>
</html>
