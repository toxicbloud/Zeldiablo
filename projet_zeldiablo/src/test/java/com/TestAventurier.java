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
        j=new Aventurier("Tom",new Vec2(0,0),10);
    }
    @Test
    public void constructeurNom(){
        Aventurier joueur=new Aventurier("Paul",new Vec2(0,0),10);
        assertEquals("Paul", joueur.getNom());
    }
    @Test
    public void testPositionXDeBase(){
        assertEquals(0, j.getPos().x);
    }
    @Test
    public void testPositionYDeBase(){
        assertEquals(0, j.getPos().y);
    }
    @Test
    public void testPositionX(){
        j.setPos(new Vec2(10, j.getPos().y));
        assertEquals(10, j.getPos().x);
    }
    @Test
    public void testPositionY(){
        j.setPos(new Vec2(0,12));
        assertEquals(12, j.getPos().y);
    }
}
