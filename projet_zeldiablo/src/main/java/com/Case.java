/**
 * Classe Case, represente une case du labyrinthe
 */
public abstract class Case {
    /** Attribut traversable: La case est traversable ou non */
    private boolean traversable;

    /** Constructeur vide de Case */
    Case() {
        this.traversable = false;
    }

    /** Constructeur complet de Case */
    Case(boolean traversable) {
        this.traversable = traversable;
    }
}