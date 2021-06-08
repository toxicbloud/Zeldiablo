package com;

import moteurJeu.DessinJeu;
import moteurJeu.MoteurGraphique;

public class Main {
    
    public static void main(String[] args) {
        Jeu j = new Jeu("Celestia");
        DessinJeu dj = new com.DessinJeu(j);

        MoteurGraphique mg = new MoteurGraphique(j, dj);

        try {
            mg.lancerJeu(900, 600);

        } catch (Exception e) {
            
        }
    }
}
