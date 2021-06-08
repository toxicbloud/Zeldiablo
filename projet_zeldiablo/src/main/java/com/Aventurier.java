package com;

import moteurJeu.Commande;

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
        this.arme=null;
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
    @Override
    public void deplacer(Commande c){
        super.deplacer(c);
        Labyrinthe laby=getLabyrinthe();
        Case proch=laby.getCaseAtVec2(getPos());
        if(proch instanceof Amulette){
            //temporaire
            System.out.println("Le jeu est fini");
        }
    }
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
