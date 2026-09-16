package com.gestionscolaire.entites;

public class Recu {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private double montant;
    private int parentId;

    public Recu() {
    }

    public Recu(String nom, String prenom, String email, double montant, int parentId) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.montant = montant;
        this.parentId = parentId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
