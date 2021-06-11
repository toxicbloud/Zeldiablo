package com;

/**
 * Arme
 */
public abstract class Arme {
    
    private Entite possesseur;
    private int degats;
    private int vitesse;
    private int range ; 


    /**
     * Constructeur de arme
     * @param de degats
     */
    public Arme(int de){
        if (de<=0) {
            this.degats=1;
        }
        else{
            this.degats=de;
        }
    }

    /**
     * Constructeur de arme
     * @param de degats
     * @param r range
     */
    public Arme(int de, int r) {
        if (de <0) {
            this.degats=1;
        }
        else{
            this.degats = de;
        }
        this.range=r;
    }

    /**
     * attaque une entité
     * @param e1 entité à attaquer
     */
    public void attaquer(Entite e1){
        e1.perdrePV(degats);
    }

    /**
     * donne les degats
     * @return degats
     */
    public int getDegats() {
		return this.degats;
	}

    /**
     * initialise les degats
     * @param degats
     */
	public void setDegats(int degats) {
		this.degats = degats;
	}

    /**
     * donne la vitesse
     * @return vitesse
     */
	public int getVitesse() {
		return this.vitesse;
	}

    /**
     * initialise la vitesse
     * @param vitesse
     */
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

    /**
     * donne le possesseur
     * @return l'entité
     */
    public Entite getPossesseur() {
        return possesseur;
    }

    /**
     * initialise le possesseur
     * @param possesseur
     */
    public void setPossesseur(Entite possesseur) {
        this.possesseur = possesseur;
    }

    /**
     * donne la range
     * @return range
     */
    public int getRange() {
        return range;
    }

    /**
     * initialise la range
     * @param range
     */
    public void setRange(int range) {
        this.range = range;
    }
}