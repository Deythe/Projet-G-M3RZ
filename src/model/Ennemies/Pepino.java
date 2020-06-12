package model.Ennemies;

import model.Jeu;

public class Pepino extends Ennemis {
    private int prime;
    //Ennemi faible mais rapide qui est généré par la plank

    public Pepino(Jeu e, double x, double y){
        super(e , x, y, 1,5, 10);
    }

    public int getVitesseDeBase(){
        return 1;
    }

    @Override
    public void agit() {
        this.seDeplace();
    }
}
