package com;

public class Camera {
    

    /**
     * ATTRIBUTS
     */

     /**
      * position
      */
    private Vec2 pos;
    
    /** Debuggage avec un mouvement de camera */
    private int i;

    /**
     * cible
     */
    private Entite target;

    /**
     * Constructeur Camera
     * @param cible Entite ciblée
     */
    public Camera(Entite cible) {
        this.target = cible;
        this.pos = cible.getPos();
    }

    /**
     * déplace la caméra vers la cible, change les attributs
     * @param e nouvelle cible
     */
    public void deplacer(Entite e) {
        this.target = e;
        Vec2 newPos = (e.getPos().minus(this.pos));
        this.pos = e.getPos();

        //DessinJeu.TILE_SIZE = (int) (Math.cos((i++/10.0)) * 4 + 60);
    }

    public Vec2 getPos() {
        return pos;
    }

    public void setPos(Vec2 pos) {
        this.pos = pos;
    }

    public Entite getTarget() {
        return target;
    }

    public void setTarget(Entite target) {
        this.target = target;
    }

}
