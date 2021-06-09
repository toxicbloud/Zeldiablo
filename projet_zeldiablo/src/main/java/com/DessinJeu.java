package com;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.*;

public class DessinJeu implements moteurJeu.DessinJeu {

    /** Taille graphique d'une case */
    public static int TILE_SIZE = 80;

    /** Attribut jeu de DessinJeu, le jeu a dessiner */
    private Jeu jeu;

    /** Decalage de l'image pour centrer le joueur */
    private Vec2 frameShift;

    /** Constructeur vide de DessinJeu */
    DessinJeu() {
        this.jeu = new Jeu("Jeu");
    }

    
    /** Constructeur complet de DessinJeu */
    DessinJeu(Jeu j) {
        this.jeu = j;
        this.frameShift = new Vec2();
    }

    /** Methode dessiner de DessinJeu pour le moteur de jeu */
    @Override
    public void dessiner(BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        int w = image.getWidth();
        int h = image.getHeight();
        this.frameShift = new Vec2((w-TILE_SIZE)/2, (h-TILE_SIZE)/2);
        g.setColor(Color.black);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        Case[][] cases = jeu.getCarte().getCases();
        for (int x = 0; x < cases.length; x++) {
            for (int y = 0; y < cases[x].length; y++) {
                Vec2 newPos = this.worldPos2ScreenPos(new Vec2(x*Labyrinthe.TILE_SIZE, y*Labyrinthe.TILE_SIZE));
                Vec2 newScale = this.worldScale2ScreenScale(new Vec2(Labyrinthe.TILE_SIZE, Labyrinthe.TILE_SIZE));
                g.drawImage(cases[x][y].getSprite(), newPos.x, newPos.y, newScale.x, newScale.y, null);
            }
        }

        for(Entite e: jeu.getEnnemis()) {
            Vec2 newPos = this.worldPos2ScreenPos(new Vec2(e.getPos().x, e.getPos().y));
            Vec2 newScale = this.worldScale2ScreenScale(new Vec2(Labyrinthe.TILE_SIZE, Labyrinthe.TILE_SIZE));
            /** Barre de vie  */
            int pv=e.getPV();
            if(pv>=10){ g.setColor(Color.green);}
            if(pv<=6){g.setColor(Color.orange);}
            g.fillRect(newPos.x, newPos.y-10, e.getPV()*4, 5);
            g.setColor(Color.black);
            g.setStroke(new BasicStroke((float) 1.5));
            g.drawRect(newPos.x-1, newPos.y-11, 50, 6);;
            g.setColor(Color.red);
            /** Dessin du monstre */
            g.drawImage(e.getTexture(), newPos.x, newPos.y, newScale.x, newScale.y, null);
            // g.fillOval(newPos.x, newPos.y, TILE_SIZE, TILE_SIZE);
        }

        Vec2 newPos = this.worldPos2ScreenPos(new Vec2(jeu.getJoueur().getPos().x, jeu.getJoueur().getPos().y));
        Vec2 newScale = this.worldScale2ScreenScale(new Vec2(Labyrinthe.TILE_SIZE, Labyrinthe.TILE_SIZE));
        g.setColor(new Color(0, 0, 0, 50));
        g.fillOval(newPos.x+10, newPos.y+newScale.y-10, newScale.x-20, 10);
        g.drawImage(jeu.getJoueur().getTexture(), newPos.x, newPos.y, newScale.x, newScale.y, null);

        /** Affichage ATH */
        BufferedImage ath = new BufferedImage(image.getWidth(),100,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) ath.getGraphics();
        /** Affichage PV */
        g2.setColor(Color.red);
        g2.fillArc(30, 4, 80, 80, 0, 360);
        int[] pixels = new int[ath.getWidth()*ath.getHeight()];
        Arrays.fill(pixels, 0); 
        ath.setRGB(0, 0, ath.getWidth(), ath.getHeight()-jeu.getJoueur().getPV(), pixels, 0, ath.getWidth());
        g2.drawImage(Textures.tex_uhd,0,0, Textures.tex_uhd.getWidth(null),Textures.tex_uhd.getHeight(null),null);
        /** Affichage energie */
        g2.setColor(Color.gray);
        g2.drawRect(120, 50, 100, 10);

        g2.setColor(Color.orange);
        g2.fillRect(120, 50, jeu.getJoueur().getEnergie(), 10);
        g.drawImage(ath, 0, image.getHeight()-90, ath.getWidth(), ath.getHeight(),null);
    }

    public Vec2 worldPos2ScreenPos(Vec2 pos) {
        return pos.minus(this.jeu.getCam().getPos()).times(TILE_SIZE).div(Labyrinthe.TILE_SIZE).plus(frameShift);
    }

    public Vec2 worldScale2ScreenScale(Vec2 scale) {
        return scale.div(Labyrinthe.TILE_SIZE).times(TILE_SIZE);
    }

    /**
     * Getter de l'attribut Jeu de DessinJeu
     * @return la valeur de l'attribut jeu
     */
    public Jeu getJeu() {
        return jeu;
    }

    /**
     * Setter de l'attribut Jeu de DessinJeu
     * @param j la nouvelle valeur de l'attribut
     */
    public void setJeu(Jeu j) {
        this.jeu = j;
    }
}
