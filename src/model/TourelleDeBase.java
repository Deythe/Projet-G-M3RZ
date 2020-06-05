package model;

import javafx.collections.ObservableList;

public class TourelleDeBase extends Tourelle{
    private Ennemi cible;

    public TourelleDeBase(Jeu j, double x, double y) {
        super(x, y, j, 96);
        this.cible = null;
    }

    @Override
    public void checkRange(ObservableList<Ennemi> ennemies){
        if(this.cible==null){
            for(Ennemi a : ennemies){
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
    public void agit() {

    }

    @Override
    public void Tire(){
        if(this.cible!=null){
            this.getJeu().getTirs().add(new TirDeBase(this.getJeu(), this.cible, this.getXValues(), this.getYValues()));
        }
    }


}