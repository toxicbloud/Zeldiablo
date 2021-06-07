package com;

public class Gobelin extends Monstre {
    
    public Gobelin(int d, int vie, Vec2 v, Labyrinthe l) {
        super("Gobelin", v, vie, d, "Le Gobelin est un monstre faible mais rapide", l);
    }
}
