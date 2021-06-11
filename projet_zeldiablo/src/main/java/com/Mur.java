package com;

/**
 * Classe Mur, represente un Mur dans le labyrinthe
 */

public class Mur extends Case {

    /**
     * CONSTRUCTEURS
     */

    /** Constructeur vide de Mur */
    Mur() {
        super(false, Textures.tex_mur);
    }

    /** Action declenchee lors du passage sur la case */
    @Override
    public void action(Jeu j) {
        
    }
}