package com;

import java.awt.image.BufferedImage;

public class DessinJeu implements moteurJeu.DessinJeu {
    /** Attribut jeu de DessinJeu, le jeu a dessiner */
    private Jeu jeu;

    DessinJeu(Jeu j) {
        this.jeu = j;
    }

    /** Methode dessiner de DessinJeu pour le moteur de jeu */
    @Override
    public void dessiner(BufferedImage image) {
        
    }
}
