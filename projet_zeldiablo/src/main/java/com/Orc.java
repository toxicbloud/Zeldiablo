package com;

public class Orc extends Monstre {
    /**
     * constructeur de Orc
     * @param n nom de l'orc
     * @param vie point de Vie de l'orc
     * @param v position
     * @param l Labyrinthe de l'orc
     * @param d dégât de l'orc
     * @param desc description de l'orc
     */
    public Orc(int d, Vec2 v, Labyrinthe l) {
        super("Orc", v, 60, d, "L'Orc est un monstre lent mais résistant", l, 75, 1);
    }

    @Override
    public void attaquerAutre(Entite e2) {
        // TODO Auto-generated method stub
        
    }
}
