package com;

import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.swing.plaf.FontUIResource;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.*;

public class DessinJeu implements moteurJeu.DessinJeu {

    /** Taille graphique d'une case */
    public static int TILE_SIZE = 80;

    /** Attribut jeu de DessinJeu, le jeu a dessiner */
    private Jeu jeu;

    /** Decalage d'ecran pour centrer */
    private Vec2 frameShift;

    /** Hauteur de l'ecran */
    private int h;

    /** Constructeur vide de DessinJeu */
    DessinJeu() {
        this.jeu = new Jeu("Jeu");
        this.frameShift = new Vec2();
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
        Graphics g1D = image.getGraphics();
        int w = image.getWidth();
        h = image.getHeight();
        this.frameShift = new Vec2((w-TILE_SIZE)/2, (h-TILE_SIZE)/2);
        g.setColor(Color.black);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        if (jeu.isEnJeu()) {
            // dessin des cases du labyrinthe
            Case[][] cases = jeu.getCarte().getCases();
            for (int x = 0; x < cases.length; x++) {
                for (int y = 0; y < cases[x].length; y++) {
                    Vec2 newPos = this.worldPos2ScreenPos(new Vec2(x*Labyrinthe.TILE_SIZE, y*Labyrinthe.TILE_SIZE));
                    Vec2 newScale = this.worldScale2ScreenScale(new Vec2(Labyrinthe.TILE_SIZE, Labyrinthe.TILE_SIZE));
                    g.drawImage(cases[x][y].getSprite(), newPos.x, newPos.y, newScale.x, newScale.y, null);
                }
            }

            // dessin des entités du labyrinthe
            for(Entite e: jeu.getEnnemis()) {
                Vec2 newPos = this.worldPos2ScreenPos(new Vec2(e.getPos().x, e.getPos().y));
                Vec2 newScale = this.worldScale2ScreenScale(new Vec2(Labyrinthe.TILE_SIZE, Labyrinthe.TILE_SIZE));
                
                // barre de vie du monstre
                int pv=e.getPV();
                if(pv>=10){ g.setColor(Color.green);}
                if(pv<=6){g.setColor(Color.orange);}
                g.fillRect(newPos.x, newPos.y-10, e.getPV()*4, 5);
                g.setColor(Color.black);
                g.setStroke(new BasicStroke((float) 1.5));
                g.drawRect(newPos.x-1, newPos.y-11, 50, 6);
                g.setColor(Color.red);

                // texture du monstre
                g.drawImage(e.getTexture(), newPos.x, newPos.y, newScale.x, newScale.y, null);
            }

            Vec2 newPos = this.worldPos2ScreenPos(new Vec2(jeu.getJoueur().getPos().x, jeu.getJoueur().getPos().y));
            Vec2 newScale = this.worldScale2ScreenScale(new Vec2(Labyrinthe.TILE_SIZE, Labyrinthe.TILE_SIZE));
            g.setColor(new Color(0, 0, 0, 100));
            g.fillOval(newPos.x+10, newPos.y+newScale.y-5, newScale.x-20, 10);
            g.drawImage(jeu.getJoueur().getTexture(), newPos.x, newPos.y, newScale.x, newScale.y, null);

            /** Affichage interface */
            BufferedImage ath = new BufferedImage(image.getWidth(),100,BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = (Graphics2D) ath.getGraphics();

            /** Affichage PV */
            g2.setColor(Color.red);
            g2.fillArc(30, 4, 80, 80, 0, 360);
            int[] pixels = new int[ath.getWidth()*ath.getHeight()];
            Arrays.fill(pixels, 0); 
            ath.setRGB(0, 0, ath.getWidth(), ath.getHeight()-jeu.getJoueur().getPV(), pixels, 0, ath.getWidth());
            g2.drawImage(Textures.tex_uhd,0,0, Textures.tex_uhd.getWidth(null),Textures.tex_uhd.getHeight(null),null);
            
            /** Affichage barre energie */
            g2.setColor(Color.gray);
            g2.drawRect(120, 50, 100, 10);

            g2.setColor(Color.orange);
            g2.fillRect(120, 50, jeu.getJoueur().getEnergie(), 10);
            g.drawImage(ath, 0, image.getHeight()-90, ath.getWidth(), ath.getHeight(),null);
        } else {
            if (jeu.isEcranFin()) {
                // dessine l'ecran de fin
                g.drawImage(Textures.tex_gameoverWin, 
                    w/2-Textures.tex_gameoverWin.getWidth(null)/2, h/2-Textures.tex_gameoverWin.getHeight(null)/2, 
                    Textures.tex_gameoverWin.getWidth(null), Textures.tex_gameoverWin.getHeight(null), null
                );
                g1D.setFont(new FontUIResource("Helvetica", FontUIResource.BOLD, 30));
                int width = g1D.getFontMetrics().stringWidth("Menu Principal");
                g.setColor(new Color(176,44,36));
                g.fillRect(w/2-width/2-15, (int)(h*0.8)-55, width+30, 60);
                g1D.drawString("Menu Principal", w/2-width/2, (int)(h*0.8)-15);
            } else {
                // dessine l'ecran de debut
                g.drawImage(Textures.tex_mur, 0, 0, w, h, null);
                g1D.setColor(Color.RED);
                g1D.setFont(new FontUIResource("Helvetica", FontUIResource.BOLD, 60));
                int width = g1D.getFontMetrics().stringWidth("Zeldiablo");
                g1D.drawString("Zeldiablo", w/2-width/2, (int)(h*0.2)-30);
                g.drawImage(Textures.guerrier[1], (int)(w/2-h*0.15), (int)(h*0.2), (int)(h*0.3), (int)(h*0.3), null);
                g1D.setFont(new FontUIResource("Helvetica", FontUIResource.BOLD, 40));
                g1D.setColor(Color.BLACK);
                g.setColor(Color.WHITE);
                width = g1D.getFontMetrics().stringWidth("Jouer");
                g.fillRect(w/2-width/2-10, (int)(h*0.75)-65, width+20, 60);
                g1D.drawString("Jouer", w/2-width/2, (int)(h*0.75)-20);
                width = g1D.getFontMetrics().stringWidth("Quitter");
                g.fillRect(w/2-width/2-10, (int)(h*0.9)-65, width+20, 60);
                g1D.drawString("Quitter", w/2-width/2, (int)(h*0.9)-20);
            }
        }
    }

    /**
     * Methode appelee quand la souris est cliquee
     */
    public void onclick(int x, int y) {
        if (!jeu.isEnJeu()) {
            if (jeu.isEcranFin()) {
                jeu.setEcranFin(false);
            } else {
                if (y <= h*0.9-65) {
                    jeu.setEnJeu(true);
                } else {
                    jeu.quit();
                }
            }
        }
    }

    /**
     * Converti la position du monde en position sur l"ecran
     * @param pos position dans le monde
     * @return position sur l'ecran
     */
    public Vec2 worldPos2ScreenPos(Vec2 pos) {
        return pos.minus(this.jeu.getCam().getPos()).times(TILE_SIZE).div(Labyrinthe.TILE_SIZE).plus(frameShift);
    }

    /**
     * Converti une taille du monde en taille sur l'ecran
     * @param scale taille dans le monde
     * @return taille sur l'ecran
     */
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
