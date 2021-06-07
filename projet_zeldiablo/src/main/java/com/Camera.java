package com;

public class Camera {
    

    /**
     * ATTRIBUTS
     */

     /**
      * position
      */
    private Vec2 pos;

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
        this.pos = e.getPos();
    }


}
