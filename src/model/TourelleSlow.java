package model;

import javafx.collections.ObservableList;

public class TourelleSlow extends Tourelle {
    public TourelleSlow(double x, double y, Jeu j) {
        super(x, y,j,96);
    }

    public void ralentissement(){

    }

    @Override
    public void agit() {

        this.decrementertempsIncactif(10);

    }

    @Override
    public void Tire() {

    }

    @Override
    public void checkRange(ObservableList<Ennemi> e) {
    }

}
