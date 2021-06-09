package com;

public  abstract class Arme_COC extends Arme {
    private int energie;

    /**
     * 
     * @param de dégats
     * @param energie energies qui prends pour l'utiliser
     */
    public Arme_COC(int de,int energie){
        super(de, Labyrinthe.TILE_SIZE);
        if (energie<=0) {
            this.energie=1;
        } else {
            this.energie=energie;
        }
    }

    /**
     * donne l'énergie que coute cette arme
     * @return
     */
    public int getEnergie() {
		return this.energie;
	}

    /**
     * initialise l'energie de l'arme
     * @param energie
     */
	public void setEnergie(int energie) {
		this.energie = energie;
	}

}
