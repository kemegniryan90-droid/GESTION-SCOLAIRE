<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inscription Etudiant</title>
</head>
<body>
    <h1>Inscription d'un etudiant</h1>

    <form action="inscrire" method="post">
        <label>Nom :</label>
        <input type="text" name="nom" required><br><br>

        <label>Prenom :</label>
        <input type="text" name="prenom" required><br><br>

        <label>Email :</label>
        <input type="email" name="email" required><br><br>

        <label>Date de naissance :</label>
        <input type="date" name="dateNaissance" required><br><br>

        <button type="submit">Inscrire</button>
    </form>
</body>
</html>
