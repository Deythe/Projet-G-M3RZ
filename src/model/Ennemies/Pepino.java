package model.Ennemies;

import model.Jeu;

public class Pepino extends Ennemies {
    private int prime;
    private static final int vitesse = 1;

    public Pepino(Jeu e, double x, double y){
        super(e , x, y,vitesse,5);
    }

    @Override
    public void prendreDesDgt(int dgt) {
    }

    @Override
    public void agit() {
        this.seDeplace();
    }
}
