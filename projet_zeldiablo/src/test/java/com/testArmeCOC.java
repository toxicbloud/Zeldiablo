package com;

import static org.junit.Assert.*;
import org.junit.*;
public class testArmeCOC {

    /**
     * Test Equiper normal
     */
    @Test
    public void TestEquiper(){
        Labyrinthe l= new Labyrinthe();
        Aventurier a1=new Aventurier("Paul",new Vec2(0,0),l);
        Arme_COC knife = new Couteau(10, 1);

        a1.equiper_Arme(knife);
        assertEquals("Paul must have a knife", knife, a1.getArme());
    }

    /**
     * Test Equiper avec Arme qui prends -100 energie
     */
    @Test
    public void TestEquiper_v1(){
        Labyrinthe l= new Labyrinthe();
        Aventurier a1=new Aventurier("Paul",new Vec2(0,0),l);
        Arme_COC knife = new Couteau(10, -100);

        a1.equiper_Arme(knife);
        assertEquals("Knife must have min 1 energie", 1, knife.getEnergie());
        assertEquals("Paul must have a knife", knife, a1.getArme());
    }

    /**
     * Test Equiper avec Arme qui prends -100 dégats
     */
    @Test
    public void TestEquiper_v2(){
        Labyrinthe l= new Labyrinthe();
        Aventurier a1=new Aventurier("Paul",new Vec2(0,0),l);
        Arme_COC knife = new Couteau(-100, 10);

        a1.equiper_Arme(knife);
        //assertEquals("Knife must have min 1 dégats", 1, knife.getDegats());
        assertEquals("Paul must have a knife", knife, a1.getArme());
        System.out.println(a1.getArme().getDegats());
    }
    
    /**
     * Test Equiper avec Arme qui prends -100 dégats et -100 energie
     */
    @Test
    public void TestEquiper_v3(){
        Labyrinthe l= new Labyrinthe();
        Aventurier a1=new Aventurier("Paul",new Vec2(0,0),l);
        Arme_COC knife = new Couteau(-100, -100);

        a1.equiper_Arme(knife);
        assertEquals("Knife must have min 1 dégats", 1, knife.getDegats());
        assertEquals("Knife must have min 1 energie", 1, knife.getEnergie());
        assertEquals("Paul must have a knife", knife, a1.getArme());
    }

    // Test attaquer
    /**
     * Cas normal
     */
    @Test
    public void TestAttaquer(){
        Labyrinthe l= new Labyrinthe();
        Aventurier a1=new Aventurier("Paul",new Vec2(0,0),l);
        Aventurier a2=new Aventurier("Paul",new Vec2(0,0),l);

        Arme_COC knife = new Couteau(2, 1);
        a1.equiper_Arme(knife);
        a1.attaquerAutre(a2);

        assertEquals("a2 must have 98 point de vies", 98 ,a2.getPV());
    }

    /**
     * Cas normal
     */
    @Test
    public void TestAttaquer_v1(){
        Labyrinthe l= new Labyrinthe();
        Aventurier a1=new Aventurier("Paul",new Vec2(0,0),l);
        Aventurier a2=new Aventurier("Paul",new Vec2(0,0),l);

        Arme_COC knife = new Couteau(-100, 1);
        a1.equiper_Arme(knife);
        a1.attaquerAutre(a2);
        System.out.println(knife.getDegats());
        assertEquals("a2 must have 99 point de vies", 99 ,a2.getPV());
    }

    /**
     * Cas normal
     */
    @Test
    public void TestJeter(){
        Labyrinthe l= new Labyrinthe();
        Aventurier a1=new Aventurier("Paul",new Vec2(0,0),l);
        Arme_COC knife = new Couteau(10, 1);

        a1.equiper_Arme(knife);
        assertEquals("Paul must have a knife", knife, a1.getArme());

        a1.jeter_Arme();
        assertEquals("Paul must not have a knife", null, a1.getArme());
    }


}
