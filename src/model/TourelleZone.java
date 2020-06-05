package model;

import javafx.collections.ObservableList;

public class TourelleZone extends Tourelle {

    private Ennemi cible;
    private double cibleX;
    private double cibleY;
    public TourelleZone(double x, double y, Jeu j) {
        super(x, y,j,96);
        this.cible=null;
    }

    public void degatsEnZone(){

    }

    @Override
    public void agit() {

        this.Tire();
    }

    @Override
    public void Tire() {
        if(this.cible!=null){
        this.getJeu().getTirs().add(new TirEnZone(this.getJeu(), this.cible, this.getXValues(), this.getYValues(),this.cibleX,this.cibleY));
        }
    }


    @Override
    public void checkRange(ObservableList<Ennemi> e) {
        if(this.cible==null){
            for(Ennemi a : e){
                if((a.getXValues()<this.getXValues()+this.getRange() && a.getXValues()>this.getXValues()-this.getRange()) && (a.getYValues()<this.getYValues()+this.getRange() && a.getYValues()>this.getYValues()-this.getRange())){

                    this.cibleX=a.getXValues();
                    this.cibleY=a.getYValues();
                    System.out.println("Trouvé");
                    break;
                }
            }
        }
        else {
            if ((this.cible.getXValues() > this.getXValues() + this.getRange() || this.cible.getXValues() < this.getXValues() - this.getRange() || this.cible.getYValues() > this.getYValues() + this.getRange() && this.cible.getYValues() < this.getYValues() - this.getRange())) {
                this.cible = null;
                System.out.println("Perdu");
            }
        }
    }
}
