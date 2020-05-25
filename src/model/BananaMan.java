package model;

public class BananaMan extends Ennemies {

    public BananaMan(double x, double y, double v) {
        super(x, y, v, 10);
    }

    public BananaMan(double v) {
        super(v, 50);
    }

    @Override
    public void prendreDesDgt(int dgt){
        this.setPvValue(this.getPvValue()-dgt);
    }
}
