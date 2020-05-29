package model.Tourelles;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import model.Ennemies.Ennemies;
import model.Environnement;

public abstract class Tourelles {
    private Environnement environnement;
    private DoubleProperty x,y;
    private String id;
    private static int nbTourelle=1;
    private int range;
    private static int fréquenceDeTir;

    public Tourelles(Environnement e, double x, double y, int r) {
        this.environnement =e;
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.id = "T"+nbTourelle;
        this.range = r;
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


    public Environnement getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(Environnement environnement) {
        this.environnement = environnement;
    }

    public abstract void checkRange(ObservableList<Ennemies> e);

    public abstract void Tire();
}
