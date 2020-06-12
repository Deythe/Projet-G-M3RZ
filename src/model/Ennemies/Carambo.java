package model.Ennemies;

import model.Jeu;

public class Carambo extends Ennemis {

    //Ennemi de base qui est classe fille de la classe mère Ennemi
    public Carambo(Jeu e, double x, double y) {
        super(e, x, y, 2, 10, 25);
    }

    public int getVitesseDeBase(){
        return 2;
    }

    @Override
    public void agit() {
        this.seDeplace();
    }
}
