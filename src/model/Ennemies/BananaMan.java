package model.Ennemies;

import model.Jeu;

public class BananaMan extends Ennemies {

    private static final int vitesse = 2;

    public BananaMan(Jeu e, double x, double y) {
        super(e, x, y, vitesse, 10);
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
