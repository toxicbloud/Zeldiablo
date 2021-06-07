package com;

import moteurJeu.Commande;

/**
 * @author Antonin
 */
public abstract class Entite{

    private String nom;
    private Vec2 pos;
    // new Attributs point de vie (PV)
    private int pv;
    private boolean mort;
    private Labyrinthe laby;

    /**
     * constructeur d' Entite
     * @param nom nom de l'entite
     * @param pointVie point de Vie de l'entité
     * @param newPos position
     * @param pointVie point ed vie
     * @param l Labyrinthe de l Entite
     */
    public Entite(String nom,Vec2 newPos, int pointVie,Labyrinthe l){
        this.nom=nom;
        this.pos = newPos;
        this.pv=pointVie;
        this.mort = false;
        this.laby=l;
    }
    /**
     * 
     * @return Vec2 Position Entite
     */
    public Vec2 getPos() {
        return pos;
    }
    /**
     * 
     * @param pos position de l entite
     */
    public void setPos(Vec2 pos) {
        this.pos = pos;
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
     * get Point de Vie de l'entité
     * @return point de vie de l'entité
     */
    public int getPV(){
        return this.pv;
    }
    /**
     * set Point de vie de l'entité
     * @param newPV : new Point de vie de l'entité
     */
    public void setPV(int newPV){
        this.pv=newPV;
    }
    /**
     * 
     * @return boolen a true si il est mort
     */
    public boolean etreMort(){
        return this.mort;
    }
    /**
     * 
     * @param gagnePv pv a ajouter
     */
    public void gagnerPV(int gagnePv){
        if (this.etreMort() == false){
            this.pv += gagnePv;
        }
    }
    /**
     * 
     * @param perdrePv pv a enlever
     */
    public void perdrePV(int perdrePv){
        if (this.etreMort() == false) {
            this.pv -= perdrePv;        
        }
        if (this.pv <= 0) {
            this.mort = true;
        }
    }
    /**
     * 
     * @param e2 entite a attaquer
     * @param pointAtt point a attaquer
     */
    public void attaquerAutre(Entite e2, int pointAtt){
        if (e2.etreMort() == false) {
            e2.perdrePV(pointAtt);   
        }
    }
    /**
     * 
     * @param e2 entite a soigner
     * @param pointSoigner point a ajouter
     */
    public void soigner(Entite e2, int pointSoigner){
        if (e2.etreMort() == false) {
            e2.gagnerPV(pointSoigner);   
        }
    }
    /**
     * getter de l'attribut Labyrinthe
     * @return Labyrinthe
     */
    public Labyrinthe getLabyrinthe(){
        return this.laby;
    }
    /**
     * deplace l'entite en prenant en compte les collisions
     * @param c commande direction a aller
     */
    public void deplacer(Commande c){
        Case cs;
        if(c.gauche){
            cs=laby.getCaseAtVec2(this.pos.plus(new Vec2(-1,0)));
            if(cs!=null && cs.isTraversable()){
                this.pos.x--;
            }
        }else if(c.droite){
            cs=laby.getCaseAtVec2(this.pos.plus(new Vec2(1,0)));
            if(cs!=null && cs.isTraversable()){
                this.pos.x++;
            }
        }else if(c.haut){
            cs=laby.getCaseAtVec2(this.pos.plus(new Vec2(0,-1)));
            if(cs!=null && cs.isTraversable()){
                this.pos.y--;
            }
        }else if(c.bas){
            cs=laby.getCaseAtVec2(this.pos.plus(new Vec2(0,1)));
            if(cs!=null && cs.isTraversable()){
                this.pos.y++;
            }
        }
    }
}