package com;

import moteurJeu.Commande;
import java.awt.Image;

/**
 * @author Antonin
 */
public abstract class Entite{

    private String nom;
    private Vec2 pos;
    private Jeu jeu;
    private Vec2 taille=new Vec2(Labyrinthe.TILE_SIZE, Labyrinthe.TILE_SIZE);
    private int pv,maxPV;
    private boolean mort;
    private Vec2 derniereDir;
    private int vitesse=2;
    private Image texture=Textures.noTexture;
    private Commande dernier;
    private int timer;


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
            this.maxPV=0;
            this.mort=true;
        }
        else{
            this.pv=pointVie;
            this.maxPV=pv;
            this.mort = false;
        }
        this.derniereDir = new Vec2(0,1);
        this.timer = 40;

    }


    public Entite(String nom,Vec2 newPos, int pointVie,Labyrinthe l, Jeu j){
        this.nom=nom;
        this.pos = newPos;
        if (pointVie<=0) {
            this.pv=0;
            this.maxPV=0;
            this.mort=true;
        }
        else{
            this.pv=pointVie;
            this.maxPV=pv;
            this.mort = false;
        }
        this.derniereDir = new Vec2(0,1);
        this.jeu = j;
        this.timer = 40;

    }
    /**
     * 
     * @param nom nom de l'entite
     * @param newPos position de l'entite
     * @param pointVie point de vie de l'entite
     * @param l labyrinthe de l'entite
     * @param t taille de l'entite
     */
    public Entite(String nom,Vec2 newPos, int pointVie,Labyrinthe l,Vec2 t){
        this.nom=nom;
        this.pos = newPos;
        if (pointVie<=0) {
            this.pv=0;
            this.maxPV=0;
            this.mort=true;
        }
        else{
            this.pv=pointVie;
            this.maxPV=pv;
            this.mort = false;
        }
        this.taille=t;
        this.timer = 40;

    }
    
    /**
     * 
     * @param nom nom de l'entite
     * @param newPos position de l'entite
     * @param pointVie point de vie de l'entite
     * @param l labyrinthe de l'entite
     * @param t taille de l'entite
     */
    public Entite(String nom,Jeu j){
        this.nom=nom;
        this.jeu = j;
        this.pos = j.getCurrentLabyrinthe().getEntree().times(Labyrinthe.TILE_SIZE);
        this.pv = 100;
        this.maxPV=pv;
        this.taille = new Vec2(Labyrinthe.TILE_SIZE, Labyrinthe.TILE_SIZE);
        this.mort = false;
        this.derniereDir = new Vec2(0,1);
        this.timer = 40;

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
     * @param t Image de Texture
     */
    public void setTexture(Image t){
        this.texture=t;
    }
    /**
     * 
     * @return Texture
     */
    public Image getTexture(){
        return this.texture;
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
            this.pv=0;
        }
    }
    /**
     * 
     * @param e2 entite a attaquer
     */
    public abstract void attaquerAutre(Entite e2);
    
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
        return this.jeu.getCurrentLabyrinthe();
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
     * 
     * @param c Sens du personnage
     */
    public void setDernier(Commande c){
        this.dernier=c;
    }
    /**
     * 
     * @return sens du personnage
     */
    public Commande getDernier(){
        return this.dernier;
    }
    /**
     * 
     * @param v vitesse de l'entite
     */
    public void setVitesse(int v){
        this.vitesse=v;
    }
    /**
     * 
     * @return vitesse de l'entite
     */
    public int getVitesse(){
        return this.vitesse;
    }
    /***
     * 
     * @return pv max de l' entite
     */
    public int getMaxPV(){
        return this.maxPV;
    }
    /**
     * deplace l'entite en prenant en compte les collisions
     * @param c commande direction a aller
     */
    public void deplacer(Commande c){
        this.dernier=c;
        Labyrinthe laby = this.jeu.getCurrentLabyrinthe();
        Case ul=laby.getCaseAtVec2(this.pos.plus(new Vec2((int)(taille.x*0.2),0)));
        Case ur=laby.getCaseAtVec2(this.pos.plus(new Vec2((int)(taille.x*0.8),0)));
        Case lu=laby.getCaseAtVec2(this.pos.plus(new Vec2(0,(int)(taille.y*0.2))));
        Case ld=laby.getCaseAtVec2(this.pos.plus(new Vec2(0,(int)(taille.y*0.8))));
        Case dl=laby.getCaseAtVec2(this.pos.plus(new Vec2((int)(taille.x*0.2),taille.y)));
        Case dr=laby.getCaseAtVec2(this.pos.plus(new Vec2((int)(taille.x*0.8),taille.y)));
        Case ru=laby.getCaseAtVec2(this.pos.plus(new Vec2(taille.x,(int)(taille.y*0.2))));
        Case rd=laby.getCaseAtVec2(this.pos.plus(new Vec2(taille.x,(int)(taille.y*0.8))));
        if(c.gauche){
            if(lu!=null && ld!=null && lu.isTraversable() && ld.isTraversable()){
                this.pos.x-=vitesse;
            }
        }else if(c.droite){
            if(ru!=null && rd!=null && ru.isTraversable() && rd.isTraversable()){
                this.pos.x+=vitesse;
            }
        }else if(c.haut){
            if(ul!=null && ur!=null && ul.isTraversable()&& ur.isTraversable()){
                this.pos.y-=vitesse;
            }
        }else if(c.bas){
            if(dl!=null && dr!=null && dl.isTraversable() &&  dr.isTraversable()){
                this.pos.y+=vitesse;
            }
        }
    }

    public int getPv() {
        return pv;
    }
    public void setPv(int pv) {
        this.pv = pv;
    }
    public boolean isMort() {
        return mort;
    }
    public void setMort(boolean mort) {
        this.mort = mort;
    }
    public Labyrinthe getLaby() {
        return this.jeu.getCurrentLabyrinthe();
    }
    public void setLaby(Labyrinthe laby) {
        
    }
    public Vec2 getDerniereDir() {
        return derniereDir;
    }
    public void setDerniereDir(Vec2 derniereDir) {
        this.derniereDir = derniereDir;
    }
        public Jeu getJeu() {
        return jeu;
    }
    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }
    public void setMaxPV(int maxPV) {
        this.maxPV = maxPV;
    }
    public int getTimer() {
        return timer;
    }
    public void setTimer(int timer) {
        this.timer = timer;
    }
}