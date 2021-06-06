package com;
/**
 * Classe Case, represente une case du labyrinthe
 */
public abstract class Case {

    /**
     * ATTRIBUTS
     */

    /** Attribut traversable: La case est traversable ou non */
    private boolean traversable;

    /**
     * CONSTRUCTEURS
     */

    /** Constructeur vide de Case */
    Case() {
        this.traversable = false;
    }

    /** Constructeur complet de Case */
    Case(boolean traversable) {
        this.traversable = traversable;
    }

    /**
     * GETTERS /SETTERS
     */

    /**
     * Getter de l'attribut traversable
     * @return si la case est traversable ou non
     */
    public boolean isTraversable() {
        return traversable;
    }
}