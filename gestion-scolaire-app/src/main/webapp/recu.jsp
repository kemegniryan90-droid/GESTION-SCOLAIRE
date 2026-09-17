<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un recu</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Ajouter un recu de paiement</h1>

    <form action="ajouter-recu" method="post">
        <label>ID Parent :</label>
        <input type="number" name="parentId" required><br><br>

        <label>Nom :</label>
        <input type="text" name="nom" required><br><br>

        <label>Prenom :</label>
        <input type="text" name="prenom" required><br><br>

        <label>Email :</label>
        <input type="email" name="email"><br><br>

        <label>Montant (FCFA) :</label>
        <input type="number" step="0.01" min="0" name="montant" required><br><br>

        <button type="submit">Ajouter</button>
    </form>
</body>
</html>
