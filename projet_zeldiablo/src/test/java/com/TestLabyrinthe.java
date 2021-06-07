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

    @Test
    public void TestGetCaseAtVec2_Normal() {
        Labyrinthe l = new Labyrinthe();
        l.getCases()[0][0] = new Chemin();
        l.getCases()[1][2] = new Mur();
        l.getCases()[1][1] = new Chemin();
        assertEquals(
            "La case en ("+(Labyrinthe.TILE_SIZE/2)+""+(Labyrinthe.TILE_SIZE/2)+") devrais etre un chemin", 
            true, l.getCaseAtVec2(new Vec2(Labyrinthe.TILE_SIZE/2, Labyrinthe.TILE_SIZE/2)) instanceof Chemin
        );
        assertEquals(
            "La case en ("+(Labyrinthe.TILE_SIZE+1)+""+(Labyrinthe.TILE_SIZE+1)+") devrais etre un chemin",
            true, l.getCaseAtVec2(new Vec2(Labyrinthe.TILE_SIZE+1, Labyrinthe.TILE_SIZE+1)) instanceof Chemin
        );
        assertEquals(
            "La case en ("+(Labyrinthe.TILE_SIZE+1)+""+(Labyrinthe.TILE_SIZE*2+1)+") devrais etre un chemin",
            true, l.getCaseAtVec2(new Vec2(Labyrinthe.TILE_SIZE+1, Labyrinthe.TILE_SIZE*2+1)) instanceof Mur
        );
    }

    @Test
    public void TestGetCaseAtVec2_HorsCarte() {
        Labyrinthe l = new Labyrinthe();
        assertEquals(
            "La case a la position (-1, -1) devrais etre nulle",
            null, l.getCaseAtVec2(new Vec2(-1, -1))
        );
        int tropLoin = l.getSize() * Labyrinthe.TILE_SIZE + 1;
        assertEquals(
            "La case a la position ("+tropLoin+", "+tropLoin+") devrais etre nulle",
            null, l.getCaseAtVec2(new Vec2(tropLoin, tropLoin))
        );
    }
}
