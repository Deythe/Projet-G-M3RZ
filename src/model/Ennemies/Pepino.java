package model.Ennemies;

import model.Environnement;

public class Pepino extends Ennemies {
    private int prime;

    public Pepino(double x, double y, Environnement e){
        super(e ,x,y,5,5);
        this.prime=8;
    }

    @Override
    public void prendreDesDgt(int dgt) {
    }

    @Override
    public void agit() {
        this.seDeplace();
    }
}
