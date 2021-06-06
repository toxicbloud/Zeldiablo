package com;
/**
 * Classe Jeu, qui va généré un labyrinthe et un joueur
 * @author Celian
 */
public class Jeu {

    private Labyrinthe carte;
    private Aventurier joueur;

    /** 
     * Constructeur vide de Jeu 
     * @param n nom de l aventurier
     */
    public Jeu(String n) {
        this.carte = new Labyrinthe();
        this.joueur = new Aventurier(n);
    }

    /** 
     * Methode getCarte qui return la carte du jeu
     */
    public Labyrinthe getCarte() {
        return this.carte;
    }

    /** 
     * Methode getAventurier qui return le joueur
     */
    public Aventurier getAventurier() {
        return this.joueur;
    }
    
}