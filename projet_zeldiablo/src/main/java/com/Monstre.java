package com;

public abstract class Monstre extends Entite {
    
    private int degat;
    private String description;

    public Monstre(String nom) {
        super(nom);
    }

    public void soigner(int soin, Entite soignee) {
        if (!etreMort()) {
            soignee.soigner(soin);
        }
    }
}
