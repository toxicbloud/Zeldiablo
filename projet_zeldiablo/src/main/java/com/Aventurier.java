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
    public Aventurier(String nom){
        super(nom);
    }

    @Override
    public void dessiner(BufferedImage image){
        Graphics g = image.getGraphics();
        g.fillOval(this.getX(), this.getY(), 10, 10);

    }

}
