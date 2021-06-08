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
    public Orc(int d, int vie, Vec2 v, Labyrinthe l) {
        super("Orc", v, vie, d, "L'Orc est un monstre lent mais résistant", l, 75, 1);
    }
}
