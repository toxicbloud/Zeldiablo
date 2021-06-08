package com;

/**
 * Arme
 */
public abstract class Arme {
    private int degats;
    private int vitesse;

    public void attaquer(Entite e1){
        e1.perdrePV(degats);
    }

    // faut ajouter Arme pour Entite
    public void jeter(){}

    // meme pour equiper
    public void equiper(Arme a1){}
}