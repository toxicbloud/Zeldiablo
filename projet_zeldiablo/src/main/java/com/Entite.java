package com;

import moteurJeu.DessinJeu;

/**
 * @author Antonin
 */
public abstract class Entite implements DessinJeu{

    private String nom;
    private Vec2 pos;
    // new Attributs point de vie (PV)
    private int pv;
    private boolean mort;

    /**
     * constructeur d' Entite
     * @param nom nom de l'entite
     * @param pointVie point de Vie de l'entité
     */
    public Entite(String nom,Vec2 newPos, int pointVie){
        this.nom=nom;
        this.pos = newPos;
        this.pv=pointVie;
        this.mort = false;
    }

    public Vec2 getPos() {
        return pos;
    }
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

    public boolean etreMort(){
        return this.mort;
    }

    public void gagnerPV(int gagnePv){
        if (this.etreMort() == false){
            this.pv += gagnePv;
        }
    }

    public void perdrePV(int perdrePv){
        if (this.etreMort() == false) {
            this.pv -= perdrePv;        
        }
        if (this.pv <= 0) {
            this.mort = true;
        }
    }

    public void attaquerAutre(Entite e2, int pointAtt){
        if (e2.etreMort() == false) {
            e2.perdrePV(pointAtt);   
        }
    }

    public void soigner(Entite e2, int pointSoigner){
        if (e2.etreMort() == false) {
            e2.gagnerPV(pointSoigner);   
        }
    }



}