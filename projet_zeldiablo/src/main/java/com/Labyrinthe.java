package com;

import java.util.ArrayList;

/**
 * Labyrinthe
 */
public class Labyrinthe {

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

        this.size = 20;
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
        else this.size = 20;

        this.createLab();
    }

    /**
     * Initialise le tableau de cases et l'entrée
     */
    private void createLab() {
        this.cases = new Case[this.size][this.size];
        for (int i = 0; i < this.cases.length; i++) {
            for (int j = 0; j < this.cases[i].length; j++) {
                this.cases[i][j] = new Mur();
            }
        }
        this.entree = new Vec2(this.size/2, this.size/2);
        this.generateLab();
    }


    public void generateLab() {

        // Liste où sont stockées des déplacements
        ArrayList<Vec2> deplacement = new ArrayList<Vec2>();


        

    }


    /**
     * Renvoie la case a la position donnee
     * @param pos position dans la carte
     * @return la case a la position donnee
     */
    public Case getCaseAtVec2(Vec2 pos) {
        if (pos.x > this.size*TILE_SIZE || pos.x < 0 || pos.y > this.size*TILE_SIZE || pos.y < 0) return null;
        int iX = pos.x / TILE_SIZE;
        int iY = pos.y / TILE_SIZE;
        return cases[iX][iY];
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