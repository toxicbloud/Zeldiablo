package com;

import java.util.*;

public class IAMonstre {
    
    private int[][] laby, soluc;
    private Labyrinthe lab;
    private Monstre m;

    public IAMonstre(Monstre monstre, Labyrinthe l) {
        this.lab = l;
        this.m = monstre;
        Case[][] c = this.lab.getCases();
        for (int i = 0; i < laby.length; i++) {
            for (int j = 0; i < laby.length; j++) {
                if (c[i][j] instanceof Mur) {
                    laby[i][j] = 0;
                }else{
                    laby[i][j] = 1;
                }
            }
        }
    }

    public boolean emplacementValide(int x, int y) {
        if (laby[x][y] == 0) {
            return false;
        }else{
            return true;
        }
    }

    public boolean resolutionTrajet(int x2, int y2) {
        int x1 = m.getPos().x;
        int y1 = m.getPos().y;
        soluc = laby;
        boolean finiTotal = false;
        boolean fini = false;
        int currentx, currenty, lastx, lasty, nbMouvement = 0;
        ArrayList<Vec2> mouvement;
        if (!emplacementValide(x1, y1)) {
            return false;
        }
        if (!emplacementValide(x2, y2)) {
            return false;
        }
        currentx = x1;
        currenty = y1;
        lastx = 0;
        lasty = 0;
        soluc[currentx][currenty] = 1;
        mouvement = new ArrayList<Vec2>();
        while (!finiTotal) {
            fini = false;
            while (!fini) {
                if (laby[currentx++][currenty] == 1) {
                    lastx = currentx;
                    soluc[currentx][currenty] = 2;
                    currentx++;
                    nbMouvement++;
                    mouvement.add(new Vec2(lastx, lasty));
                    continue;
                }
                if (laby[currentx][currenty++] == 1) {
                    lasty = currenty;
                    soluc[currentx][currenty] = 2;
                    currenty++;
                    nbMouvement++;
                    mouvement.add(new Vec2(lastx, lasty));
                    continue;
                }
                if (laby[currentx--][currenty] == 1) {
                    lastx = currentx;
                    soluc[currentx][currenty] = 2;
                    currentx--;
                    nbMouvement++;
                    mouvement.add(new Vec2(lastx, lasty));
                    continue;
                }
                if (laby[currentx][currenty--] == 1) {
                    lasty = currenty;
                    soluc[currentx][currenty] = 2;
                    currenty--;
                    nbMouvement++;
                    mouvement.add(new Vec2(lastx, lasty));
                    continue;
                }
                if (x2 == currentx && y2 == currenty) {
                    fini = true;
                    finiTotal = true;
                }
            
                soluc[currentx][currenty] = 0;
                currentx = lastx;
                currenty = lasty;
                nbMouvement--;
                lastx = mouvement.get(nbMouvement-1).x;
                lasty = mouvement.get(nbMouvement-1).y;
            }
        }
        return false;
    }

    public void deplacementAB(int x, int y) {
        int x1 = m.getPos().x;
        int y1 = m.getPos().y;
        boolean trajet = false, arrive = false, chemin = false;
        while(!arrive) {
            trajet = false;
            while(!trajet) {
                if (laby[x1++][y1] == 1) {
                    while(!chemin) {
                        m.deplacer("Droite");
                        if (m.getPos().x == x1++){
                            x1++;
                            chemin = true;
                        }
                    }
                    continue;
                }
                if (laby[x1][y1++] == 1) {
                    while(!chemin) {
                        m.deplacer("Bas");
                        if (m.getPos().y == y1++){
                            y1++;
                            chemin = true;
                        }
                    }
                    continue;
                }
                if (laby[x1--][y1] == 1) {
                    while(!chemin) {
                        m.deplacer("Gauche");
                        if (m.getPos().x == x1--){
                            x1--;
                            chemin = true;
                        }
                    }
                    continue;
                }
                if (laby[x1][y1--] == 1) {
                    while(!chemin) {
                        m.deplacer("Bas");
                        if (m.getPos().y == y1--){
                            y1--;
                            chemin = true;
                        }
                    }
                    continue;
                }
                if (m.getPos().x == x && m.getPos().y == y) {
                    trajet = true;
                    arrive = true;
                }
            }
        }
    }
}
