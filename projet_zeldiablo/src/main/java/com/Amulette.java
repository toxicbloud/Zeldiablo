package com;

import java.awt.Color;

public class Amulette extends Case{
    /**
     * constructeur
     */
    Amulette(){
        super(true,Textures.tex_amulette);
    }

    @Override
    public void action(Jeu j) {
        j.setFini(true);
        
    }
}
