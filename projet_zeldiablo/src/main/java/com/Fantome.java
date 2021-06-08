package com;

public class Fantome extends Monstre {

    /**
     * constructeur du fantome
     * @param n nom du fantome
     * @param vie point de Vie du Fantome
     * @param v position
     * @param l Labyrinthe du Fantome
     * @param d dégât du Fantome
     * @param desc description du Fantome
     */
    public Fantome(int d, Vec2 v, Labyrinthe l) {
        super("Fantome", v, 20, d, "Le Fantome est un monstre plutot lent mais qui traverse les murs", l, 75, 1);
    }

    @Override
    public void attaquerAutre(Entite e2) {
        // TODO Auto-generated method stub
        
    }
    
}
