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
        this.entree = new Vec2(10, 10);
        this.generateLab();
    }

    public void generateLab() {

        // Liste ou sont stockes des deplacements
        ArrayList<Vec2> deplacement = new ArrayList<Vec2>();
        Vec2 placeFin = new Vec2();
        int placeDistance = 0;
        deplacement.add(entree);
        while (deplacement.size() > 0) {
            Vec2 direction = randomDirection(entree);
            if (!direction.isZero()) { // continue le chemin
                for (int nbDeplacements = (int)(Math.random() * 3) + 2; nbDeplacements > 0; nbDeplacements--) {
                    Vec2 position = lastElement(deplacement);

                    Vec2 target = position.plus(direction).plus(direction);
                    boolean outOfBounds = (target.x < 0 || target.y < 0 || target.x >= this.size || target.y >= this.size);
                    if ( outOfBounds || cases[target.x][target.y].isTraversable() ) break;
                    cases[position.x][position.y] = (Math.random() > 0.5)? new Chemin(): new Eau();
                    Vec2 newPos = position.plus(direction);
                    deplacement.add(newPos);
                }
            } else { // bloqué, donc retourne en arriere
                if (placeDistance < deplacement.size()) {
                    placeFin = lastElement(deplacement);
                    placeDistance = deplacement.size();
                }
                deplacement.remove(deplacement.size()-1);
            }
        }

        cases[placeFin.x][placeFin.y] = new Amulette();
    }

    /**
     * Renvoie la position actuelle dans la liste de deplacements (dernier index)
     * @param ar liste de deplacements
     * @return position actuelle sur la carte
     */
    public Vec2 lastElement(ArrayList<Vec2> ar) {
        return ar.get(ar.size()-1);
    }

    /**
     * Choisi une direction valide en fonction de la position dans la carte, renvoie un Vec2(0, 0) si aucune direction n'est possible
     * @param pos position sur la carte
     * @return vecteur de deplacement
     */
    public Vec2 randomDirection(Vec2 pos) {
        boolean[] faits = {false, false, false, false};
        boolean valide = false;
        Vec2 direction = new Vec2(0, 0);
        while (!(faits[0]||faits[1]||faits[2]||faits[3]) && !valide) {
            int nb = (int) (Math.random() * 4);
            switch (nb) {
                case 0:
                    direction = new Vec2(1, 0);
                    faits[0] = true;
                    valide = true;
                    break;
                case 1:
                    direction = new Vec2(0, 1);
                    faits[1] = true;
                    valide = true;
                    break;
                case 2:
                    direction = new Vec2(-1, 0);
                    faits[2] = true;
                    valide = true;
                    break;
                case 3:
                    direction = new Vec2(0, -1);
                    faits[3] = true;
                    valide = true;
                    break;
            }
            Vec2 target = pos.plus(direction).plus(direction);
            boolean outOfBounds = (target.x < 0 || target.y < 0 || target.x >= this.size || target.y >= this.size);
            if (outOfBounds || cases[target.x][target.y].isTraversable()) {
                valide = false;
                direction = new Vec2(0, 0);
            }
        }

        return direction;
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