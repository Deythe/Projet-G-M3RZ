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

    public int getPrime(){
    return this.prime;
    }
}
