package com.gestionscolaire.entites;

public class Note {

    private int id;
    private String appreciation;
    private double valeur;
    private int etudiantId;
    private int matiereId;

    public Note() {
    }

    public Note(double valeur, int etudiantId, int matiereId) {
        this.valeur = valeur;
        this.etudiantId = etudiantId;
        this.matiereId = matiereId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public int getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }

    public int getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(int matiereId) {
        this.matiereId = matiereId;
    }
}
