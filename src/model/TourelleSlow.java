package model;

public class TourelleSlow extends Tourelle {
    public TourelleSlow(double x, double y, Jeu j) {
        super(x, y,j);
    }

    public void ralentissement(){

    }

    @Override
    public void agit() {

        this.decrementertempsIncactif(10);

    }
}
