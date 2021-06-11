package com;

import static org.junit.Assert.*;
import org.junit.*;

public class TestEntite {
    
    // @Test
    // public void TestEntiteDeplacer() {

    //     Labyrinthe l = new Labyrinthe();
    //     Vec2 v = new Vec2(50, 100);
    //     Entite e1 = new Aventurier("Hallo",v,100, l);

    //     Commande

    // }

    /**
     * Test Constructor avec case normal de point de vie
     */
    @Test
    public void TestConstructorEntite(){
        Labyrinthe l = new Labyrinthe();
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v, l);

        assertEquals("PV est 100",100, e1.getPV());
        assertEquals("PV est 100",false, e1.etreMort());
    }

    /**
     * Test Constructor 
     * point de Vie =0
     */
    @Test
    public void TestConstructorEntite_v3(){
        Labyrinthe l = new Labyrinthe();
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v, l);
        e1.perdrePV(500);
        assertEquals("PV est 100",0, e1.getPV());
        assertEquals("PV est 100",true, e1.etreMort());
    }

    /**
     * test Soigner autre Entite
     */
    @Test
    public void TestSoignerEntite(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v, l);
        Entite e2 = new Aventurier("Hello",v, l);
        e2.perdrePV(50);

        e1.soigner(e2, 1000);
        assertEquals(1050, e2.getPV());
    }
/**
 * tEST soigner quand ENtite e2 perds trop de PV
 */
    @Test
    public void TestSoignerEntite_v2(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v, l);
        Entite e2 = new Aventurier("Hello",v, l);
        e2.perdrePV(500);
        e1.soigner(e2, 1000);
        assertEquals(0, e2.getPV());
    }

    /**
     * Test soiger entite quand e1 est mort
     */
    @Test
    public void TestSoignerEntite_v3(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v, l);
        Entite e2 = new Aventurier("Hello",v, l);
        e1.perdrePV(500);
        e1.soigner(e2, 1000);
        assertEquals(100, e2.getPV());
    }

    /**
     * test soigner négative
     */
    @Test
    public void TestSoignerEntite_v4(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v, l);
        Entite e2 = new Aventurier("Hello",v, l);
        e1.perdrePV(50);
        e1.soigner(e2, -1000);
        assertEquals(100, e2.getPV());
    }

    /**
     * test soinger 0
     */
    @Test
    public void TestSoignerEntite_v5(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v, l);
        Entite e2 = new Aventurier("Hello",v, l);
        e1.perdrePV(50);
        e1.soigner(e2, 0);
        assertEquals(100, e2.getPV());
    }

    /**
     * test quand e1 mort et soinge e2 négative
     */
    @Test
    public void TestSoignerEntite_v6(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v, l);
        Entite e2 = new Aventurier("Hello",v, l);
        e1.perdrePV(100);

        e1.soigner(e2, -1000);
        assertEquals(100, e2.getPV());
    }

    /**
     * test quand e1 mort et soinger e2 0
     */
    @Test
    public void TestSoignerEntite_v7(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v, l);
        Entite e2 = new Aventurier("Hello",v, l);
        e1.perdrePV(1000);

        e1.soigner(e2, 0);
        assertEquals(100, e2.getPV());
    }

    /**
     * test quand e2 mort et e1 soinge e1 négative
     */
    @Test
    public void TestSoignerEntite_v8(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v, l);
        Entite e2 = new Aventurier("Hello",v, l);
        e2.perdrePV(1000);
        e1.soigner(e2, -1000);
        assertEquals(0, e2.getPV());
    }

    /**
     * test e2 mort soigne e1 0
     */
    @Test
    public void TestSoignerEntite_v9(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v, l);
        Entite e2 = new Aventurier("Hello",v, l);
        e2.perdrePV(500);
        e1.soigner(e2, 0);
        assertEquals(0, e2.getPV());
    }


}
