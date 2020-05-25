package model;

public abstract class Piege {
    double x,y;
    boolean actif;
    protected Jeu jeu;
    public Piege(double x, double y,Jeu j){
        this.x=x;
        this.y=y;
        this.jeu=j;
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
}
