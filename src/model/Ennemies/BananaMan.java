package model.Ennemies;

import model.Environnement;

public class BananaMan extends Ennemies {

    public BananaMan(Environnement e, double x, double y, double v) {
        super(e, x, y, v, 10);
    }


    @Override
    public void prendreDesDgt(int dgt){
        this.setPvValue(this.getPvValue()-dgt);
    }
}
