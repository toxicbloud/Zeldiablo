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

    public void deplacer(String Mouvement){
        super.deplacer(Mouvement);
        int testOx = this.getPos().x - this.posOrigine.x;
        int testOy = this.getPos().y - this.posOrigine.y;
        
        if (Math.abs(testOx)>this.range || Math.abs(testOy)>this.range ) {
            switch (Mouvement) {
                case "Gauche":
                setPos(new Vec2((getPos().x)+(this.getVitesse()), getPos().y));
                    break;
                case "Droite":
                setPos(new Vec2((getPos().x)-(this.getVitesse()), getPos().y));
                    break;
                
                case "Haute":
                setPos(new Vec2(  getPos().x, getPos().y -(this.getVitesse()))) ;
                    break;

                case "Bas":
                setPos(new Vec2(  getPos().x, getPos().y +(this.getVitesse()))) ;
                    break;
                default:
                    break;
            }
        }
    }
    

    @Override
    public void attaquerAutre(Entite e2) {
        // TODO Auto-generated method stub
        
    }
    
}
