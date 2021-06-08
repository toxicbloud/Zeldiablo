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
        Entite e1 = new Aventurier("Hallo",v,100, l);

        assertEquals("PV est 100",100, e1.getPV());
        assertEquals("PV est 100",false, e1.etreMort());
    }

    /**
     * Test Constructor 
     * point de Vie <0
     */
    @Test
    public void TestConstructorEntite_v2(){
        Labyrinthe l = new Labyrinthe();
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,-500, l);

        assertEquals("PV est 100",0, e1.getPV());
        assertEquals("cet entite est mort",true, e1.etreMort());
    }

    /**
     * Test Constructor 
     * point de Vie =0
     */
    @Test
    public void TestConstructorEntite_v3(){
        Labyrinthe l = new Labyrinthe();
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,0, l);

        assertEquals("PV est 100",0, e1.getPV());
        assertEquals("PV est 100",true, e1.etreMort());
    }

    
    @Test
    public void TestSoignerEntite(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100, l);
        Entite e2 = new Aventurier("Hello",v,50, l);

        e1.soigner(e2, 1000);
        assertEquals(1050, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v2(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100, l);
        Entite e2 = new Aventurier("Hello",v,0, l);

        e1.soigner(e2, 1000);
        assertEquals(0, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v3(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,0, l);
        Entite e2 = new Aventurier("Hello",v,100, l);

        e1.soigner(e2, 1000);
        assertEquals(100, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v4(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,50, l);
        Entite e2 = new Aventurier("Hello",v,100, l);

        e1.soigner(e2, -1000);
        assertEquals(100, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v5(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,50, l);
        Entite e2 = new Aventurier("Hello",v,100, l);

        e1.soigner(e2, 0);
        assertEquals(100, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v6(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,0, l);
        Entite e2 = new Aventurier("Hello",v,100, l);

        e1.soigner(e2, -1000);
        assertEquals(100, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v7(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,0, l);
        Entite e2 = new Aventurier("Hello",v,100, l);

        e1.soigner(e2, 0);
        assertEquals(100, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v8(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100, l);
        Entite e2 = new Aventurier("Hello",v,0, l);

        e1.soigner(e2, -1000);
        assertEquals(0, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v9(){
        Labyrinthe l = new Labyrinthe();

        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100, l);
        Entite e2 = new Aventurier("Hello",v,0, l);

        e1.soigner(e2, 0);
        assertEquals(0, e2.getPV());
    }


}
