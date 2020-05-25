package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;

public abstract class Tourelles {
    private Environnement environnement;
    private DoubleProperty x,y;
    private int pv;
    private String id;
    private static int nbTourelle=1;
    private int range;

    public Tourelles(Environnement e, double x, double y, int pv, int r) {
        this.environnement =e;
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.pv = pv;
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
