package model.Tourelles;

import javafx.collections.ObservableList;
import model.Ennemies.Ennemis;
import model.Jeu;
import model.Tirs.Tir2Base;

public class Tourelle2Base extends Tourelles {
    //Tourelle classique qui crée des tir si elle capte un ennemi dans une certaine zone

    private Ennemis cible;

    private static int frequenceDeTir = 100;
    private static int valeur = 100;

    public Tourelle2Base(Jeu e, double x, double y) {
        super(e, x, y, 96);
        this.cible = null;
    }

    public static int getValeur() {
        return valeur;
    }

    //Vérifie si un ennemi est dans sa zone de détection, si oui il devient sa cible
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
            //Si l'ennemi sort de la vision de la tour, elle le perd en tant que cible
            if(!this.cible.isVivant() || !detectionEnnemie(this.cible)){
                this.cible = null;
            }
        }
    }

    //Si la tourelle n'est pas désactivée, et que sa fréquence de tir concorde, elle crée un tir
    @Override
    public void tirer(){
        if(this.getTempsInactif()==0){
            if(this.jeu.getNbTour()%frequenceDeTir==0){
                if(this.cible!=null){
                    this.jeu.getTirs().add(new Tir2Base( this.getJeu(), this.cible, this.getX(), this.getY()));
                }
            }
        }
        else{
            this.setTempsInactif(this.getTempsInactif()-1);
        }
    }
}
