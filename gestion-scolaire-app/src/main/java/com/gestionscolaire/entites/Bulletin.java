package com.gestionscolaire.entites;

public class Bulletin {

    private int id;
    private String nom;
    private String prenom;
    private double moyenne;
    private String annee;
    private String trimestre;
    private int etudiantId;

    public Bulletin() {
    }

    public Bulletin(String nom, String prenom, double moyenne, String annee, String trimestre, int etudiantId) {
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
        this.annee = annee;
        this.trimestre = trimestre;
        this.etudiantId = etudiantId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    public int getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }
}
