package com;

/**
 * Arme
 */
public abstract class Arme {
    private int degats;
    private int vitesse;
    



    public Arme(int de){
        if (de<=0) {
            this.degats=1;
        }
        else{
            this.degats=de;
        }
    }
    public void attaquer(Entite e1){
        e1.perdrePV(degats);
    }

    public int getDegats() {
		return this.degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

	public int getVitesse() {
		return this.vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
}