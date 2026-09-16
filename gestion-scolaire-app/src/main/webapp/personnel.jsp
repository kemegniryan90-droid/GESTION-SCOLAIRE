<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un personnel</title>
</head>
<body>
    <h1>Ajouter un membre du personnel</h1>

    <form action="ajouter-personnel" method="post">
        <label>Nom :</label>
        <input type="text" name="nom" required><br><br>

        <label>Prenom :</label>
        <input type="text" name="prenom" required><br><br>

        <label>Email :</label>
        <input type="email" name="email" required><br><br>

        <label>Mot de passe :</label>
        <input type="password" name="motDePasse" required><br><br>

        <button type="submit">Ajouter</button>
    </form>
</body>
</html>
