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
    private int shakeAmount;

    /**
     * Constructeur Camera
     * @param cible Entite ciblée
     */
    public Camera(Entite cible) {
        this.target = cible;
        this.pos = cible.getPos();
        this.shakeAmount = 0;
    }

    /**
     * déplace la caméra vers la cible, change les attributs
     * @param e nouvelle cible
     */
    public void deplacer(Entite e) {
        if (reculer) targetTileSize = 75;
        else targetTileSize = 90;
        this.target = e;
        Vec2 newPos = this.pos.plus( e.getPos().minus(this.pos).div(4) );
        newPos = newPos.plus(new Vec2((int)((Math.random()-0.5)*shakeAmount), (int)((Math.random()-0.5)*shakeAmount)));
        this.pos = newPos;
        if (this.shakeAmount > 0) this.shakeAmount--;
        DessinJeu.TILE_SIZE += (targetTileSize - DessinJeu.TILE_SIZE) / 2.0;
    }

    public void shake() {
        this.shakeAmount = 5;
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
