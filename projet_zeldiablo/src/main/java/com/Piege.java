package com;

import java.util.Date;

public class Piege extends Case {
    private long dernier=new Date().getTime();
    private boolean decouvert=false;
    public Piege(){
        super(true,Textures.tex_chemin);
    }
    public void decouvrir() {
        this.decouvert = true;
        setSprite(Textures.tex_piege);
    }
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
