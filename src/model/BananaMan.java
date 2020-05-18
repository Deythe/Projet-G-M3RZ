package model;

public class BananaMan extends Ennemies {

    public BananaMan(double x, double y, double v) {
        super(x, y, v);
    }

    public BananaMan(double v) {
        super(v);
    }

    @Override
    public void prendreDesDgt(int dgt){
        this.setPv(this.getPv()-dgt);
    }

    @Override
    public boolean estMort(){
        return this.getPv()<=0;
    }

}
