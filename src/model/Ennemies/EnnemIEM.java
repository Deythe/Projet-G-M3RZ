package model.Ennemies;

import model.Jeu;
import model.Tourelles.Tourelles;

public class EnnemIEM  extends Ennemies {

    private static final int TEMPSIEM = 200;
    private static final int vitesse = 4;

    private int range;

    public EnnemIEM(Jeu j, double x, double y) {
        super(j, x, y, vitesse, 10);
        this.range = 96;
    }

    @Override
    public void prendreDesDgt(int dgt) {
        this.setPvValue(this.getPvValue() - dgt);
    }

    public static int getTempsIem() {
        return TEMPSIEM;
    }

    public void iem() {
       for(Tourelles t : super.e.getTourelles()) {
           if(t.getXValues() - this.getXValues() <= this.range && t.getXValues() - this.getXValues() >= -this.range) {
                if(t.getYValues() - this.getYValues() <= this.range && t.getYValues() - this.getYValues() >= -this.range) {
                    t.setTempsInactif(TEMPSIEM);
                }
            }
        }


    }

    public void agit() {
        this.seDeplace();
        if(!this.isVivant()) {
            System.out.println("IEM Activé");
            this.iem();
        }
    }
}
