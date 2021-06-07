package com;

import java.awt.image.BufferedImage;

public class DessinJeu implements moteurJeu.DessinJeu {
    /** Attribut jeu de DessinJeu, le jeu a dessiner */
    private Jeu jeu;

    /** Constructeur vide de DessinJeu */
    DessinJeu() {
        this.jeu = new Jeu("Jeu");
    }

    
    /** Constructeur complet de DessinJeu */
    DessinJeu(Jeu j) {
        this.jeu = j;
    }

    /** Methode dessiner de DessinJeu pour le moteur de jeu */
    @Override
    public void dessiner(BufferedImage image) {
        jeu.getCarte().dessiner(image);
        jeu.getJoueur().dessiner(image);
    }

    /**
     * Getter de l'attribut Jeu de DessinJeu
     * @return la valeur de l'attribut jeu
     */
    public Jeu getJeu() {
        return jeu;
    }

    /**
     * Setter de l'attribut Jeu de DessinJeu
     * @param j la nouvelle valeur de l'attribut
     */
    public void setJeu(Jeu j) {
        this.jeu = j;
    }
}
