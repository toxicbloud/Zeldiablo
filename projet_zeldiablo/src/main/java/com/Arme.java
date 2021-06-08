package com;

/**
 * Arme
 */
public abstract class Arme {
    
    private Entite possesseur;
    private int degats;
    private int vitesse;
    private int range ; 


    public Arme(int de, int range){
        if (de<=0) {
            this.degats=1;
        }
        else{
            this.degats=de;
        }
        if (range<=0) {
            this.range=5;
        } else {
            this.range=range;
        }
    }

    public Arme(int de, int r) {
        this.degats = de;
        this.range = r;
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

    public Entite getPossesseur() {
        return possesseur;
    }
    public void setPossesseur(Entite possesseur) {
        this.possesseur = possesseur;
    }
    public int getRange() {
        return range;
    }
    public void setRange(int range) {
        this.range = range;
    }
}