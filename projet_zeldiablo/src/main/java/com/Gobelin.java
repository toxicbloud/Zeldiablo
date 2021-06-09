package com;

/**
 * classe qui représente un gobelin
 */
public class Gobelin extends Monstre {
    
    /**
     * constructeur de gobelin
     * @param n nom du gobelin
     * @param vie point de Vie du gobelin
     * @param v position
     * @param l Labyrinthe du gobelin
     * @param d dégât du gobelin
     * @param desc description du gobelin
     */
    public Gobelin(int d, Vec2 v, Labyrinthe l) {
        super("Gobelin", v, 10, d, "Le Gobelin est un monstre faible mais rapide", l, 25, 2);
        setTexture(Textures.goblin[1]);
    }

    @Override
    public void attaquerAutre(Entite e2) {
        // TODO Auto-generated method stub
        
    }
}
