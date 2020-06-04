package model.Ennemies;

import model.Environnement;

public class BananaMan extends Ennemies {

    public BananaMan(Environnement e, double x, double y) {
        super(e, x, y, 1, 10);
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