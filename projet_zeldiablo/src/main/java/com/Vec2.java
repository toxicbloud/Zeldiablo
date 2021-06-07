package com;
public class Vec2{
    /**Coordonnee sur x*/
    public int x;
    /**Coordonnee sur y*/
    public int y;
    /**
     * Constructeur vide de Vec2
     */
    public Vec2() {
        this.x = 0;
        this.y = 0;
    }
    /**
     * Constructeur complet de Vec2
     * @param x coordonnee sur x
     * @param y coordonnee sur y
     */
    public Vec2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Addition de Vec2
     * @param v Vec2 a ajouter
     * @return un Vec2 correpondant a l'addition
     */
    public Vec2 plus(Vec2 v) {
        Vec2 r = new Vec2(this.x + v.x, this.y + v.y);
        return r;
    }
    /**
     * Soustraction de Vec2
     * @param v Vec2 a soustraire
     * @return un Vec2 correpondant a la soustraction
     */
    public Vec2 minus(Vec2 v) {
        Vec2 r = new Vec2(this.x - v.x, this.y - v.y);
        return r;
    }
    /**
     * Multiplication de Vec2
     * @param v Vec2 a mutliplier
     * @return un Vec2 correpondant a la multiplication
     */
    public Vec2 times(Vec2 v) {
        Vec2 r = new Vec2(this.x * v.x, this.y * v.y);
        return r;
    }
    /**
     * Division de Vec2
     * @param v Vec2 a division
     * @return un Vec2 correpondant a la division
     */
    public Vec2 div(Vec2 v) {
        Vec2 r = new Vec2(this.x / v.x, this.y / v.y);
        return r;
    }
    /**
     * Egualite de Vec2
     * @param v Vec2 a tester
     * @return un booleen si les Vec2 sont egaux
     */
    public boolean equals(Vec2 v) {
        return this.x == v.x && this.y == v.y;
    }
    /**
     * Test su le Vec2 est egual a 0
     * @return un booleen si le Vec2 est egual a 0
     */
    public boolean isZero() {
        return this.x == 0 && this.y == 0;
    }
    
    /**
     * Representation en chaine de caracteres du Vec2
     * @return representation ecrite du Vec2
     */
    public String toString() {
        return "("+this.x+", "+this.y+")";
    }
}