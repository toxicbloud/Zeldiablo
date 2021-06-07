package com;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

/**
 * Labyrinthe
 */
public class Labyrinthe implements moteurJeu.DessinJeu {

    /**
     * ATTRIBUTS
     */
    public static final int TILE_SIZE = 30;

    /**
     * taille du tableau
     */
    private int size;

    /**
     * tableau de cases
     */
    private Case[][] cases;

    /**
     * entrée du labyrinthe
     */
    private Vec2 entree;

    /**
     * Constructeur de Labyrinthe
     */
    public Labyrinthe() {

        this.size = 10;
        this.createLab();
    }

    /**
     * Constructeur de Labyrinthe
     * @param s
     */
    public Labyrinthe(int s) {
        if (s > 5) {
            this.size = s;
        }
        else this.size = 5;

        this.createLab();
    }

    /**
     * Initialise le tableau de cases et l'entrée
     */
    private void createLab() {
        this.cases = new Case[this.size][this.size];
        for (int i = 0; i < cases.length; i++) {
            for (int j = 0; j < cases[i].length; j++) {
                // double r = Math.random();
                // if (r <0.5) {
                //     this.cases[i][j] = new Chemin();

                // }
                // else this.cases[i][j] = new Mur();
                this.cases[i][j] = new Chemin();

            }
        }
        this.entree = new Vec2(this.size/2, this.size/2);
    }

    
    @Override
    public void dessiner(BufferedImage image) {
        Graphics g = image.getGraphics();
        for (int x = 0; x < cases.length; x++) {
            for (int y = 0; y < cases[x].length; y++) {
                g.setColor(cases[x][y].getSprite());
                g.fillRect(x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    /**
     * Renvoie la case a la position donnee
     * @param pos position dans la carte
     * @return la case a la position donnee
     */
    public Case getCaseAtVec2(Vec2 pos) {
        return null;
    }

    /**
     * getter size
     * @return size du tableau
     */
    public int getSize() {
        return size;
    }

    /**
     * getter tableau de cases
     * @return tableau de cases
     */
    public Case[][] getCases() {
        return cases;
    }

    /**
     * setter cases
     * @param cases
     */
    public void setCases(Case[][] cases) {
        this.cases = cases;
    }

    /**
     * getter case entrée
     * @return entree
     */
    public Vec2 getEntree() {
        return entree;
    }

    /**
     * setter case entrée
     * @param entree
     */
    public void setEntree(Vec2 entree) {
        this.entree = entree;
    }
}