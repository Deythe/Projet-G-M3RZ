package model.Pièges;

import model.Ennemies.Ennemies;
import model.Jeu;

public class Ressort extends Piege {
    private int recharge;

    public Ressort( Jeu j, double x, double y) {
        super(j, y, x);
    }

    @Override
    public void agit() {
        if(this.actif){
            activation();
        }
    }

    @Override
    public boolean checkRange(){
        for (Ennemies n:  this.jeu.getEnnemies()) {
            if((n.getXValues()==this.x || n.getHitboxX()==this.x) && (n.getYValues()==this.y || n.getYValues()==this.y)){
                System.out.println("test");
                return true;
            }
        }

        return false;
    }

    public void activation(){
        for (Ennemies n:  this.jeu.getEnnemies()) {
            if(n.getXValues()==this.x && n.getYValues()==this.y){
                this.actif=false;
            }
        }
    }

}
