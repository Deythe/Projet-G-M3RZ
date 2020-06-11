package model.Ennemies;

import model.Jeu;

public class Carambo extends Ennemies {

    public Carambo(Jeu e, double x, double y) {
        super(e, x, y, 0.25, 10, 15);
    }

    public int getVitesseDeBase(){
        return 2;
    }

    @Override
    public void prendreDesDgt(int dgt) {
        this.setPvValue(this.getPvValue() - dgt);
    }

    @Override
    public void agit() {
        this.seDeplace();
    }
}
