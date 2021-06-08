package com;

/**
 * Arme
 */
public abstract class Arme {
    private Entite possesseur;
    private int degats;
    private int vitesse;
<<<<<<< HEAD
    private int range ; 
=======
    

>>>>>>> eaf5083e78f2ed9b11ffcfd2775bd0a8875f07e6


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