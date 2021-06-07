package com;

public abstract class Monstre extends Entite {
    
    private int degat;
    private String description;

    public Monstre(int d) {
        super("Monstre", d);
    }

    public void soigner(int soin, Entite soignee) {
        if (!etreMort()) {
            soignee.soigner(soin);
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
