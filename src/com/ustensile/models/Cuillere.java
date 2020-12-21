package com.ustensile.models;

public class Cuillere extends Ustensile{
    private double longueur;

    public Cuillere() {
    }

    public Cuillere(double longueur) {
        this.longueur = longueur;
    }

    public double getLongueur() {
        return this.longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }
    
    
}
