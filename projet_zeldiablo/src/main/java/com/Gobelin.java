package com;

public class Gobelin extends Monstre {
    
    public Gobelin(int d, int vie, Vec2 v, Labyrinthe l) {
        super("Gobelin", v, vie, d, "Le Gobelin est un monstre faible mais rapide", l);
    }

    public void deplacer() {
        int rand = (int)(Math.random() * 4);
        switch(rand) {
            case 0:
                if(getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(-1,0))).isTraversable()){
                   this.getPos().x--;
                }
                break;
            case 1:
                if(getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(1,0))).isTraversable()){
                    this.getPos().x++;
                }
                break;
            case 2:
                if(getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(0,-1))).isTraversable()){
                    this.getPos().y--;
                }
                break;
            case 3: 
                if(getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(0,1))).isTraversable()){
                    this.getPos().y++;
                }
                break;
            default:
                if(getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(0,1))).isTraversable()){
                    this.getPos().y++;
                }
        }
    }
}
