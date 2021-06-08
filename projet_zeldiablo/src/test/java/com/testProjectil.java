package com;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import moteurJeu.Commande;

public class testProjectil {
    @Test 
    public void TestParcours(){
        Vec2 posAct = new Vec2(3, 3);
        Vec2 forReal = new Vec2(3,2);
        Vec2 forReal2 = new Vec2(3,1);
        Commande direc = new Commande();
        direc.setBas(true);
        Arme_distance AK = new Arme_distance(10, 2, 30);

        Projectil p1 = new Projectil(posAct, direc, AK);

        ArrayList<Vec2> resultat = new ArrayList<Vec2>();
        resultat = p1.parcours();
        
        ArrayList<Vec2> real = new ArrayList<Vec2>();
        real.add(forReal);
        real.add(forReal2);
        int i=0;
        while(resultat.get(i).isZero() == true ){
            assertEquals(true, resultat.get(i).equals(real.get(i)));
        }
    }
}
