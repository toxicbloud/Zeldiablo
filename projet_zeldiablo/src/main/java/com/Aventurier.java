package com;

import java.util.ArrayList;

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
    public Aventurier(String nom,Vec2 v,Labyrinthe l){
        super(nom,v,100,l);
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

        if (c.espace) {

        }
        Labyrinthe laby=getLabyrinthe();
        Case proch=laby.getCaseAtVec2(getPos());

        if(proch instanceof Amulette){
            //temporaire
            System.out.println("Le jeu est fini");
            this.getJeu().setFini(true);
        }
    }

    public void attaque() {
        int r = this.arme.getRange();

    }

    public void attaqueZone(int r) {
        Vec2 dir = this.getDerniereDir();
        Vec2 max = dir.times(r);
        Jeu j = this.getJeu();
        ArrayList<Entite> ar = j.getEnnemis();
        for (Entite entite : ar) {
            if (dir.equals(new Vec2(1,0))) {
                if(entite.getPos().x <= max.x + this.getPos().x && entite.getPos().x >= this.getPos().x){
                    if (entite.getPos().y <= this.getPos().y + 2 && entite.getPos().y >= this.getPos().y - 2) {
                        this.attaquerAutre(entite);
                    }
                }
            }
            else if(dir.equals(new Vec2(0,1))){
                if(entite.getPos().y <= max.y + this.getPos().y && entite.getPos().y >= this.getPos().y){
                    if (entite.getPos().x <= this.getPos().x + 2 && entite.getPos().x >= this.getPos().x - 2) {
                        this.attaquerAutre(entite);
                    }
                }
            }
            else if(dir.equals(new Vec2(-1,0))){
                if(entite.getPos().x >= max.x + this.getPos().x && entite.getPos().x <= this.getPos().x){
                    if (entite.getPos().y <= this.getPos().y + 2 && entite.getPos().y >= this.getPos().y - 2) {
                        this.attaquerAutre(entite);
                    }
                }
            }
            else if(dir.equals(new Vec2(0,-1))){
                if(entite.getPos().y >= max.y + this.getPos().y && entite.getPos().y >= this.getPos().y){
                    if (entite.getPos().x <= this.getPos().x + 2 && entite.getPos().x >= this.getPos().x - 2) {
                        this.attaquerAutre(entite);
                    }
                }
            }
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
