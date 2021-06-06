package com;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe de test pour Mur
 */
public class TestMur {
    /**
     * Test constructeur Chemin
     */
    @Test
    public void TestConstructeurVide() {
        Case c = new Mur();
        assertTrue(true);
    }

    /**
     * Test attribut traversable
     */
    @Test
    public void TestTraversable() {
        Case c = new Mur();
        assertEquals("La case ne devrait pas etre traversable", false, c.isTraversable());
    }
}
