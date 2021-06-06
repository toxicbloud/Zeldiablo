package com;
/**
 * @author Antonin
 */
import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TestAventurier {
    private Aventurier j;
    @Before
    public void init(){
        j=new Aventurier("Tom");
    }
    @Test
    public void constructeurNom(){
        Aventurier joueur=new Aventurier("Paul");
        assertEquals("Paul", joueur.getNom());
    }
    @Test
    public void testPositionXDeBase(){
        assertEquals(0, j.getX());
    }
    @Test
    public void testPositionYDeBase(){
        assertEquals(0, j.getY());
    }
    @Test
    public void testPositionX(){
        j.setX(10);
        assertEquals(10, j.getX());
    }
    @Test
    public void testPositionY(){
        j.setY(12);
        assertEquals(12, j.getY());
    }
}
