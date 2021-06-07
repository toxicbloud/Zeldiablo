package com;
import java.awt.Graphics;
/**
 * @author Antonin
 */
import java.awt.image.BufferedImage;

import moteurJeu.DessinJeu;

public class Aventurier extends Entite{

    /**
     * constructeur aventurier avec un nom
     * @param nom nom de l aventurier
     */
    public Aventurier(String nom,Vec2 v,int pv){
        super(nom,v,pv);
    }

    @Override
    public void dessiner(BufferedImage image){
        Graphics g = image.getGraphics();
        g.fillOval(this.getPos().x, this.getPos().y, 10, 10);

    }

}
