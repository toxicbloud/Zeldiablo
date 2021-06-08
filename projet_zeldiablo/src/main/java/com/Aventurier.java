package com;
/**
 * @author Antonin
 */

public class Aventurier extends Entite{

    private int energie;
    private Arme arme;
    /**
     * constructeur aventurier avec un nom
     * @param nom nom de l aventurier
     */
    public Aventurier(String nom,Vec2 v,int pv,Labyrinthe l){
        super(nom,v,pv,l);
        this.energie = 100;

    }

    public void equiper_Arme(Arme a1){
        this.arme=a1;
    }

    public void jeter_Arme(){
        this.arme = null;
    }
    
    public Arme getArme(){
        return this.arme;
    }
}
