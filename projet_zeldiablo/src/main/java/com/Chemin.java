package com;
/**
 * Classe Chemin, represente un chemin dans le labyrinthe
 */
public class Chemin extends Case {

    /**
     * CONSTRUCTEURS
     */
    
    /** Constructeur vide de Chemin */
    Chemin() {
        super(true, Textures.tex_chemin);
    }

    /** Action declenchee lors du passage sur la case */
    @Override
    public void action(Jeu j) {
    }
}