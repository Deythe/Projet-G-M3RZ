package model.Pièges;

import model.Ennemies.Ennemies;
import model.Jeu;
import model.Pièges.Piege;

public class Trappe extends Piege {
    boolean ouvert;
    int tourDebut;
    public Trappe(Jeu j, double x, double y) {
        super(j, x, y);
        this.actif=true;
    }

    public void agit(){

        if (!this.ouvert && this.actif){
            if (this.jeu.getNbTour()==this.tourDebut+1000){
                this.actif=false;
                this.ouvert=true;
            }else {
                this.activation();
            }
        }else{
            this.ouverture();
        }
    }

    public void ouverture(){
        if(this.actif && this.checkEnnemi()){
            this.actif=true;
            this.tourDebut=this.jeu.getNbTour();
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

    public void activation() {
        for (Ennemies n:  this.jeu.getEnnemies()) {
            if((n.getXValues()==this.x || n.getHitboxX()==this.x) && (n.getYValues()==this.y || n.getHitboxY()==this.y)){
                n.setPvValue(0);
                System.out.println(this.jeu.getNbTour());
            }
        }
    }

}
