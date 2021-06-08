package com;

public class Arme_distance extends Arme {
    private int range ; 
    private int munitions;
    // Mettre projectile apres
    /**
     * 
     * @param de dégats
     * @param range range de Arme
     * @param munitions munitions de Arme
     */
    public Arme_distance(int de, int range, int munitions){
        super(de);
        if (range<=0) {
            this.range=5;
        } else {
            this.range=range;
        }
        if (munitions<=0) {
            this.munitions=5;
        } else {
            this.munitions=munitions;
        }
    }

    public void chargerArme(){
        this.munitions += 100;
    }
}
