package model.Pièges;

import model.Ennemies.Ennemies;
import model.Jeu;

public class Mine extends Piege {

    int degatsDeclenchement;
    int range;
    private static int valeur = 100;

    public Mine(Jeu j, double x, double y) {
        super(j, x, y);
        this.degatsDeclenchement=20;
        this.range=64;
    }

    public void agit(){
        if(this.actif && this.checkEnnemi()) {
            this.activation();
            this.actif = false;
        }
    }

    public boolean checkEnnemi(){
        for (Ennemies n:  this.jeu.getEnnemies()) {
            if((n.getXValues()==this.x || n.getHitboxX()==this.x) && (n.getYValues()==this.y || n.getHitboxY()==this.y)){
                return true;
            }
        }

        return false;
    }

    public void activation(){
        for (Ennemies n:  this.jeu.getEnnemies()) {
            if((n.getXValues()==this.x || n.getHitboxX()==this.x) && (n.getYValues()==this.y || n.getHitboxY()==this.y)){
                 n.prendreDesDgt(this.degatsDeclenchement);
            }
       }
    }

    public static int getValeur() {
        return valeur;
    }

}
