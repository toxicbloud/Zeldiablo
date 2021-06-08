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
    private boolean fini = false;

    /** 
     * Constructeur vide de Jeu 
     * @param n nom de l aventurier
     */
    public Jeu(String n) {
        Textures.chargerTextures();
        this.ennemis = new ArrayList<Entite>();
        this.carte = new Labyrinthe();
        this.joueur = new Aventurier(n, this.carte.getEntree().times(new Vec2(Labyrinthe.TILE_SIZE, Labyrinthe.TILE_SIZE)), this.carte);
        this.cam = new Camera(this.joueur);
        this.ennemis.add(new Gobelin(5, new Vec2(2, 2), this.carte));
    }

    /** Methode evoluer utilisee par le moteur de jeu */
    @Override
    public void evoluer(Commande commandeUser) {
        this.joueur.deplacer(commandeUser);
        cam.deplacer(this.joueur);
        for(Entite e: this.ennemis) {
            ((Monstre)e).deplacer();
        }
    }

    /** Methode etreFini utilisee par le moteur de jeu */
    @Override
    public boolean etreFini() {
        return this.fini;
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

    /**
     * Getter de l'attribut ennemis de Jeu
     * @return valeur de l'attribut ennemis
     */
    public ArrayList<Entite> getEnnemis() {
        return ennemis;
    }

    /**
     * Getter de l'attribut fini
     * @param fini nouvelle valeur de fini
     */
    public void setFini(boolean fini) {
        this.fini = fini;
    }
    
    @Override
    public String toString() {
        return "Jeu [carte=" + carte + ", joueur=" + joueur + "]";
    }
}