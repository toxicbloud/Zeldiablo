package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCamera {
    
    @Test
    public void testCamera() {
        Entite e = new Aventurier("Tallu", new Vec2(10, 10), 10);
        Camera c = new Camera(e);

        assertEquals("Camera pas à la bonne position", true, c.getPos().equals(new Vec2(10, 10)));
    }

    @Test
    public void deplacerCamera() {
        Entite e = new Aventurier("Tallu", new Vec2(10, 10), 10);
        Camera c = new Camera(e);
        c.deplacer(new Aventurier("Traitre", new Vec2(15, 50), 10));

        assertEquals("Camera pas à la bonne position", true, c.getPos().equals(new Vec2(15, 50)));

    }
}
