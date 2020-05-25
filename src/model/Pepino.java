package model;

public class Pepino extends Ennemi {
    private int prime;

    public Pepino(double x, double y, Jeu j){
        super(6,x,y,15,j);
        this.prime=8;
    }

    @Override
    public void agit() {
        seDeplacer();
    }
}
