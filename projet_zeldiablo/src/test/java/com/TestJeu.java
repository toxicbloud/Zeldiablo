package com;

import static org.junit.Assert.*;
import org.junit.*;

public class TestJeu {
    
    @Test
    public void TestJeuConstructeur() {
        Jeu j = new Jeu("Talluan");

        // vérifie que le labyrinthe a bien été créé
        assertEquals("pas la bonne taille", new Labyrinthe(), j.getLabyrinthe());

        // vérifie que l'Aventurier a bien été créé
        assertEquals("pas la bonne taille", new Aventurier("Talluan"), j.getAventurier());
        
        }
}
