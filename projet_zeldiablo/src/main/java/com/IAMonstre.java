package com;

import java.util.*;

public class IAMonstre {
    
    private int[][] laby, soluc;
    private Labyrinthe lab;
    private Monstre m;
    private ArrayList<Vec2> path;
    private boolean occupee = false, bloquee = false;

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
        System.out.println("resolution du trajet");
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
            return false;
        }
        if (!emplacementValide(x2, y2)) {
            System.out.println("destination pas valide");
            return false;
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
        return true;
    }

    public boolean deplacementAB(int x, int y) {
        System.out.println("deplacement AB");
        for (int i = 1; i < path.size(); i++) {
            Vec2 c = path.get(i);
            System.out.println(path.size());
            boolean fini = false;
            System.out.println(m + " a pour position :" + deLabALaby(m.getPos().y) + " " + deLabALaby(m.getPos().x));
            if (deLabALaby(m.getPos().x) > c.x) {
                System.out.println("Deplacement à gauche");
                while (!fini) {
                    System.out.println("yo");
                    bloquee = m.deplacer("Gauche");
                    System.out.println("yo1");
                    if (deLabALaby(m.getPos().x) == c.x) {
                        System.out.println("yo2");
                        fini = true;
                        System.out.println("yo3");
                    }
                    System.out.println("yo4");
                    if (!bloquee) {
                        System.out.println("y5");
                        this.occupee = false;
                        System.out.println("yo6");
                        return false;
                    }
                }
            }else if (deLabALaby(m.getPos().x) < c.x) {
                System.out.println("Deplacement à droite");
                while (!fini) {
                    System.out.println("yo");
                    bloquee = m.deplacer("Droite");
                    System.out.println("yo1");
                    if (deLabALaby(m.getPos().x) == c.x) {
                        System.out.println("yo2");
                        fini = true;
                        System.out.println("yo3");
                    }
                    System.out.println("yo4");
                    if (!bloquee) {
                        System.out.println("yo5");
                        this.occupee = false;
                        System.out.println("yo6");
                        return false;
                    }
                }
            }else if (deLabALaby(m.getPos().y) > c.y) {
                System.out.println("Deplacement en haut");
                while (!fini) {
                    System.out.println("yo");
                    bloquee = m.deplacer("Haut");
                    System.out.println("y1");
                    if (deLabALaby(m.getPos().y) == c.y) {
                        System.out.println("yo2");
                        fini = true;
                        System.out.println("yo3");
                    }
                    System.out.println("yo4");
                    if (!bloquee) {
                        System.out.println("yo5");
                        this.occupee = false;
                        System.out.println("yo6");
                        return false;
                    }
                }
            }else{
                System.out.println("Deplacement en bas");
                while (!fini) {
                    System.out.println("yo");
                    bloquee = m.deplacer("Bas");
                    System.out.println("yo1");
                    if (deLabALaby(m.getPos().y) == c.y) {
                        System.out.println("yo2");
                        fini = true;
                        System.out.println("yo3");
                    }
                    System.out.println("yo4");
                    if (!bloquee) {
                        System.out.println("yo5");
                        this.occupee = false;
                        System.out.println("yo6");
                        return false;
                    }
                }
            }
        }
        this.occupee = false;
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
            if (b) {
                boolean booboo = deplacementAB(x, y);
                System.out.println("ah");
                if (booboo) {
                    System.out.println("oh");
                    m.setPos(new Vec2(m.getPos().x, m.getPos().y));
                    System.out.println("ouh");
                }
                System.out.println("oh oui");
            }
        }
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