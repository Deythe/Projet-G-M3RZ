package model.Pièges;

import model.Jeu;

public abstract class Piege {
    double x,y;
    boolean actif;
    private static int nbPiege=1;
    private String id;
    protected Jeu jeu;
    private static int valeur = 100;

    public Piege(Jeu j, double x, double y){
        this.x=x;
        this.y=y;
        this.jeu=j;
        this.actif=true;
        this.id = "P"+nbPiege;
        nbPiege++;
        System.out.println("Piège placé");
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

    public abstract boolean checkEnnemi();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
