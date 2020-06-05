package model.Ennemies;

import model.Jeu;
import model.Tourelles.Tourelles;

public class EnnemIEM  extends Ennemies {

    private static final int TEMPSIEM = 10000;

    public EnnemIEM(Jeu j, double x, double y) {
        super(j, x, y, 2, 10);
    }

    @Override
    public void prendreDesDgt(int dgt) {
        this.setPvValue(this.getPvValue() - dgt);
    }

    public static int getTempsIem() {
        return TEMPSIEM;
    }

    public void iem() {
       /* for(Tourelles t : super.e.getTourelles()) {
            if(t.getXValues() - this.getXValues() <= (5 * 32) && t.getYValues() - this.getYValues() >= (-5 * 32)) {
                if(t.getYValues() - this.getYValues() <= (5 * 32) && t.getYValues() - this.getYValues() >= (-5 * 32)) {
                    t.setTempsInactif(TEMPSIEM);
                }
            }
        }

        */
    }

    public void agit() {
        if(!this.isVivant()) {
            System.out.println("IEM Activé");
            this.iem();
        }
        this.seDeplace();
        //System.out.println(this.getPvValue());
    }
}
