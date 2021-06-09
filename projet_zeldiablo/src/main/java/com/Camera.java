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

    private boolean reculer = false;
    private int targetTileSize = DessinJeu.TILE_SIZE;

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
        if (reculer) targetTileSize = 70;
        else targetTileSize = 75;
        this.target = e;
        this.pos = this.pos.plus( e.getPos().minus(this.pos).div(4) );
        DessinJeu.TILE_SIZE += (targetTileSize - DessinJeu.TILE_SIZE) / 2.0;
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

    /** Est-ce que la cemra doit agrandir le champ de vision ou non */
    public void doitReculer(boolean state) {
        this.reculer = state;
    }

}
