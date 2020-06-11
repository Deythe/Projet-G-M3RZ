package model.Tourelles;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import model.Ennemies.Ennemies;
import model.Jeu;

public abstract class Tourelles {
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

    public abstract void checkRange(ObservableList<Ennemies> e);

    public abstract void Tire();

    public boolean detectionEnnemie(Ennemies a) {
        if ((a.getXValues() < this.x + this.getRange() && a.getXValues() > this.x - this.getRange()) && (a.getYValues() < this.y + this.getRange() && a.getYValues() > this.y - this.getRange())) {
            return true;
        } else {
            return false;
        }

    }
}
