package com;
/**
 * @author Antonin
 */
public abstract class Entite {
    private String nom;
    private int x;
    private int y;

    /**
     * constructeur d' Entite
     * @param nom nom de l'entite
     */
    public Entite(String nom){
        this.nom=nom;
        this.x=0;
        this.y=0;
    }
    /**
     * 
     * @return nom de l'entite
     */
    public String getNom() {
        return this.nom;
    }
    /**
     * 
     * @param nom nom de l'entite
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * 
     * @return position en X de l'entite
     */
    public int getX() {
        return this.x;
    }
    /**
     * 
     * @param x position en X de l'entite
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * 
     * @return position en Y de l'entite
     */
    public int getY() {
        return this.y;
    }
    /**
     * 
     * @param y position en Y de l'entite
     */
    public void setY(int y) {
        this.y = y;
    }

    

}
