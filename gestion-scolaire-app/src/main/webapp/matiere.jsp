<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter une matiere</title>
</head>
<body>
    <h1>Ajouter une matiere</h1>

    <form action="ajouter-matiere" method="post">
        <label>Nom :</label>
        <input type="text" name="nom" required><br><br>

        <label>Coefficient :</label>
        <input type="number" name="coefficient" min="1" value="1" required><br><br>

        <button type="submit">Ajouter</button>
    </form>
</body>
</html>
