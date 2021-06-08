package com;
/**
 * classe qui représente les différents monstres du jeu
 */
public abstract class Monstre extends Entite {
    
    private int degat, vitesse;
    private String description;
    private int attente; //Ce parametre permet de savoir le laps de temps entre chaque deplacement du monstre, plus le nombre ce rapproche de 100, plus il est lent et plus il se rapproche de 0, plus il ets rapide
    /**
     * constructeur de monstre
     * @param n nom de l'entite
     * @param vie point de Vie de l'entité
     * @param v position
     * @param l Labyrinthe de l Entite
     * @param d dégât du monstre
     * @param desc description du monstre
     * @param a délai entre chaque déplacement du monstre
     * @param v vitesse de déplacement du monstre
     */
    public Monstre(String n, Vec2 v, int vie, int d, String desc, Labyrinthe l, int a, int vit) {
        super(n, v, vie, l);
        this.degat = d;
        this.description = desc;
        this.attente = a;
        this.vitesse = vit;

    }

    /**
     * methode qui permet à un monstre de soigner une entité
     * @param soin soin que le monstre va administrer à l'entité
     * @param soignee entitée qui va etre soignée
     */
    public void soigner(int soin, Entite soignee) {
        if (!etreMort()) {
            soignee.gagnerPV(soin);
        }
    }

    /**
     * methode qui retourne les degats du monstre
     * @return int degat du monstre
     */
    public int getDegat() {
        return this.degat;
    }

    /**
     * methode qui permet de changer les degats du monstre
     * @param d nouveau degat du monstre
     */
    public void setDegat(int d) {
        this.degat = d;
    }

    /**
     * methode qui retourne la description du monstre
     * @return String description du monstre
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * methode qui permet à un monstre de se déplacer de manière aléatoire
     */
    public void deplacer() {
        int att = (int)(Math.random() * 101);
        Case ul=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2((int)(getTaille().x*0.2),0)));
        Case ur=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2((int)(getTaille().x*0.8),0)));
        Case lu=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(0,(int)(getTaille().y*0.2))));
        Case ld=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(0,(int)(getTaille().y*0.8))));
        Case dl=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2((int)(getTaille().x*0.2),getTaille().y)));
        Case dr=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2((int)(getTaille().x*0.8),getTaille().y)));
        Case ru=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(getTaille().x,(int)(getTaille().y*0.2))));
        Case rd=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(getTaille().x,(int)(getTaille().y*0.8))));
        int rand = (int)(Math.random() * 4);
        if (att >= this.attente) {
            switch(rand) {
                case 0:
                    if(lu!=null && ld!=null && lu.isTraversable() && ld.isTraversable()) {
                        setPos(new Vec2((getPos().x)-(this.vitesse), getPos().y));
                    }
                    break;
                case 1:
                    if(ru!=null && rd!=null && ru.isTraversable() && rd.isTraversable()) {
                        setPos(new Vec2((getPos().x)+(this.vitesse), getPos().y));
                    }
                    break;
                case 2:
                    if(ul!=null && ur!=null && ul.isTraversable()&& ur.isTraversable()) {
                        setPos(new Vec2(getPos().x, (getPos().y)-(this.vitesse)));
                    }
                    break;
                case 3: 
                    if(dl!=null && dr!=null && dl.isTraversable() &&  dr.isTraversable()){
                        setPos(new Vec2(getPos().x, (getPos().y)+(this.vitesse)));
                    }
                    break;
                default:
                    if(dl!=null && dr!=null && dl.isTraversable() &&  dr.isTraversable()){
                        setPos(new Vec2(getPos().x, (getPos().y)+(this.vitesse)));
                    }
            }
        }
    } 
}
