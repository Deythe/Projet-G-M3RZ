package model.Pièges;

import model.Jeu;

public abstract class Piege {
    double x,y;
    boolean actif;
    protected Jeu jeu;

    public Piege(Jeu j, double x, double y){
        this.x=x;
        this.y=y;
        this.jeu=j;
        this.actif=true;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public abstract void agit();

    public abstract boolean checkRange();
}
