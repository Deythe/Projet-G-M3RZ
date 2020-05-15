package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Ennemies  {
    private static int nbEnnemi = 0;
    private DoubleProperty x,y;
    private double vitesse;
    private String id;
    private int pv;

    public Ennemies(double x, double y, double v) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.vitesse = v;
        nbEnnemi++;
        this.id=""+nbEnnemi;
        this.pv=10;
    }

    public Ennemies(double v){
        this.x= new SimpleDoubleProperty(Math.floor(Math.random()*450+50));
        System.out.println(x.getValue());
        this.y= new SimpleDoubleProperty(Math.floor(Math.random()*450+50));
        System.out.println(y.getValue());
        this.vitesse = v;
        nbEnnemi++;
        this.id=""+nbEnnemi;
        this.pv=10;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void seDeplace(){
        System.out.println("Se déplace");

        SetX( this.getXValues()+this.vitesse);
        SetY( this.getYValues()+this.vitesse);
    }
}
