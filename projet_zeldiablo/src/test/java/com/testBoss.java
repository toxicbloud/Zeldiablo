package com;
import static org.junit.Assert.*;
import org.junit.*;

public class testBoss {
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
    Vec2 v= new Vec2(4, 4);
    Labyrinthe l = new Labyrinthe();
    int d = 10;
    String desc = "I'm John";
    int a = 10;
    int vit=3;
    int range=2;

    Boss b1= new Boss(n, v, vie, d, desc, l, a, vit, range);
    b1.deplacer("Gauche");
    b1.deplacer("Haute");

    Vec2 real = new Vec2(3, 4);
    assertEquals("Vec must not be 4,4", real,b1.getPos());
    }

    @Test
    public void testMonstre(){
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
    Vec2 v= new Vec2(4, 4);
    Labyrinthe l = new Labyrinthe();
    int d = 10;
    String desc = "I'm John";
    int a = 10;
    int vit=3;


    Monstre m1 = new Monstre( n,  v,  vie,  d,  desc,  l,  a,  vit);
    }
    
}
