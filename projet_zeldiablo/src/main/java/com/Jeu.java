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

    private boolean enJeu;
    private boolean ecranFin;
    /** La fenetre devrais se fermer */
    private boolean quit;

    /** 
     * Constructeur vide de Jeu 
     * @param n nom de l aventurier
     */
    public Jeu(String n) {
        Textures.chargerTextures();
        this.currentLabyrinthe = 0;
        labyrinthes = new Labyrinthe[3];
        for (int i = 0; i < labyrinthes.length; i++)
            labyrinthes[i] = new Labyrinthe(i == labyrinthes.length-1);
        
        this.ennemis = new ArrayList<Entite>();
        this.ennemis.add(new Gobelin(1, this.getCurrentLabyrinthe().getEntree().times(Labyrinthe.TILE_SIZE), getCurrentLabyrinthe(), this));
        this.joueur = new Aventurier(n, this);
        this.genererEnnemis();
        this.cam = new Camera(this.joueur);
        enJeu = false;
        ecranFin = false;
        quit = false;
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
        this.joueur = new Aventurier("testeur", this.getCurrentLabyrinthe().getEntree().times(Labyrinthe.TILE_SIZE), this.getCurrentLabyrinthe(), this);
        this.cam = new Camera(this.joueur);
        this.ennemis.add(new Gobelin(5, this.getCarte().getEntree(), this.getCarte(), this));
    }

    public Labyrinthe getCurrentLabyrinthe() {
        return this.labyrinthes[this.currentLabyrinthe];
    }

    public boolean nextLabyrinthe() {
        if (this.currentLabyrinthe > this.labyrinthes.length-1)
            return false;
        this.currentLabyrinthe++;
        return true;
    }

    public boolean prevLabyrinthe() {
        if (this.currentLabyrinthe < 1)
            return false;
        this.currentLabyrinthe--;
        return true;
    }

    public void genererEnnemis() {
        this.ennemis.clear();
        Case[][] cases = getCurrentLabyrinthe().getCases();
        for (int x = 0; x < cases.length; x++) {
            for (int y = 0; y < cases[x].length; y++) {
                if (cases[x][y].isTraversable() && Math.random() > 0.93) {
                    this.ennemis.add(new Gobelin(5, new Vec2(x, y).times(Labyrinthe.TILE_SIZE), this.getCurrentLabyrinthe(), this));
                }
            }
        }
    }

    /** Methode evoluer utilisee par le moteur de jeu */
    @Override
    public void evoluer(Commande commandeUser) {
        // lance le jeu
        if (!enJeu) {
            if (!ecranFin) {
                enJeu = commandeUser.espace;
            } else {
                
            }
        } else {
            this.joueur.deplacer(commandeUser);
            cam.deplacer(this.joueur);
            for(Entite e: this.ennemis) {
                Monstre m = ((Monstre)e);
                // m.deplacer(new Commande());
                if (m.etreMort()) {
                    this.ennemis.remove(m);
                    break;
                }
            }
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
        return this.getCurrentLabyrinthe();
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
        this.enJeu = false;
        this.ecranFin = true;
        evoluer(null);
    }

    /**
     * Getter de l'attribut enJeu de Jeu
     * @return la valeur de l'attribut
     */
    public boolean isEnJeu() {
        return enJeu;
    }

    /**
     * Getter de l'attribut ecranFin de Jeu
     * @return la valeur de l'attribut
     */
    public boolean isEcranFin() {
        return ecranFin;
    }

    /**
     * setter de enJeu
     * @param enJeu valeur
     */
    public void setEnJeu(boolean enJeu) {
        if (enJeu) {
            labyrinthes = new Labyrinthe[3];
            for (int i = 0; i < labyrinthes.length; i++)
                labyrinthes[i] = new Labyrinthe(i == labyrinthes.length-1);
            this.joueur = new Aventurier("Aventurier", this);
            genererEnnemis();
        }
        this.enJeu = enJeu;
    }

    /** Quitte le jeu */
    public void quit() {
        this.quit = true;
    }

    /** Getter de quit */
    public boolean shouldQuit() {
        return this.quit;
    }

    /**
     * Setter de EcranFin
     * @param ecranFin valeur
     */
    public void setEcranFin(boolean ecranFin) {
        this.ecranFin = ecranFin;
    }
    
    @Override
    public String toString() {
        return "Jeu [carte=" + getCurrentLabyrinthe() + ", joueur=" + joueur + "]";
    }
}