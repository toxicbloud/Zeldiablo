package com;

public class Piege extends Case {
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
        this.decouvrir();
        j.getJoueur().perdrePV(1);
    }
}
