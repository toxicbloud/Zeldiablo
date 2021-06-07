package com;

public class Gobelin extends Monstre {
    
    public Gobelin(int d, int vie, int x, int y) {
        super("Gobelin", new Vec2(x, y), vie, d, "Le Gobelin est un monstre faible mais rapide");
    }
}
