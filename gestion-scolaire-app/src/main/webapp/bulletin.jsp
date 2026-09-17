<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un bulletin</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Ajouter un bulletin</h1>

    <form action="ajouter-bulletin" method="post">
        <label>ID Etudiant :</label>
        <input type="number" name="etudiantId" required><br><br>

        <label>Nom :</label>
        <input type="text" name="nom" required><br><br>

        <label>Prenom :</label>
        <input type="text" name="prenom" required><br><br>

        <label>Moyenne :</label>
        <input type="number" step="0.01" min="0" max="20" name="moyenne" required><br><br>

        <label>Annee (ex: 2025-2026) :</label>
        <input type="text" name="annee" required><br><br>

        <label>Trimestre :</label>
        <select name="trimestre" required>
            <option value="Trimestre 1">Trimestre 1</option>
            <option value="Trimestre 2">Trimestre 2</option>
            <option value="Trimestre 3">Trimestre 3</option>
        </select><br><br>

        <button type="submit">Ajouter</button>
    </form>
</body>
</html>
