package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestLabyrinthe {
    
    @Test
    public void TestLabyrintheConstructeur() {
        Labyrinthe lab = new Labyrinthe();

        // vérifie la taille du tableau
        assertEquals("pas la bonne taille", 10, lab.getSize());
        
        // vérifie que les cases du tableau sont accessibles
        assertEquals("problème case", true, lab.getCases()[8][7].isTraversable());

        // vérifie que l'entrée se trouve en bas au milieu du labyrinthe
        assertEquals("problème entrée", lab.getEntree(), lab.getCases()[lab.getSize()/2][lab.getSize()-1]);
    }

    @Test
    public void TestLabyrintheConstructeur2() {
        Labyrinthe lab = new Labyrinthe(15);

        // vérifie la taille du tableau
        assertEquals("pas la bonne taille", 15, lab.getSize());

        // vérifie que les cases du tableau sont accessibles
        assertEquals("problème case", true, lab.getCases()[8][7].isTraversable());

        // vérifie que l'entrée se trouve en bas au milieu du labyrinthe
        assertEquals("problème entrée", lab.getEntree(), lab.getCases()[lab.getSize()/2][lab.getSize()-1]);


    }
}
