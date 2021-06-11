package com;

public class Murloc extends Monstre {
    /**
     * constructeur de Murloc
     * @param n nom du Murloc
     * @param vie point de Vie du Murloc
     * @param v position
     * @param l Labyrinthe du Murloc
     * @param d dégât du Murloc
     * @param desc description du Murloc
     */
    public Murloc(int d, Vec2 v, Labyrinthe l, Jeu j) {
        super("Murloc", v, 25, d, "Le Murloc est un monstre normal mais qui devient très rapide quand il voit le joueur", l, 50, 1, j);
    }

    @Override
    public void attaquerAutre(Entite e2) {
        // TODO Auto-generated method stub
        
    }
}
