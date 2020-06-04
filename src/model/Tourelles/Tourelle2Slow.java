package model.Tourelles;

import javafx.collections.ObservableList;
import model.Ennemies.Ennemies;
import model.Environnement;
import model.Tir;

import java.util.ArrayList;

public class Tourelle2Slow extends Tourelles {
    private ArrayList<Ennemies> cibles;

    public Tourelle2Slow(Environnement e, double x, double y) {
        super(e, x, y, 64);
        this.cibles = new ArrayList<>();
    }

    @Override
    public void checkRange(ObservableList<Ennemies> e) {
        for (Ennemies n : super.getEnvironnement().getEnnemies()){
            if(n.getXValues()<= this.getXValues()+this.getRange() && n.getXValues()>= this.getXValues()-this.getRange() && n.getYValues()<= this.getYValues()+this.getRange() && n.getYValues()>= this.getYValues()-this.getRange()){
                if(!this.cibles.contains(n)){
                    this.cibles.add(n);
                    System.out.println("trouvé");
                    break;
                }
            }
            else{
                for(Ennemies p : this.cibles){
                    if (!p.isVivant() || (p.getXValues() > this.getXValues() + this.getRange() || p.getXValues() < this.getXValues() - this.getRange() || p.getYValues() > this.getYValues() + this.getRange() && p.getYValues() < this.getYValues() - this.getRange())) {
                        n.setVitesse(1);
                        this.cibles.remove(n);
                        System.out.println("Perdu");
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void Tire() {
       for(Ennemies n : this.cibles){
            n.setVitesse(0.25);
       }
    }
}
