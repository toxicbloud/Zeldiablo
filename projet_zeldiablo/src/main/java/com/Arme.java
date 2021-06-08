package com;

/**
 * Arme
 */
public abstract class Arme {
    private Entite possesseur;
    private int degats;
    private int vitesse;
<<<<<<< HEAD
    private int range;

=======
<<<<<<< HEAD
    private int range ; 
=======
    
>>>>>>> 940e16ef46974ffcc59f5e6dbb0c4062c1b059fa

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

    
	public int getRange() {
		return this.range;
	}

	public void setRange(int range) {
		this.range = range;
	}

}