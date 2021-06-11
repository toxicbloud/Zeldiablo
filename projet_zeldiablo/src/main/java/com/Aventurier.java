package com;

import java.util.ArrayList;

import java.awt.Image;

import moteurJeu.Commande;

/**
 * @author Antonin
 */

public class Aventurier extends Entite{

    private int energie;
    private Arme arme;
    private int timer;


    /**
     * constructeur aventurier
     * @param nom
     * @param v position
     * @param l labyrinthe
     */
    public Aventurier(String nom,Vec2 v,Labyrinthe l){
        super(nom,v,100,l);
        this.energie = 100;
        this.arme=new Couteau(5, 1);
        this.timer = 40;

    }

    /**
     * constructeur aventurier
     * @param nom
     * @param v position
     * @param l labyrinthe
     * @param j jeu
     */
    public Aventurier(String nom,Vec2 v,Labyrinthe l, Jeu j){
        super(nom,v,100,l,j);
        this.energie = 100;
        this.arme=new Couteau(5, 1);
        this.setTexture(Textures.guerrier[1]);
        this.timer = 40;
    }
    /**
     * constructeur aventurier
     * @param nom
     * @param v position
     * @param l labyrinthe
     * @param j jeu
     */
    public Aventurier(String nom,Jeu j){
        super(nom, j);
        this.energie = 100;
        this.arme=new Couteau(5, 1);
        this.setTexture(Textures.guerrier[1]);
    }

    /**
     * equipe une arme à l'aventurier
     * @param a1
     */
    public void equiper_Arme(Arme a1){
        this.arme=a1;
    }

    /**
     * jette l'arme de l'aventurier
     */
    public void jeter_Arme(){
        this.arme = null;
    }
    
    @Override
    public void perdrePV(int perdrePv) {
        if (this.timer < 40) {
            this.timer++;
            return;
        }
        if (this.etreMort() == false) {
            this.setPv(this.getPV()- perdrePv);        
        }
        if (this.getPv() <= 0) {
            this.setMort(true);
            this.setPv(0);
        }
        this.timer = 0;
    }

    /**
     * donne l'arme de l'aventurier
     * @return arme
     */
    public Arme getArme(){
        return this.arme;
    }

    /**
     * donne l'energie
     * @return energie
     */
    public int getEnergie(){
        return this.energie;
    }
    
    @Override
    /**
     * deplace l'aventurier
     * @param c Commande
     */
    public void deplacer(Commande c){
        Vec2 lastPos = new Vec2(this.getPos().x, this.getPos().y);
        super.deplacer(c);
        this.getJeu().getCam().doitReculer(!(lastPos.x == this.getPos().x && lastPos.y == this.getPos().y));

        if (c.espace) {
            int z = this.getRange();
            System.out.println(z);
            this.attaqueZone(z);
        }
        Labyrinthe laby=getLabyrinthe();
        Case proch=laby.getCaseAtVec2(getPos().plus(new Vec2(Labyrinthe.TILE_SIZE/2,Labyrinthe.TILE_SIZE/2)));
        setVitesse(2);
        proch.action(getJeu());
        // System.out.println("ca passe");
        detectEnnemis();
        animer(c);
    }
    /**
     * 
     * @param c Direction
     */
    public void animer(Commande c){
        if(c.gauche){
            setTexture(Textures.guerrier[11]);
        }else if(c.droite){
            setTexture(Textures.guerrier[7]);
        }else if(c.bas){
            setTexture(Textures.guerrier[2]);
        }else if(c.haut){
            setTexture(Textures.guerrier[17]);
        }
    }
    
    /**
     * retourne la range de l'arme
     * @return
     */
    public int getRange() {
        return this.arme.getRange();

    }

    /**
     * méthode qui fait subir des dégats à l'aventurier quand des ennemis sont autour
     */
    public void detectEnnemis() {
        Jeu j = this.getJeu();
        ArrayList<Entite> ar = j.getEnnemis();
        for (Entite entite : ar) {
            int distance = entite.getPos().dist(this.getPos());
            if (distance > Labyrinthe.TILE_SIZE*1.5) continue;
            this.perdrePV(((Monstre)entite).getDegat());
            if (this.etreMort()) j.setFini(true);
        }
    }

    /**
     * attaque dans la zone adéquate
     * @param r range de l'arme
     */
    public void attaqueZone(int r) {
        this.getJeu().getCam().shake();
        Vec2 dir = this.getDerniereDir();
        System.out.println(dir);
        Jeu j = this.getJeu();

        ArrayList<Entite> ar = j.getEnnemis();

        for (Entite entite : ar) {
            int distance = entite.getPos().dist(this.getPos());
            if (distance > this.arme.getRange()) continue;

            boolean valideEast = dir.equals(new Vec2(1,0)) && entite.getPos().x >= this.getPos().x;
            boolean valideWest = dir.equals(new Vec2(-1,0)) && entite.getPos().x <= this.getPos().x;
            boolean valideNorth = dir.equals(new Vec2(0,-1)) && entite.getPos().y <= this.getPos().y;
            boolean valideSouth = dir.equals(new Vec2(0,1)) && entite.getPos().y >= this.getPos().y;


            if (valideEast || valideWest || valideNorth || valideSouth) {
                this.attaquerAutre(entite);
            }
        }
    }

    /**
     * attaque une entité
     * @param e2 entite à attaquer
     */
    @Override
    public void attaquerAutre(Entite e2){
        
            if (e2.etreMort() == false && this.etreMort() == false   ) {
                this.arme.attaquer(e2);
                if(this.arme instanceof Arme_COC){
                    this.energie -= ((Arme_COC)this.arme).getEnergie();
                }
            }
        
    }
    
}
