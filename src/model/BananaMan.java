package model;

public class BananaMan extends Ennemi {

    public BananaMan(double x, double y, double v, Jeu j) {
        super(50,x, y, v,j);
    }

    public BananaMan(double v) {
        super(v);
    }

    @Override
    public void agit() {

    }

}
