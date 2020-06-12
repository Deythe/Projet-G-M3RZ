package model.Tourelles;

import javafx.collections.ObservableList;
import model.Ennemies.Ennemis;
import model.Jeu;

public abstract class Tourelles {
    //Classe mère des tourelle contenant tout les attributs basiques des tours

    protected Jeu jeu;
    private double x,y;
    private String id;
    private static int nbTourelle=1;
    private int range;
    private int tempsInactif;

    public Tourelles(Jeu e, double x, double y, int r) {
        this.jeu =e;
        this.x = x;
        this.y = y;
        this.id = "T"+nbTourelle;
        this.range = r;
        this.tempsInactif=0;
        nbTourelle++;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getX() {
        return x;
    }

    public final void SetX(double d){
        this.x = d;
    }


    public double getY() {
        return y;
    }

    public final void SetY(double d){
        this.y = d;
    }

    public int getTempsInactif() {
        return tempsInactif;
    }

    public void setTempsInactif(int tempsInactif) {
        this.tempsInactif = tempsInactif;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public abstract void checkRange(ObservableList<Ennemis> e);

    public abstract void tirer();

    public boolean detectionEnnemie(Ennemis a) {
        if ((a.getX() < this.x + this.getRange() && a.getX() > this.x - this.getRange())) {
            if(a.getY() < this.y + this.getRange() && a.getY() > this.y - this.getRange()){
                return true;
            }

            return false;
        }
        else {
            return false;
        }
    }
}
