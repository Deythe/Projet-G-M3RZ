package model.Ennemies;

import model.Jeu;

public class Pepino extends Ennemies {
    private int prime;

    public Pepino(Jeu e, double x, double y){
        super(e , x, y, 1,5, 15);
    }

    public int getVitesseDeBase(){
        return 1;
    }

    @Override
    public void prendreDesDgt(int dgt) {
    }

    @Override
    public void agit() {
        this.seDeplace();
    }
}
