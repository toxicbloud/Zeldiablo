package com;

import moteurJeu.Commande;

/**
 * @author Antonin
 */
public abstract class Entite{

    private String nom;
    private Vec2 pos;
    // new Attributs point de vie (PV)
    private Vec2 taille=new Vec2(Labyrinthe.TILE_SIZE, Labyrinthe.TILE_SIZE);
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
        if (pointVie<=0) {
            this.pv=0;
            this.mort=true;
        }
        else{
            this.pv=pointVie;
            this.mort = false;
        }
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
        if (pv <= 0) {
            mort =true;
            this.pv=0;
        }
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
        if (e2.etreMort() == false && this.etreMort() == false && pointAtt >0 ) {
            e2.perdrePV(pointAtt);   
        }
    }
    /**
     * 
     * @param e2 entite a soigner
     * @param pointSoigner point a ajouter
     */
    public void soigner(Entite e2, int pointSoigner){
        if (e2.etreMort() == false&& this.etreMort() == false && pointSoigner >0    ) {
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
     * getter de l'attribut taille
     * @return taille de l entite
     */
    public Vec2 getTaille(){
        return this.taille;
    }
    /**
     * setter de l'attribut taille
     * @param v taille Vec2
     */
    public void setTaille(Vec2 v){
        this.pos=v;
    }
    /**
     * deplace l'entite en prenant en compte les collisions
     * @param c commande direction a aller
     */
    public void deplacer(Commande c){
        Case cs;
        Case ul=laby.getCaseAtVec2(this.pos.plus(new Vec2((int)(taille.x*0.2),0)));
        Case ur=laby.getCaseAtVec2(this.pos.plus(new Vec2((int)(taille.x*0.8),0)));
        Case lu=laby.getCaseAtVec2(this.pos.plus(new Vec2(0,(int)(taille.y*0.2))));
        Case ld=laby.getCaseAtVec2(this.pos.plus(new Vec2(0,(int)(taille.y*0.8))));
        Case dl=laby.getCaseAtVec2(this.pos.plus(new Vec2((int)(taille.x*0.2),taille.y)));
        Case dr=laby.getCaseAtVec2(this.pos.plus(new Vec2((int)(taille.x*0.8),taille.y)));
        Case ru=laby.getCaseAtVec2(this.pos.plus(new Vec2(taille.x,(int)(taille.y*0.2))));
        Case rd=laby.getCaseAtVec2(this.pos.plus(new Vec2(taille.x,(int)(taille.y*0.8))));
        if(c.gauche){
            // cs=laby.getCaseAtVec2(this.pos.plus(new Vec2(-1,0)));
            if(lu!=null && ld!=null && lu.isTraversable() && ld.isTraversable()){
                this.pos.x--;
            }
        }else if(c.droite){
            // cs=laby.getCaseAtVec2(this.pos.plus(new Vec2(1,0)));
            if(ru!=null && rd!=null && ru.isTraversable() && rd.isTraversable()){
                this.pos.x++;
            }
        }else if(c.haut){
            // cs=laby.getCaseAtVec2(this.pos.plus(new Vec2(0,-1)));
            if(ul!=null && ur!=null && ul.isTraversable()&& ur.isTraversable()){
                this.pos.y--;
            }
        }else if(c.bas){
            // cs=laby.getCaseAtVec2(this.pos.plus(new Vec2(0,1)));
            if(dl!=null && dr!=null && dl.isTraversable() &&  dr.isTraversable()){
                this.pos.y++;
            }
        }
    }
}