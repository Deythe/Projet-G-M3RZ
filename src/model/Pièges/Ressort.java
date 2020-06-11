package model.Pièges;

import model.Ennemies.Ennemies;
import model.Jeu;

public class Ressort extends Piege {
    private Ennemies cible;
    private static int valeur = 100;

    public Ressort( Jeu j, double x, double y) {
        super(j, x, y);
        this.cible=null;
    }

    @Override
    public void agit() {
        checkEnnemi();
        if(this.actif && this.cible!=null){
            activation();
            this.actif=false;
        }
    }

    @Override
    public boolean checkEnnemi(){
        for (Ennemies n:  this.jeu.getEnnemies()) {
            if((n.getXValues()==this.x || n.getHitboxX()==this.x) && (n.getYValues()==this.y || n.getHitboxY()==this.y)){
                this.cible=n;
                return true;
            }
        }

        return false;
    }

    public void activation(){
        this.cible.SetX(0);
        this.cible.SetY(128);
        this.cible.setSommetActu(this.cible.checkSommet());
        this.cible=null;
    }

    public static int getValeur() {
        return valeur;
    }

}
