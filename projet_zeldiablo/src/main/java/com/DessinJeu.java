package com;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;

public class DessinJeu implements moteurJeu.DessinJeu {

    /** Taille graphique d'une case */
    public static final int TILE_SIZE = 50;

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
        Graphics g = image.getGraphics();
        Case[][] cases = jeu.getCarte().getCases();
        for (int x = 0; x < cases.length; x++) {
            for (int y = 0; y < cases[x].length; y++) {
                g.setColor(cases[x][y].getSprite());
                g.fillRect(x*TILE_SIZE-jeu.getCam().getPos().x, y*TILE_SIZE-jeu.getCam().getPos().y, TILE_SIZE, TILE_SIZE);
            }
        }
        g.setColor(Color.BLUE);
        g.fillOval((jeu.getJoueur().getPos().x-jeu.getCam().getPos().x)*TILE_SIZE/Labyrinthe.TILE_SIZE, (jeu.getJoueur().getPos().y-jeu.getCam().getPos().y)*TILE_SIZE/Labyrinthe.TILE_SIZE, TILE_SIZE, TILE_SIZE);
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
