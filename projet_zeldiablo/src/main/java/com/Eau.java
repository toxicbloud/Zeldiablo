package com;
/**
 * Classe Chemin, represente un chemin dans le labyrinthe
 */
public class Eau extends Case {

    /**
     * CONSTRUCTEURS
     */
    
    /** Constructeur vide de Chemin */
    Eau() {
        super(true, Textures.tex_eau);
    }

    @Override
    public void action(Jeu j) {
        j.getJoueur().setVitesse(1);
    }
    
}