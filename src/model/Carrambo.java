package model;

public class Carrambo extends Ennemi {
int prime;
public Carrambo(double x, double y,Jeu j){
    super(60,x,y,10,j);
        this.prime=15;
}

    @Override
    public void agit() {
        seDeplacer();
    }

    @Override
    public void prendreDesDgt(int dgt) {

    }

    public int getPrime(){
    return this.prime;
    }
}
