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

}