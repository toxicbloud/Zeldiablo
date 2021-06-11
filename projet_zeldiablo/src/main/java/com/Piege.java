package com;

import java.util.Date;

public class Piege extends Case {
    private long dernier=new Date().getTime();
    private boolean decouvert=false;

    /** Constructeur de Piege */
    public Piege(){
        super(true,Textures.tex_chemin);
    }

    /** Passe l'etat de la case en mode decouvert */
    public void decouvrir() {
        this.decouvert = true;
        setSprite(Textures.tex_piege);
    }

    /** Action declenchee lors du passage sur la case */
    @Override
    public void action(Jeu j) {
        if(!decouvert){
            this.decouvrir();
            j.getCam().shake();
        }
        Date now = new Date();
        if(now.getTime()>dernier+3000){
            j.getJoueur().perdrePV(5);
        }
    }
}
