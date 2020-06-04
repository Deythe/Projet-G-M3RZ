package model.Ennemies;

import model.Environnement;

public class Plank extends Ennemies {
    private int prime;

    public Plank(Environnement e, double x, double y){
        super(e,x,y,0.25,10);
        this.prime=25;
    }

    @Override
    public void agit() {
        this.seDeplace();
        if(!this.estVivant()){
             this.largage();
        }

    }

    @Override
    public void prendreDesDgt(int dgt) {
        this.setPvValue(this.getPvValue() - dgt);
    }

    public int getPrime() {
        return prime;
    }

    public void largage(){
        for (int i = 0; i < 4; i++) {
            Ennemies e = new Pepino(this.getXValues(), this.getYValues(), this.getE());
            super.getE().getEnnemies().add(e);
        }
    }

    public boolean estVivant(){
        if (this.getPvValue()>=0){
            return true;
        }else return false;
    }
}
