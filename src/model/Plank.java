package model;

public class Plank extends Ennemi {
    private int prime;
    public Plank(double x, double y,Jeu j){
        super(120,x,y,8,j);
        this.prime=25;
    }

    @Override
    public void agit() {
        this.seDeplacer();
        this.largage();
    }

    @Override
    public void prendreDesDgt(int dgt) {

    }

    public int getPrime() {
        return prime;
    }

    public void largage(){

        if (!this.estVivant()) {
            for (int i = 0; i < 4; i++) {
                Ennemi e = new Pepino(this.getXValues(), this.getYValues(),this.jeu);
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
