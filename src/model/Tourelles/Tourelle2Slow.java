package model.Tourelles;

import javafx.collections.ObservableList;
import model.Ennemies.Ennemis;
import model.Jeu;

import java.util.ArrayList;

public class Tourelle2Slow extends Tourelles {
    //Tourelle qui ralentit les ennemis autour d'elle

    //Elle a une liste de cible
    private ArrayList<Ennemis> cibles;
    private static int valeur = 150;

    public Tourelle2Slow(Jeu e, double x, double y) {
        super(e, x, y, 96);
        this.cibles = new ArrayList<>();
    }

    public static int getValeur() {
        return valeur;
    }

    //Elle vérifie si une cible rentre ou sort de sa zone en l'ajoutant ou non dans sa liste de cible
    @Override
    public void checkRange(ObservableList<Ennemis> e) {
        for (Ennemis n : super.getJeu().getEnnemis()){
            if(this.detectionEnnemie(n)){
                if(!this.cibles.contains(n)){
                    this.cibles.add(n);
                    break;
                }
            }
            else{
                for(Ennemis p : this.cibles){
                    if (!p.isVivant() || !this.detectionEnnemie(p)){
                        n.setVitesse(n.getVitesseDeBase());
                        n.setRalentit(false);
                        this.cibles.remove(n);
                        break;
                    }
                }
            }
        }
    }

    // Ici la tourelle ne crée pas de tir, mais vérifie si l'ennemi de sa liste est déja ralentit ou non, et le ralentit
    @Override
    public void tirer() {
        if(this.getTempsInactif()==0) {
            for (Ennemis n : this.cibles) {
                if (!n.isRalentit()) {
                    n.setVitesse(n.getVitesse() * 2);
                    n.setRalentit(true);
                }
            }
        } else{
            this.setTempsInactif(this.getTempsInactif()-1);
        }
    }

}
