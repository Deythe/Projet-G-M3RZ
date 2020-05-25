package model;

public class Ressort extends Piege {
    private int timer;
    private boolean pret;

    public Ressort(double x, double y, Jeu j) {
        super(x, y,j);
        this.timer=8;
    }

    public void activation(){

    }
    public void reduitTimer(){
        this.timer-=1;
    }
}
