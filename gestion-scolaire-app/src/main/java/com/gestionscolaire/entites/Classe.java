package com.gestionscolaire.entites;

public class Classe {

    private int id;
    private String nom;
    private int nombreEtudiant;

    public Classe() {
    }

    public Classe(String nom) {
        this.nom = nom;
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

    public int getNombreEtudiant() {
        return nombreEtudiant;
    }

    public void setNombreEtudiant(int nombreEtudiant) {
        this.nombreEtudiant = nombreEtudiant;
    }
}
