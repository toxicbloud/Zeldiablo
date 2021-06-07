package com;

public abstract class Monstre extends Entite {
    
    private int degat;
    private String description;

    public Monstre(String n, Vec2 v, int vie, int d, String desc, Labyrinthe l) {
        super(n, v, vie, l);
        this.degat = d;
        this.description = desc;

    }

    public void soigner(int soin, Entite soignee) {
        if (!etreMort()) {
            soignee.gagnerPV(soin);
        }
    }

    public int getDegat() {
        return this.degat;
    }

    public void setDegat(int d) {
        this.degat = d;
    }

    public String getDescription() {
        return this.description;
    }
}
