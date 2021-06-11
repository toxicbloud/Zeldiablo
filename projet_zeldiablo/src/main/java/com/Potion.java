package com;

public class Potion extends Case {
    /**
     * constructeur Potion
     */
    public Potion() {
        super(true, Textures.tex_hpPotion);
    }
    /**
     * action de la case 
     *@param Jeu jeu 
     */
    @Override
    public void action(Jeu j) {
        if (j.getJoueur().getPV() > 99) {
            return;
        }
        j.getJoueur().gagnerPV(10);
        // j.getCarte().getCaseAtVec2(j.getJoueur().getPos());
        Case lab[][] = j.getCarte().getCases();
        Vec2 newPos = j.getJoueur().getPos().plus(new Vec2(Labyrinthe.TILE_SIZE / 2, Labyrinthe.TILE_SIZE / 2))
                .div(Labyrinthe.TILE_SIZE);
        lab[newPos.x][newPos.y] = new Chemin();
    }

}
