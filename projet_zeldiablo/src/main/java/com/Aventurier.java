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
    }
    /**
     * constructeur aventurier
     * @param nom
     * @param v position
     * @param l labyrinthe
     * @param j jeu
     */
    public Aventurier(String nom,Jeu j){
        super(nom,j.getCurrentLabyrinthe().getEntree(),100,j.getCurrentLabyrinthe(),j);
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
        if(proch instanceof Amulette){
            //temporaire
            System.out.println("Le jeu est fini");
            this.getJeu().setFini(true);
        }else if(proch instanceof Eau){
            setVitesse(1);
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
     * attaque dans la zone adéquate
     * @param r range de l'arme
     */
    public void attaqueZone(int r) {
        Vec2 dir = this.getDerniereDir();
        System.out.println(dir);
        Vec2 max = dir.times(r);

        Jeu j = this.getJeu();

        ArrayList<Entite> ar = j.getEnnemis();

        for (Entite entite : ar) {
            if (dir.equals(new Vec2(1,0))) {
                if(entite.getPos().x <= max.x + this.getPos().x && entite.getPos().x >= this.getPos().x){
                    if (entite.getPos().y <= this.getPos().y + 10 && entite.getPos().y >= this.getPos().y - 10) {
                        this.attaquerAutre(entite);
                    }
                }
            }
            else if(dir.equals(new Vec2(0,1))){
                System.out.println(entite.getPos().y + " plus petit que " + (max.y + this.getPos().y));
                System.out.println(entite.getPos().y + " plus grand que " + this.getPos().y);
                System.out.println(entite.getPos().x + " plus petit que " + (this.getPos().x + 10));
                System.out.println(entite.getPos().x + " plus grand que " + (this.getPos().x - 10));

                if(entite.getPos().y <= max.y + this.getPos().y && entite.getPos().y >= this.getPos().y){
                    if (entite.getPos().x <= this.getPos().x + 10 && entite.getPos().x >= this.getPos().x - 10) {
                        this.attaquerAutre(entite);
                    }
                }
            }
            else if(dir.equals(new Vec2(-1,0))){
                if(entite.getPos().x >= max.x + this.getPos().x && entite.getPos().x <= this.getPos().x){
                    if (entite.getPos().y <= this.getPos().y + 10 && entite.getPos().y >= this.getPos().y - 10) {
                        this.attaquerAutre(entite);
                    }
                }
            }
            else if(dir.equals(new Vec2(0,-1))){
                if(entite.getPos().y >= max.y + this.getPos().y && entite.getPos().y <= this.getPos().y){
                    if (entite.getPos().x <= this.getPos().x + 10 && entite.getPos().x >= this.getPos().x - 10) {
                        this.attaquerAutre(entite);
                    }
                }
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
