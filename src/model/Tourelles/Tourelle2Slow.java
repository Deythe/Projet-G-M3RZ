package model.Tourelles;

import javafx.collections.ObservableList;
import model.Ennemies.Ennemies;
import model.Jeu;

import java.util.ArrayList;

public class Tourelle2Slow extends Tourelles {
    private ArrayList<Ennemies> cibles;

    public Tourelle2Slow(Jeu e, double x, double y) {
        super(e, x, y, 64);
        this.cibles = new ArrayList<>();
    }

    @Override
    public void checkRange(ObservableList<Ennemies> e) {
        for (Ennemies n : super.getJeu().getEnnemies()){
            if(this.detectionEnnemie(n)){
                if(!this.cibles.contains(n)){
                    this.cibles.add(n);
                    System.out.println("trouvé");
                    break;
                }
            }
            else{
                for(Ennemies p : this.cibles){
                    if (!p.isVivant() || !this.detectionEnnemie(p)){
                        n.setVitesse(1);
                        n.setRalentit(false);
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
           if(!n.isRalentit()) {
               n.setVitesse(n.getVitesse()*2);
               n.setRalentit(true);
           }
       }
    }

    @Override
    public boolean detectionEnnemie(Ennemies n) {
        if(n.getXValues()<= this.getXValues()+this.getRange() && n.getXValues()>= this.getXValues()-this.getRange() && n.getYValues()<= this.getYValues()+this.getRange() && n.getYValues()>= this.getYValues()-this.getRange()){
            return true;
        } else {
            return false;
        }

    }
}
