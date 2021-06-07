package com;

import java.util.ArrayList;

import moteurJeu.Commande;

/**
 * Classe Jeu, qui va généré un labyrinthe et un joueur
 * @author Celian
 */
public class Jeu implements moteurJeu.Jeu {

    private Labyrinthe carte;
    private Aventurier joueur;
    private Camera cam;
    private ArrayList<Entite> ennemis;

    /** 
     * Constructeur vide de Jeu 
     * @param n nom de l aventurier
     */
    public Jeu(String n) {
        this.carte = new Labyrinthe();
        this.joueur = new Aventurier(n, new Vec2(), 10, this.carte);
        this.cam = new Camera(this.joueur);
        this.ennemis.add(new Gobelin(5, 20, new Vec2(2, 2), this.carte));
    }

    /** Methode evoluer utilisee par le moteur de jeu */
    @Override
    public void evoluer(Commande commandeUser) {
        this.joueur.deplacer(commandeUser);
        cam.deplacer(this.joueur);
    }

    /** Methode etreFini utilisee par le moteur de jeu */
    @Override
    public boolean etreFini() {
        return false;
    }

    /** 
     * Methode getCarte qui return la carte du jeu
     */
    public Labyrinthe getCarte() {
        return this.carte;
    }

    /** 
     * Methode getJoueur qui return le joueur
     */
    public Aventurier getJoueur() {
        return this.joueur;
    }

    /** 
     * Getter de l'attribut cam de Jeu
     * @return valeur de l'attribut cam
     */
    public Camera getCam() {
        return cam;
    }
    
    @Override
    public String toString() {
        return "Jeu [carte=" + carte + ", joueur=" + joueur + "]";
    }
}