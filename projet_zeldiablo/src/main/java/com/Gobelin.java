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
    public Gobelin(int d, int vie, Vec2 v, Labyrinthe l) {
        super("Gobelin", v, vie, d, "Le Gobelin est un monstre faible mais rapide", l);
    }

    /**
     * methode qui permet à un gobelin de se déplacer
     */
    public void deplacer() {
        Case cs;
        int rand = (int)(Math.random() * 4);
        switch(rand) {
            case 0:
                cs=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(-1,0)));
                if(cs!=null && cs.isTraversable()){
                    setPos(new Vec2((getPos().x)-1, getPos().y));
                }
                break;
            case 1:
                cs=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(1,0)));
                if(cs!=null && cs.isTraversable()){
                    setPos(new Vec2((getPos().x)+1, getPos().y));
                }
                break;
            case 2:
                cs=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(0,-1)));
                if(cs!=null && cs.isTraversable()) {
                    setPos(new Vec2(getPos().x, (getPos().y)-1));
                }
                break;
            case 3: 
                cs=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(0,1)));
                if(cs!=null && cs.isTraversable()){
                    setPos(new Vec2(getPos().x, (getPos().y)+1));
                }
                break;
            default:
                cs=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(0,1)));
                if(cs!=null && cs.isTraversable()){
                    setPos(new Vec2(getPos().x, (getPos().y)+1));
                }
        }
        System.out.println(getPos().x + " " + getPos().y);
    }
}
