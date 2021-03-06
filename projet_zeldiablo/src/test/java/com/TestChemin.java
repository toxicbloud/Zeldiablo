package com;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe de test pour Chemin
 */
public class TestChemin {
    /**
     * Test constructeur Chemin
     */
    @Test
    public void TestConstructeurVide() {
        Case c = new Chemin();
        assertTrue(true);
    }

    /**
     * Test attribut traversable
     */
    @Test
    public void TestTraversable() {
        Case c = new Chemin();
        assertEquals("La case devrait etre traversable", true, c.isTraversable());
    }
}
