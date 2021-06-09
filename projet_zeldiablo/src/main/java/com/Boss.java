package com;

public class Boss extends Monstre {
    int range;
    Vec2 posOrigine; // pour tester si posAct est dehors de range de posOrigine
    public Boss(String n, Vec2 v, int vie, int d, String desc, Labyrinthe l, int a, int vit, int range) {
        super(n, v, vie, d, desc, l, a, vit);
        //TODO Auto-generated constructor stub
        this.range=range;
        this.posOrigine=super.getPos();
    }

    public void deplacer(String mouvement) {
        super.deplacer(mouvement);
    } 
    

    @Override
    public void attaquerAutre(Entite e2) {
        // TODO Auto-generated method stub
        
    }
    
}
