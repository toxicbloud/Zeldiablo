package com;
/**
 * @author Antonin
 */
import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TestAventurier {
    private Aventurier j;
    private Labyrinthe l;
    private Monstre gob;
    private Jeu jeu;
    @Before
    public void init(){
        l= new Labyrinthe();
        j=new Aventurier("Tom",new Vec2(0,0),l);
        jeu=new Jeu();
    }
    /**
     * Test constructor Nom 
     */
    @Test
    public void constructeurNom(){
        Aventurier joueur=new Aventurier("Paul",new Vec2(0,0),l);
        assertEquals("Paul", joueur.getNom());
    }
    /**
     * Test la position de X à base
     */
    @Test
    public void testPositionXDeBase(){
        assertEquals(0, j.getPos().x);
    }
    /**
     * Test Position de Y à base
     */
    @Test
    public void testPositionYDeBase(){
        assertEquals(0, j.getPos().y);
    }
    /**
     * Test Position X avec cas normal
     */
    @Test
    public void testPositionX(){
        j.setPos(new Vec2(10, j.getPos().y));
        assertEquals(10, j.getPos().x);
    }
    /**
     * Test Position Y cas normal
     */
    @Test
    public void testPositionY(){
        j.setPos(new Vec2(0,12));
        assertEquals(12, j.getPos().y);
    }


    /**
     * Test Attaque monstre 
     * 
     */
    @Test
    public void testAttaqueDessus(){
        Aventurier a = jeu.getJoueur();
        Monstre test = (Monstre)jeu.getEnnemis().get(0);
        a.setDerniereDir(new Vec2(0,1));
        // On place l'aventurier une demi-case au dessus du monstre
        a.setPos(jeu.getCarte().getEntree().plus(new Vec2(0,-Labyrinthe.TILE_SIZE/2)));

        assertEquals("le gobelin n'a pas le bon nombre de pvs initiaux", 10, test.getPv());
        // test.setPos(jeu.getCarte().getEntree());
        int r = a.getRange();
        a.attaqueZone(r);
        assertEquals("le gobelin n'a pas le bon nombre de points de vie", 5, test.getPV());

    }

    /**
     * Test range de attaque à Droite
     */
    @Test
    public void testAttaqueDroite(){
        Aventurier a = jeu.getJoueur();
        Monstre test = (Monstre)jeu.getEnnemis().get(0);
        a.setDerniereDir(new Vec2(-1,0));
        // On place l'aventurier une demi-case au dessus du monstre
        a.setPos(jeu.getCarte().getEntree().plus(new Vec2(Labyrinthe.TILE_SIZE/2,0)));

        assertEquals("le gobelin n'a pas le bon nombre de pvs initiaux", 10, test.getPv());
        // test.setPos(jeu.getCarte().getEntree());
        int r = a.getRange();
        a.attaqueZone(r);
        assertEquals("le gobelin n'a pas le bon nombre de points de vie", 5, test.getPV());

    }

    /**
     * Test range de attaque à Gauche
     */
    @Test
    public void testAttaqueGauche(){
        Aventurier a = jeu.getJoueur();
        Monstre test = (Monstre)jeu.getEnnemis().get(0);
        a.setDerniereDir(new Vec2(1,0));
        // On place l'aventurier une demi-case au dessus du monstre
        a.setPos(jeu.getCarte().getEntree().plus(new Vec2(-Labyrinthe.TILE_SIZE/2,0)));

        assertEquals("le gobelin n'a pas le bon nombre de pvs initiaux", 10, test.getPv());
        // test.setPos(jeu.getCarte().getEntree());
        int r = a.getRange();
        a.attaqueZone(r);
        assertEquals("le gobelin n'a pas le bon nombre de points de vie", 5, test.getPV());
    }

    /**
     * Test range de attaque à Haute
     */
    @Test
    public void testAttaqueDessous(){
        Aventurier a = jeu.getJoueur();
        Monstre test = (Monstre)jeu.getEnnemis().get(0);
        test.setPos(new Vec2(0, 0));
        a.setDerniereDir(new Vec2(0,-1));
        // On place l'aventurier une demi-case au dessus du monstre
        a.setPos(jeu.getCarte().getEntree().plus(new Vec2(0,Labyrinthe.TILE_SIZE/2)));

        assertEquals("le gobelin n'a pas le bon nombre de pvs initiaux", 10, test.getPv());
        // test.setPos(jeu.getCarte().getEntree());
        int r = a.getRange();
        a.attaqueZone(r);
        assertEquals("le gobelin n'a pas le bon nombre de points de vie", 5, test.getPV());

    }
}
