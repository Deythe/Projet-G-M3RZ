package model;

public class TirEnZone extends Tir{

    private double cibleX,cibleY;
    public TirEnZone(Jeu j, Ennemi cible, double x, double y,double cibleX,double cibleY) {
        super(j, cible, x, y,3);
        this.cibleX=cibleX;
        this.cibleY=cibleY;
    }

    public double getCibleX() {
        return cibleX;
    }

    public double getCibleY() {
        return cibleY;
    }

    @Override
    public void seDeplace() {
        if(this.getCibleX() + this.getRange() >this.getXValues()){
            this.SetX(this.getXValues()+getV());
        }

        else if(this.getCibleX() - this.getRange()<this.getXValues()){
            this.SetX(this.getXValues()-getV());
        }

        if(this.getCibleY()+ this.getRange()>this.getYValues()){
            this.SetY(this.getYValues()+getV());
        }

        else if(this.getCibleY() - this.getRange()<this.getYValues()){
            this.SetY(this.getYValues()-getV());
        }

        this.touche();
    }

    @Override
    public void touche() {
        if (this.getXValues() >= this.getCibleX() - this.getRange() && this.getXValues() <= this.getCibleX() + this.getRange() && this.getYValues() >= this.getCibleY() - this.getRange() && this.getYValues() <= this.getCibleY() + this.getRange()) {
            System.out.println("Touché");
            this.cible.prendreDesDgt(this.getDegat());
            this.getJeu().getTirs().remove(this);
        }
    }
}
