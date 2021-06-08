package com;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.*;

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
        g.setColor(Color.black);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
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
        /**
         * Affichage du joueur
         */
        g.drawImage(Textures.tex_perso, posX, posY, (int) (TILE_SIZE*0.8), TILE_SIZE, null);
        // TILE_SIZE++;

        for(Entite e: jeu.getEnnemis()) {
            posX = (e.getPos().x-(jeu.getCam().getPos().x*TILE_SIZE/Labyrinthe.TILE_SIZE)) + w/2 - TILE_SIZE/2;
            posY = (e.getPos().y-(jeu.getCam().getPos().y*TILE_SIZE/Labyrinthe.TILE_SIZE)) + h/2 - TILE_SIZE/2;
            /** Barre de vie  */
            int pv=e.getPV();
            if(pv>=10){ g.setColor(Color.green);}
            if(pv<=6){g.setColor(Color.orange);}
            g.fillRect(posX, posY-10, e.getPV()*4, 5);
            g.setColor(Color.black);
            g.setStroke(new BasicStroke((float) 1.5));
            g.drawRect(posX-1, posY-11, 50, 6);;
            g.setColor(Color.red);
            /** Dessin du monstre */
            g.fillOval(posX, posY, TILE_SIZE, TILE_SIZE);
        }
        /** Affichage ATH */
        BufferedImage ath = new BufferedImage(image.getWidth(),100,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) ath.getGraphics();
        /** Affichage PV */
        g2.setColor(Color.red);
        g2.fillArc(30, 2, 80, 80, 0, 360);
        int[] pixels = new int[ath.getWidth()*ath.getHeight()];
        Arrays.fill(pixels, 0); 
        ath.setRGB(0, 0, ath.getWidth(), ath.getHeight()-jeu.getJoueur().getPV(), pixels, 0, ath.getWidth());
        g2.drawImage(Textures.tex_uhd,0,0, Textures.tex_uhd.getWidth(null),Textures.tex_uhd.getHeight(null),null);
        /** Affichage energie */
        g2.setColor(Color.orange);
        g2.fillRect(120, 50, jeu.getJoueur().getEnergie(), 10);
        g.drawImage(ath, 0, image.getHeight()-90, ath.getWidth(), ath.getHeight(),null);
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
