<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion Scolaire - Accueil</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body class="dashboard-body">

    <div class="dashboard-sidebar">
        <h2><i class="fa-solid fa-graduation-cap"></i> Ecole Manager</h2>

        <div class="dashboard-section-label">Inscriptions</div>
        <a href="inscription.jsp"><i class="fa-solid fa-user-plus"></i> Inscrire un etudiant</a>
        <a href="suivi.jsp"><i class="fa-solid fa-magnifying-glass"></i> Suivi inscription</a>
        <a href="directeur"><i class="fa-solid fa-user-tie"></i> Espace Directeur</a>

        <div class="dashboard-section-label">Gestion</div>
        <a href="classe.jsp"><i class="fa-solid fa-chalkboard"></i> Ajouter une classe</a>
        <a href="personnel.jsp"><i class="fa-solid fa-id-badge"></i> Ajouter personnel</a>
        <a href="enseignant.jsp"><i class="fa-solid fa-chalkboard-user"></i> Ajouter enseignant</a>
        <a href="parent.jsp"><i class="fa-solid fa-people-roof"></i> Ajouter parent</a>
        <a href="matiere.jsp"><i class="fa-solid fa-book"></i> Ajouter matiere</a>
        <a href="note.jsp"><i class="fa-solid fa-pen"></i> Ajouter note</a>
        <a href="bulletin.jsp"><i class="fa-solid fa-file-lines"></i> Ajouter bulletin</a>
        <a href="recu.jsp"><i class="fa-solid fa-receipt"></i> Ajouter recu</a>
    </div>

    <div class="dashboard-main">
        <div class="dashboard-topbar">
            <h1>Tableau de bord</h1>
        </div>

        <div class="dashboard-cards">

            <a href="inscription.jsp" class="dashboard-card">
                <div class="icon-box bg-purple"><i class="fa-solid fa-user-plus"></i></div>
                <div class="card-text">
                    <strong>Inscription</strong>
                    <span>Inscrire un nouvel etudiant</span>
                </div>
            </a>

            <a href="suivi.jsp" class="dashboard-card">
                <div class="icon-box bg-blue"><i class="fa-solid fa-magnifying-glass"></i></div>
                <div class="card-text">
                    <strong>Suivi</strong>
                    <span>Suivre une inscription</span>
                </div>
            </a>

            <a href="directeur" class="dashboard-card">
                <div class="icon-box bg-green"><i class="fa-solid fa-user-tie"></i></div>
                <div class="card-text">
                    <strong>Directeur</strong>
                    <span>Valider les inscriptions</span>
                </div>
            </a>

            <a href="classe.jsp" class="dashboard-card">
                <div class="icon-box bg-yellow"><i class="fa-solid fa-chalkboard"></i></div>
                <div class="card-text">
                    <strong>Classes</strong>
                    <span>Ajouter une classe</span>
                </div>
            </a>

            <a href="personnel.jsp" class="dashboard-card">
                <div class="icon-box bg-pink"><i class="fa-solid fa-id-badge"></i></div>
                <div class="card-text">
                    <strong>Personnel</strong>
                    <span>Ajouter un membre du personnel</span>
                </div>
            </a>

            <a href="enseignant.jsp" class="dashboard-card">
                <div class="icon-box bg-teal"><i class="fa-solid fa-chalkboard-user"></i></div>
                <div class="card-text">
                    <strong>Enseignants</strong>
                    <span>Ajouter un enseignant</span>
                </div>
            </a>

            <a href="parent.jsp" class="dashboard-card">
                <div class="icon-box bg-purple"><i class="fa-solid fa-people-roof"></i></div>
                <div class="card-text">
                    <strong>Parents</strong>
                    <span>Ajouter un parent</span>
                </div>
            </a>

            <a href="matiere.jsp" class="dashboard-card">
                <div class="icon-box bg-blue"><i class="fa-solid fa-book"></i></div>
                <div class="card-text">
                    <strong>Matieres</strong>
                    <span>Ajouter une matiere</span>
                </div>
            </a>

            <a href="note.jsp" class="dashboard-card">
                <div class="icon-box bg-green"><i class="fa-solid fa-pen"></i></div>
                <div class="card-text">
                    <strong>Notes</strong>
                    <span>Ajouter une note</span>
                </div>
            </a>

            <a href="bulletin.jsp" class="dashboard-card">
                <div class="icon-box bg-yellow"><i class="fa-solid fa-file-lines"></i></div>
                <div class="card-text">
                    <strong>Bulletins</strong>
                    <span>Ajouter un bulletin</span>
                </div>
            </a>

            <a href="recu.jsp" class="dashboard-card">
                <div class="icon-box bg-pink"><i class="fa-solid fa-receipt"></i></div>
                <div class="card-text">
                    <strong>Recus</strong>
                    <span>Ajouter un recu</span>
                </div>
            </a>

        </div>
    </div>

</body>
</html>
