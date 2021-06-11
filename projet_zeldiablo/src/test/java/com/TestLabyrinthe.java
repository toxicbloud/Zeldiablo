package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestLabyrinthe {

    /**
     * test Get Case at Vec 2 
     * cas Normal
     */
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
    /**
     * test Get Case at Vec 2 
     * cas hors de Carte
     */
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
