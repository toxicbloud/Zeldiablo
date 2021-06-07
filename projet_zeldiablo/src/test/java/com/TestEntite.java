package com;

import static org.junit.Assert.*;
import org.junit.*;

public class TestEntite {
    
    @Test
    public void TestEntiteDeplacer() {
        assertTrue(true);
    }

    /**
     * Test Constructor avec case normal de point de vie
     */
    @Test
    public void TestConstructorEntite(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100);

        assertEquals("PV est 100",100, e1.getPV());
        assertEquals("PV est 100",false, e1.etreMort());
    }

    /**
     * Test Constructor 
     * point de Vie <0
     */
    @Test
    public void TestConstructorEntite_v2(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,-500);

        assertEquals("PV est 100",0, e1.getPV());
        assertEquals("cet entite est mort",true, e1.etreMort());
    }

    /**
     * Test Constructor 
     * point de Vie =0
     */
    @Test
    public void TestConstructorEntite_v3(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,0);

        assertEquals("PV est 100",0, e1.getPV());
        assertEquals("PV est 100",true, e1.etreMort());
    }

    /**
     * Test attaquer autre Entité
     */
    @Test
    public void TestAttaquerEntite(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100);
        Entite e2 = new Aventurier("Hello",v,50);

        e1.attaquerAutre(e2, 30);

        assertEquals("Il faut etre 20",20, e2.getPV());
    }

    /**
     * When the entite 2 is mort
     */
    @Test
    public void TestAttaquerEntite_version2(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100);
        Entite e2 = new Aventurier("Hello",v,0);

        e1.attaquerAutre(e2, 50);
        assertEquals("Nothing", 0,e2.getPV());
    }

    /**
     * When the entite 1 is mort
     */
    @Test
    public void TestAttaquerEntite_version3(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,0);
        Entite e2 = new Aventurier("Hello",v,50);

        e1.attaquerAutre(e2, 20);
        assertEquals("e2 must have 50 point de Vie", 50,e2.getPV());
    }

     /**
     * When we attack too hard
     */
    @Test
    public void TestAttaquerEntite_version4(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100);
        Entite e2 = new Aventurier("Hello",v,50);

        e1.attaquerAutre(e2, 1000);
        assertEquals("e2 must have 0 point de Vie", 0,e2.getPV());
    }

    /**
     * When we attack with negative point
     */
    @Test
    public void TestAttaquerEntite_version5(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100);
        Entite e2 = new Aventurier("Hello",v,50);

        e1.attaquerAutre(e2, -500);
        assertEquals("e2 must have 0 point de Vie", 50,e2.getPV());
    }

    /**
     * When we attack with 0 point
     */
    @Test
    public void TestAttaquerEntite_version6(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100);
        Entite e2 = new Aventurier("Hello",v,50);

        e1.attaquerAutre(e2, 0);
        assertEquals("e2 must have 0 point de Vie", 50,e2.getPV());
    }

    @Test
    public void TestSoignerEntite(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100);
        Entite e2 = new Aventurier("Hello",v,50);

        e1.soigner(e2, 1000);
        assertEquals(1050, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v2(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100);
        Entite e2 = new Aventurier("Hello",v,0);

        e1.soigner(e2, 1000);
        assertEquals(0, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v3(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,0);
        Entite e2 = new Aventurier("Hello",v,100);

        e1.soigner(e2, 1000);
        assertEquals(100, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v4(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,50);
        Entite e2 = new Aventurier("Hello",v,100);

        e1.soigner(e2, -1000);
        assertEquals(100, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v5(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,50);
        Entite e2 = new Aventurier("Hello",v,100);

        e1.soigner(e2, 0);
        assertEquals(100, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v6(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,0);
        Entite e2 = new Aventurier("Hello",v,100);

        e1.soigner(e2, -1000);
        assertEquals(100, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v7(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,0);
        Entite e2 = new Aventurier("Hello",v,100);

        e1.soigner(e2, 0);
        assertEquals(100, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v8(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100);
        Entite e2 = new Aventurier("Hello",v,0);

        e1.soigner(e2, -1000);
        assertEquals(0, e2.getPV());
    }

    @Test
    public void TestSoignerEntite_v9(){
        Vec2 v = new Vec2(50, 100);
        Entite e1 = new Aventurier("Hallo",v,100);
        Entite e2 = new Aventurier("Hello",v,0);

        e1.soigner(e2, 0);
        assertEquals(0, e2.getPV());
    }
}
