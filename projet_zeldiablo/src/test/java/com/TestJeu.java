package com;

import static org.junit.Assert.*;
import org.junit.*;

public class TestJeu {
    
    @Test
    public void TestJeuConstructeur() {
        Jeu j = new Jeu("Talluan");

        // vérifie que le labyrinthe a bien été créé
        assertEquals("le labyrinthe n'a pas bien été créé", true, j.getCarte() != null );

        // vérifie que le joueur a bien été créé
        assertEquals("le joueur n'a pas bien été créé", true, j.getJoueur() != null );
    }
}
