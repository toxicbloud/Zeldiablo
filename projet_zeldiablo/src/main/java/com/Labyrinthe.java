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
        this.cases[0][0] = new Chemin();
        this.cases[1][0] = new Chemin();
        this.cases[0][1] = new Chemin();
        this.cases[1][1] = new Chemin();
        //this.generateLab();
    }


    public void generateLab() {

        ArrayList<Vec2> deplacement = new ArrayList<Vec2>();
        deplacement.add(entree);
        while (deplacement.size() > 0) {
            Vec2 direction = randomDirection();
            for (int nbDeplacements = (int)(Math.random() * 3) + 1; nbDeplacements > 0; nbDeplacements--) {
                Vec2 position = lastElement(deplacement);

                Vec2 target = position.plus(direction).plus(direction);
                if ( cases[target.x][target.y].isTraversable() ) break;
                target = position.plus(direction);
                if ( cases[target.x][target.y].isTraversable() ) break;

                cases[position.x][position.y] = new Chemin();
                deplacement.add(entree.plus(direction));
            }
        }
    }

<<<<<<< HEAD
        
        

=======
    public Vec2 lastElement(ArrayList<Vec2> ar) {
        return ar.get(ar.size()-1);
    }

    public Vec2 randomDirection() {
        int nb = (int) Math.random() * 4;
        switch (nb) {
            case 0:
                return new Vec2(1, 0);
            case 1:
                return new Vec2(0, 1);
            case 2:
                return new Vec2(-1, 0);
            case 3:
                return new Vec2(0, -1);
        }
        return new Vec2(0, 0);
>>>>>>> eaf5083e78f2ed9b11ffcfd2775bd0a8875f07e6
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