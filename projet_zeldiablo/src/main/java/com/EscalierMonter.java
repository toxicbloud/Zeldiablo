package com;
/**
 * Classe Chemin, represente un chemin dans le labyrinthe
 */
public class EscalierMonter extends Case {

    /**
     * CONSTRUCTEURS
     */
    
    /** Constructeur vide de Chemin */
    EscalierMonter() {
        super(true, Textures.tex_escalierMonter);
    }

    @Override
    public void action(Jeu j) {
        if (j.nextLabyrinthe()) {
            j.getJoueur().setPos(j.getCurrentLabyrinthe().getEntree().times(Labyrinthe.TILE_SIZE));
            j.genererEnnemis();
        }
        
    }
}