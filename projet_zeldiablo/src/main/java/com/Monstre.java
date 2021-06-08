package com;
/**
 * classe qui représente les différents monstres du jeu
 */
public abstract class Monstre extends Entite {
    
    private int degat;
    private String description;


    /**
     * constructeur de monstre
     * @param n nom de l'entite
     * @param vie point de Vie de l'entité
     * @param v position
     * @param l Labyrinthe de l Entite
     * @param d dégât du monstre
     * @param desc description du monstre
     */
    public Monstre(String n, Vec2 v, int vie, int d, String desc, Labyrinthe l) {
        super(n, v, vie, l);
        this.degat = d;
        this.description = desc;

    }

    /**
     * methode qui permet à un monstre de soigner une entité
     * @param soin soin que le monstre va administrer à l'entité
     * @param soignee entitée qui va etre soignée
     */
    public void soigner(int soin, Entite soignee) {
        if (!etreMort()) {
            soignee.gagnerPV(soin);
        }
    }

    /**
     * methode qui retourne les degats du monstre
     * @return int degat du monstre
     */
    public int getDegat() {
        return this.degat;
    }

    /**
     * methode qui permet de changer les degats du monstre
     * @param d nouveau degat du monstre
     */
    public void setDegat(int d) {
        this.degat = d;
    }

    /**
     * methode qui retourne la description du monstre
     * @return String description du monstre
     */
    public String getDescription() {
        return this.description;
    }

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
                if(cs!=null && cs.isTraversable()){
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
    }
}
