package model;

public class TirDeBase extends Tir {


    public TirDeBase(Jeu j, Ennemi cible, double x, double y) {
        super(j, cible, x, y,2);

    }


    @Override
    public void seDeplace() {
        if(this.cible.getXValues() + this.getRange() >this.getXValues()){
            this.SetX(this.getXValues()+getV());
        }

        else if(this.cible.getXValues() - this.getRange()<this.getXValues()){
            this.SetX(this.getXValues()-getV());
        }

        if(this.cible.getYValues() + this.getRange()>this.getYValues()){
            this.SetY(this.getYValues()+getV());
        }

        else if(this.cible.getYValues() - this.getRange()<this.getYValues()){
            this.SetY(this.getYValues()-getV());
        }

        this.touche();
    }

    @Override
    public void touche() {
        if (this.getXValues() >= this.cible.getXValues() - this.getRange() && this.getXValues() <= this.cible.getXValues() + this.getRange() && this.getYValues() >= this.cible.getYValues() - this.getRange() && this.getYValues() <= this.cible.getYValues() + this.getRange()) {
            System.out.println("Touché");
            this.cible.prendreDesDgt(this.getDegat());
            this.getJeu().getTirs().remove(this);
        }
    }
}
