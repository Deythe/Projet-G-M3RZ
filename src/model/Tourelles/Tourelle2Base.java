package model.Tourelles;

import javafx.collections.ObservableList;
import model.Ennemies.Ennemies;
import model.Environnement;
import model.Tir;

public class Tourelle2Base extends Tourelles {
    private Ennemies cible;
    private static int frequenceDeTir = 100;

    public Tourelle2Base(Environnement e, double x, double y) {
        super(e, x, y, 96);
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
            if (!this.cible.isVivant() || (this.cible.getXValues() > this.getXValues() + this.getRange() || this.cible.getXValues() < this.getXValues() - this.getRange() || this.cible.getYValues() > this.getYValues() + this.getRange() && this.cible.getYValues() < this.getYValues() - this.getRange())) {
                this.cible = null;
                System.out.println("Perdu");
            }
        }
    }

    @Override
    public void Tire(){
        if(this.getEnvironnement().getNbTour()%frequenceDeTir==0){
            if(this.cible!=null){
                this.getEnvironnement().getTirs().add(new Tir( this.getEnvironnement(), this.cible, this.getXValues(), this.getYValues()));
            }
        }
    }
}
