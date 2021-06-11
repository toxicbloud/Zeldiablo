package com;

import java.util.*;

/**
 * CLASSE IAMONSTRE NON FINIE: Code trop complexe a debugger (et manque de temps)
 */
public class IAMonstre {
    
    private int[][] laby, soluc;
    private Labyrinthe lab;
    private Monstre m;
    private ArrayList<Vec2> path;
    private boolean occupee = false, bloquee = false;
    private int i;

    public IAMonstre(Monstre monstre, Labyrinthe l) {
        this.lab = l;
        this.m = monstre;
        this.path = new ArrayList<>();
        laby = new int[this.lab.getSize()][this.lab.getSize()];
        Case[][] c = this.lab.getCases();
        for (int i = 0; i < this.lab.getSize(); i++) {
            for (int j = 0; j < this.lab.getSize(); j++) {
                if (!c[i][j].isTraversable()) {
                    laby[j][i] = 0;
                }else{
                    laby[j][i] = 1;
                }
            }
        }
    }

    public boolean emplacementValide(int x, int y) {
        if (laby[y][x] == 0) {
            return false;
        }else{
            return true;
        }
    }

    public boolean resolutionTrajet(int x2, int y2) {
        i = 0;
        int x1 = deLabALaby(m.getPos().x);
        int y1 = deLabALaby(m.getPos().y);
        Case[][] c = this.lab.getCases();
        for (int i = 0; i < this.lab.getSize(); i++) {
            for (int j = 0; j < this.lab.getSize(); j++) {
                if (!c[i][j].isTraversable()) {
                    laby[j][i] = 0;
                }else{
                    laby[j][i] = 1;
                }
            }
        }
        soluc = laby;
        boolean finiTotal = false;
        boolean fini = false;
        int currentx, currenty, lastx, lasty, nbMouvement = 0;
        ArrayList<Vec2> mouvement;
        if (!emplacementValide(x1, y1)) {
            System.out.println("emplacement monstre pas valide");
            
        }
        if (!emplacementValide(x2, y2)) {
            System.out.println("destination pas valide");
            
        }
        currentx = y1;
        currenty = x1;
        lastx = 0;
        lasty = 0;
        soluc[currentx][currenty] = 1;
        mouvement = new ArrayList<Vec2>();
        while (!finiTotal) {
            fini = false;
            while (!fini) {   
                if (laby[currentx + 1][currenty] == 1) {
                    lastx = currentx;
                    lasty = currenty;
                    soluc[currentx][currenty] = 2;
                    currentx += 1;
                    nbMouvement += 1;
                    mouvement.add(new Vec2(lastx, lasty));
                    continue;
                }
                if (laby[currentx][currenty + 1] == 1) {
                    lasty = currenty;
                    lastx = currentx;
                    soluc[currentx][currenty] = 2;
                    currenty += 1;
                    nbMouvement += 1;
                    mouvement.add(new Vec2(lastx, lasty));
                    continue;
                }
                if (laby[currentx - 1][currenty] == 1) {
                    lastx = currentx;
                    lasty = currenty;
                    soluc[currentx][currenty] = 2;
                    currentx -= 1;
                    nbMouvement += 1;
                    mouvement.add(new Vec2(lastx, lasty));
                    continue;
                }
                if (laby[currentx][currenty - 1] == 1) {
                    lastx = currentx;
                    lasty = currenty;
                    soluc[currentx][currenty] = 2;
                    currenty -= 1;
                    nbMouvement += 1;
                    mouvement.add(new Vec2(lastx, lasty));
                    continue;
                }
                if (y2 == currentx && x2 == currenty) {
                    fini = true;
                    finiTotal = true;
                    continue;
                }
                soluc[currentx][currenty] = 4;
                currentx = lastx;
                currenty = lasty;
                nbMouvement -= 1;
                if (nbMouvement == 0) {
                    lastx = 0;
                    lasty = 0;
                    mouvement.remove(mouvement.get(nbMouvement));
                }else{
                    lastx = mouvement.get(nbMouvement-1).x;
                    lasty = mouvement.get(nbMouvement-1).y;
                    mouvement.remove(mouvement.get(nbMouvement));
                }
            }
        }
        mouvement.add(new Vec2(x2, y2));
        this.path = mouvement;
        this.occupee = true;
        System.out.println("position de fin: "+this.path.get(this.path.size()-1));
        return true;
    }

    public boolean deplacementAB(int x, int y) {
            Vec2 c = path.get(i);
            System.out.println("position actuelle: "+c);
            if (deLabALaby(m.getPos().x) > c.x) {
                if (deLabALaby(m.getPos().x) == c.x) {
                    i++;
                }
                if (!bloquee) {
                    return false;
                }
            }else if (deLabALaby(m.getPos().x) < c.x) {
                bloquee = m.deplacer("Droite");
                if (deLabALaby(m.getPos().x) == c.x) {
                    i++;
                }
                if (!bloquee) {
                    return false;
                }
            }else if (deLabALaby(m.getPos().y) > c.y) {
                bloquee = m.deplacer("Haut");
                if (deLabALaby(m.getPos().y) == c.y) {
                    i++;
                }
                if (!bloquee) {
                    return false;
                }
            }else{
                bloquee = m.deplacer("Bas");
                if (deLabALaby(m.getPos().y) == c.y) {
                    i++;
                }
                if (!bloquee) {
                    return false;
                }
            }
        this.occupee = this.path.get(this.path.size()-1).x == deLabALaby(m.getPos().x) && 
                       this.path.get(this.path.size()-1).y == deLabALaby(m.getPos().y);
        return true;
    }

    public void deplacement() {
        if (!occupee) {
            int x = 0, y = 0;
            boolean bon = false;
            while (!bon) {
                x = (int)(Math.random() * (lab.getSize()));
                y = (int)(Math.random() * (lab.getSize()));
                if (emplacementValide(x, y)) {
                    bon = true;
                }
            }
            boolean b = resolutionTrajet(x, y);
        }
        boolean booboo = deplacementAB(this.path.get(this.path.size()-1).x, this.path.get(this.path.size()-1).y);
    }

    public int deLabALaby(int x) {
        return x/(Labyrinthe.TILE_SIZE);
    }

    public int deLabyALab(int x) {
        return x*(Labyrinthe.TILE_SIZE);
    }

    public Labyrinthe getLab() {
        return this.lab;
    }
}