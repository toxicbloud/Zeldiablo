package com;
import static org.junit.Assert.*;
import org.junit.*;

public class testBoss {
    /**
     * Test Deplacement de Boss
     * On va tester dans un environnement chemin ou il n'y a pas de chemin 
     * Ici, la position est 0,0 avec aucune de mûr 
     * Tout d'abord, on fait de constructor 
     * Ensuite, on essaie de run à gauche une fois
     * C'est bon car ca passe pas le range
     * 
     */
    @Test
    public void testDeplacement(){
        /**
     * constructeur de Boss
     * @param n nom de Boss
     * @param vie point de Vie de Boss
     * @param v position
     * @param l Labyrinthe de Boss
     * @param d dégât du Boss
     * @param desc description du Boss
     * @param a délai entre chaque déplacement du Boss
     * @param v vitesse de déplacement du Boss
     * @param range range de Boss
     */
    String n = "John";
    int vie = 100;
    Vec2 v= new Vec2(0, 0);
    int d = 10;
    String desc = "I'm John";
    int a = 10;
    int vit=2;
    int range=3;
    Jeu j = new Jeu("Hello");

    Labyrinthe l =  j.getCarte();
        Case [][] c = l.getCases();
        c[0][0] = new Chemin();
                
    
    Boss b1= new Boss(n, v, vie, d, desc, l, a, vit, range,j);
    b1.setPos( new Vec2(0, 0));
    assertEquals(true, b1.deplacer("Gauche"));

    }
    
}
