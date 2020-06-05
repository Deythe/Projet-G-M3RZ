package model.Tourelles;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import model.Ennemies.Ennemies;
import model.Jeu;

public abstract class Tourelles {
    protected Jeu jeu;
    private DoubleProperty x,y;
    private String id;
    private static int nbTourelle=1;
    private int range;
    private int tempsInactif;

    public Tourelles(Jeu e, double x, double y, int r) {
        this.jeu =e;
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
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

    public final DoubleProperty getX() {
        return x;
    }

    public final void SetX(double d){
        this.x.set(d);
    }

    public final double getXValues(){
        return x.getValue();
    }

    public final DoubleProperty getY() {
        return y;
    }

    public final void SetY(double d){
        this.y.set(d);
    }

    public final double getYValues(){
        return y.getValue();
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

    public abstract boolean detectionEnnemie(Ennemies a);
}
