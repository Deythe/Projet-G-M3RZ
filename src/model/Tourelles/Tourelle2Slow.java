package model.Tourelles;

import javafx.collections.ObservableList;
import model.Ennemies.Ennemies;
import model.Jeu;

import java.util.ArrayList;

public class Tourelle2Slow extends Tourelles {
    private ArrayList<Ennemies> cibles;
    private static int valeur = 150;

    public Tourelle2Slow(Jeu e, double x, double y) {
        super(e, x, y, 64);
        this.cibles = new ArrayList<>();
    }

    public static int getValeur() {
        return valeur;
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
                        n.setVitesse(n.getVitesseDeBase());
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

}
