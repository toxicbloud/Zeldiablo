package com;
import java.awt.Color;
/**
 * Classe Case, represente une case du labyrinthe
 */
public abstract class Case {

    /**
     * ATTRIBUTS
     */

    /** Attribut traversable: La case est traversable ou non */
    private boolean traversable;

    /** Attribut sprite: le sprite de la case (temporairement une couleur) */
    private Color sprite;

    /**
     * CONSTRUCTEURS
     */

    /** Constructeur vide de Case */
    Case() {
        this.traversable = false;
    }

    /** Constructeur complet de Case */
    Case(boolean traversable, Color c) {
        this.traversable = traversable;
        this.sprite = c;
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

    /**
     * Getter de l'attribut sprite
     * @return le sprite de la case (temporairement une couleur)
     */
    public Color getSprite() {
        return sprite;
    }
}