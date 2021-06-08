package com;

public class PlanteC extends Monstre{
    /**
     * constructeur de PlanteC
     * @param n nom de la plante
     * @param vie point de Vie de la plante
     * @param v position
     * @param l Labyrinthe de la plante
     * @param d dégât de la plante
     * @param desc description de la plante
     */
    public PlanteC(int d, Vec2 v, Labyrinthe l) {
        super("Plante Carnivore", v, 50, d, "La Plante Carnivore est un monstre plutôt puissant mais qui ne peut pas se déplacer", l, 100, 0);
    }
}
