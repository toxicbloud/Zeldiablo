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
        super(de,range);
        
        if (munitions<=0) {
            this.munitions=5;
        } else {
            this.munitions=munitions;
        }
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
