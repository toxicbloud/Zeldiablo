package com;

import java.util.ArrayList;
import moteurJeu.Commande;

/**
 * Classe Jeu, qui va généré un labyrinthe et un joueur
 * @author Celian
 */
public class Jeu implements moteurJeu.Jeu {

    private Labyrinthe[] labyrinthes;
    private int currentLabyrinthe;
    private Aventurier joueur;
    private Camera cam;
    private ArrayList<Entite> ennemis;
    private boolean fini = false;

    /** 
     * Constructeur vide de Jeu 
     * @param n nom de l aventurier
     */
    public Jeu(String n) {
        this.currentLabyrinthe = 0;
        labyrinthes = new Labyrinthe[3];
        for (int i = 0; i < labyrinthes.length; i++)
            labyrinthes[i] = new Labyrinthe();
        
        Textures.chargerTextures();
        this.ennemis = new ArrayList<Entite>();
        this.joueur = new Aventurier(n, this);
        this.cam = new Camera(this.joueur);
    }

    /** 
     * Constructeur vide de Jeu pour les tests
     */
    public Jeu() {
        labyrinthes = new Labyrinthe[1];
        for (int i = 0; i < labyrinthes.length; i++)
            labyrinthes[i] = new Labyrinthe();
        Textures.chargerTextures();
        this.ennemis = new ArrayList<Entite>();
        this.joueur = new Aventurier("testeur", this.carte.getEntree().times(Labyrinthe.TILE_SIZE), this.carte, this);
        this.cam = new Camera(this.joueur);
        this.ennemis.add(new Gobelin(5, carte.getEntree().times(Labyrinthe.TILE_SIZE), this.carte));
        this.ennemis.add(new Gobelin(5, new Vec2(2, 2), this.carte));
    }

    public Labyrinthe getCurrentLabyrinthe() {
        return this.labyrinthes[this.currentLabyrinthe];
    }

    public boolean nextLabyrinthe() {
        return true;
    }

    public boolean prevLabyrinthe() {
        return true;
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