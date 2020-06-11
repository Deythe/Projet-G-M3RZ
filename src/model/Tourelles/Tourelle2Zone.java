package model.Tourelles;

import javafx.collections.ObservableList;
import model.Ennemies.Ennemies;
import model.Jeu;
import model.Tirs.Tir2Base;
import model.Tirs.Tir2Zone;

public class Tourelle2Zone extends Tourelles {
    private Ennemies cible;
    private static int frequenceDeTir = 100;
    private static int valeur = 200;

    public Tourelle2Zone(Jeu e, double x, double y) {
        super(e, x, y, 96);
        this.cible = null;
    }

    public static int getValeur() {
        return valeur;
    }

    @Override
    public void checkRange(ObservableList<Ennemies> ennemies){
        if(this.cible==null){
            for(Ennemies a : ennemies){
                if(this.detectionEnnemie(a)){
                    this.cible=a;
                    System.out.println("Trouvé");
                    break;
                }
            }
        }
        else {
            if(!this.cible.isVivant() || !detectionEnnemie(this.cible)){
                this.cible = null;
                System.out.println("Perdu");
            }
        }
    }

    @Override
    public void Tire(){
        if(this.jeu.getNbTour()%frequenceDeTir==0){
            if(this.cible!=null){
                this.jeu.getTirs().add(new Tir2Zone(this.jeu, this.getX(), this.getY(), this.cible.getXValues(), this.cible.getYValues()));
                this.cible=null;
            }
        }
    }

}
