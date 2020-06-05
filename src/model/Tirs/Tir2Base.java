package model.Tirs;

import model.Ennemies.Ennemies;
import model.Jeu;
import model.Tirs.Tir;

public class Tir2Base extends Tir {

    private Ennemies cible;
    public Tir2Base(Jeu j, Ennemies cible, double x, double y) {
        super(j, x, y, 2, 1);
        this.cible=cible;
    }


    @Override
    public void seDeplace() {
        if(this.e.getNbTour()%this.getV()==0) {
            try {
                if (this.cible.getXValues() > this.getXValues()) {
                    this.SetX(this.getXValues() + 1);
                } else if (this.cible.getXValues() < this.getXValues()) {
                    this.SetX(this.getXValues() - 1);
                }

                if (this.cible.getYValues() > this.getYValues()) {
                    this.SetY(this.getYValues() + 1);
                } else if (this.cible.getYValues() < this.getYValues()) {
                    this.SetY(this.getYValues() - 1);
                }

                this.touche();
            } catch (Exception e) {
                this.e.getTirs().remove(this);
            }
        }
    }

    @Override
    public void touche() {
        if (this.getXValues() >= this.cible.getXValues() && this.getXValues() <= this.cible.getHitboxX() && this.getYValues() >= this.cible.getYValues() && this.getYValues() <= this.cible.getHitboxY()) {
            System.out.println("Touché");
            this.cible.prendreDesDgt(super.getDgt());
            this.e.getTirs().remove(this);
        }
}

}
