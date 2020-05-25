package model;

public class Plank extends Ennemi {
    private int prime;
    public Plank(double x, double y,Jeu j){
        super(120,x,y,8,j);
        this.prime=25;
    }

    @Override
    public void agit() {
        seDeplacer();
        largage();
    }

    public int getPrime() {
        return prime;
    }

    public void largage(){

        if (!this.estVivant()) {
            for (int i = 0; i < 4; i++) {
                Ennemi e = new Pepino(this.getXValues()+2, this.getYValues()+2,this.jeu);
                this.jeu.ajouterEnnemi(e);
            }
        }
    }
    public boolean estVivant(){
        if (this.getPv()>=0){
            return true;
        }else return false;
    }
}
