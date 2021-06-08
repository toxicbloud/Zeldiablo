package com;

public class Arme_distance extends Arme {
    private int munitions;
    private Projectil[] projectil;
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

    /**
     * 
     * @return int range
     */
    public int getRange() {
		return this.range;
	}
    /**
     * set range
     * @param range 
     */
	public void setRange(int range) {
		this.range = range;
	}

    /**
     * 
     * @return int Munitions
     */
	public int getMunitions() {
		return this.munitions;
	}

    /**
     * set Munitions
     */
	public void setMunitions(int munitions) {
		this.munitions = munitions;
	}

    /**
     * charger Munitions
     */
    public void chargerArme(){
        this.munitions += 100;
    }
}
