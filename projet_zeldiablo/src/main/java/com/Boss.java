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

    public void deplacer(String Mouvement) {
        Case ul=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2((int)(getTaille().x*0.2),0)));
        Case ur=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2((int)(getTaille().x*0.8),0)));
        Case lu=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(0,(int)(getTaille().y*0.2))));
        Case ld=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(0,(int)(getTaille().y*0.8))));
        Case dl=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2((int)(getTaille().x*0.2),getTaille().y)));
        Case dr=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2((int)(getTaille().x*0.8),getTaille().y)));
        Case ru=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(getTaille().x,(int)(getTaille().y*0.2))));
        Case rd=getLabyrinthe().getCaseAtVec2(this.getPos().plus(new Vec2(getTaille().x,(int)(getTaille().y*0.8))));
        int testOx=0;
        int testOy=0;
            switch(Mouvement) {
                case "Gauche":
                    if(lu!=null && ld!=null && lu.isTraversable() && ld.isTraversable()) {
                        // tourner à Gauche
                        setPos(new Vec2( (getPos().x)-(this.getVitesse() ), getPos().y));
                        testOx = this.getPos().x-this.posOrigine.x;
                        testOy = this.getPos().y-this.posOrigine.y;
                        // Si c'est Dehors de range
                        if ( Math.abs(testOx)> range || Math.abs(testOy)>range  ) {
                            // On va tourner à Droit
                            setPos(new Vec2((getPos().x)+(this.getVitesse()), getPos().y));
                        }
                    }
                    break;
                case "Droite":
                    if(ru!=null && rd!=null && ru.isTraversable() && rd.isTraversable()) {
                        // tourner à Droite
                        setPos(new Vec2((getPos().x)+(this.getVitesse()), getPos().y));
                        testOx = this.getPos().x-this.posOrigine.x;
                        testOy = this.getPos().y-this.posOrigine.y;
                        // Si c'est Dehors de range
                        if ( Math.abs(testOx)> range || Math.abs(testOy)>range  ) {
                            // On va tourner à Gauche
                            setPos(new Vec2( (getPos().x)-(this.getVitesse() ), getPos().y));
                        }
                    }
                    break;
                case "Haute":
                    if(ul!=null && ur!=null && ul.isTraversable()&& ur.isTraversable()) {
                        // Aller Haute
                        setPos(new Vec2(getPos().x, (getPos().y)-(this.getVitesse())));
                        testOx = this.getPos().x-this.posOrigine.x;
                        testOy = this.getPos().y-this.posOrigine.y;
                        // Si c'est Dehors de range
                        if ( Math.abs(testOx)> range || Math.abs(testOy)>range  ) {
                            // On va aller au bas
                            setPos(new Vec2(getPos().x, (getPos().y)+(this.getVitesse())));
                        }
                    }
                    break;
                case "Bas": 
                    if(dl!=null && dr!=null && dl.isTraversable() &&  dr.isTraversable()){
                        // Aller Bas
                        setPos(new Vec2(getPos().x, (getPos().y)+(this.getVitesse())));
                        testOx = this.getPos().x-this.posOrigine.x;
                        testOy = this.getPos().y-this.posOrigine.y;
                        // Si c'est Dehors de range
                        if ( Math.abs(testOx)> range || Math.abs(testOy)>range  ) {
                            // On va Aller Haute
                            setPos(new Vec2(getPos().x, (getPos().y)-(this.getVitesse())));
                        }
                    
                    break;
        }
    } 

    @Override
    public void attaquerAutre(Entite e2) {
        // TODO Auto-generated method stub
        
    }
    
}
