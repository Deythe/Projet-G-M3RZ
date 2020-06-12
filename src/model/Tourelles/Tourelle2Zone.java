package model.Tourelles;

import javafx.collections.ObservableList;
import model.Ennemies.Ennemis;
import model.Jeu;
import model.Tirs.Tir2Zone;

public class Tourelle2Zone extends Tourelles {
    //Tourelle qui crée des tire plus lent et qui font des dégats en zone

    private Ennemis cible;
    private static int frequenceDeTir = 200;
    private static int valeur = 200;

    public Tourelle2Zone(Jeu e, double x, double y) {
        super(e, x, y, 96);
        this.cible = null;
    }

    public static int getValeur() {
        return valeur;
    }

    //Regarde si un ennemi entre ou sort du champ de vision de la tourelle et il devient sa cible ou non
    @Override
    public void checkRange(ObservableList<Ennemis> ennemies){
        if(this.cible==null){
            for(Ennemis a : ennemies){
                if(this.detectionEnnemie(a)){
                    this.cible=a;
                    break;
                }
            }
        }
        else {
            if(!this.cible.isVivant() || !detectionEnnemie(this.cible)){
                this.cible = null;
            }
        }
    }

    //On crée le tir si elle n'est pas inactive et que la fréquence de tir est bonne
    @Override
    public void tirer(){
        if(this.getTempsInactif()==0) {
            if (this.jeu.getNbTour() % frequenceDeTir == 0) {
                if (this.cible != null) {
                    this.jeu.getTirs().add(new Tir2Zone(this.jeu, this.getX(), this.getY(), this.cible.getX(), this.cible.getY()));
                    this.cible = null;
                }
            }
        }
        else{
            this.setTempsInactif(this.getTempsInactif()-1);
        }
    }

}
