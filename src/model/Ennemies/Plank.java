package model.Ennemies;

import model.Jeu;

public class Plank extends Ennemies {
    private int prime;
    private boolean planté;

    public Plank(Jeu e, double x, double y){
        super(e,x,y,7,10);
        this.planté = false;
    }

    @Override
    public void agit() {
        if(!this.isVivant() && !this.planté){
            this.planté=true;
            this.setPvValue(20);
        }

        if(!planté){
            this.seDeplace();
        }

        else{
            largage();
        }

    }

    @Override
    public void prendreDesDgt(int dgt) {
        this.setPvValue(this.getPvValue() - dgt);
    }

    public void largage(){
        if (this.e.getNbTour() % 100 == 0) {
            this.e.getEnnemies().add(new Pepino(this.e, (int)this.getXValues()/32*32, (int)this.getYValues()/32*32));
            System.out.println("pop");
        }
    }
}
