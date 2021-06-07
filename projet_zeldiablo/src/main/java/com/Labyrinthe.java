package com;

/**
 * Labyrinthe
 */
public class Labyrinthe {

    /**
     * ATTRIBUTS
     */



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
    private Case entree;

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
                this.cases[i][j] = new Chemin();
            }
        }
        this.entree = this.cases[this.size/2][this.size-1];
    }

    /**
     * getter size
     * @return size du tableau
     */
    public int getSize() {
        return size;
    }

    /**
     * setter size
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
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
    public Case getEntree() {
        return entree;
    }

    /**
     * setter case entrée
     * @param entree
     */
    public void setEntree(Case entree) {
        this.entree = entree;
    }
}