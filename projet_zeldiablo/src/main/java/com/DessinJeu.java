package com;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class DessinJeu implements moteurJeu.DessinJeu {

    /** Taille graphique d'une case */
    public static int TILE_SIZE = 80;

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
        Graphics2D g = (Graphics2D) image.getGraphics();
        int w = image.getWidth();
        int h = image.getHeight();
        Case[][] cases = jeu.getCarte().getCases();
        for (int x = 0; x < cases.length; x++) {
            for (int y = 0; y < cases[x].length; y++) {
                int posX = (x*TILE_SIZE-(jeu.getCam().getPos().x*TILE_SIZE/Labyrinthe.TILE_SIZE)) + w/2 - TILE_SIZE/2;
                int posY = (y*TILE_SIZE-(jeu.getCam().getPos().y*TILE_SIZE/Labyrinthe.TILE_SIZE)) + h/2 - TILE_SIZE/2;
                g.drawImage(cases[x][y].getSprite(), posX, posY, TILE_SIZE, TILE_SIZE, null);
            }
        }
        g.setColor(Color.BLUE);
        int posX = (jeu.getJoueur().getPos().x-jeu.getCam().getPos().x)*TILE_SIZE + w/2 - TILE_SIZE/2;
        int posY = (jeu.getJoueur().getPos().y-jeu.getCam().getPos().y)*TILE_SIZE + h/2 - TILE_SIZE/2;
        //g.fillOval(posX, posY, TILE_SIZE, TILE_SIZE);
        g.drawImage(Textures.tex_perso, posX, posY, (int) (TILE_SIZE*0.8), TILE_SIZE, null);
        // TILE_SIZE++;

        for(Entite e: jeu.getEnnemis()) {
            g.setColor(Color.RED);
            posX = (e.getPos().x-(jeu.getCam().getPos().x*TILE_SIZE/Labyrinthe.TILE_SIZE)) + w/2 - TILE_SIZE/2;
            posY = (e.getPos().y-(jeu.getCam().getPos().y*TILE_SIZE/Labyrinthe.TILE_SIZE)) + h/2 - TILE_SIZE/2;
            g.fillOval(posX, posY, TILE_SIZE, TILE_SIZE);
        }
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
