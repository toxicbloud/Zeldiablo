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
        Aventurier a1=new Aventurier("Paul",new Vec2(0,0),10,l);
        Arme_COC knife = new Arme_COC(10, 1);

        a1.equiper_Arme(knife);
        assertEquals("Paul must have a knife", knife, a1.getArme());
    }

    /**
     * Test Equiper avec Arme qui prends -100 energie
     */
    @Test
    public void TestEquiper_v1(){
        Labyrinthe l= new Labyrinthe();
        Aventurier a1=new Aventurier("Paul",new Vec2(0,0),10,l);
        Arme_COC knife = new Arme_COC(10, -100);

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
        Aventurier a1=new Aventurier("Paul",new Vec2(0,0),10,l);
        Arme_COC knife = new Arme_COC(-100, 10);

        a1.equiper_Arme(knife);
        assertEquals("Knife must have min 1 dégats", 1, knife.getDegats());
        assertEquals("Paul must have a knife", knife, a1.getArme());
    }
    
    /**
     * Test Equiper avec Arme qui prends -100 dégats et -100 energie
     */
    @Test
    public void TestEquiper_v3(){
        Labyrinthe l= new Labyrinthe();
        Aventurier a1=new Aventurier("Paul",new Vec2(0,0),10,l);
        Arme_COC knife = new Arme_COC(-100, -100);

        a1.equiper_Arme(knife);
        assertEquals("Knife must have min 1 dégats", 1, knife.getDegats());
        assertEquals("Knife must have min 1 energie", 1, knife.getEnergie());
        assertEquals("Paul must have a knife", knife, a1.getArme());
    }
}
