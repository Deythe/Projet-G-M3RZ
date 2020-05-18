package model;

import javafx.collections.ObservableList;

public class Tourelle2Base extends Tourelles{
    private Ennemies cible;

    public Tourelle2Base(double x, double y) {
        super(x, y, 10, 64);
        this.cible = null;
    }

    @Override
    public void checkRange(ObservableList<Ennemies> ennemies){
        if(this.cible==null){
            for(Ennemies a : ennemies){
                if((a.getXValues()<this.getXValues()+this.getRange() && a.getXValues()>this.getXValues()-this.getRange()) && (a.getYValues()<this.getYValues()+this.getRange() && a.getYValues()>this.getYValues()-this.getRange())){
                    this.cible=a;
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

    @Override
    public void Tire(){
        this.cible.prendreDesDgt(5);
    }
}
