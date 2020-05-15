package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Tourelles {
    private DoubleProperty x,y;
    private int pv;
    private String id;
    private static int nbTourelle=0;


    public Tourelles(double x, double y, int pv) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.pv = pv;
        this.id = ""+nbTourelle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
