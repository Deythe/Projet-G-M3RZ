package model.Ennemies;

import model.Jeu;
import model.Tourelles.Tourelles;

public class Gladiem extends Ennemis {
    //Ennemie pouvant désactiver sur une certaine zone les tourelles lorsqu'elle meurt

    //Constante : durée de la désactivation des tourelles
    private static final int TEMPSIEM = 200;

    private int range;

    public Gladiem(Jeu j, double x, double y) {
        super(j, x, y, 3, 15, 50);
        this.range = 96;
    }

    public int getVitesseDeBase(){
        return 4;
    }


    public static int getTempsIem() {
        return TEMPSIEM;
    }

    //Méthode qui permet à l'activation de détecter toutes les tourelles autour et les désactiver
    public void iem() {
       for(Tourelles t : super.e.getTourelles()) {
           if(t.getX() - this.getX() <= this.range && t.getX() - this.getX() >= -this.range) {
                if(t.getY() - this.getY() <= this.range && t.getY() - this.getY() >= -this.range) {
                    t.setTempsInactif(TEMPSIEM);
                }
            }
        }
    }

    //Si elle meurt, la méthode iem est appelée
    public void agit() {
        this.seDeplace();
        if(!this.isVivant()) {
            this.iem();
        }
    }
}
