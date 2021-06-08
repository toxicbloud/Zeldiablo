package com;

import java.util.ArrayList;

import moteurJeu.Commande;

public class Projectil {
    private Vec2 posAct ; 
    private Commande direction;
    private Arme origine;

    public Projectil(Vec2 pos,  Commande direc, Arme possedeur ){
        this.posAct = pos;
        this.direction = direc;
        this.origine = possedeur;
    }

    public Vec2[] parcours(){
        int lim = this.origine.getRange();
        ArrayList<Vec2> parcours = new ArrayList<Vec2>();
        if (this.direction.isBas() == true) {
            for (int i = 0; i < lim; i++) {
                parcours.get(i).x = ((this.posAct.x));
                parcours.get(i).y = ((this.posAct.y) -1 -i);
            }
        }

        if (this.direction.isHaut() == true) {
            for (int i = 0; i < lim; i++) {
                parcours.get(i).x = ((this.posAct.x));
                parcours.get(i).y = ((this.posAct.y) +1 +i);
            }
        }

        if (this.direction.isDroite() == true) {
            for (int i = 0; i < lim; i++) {
                parcours.get(i).x = ((this.posAct.x) +1 +i);
                parcours.get(i).y = ((this.posAct.y) );
            }
        }

        if (this.direction.isGauche() == true) {
            for (int i = 0; i < lim; i++) {
                parcours.get(i).x = ((this.posAct.x)  -1 -i);
                parcours.get(i).y = ((this.posAct.y) );
            }
        }

        return parcours();
    }
}
