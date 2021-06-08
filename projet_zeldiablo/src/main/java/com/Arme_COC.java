package com;

public  abstract class Arme_COC extends Arme {
    private int energie;

    /**
     * 
     * @param de dégats
     * @param energie energies qui prends pour l'utiliser
     */
    public Arme_COC(int de,int energie){
        super(de, 5);
        if (energie<=0) {
            this.energie=1;
        } else {
            this.energie=energie;
        }
    }

    public int getEnergie() {
		return this.energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}

}
