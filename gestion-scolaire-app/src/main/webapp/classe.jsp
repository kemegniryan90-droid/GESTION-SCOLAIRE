<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter une classe</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Ajouter une classe</h1>

    <form action="ajouter-classe" method="post">
        <label>Nom de la classe :</label>
        <input type="text" name="nom" required><br><br>

        <button type="submit">Ajouter</button>
    </form>
</body>
</html>
