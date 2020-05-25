package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemies  {
    private Environnement e;
    private static int nbEnnemi = 1;
    private DoubleProperty x,y;
    private double vitesse;
    private String id;
    private boolean vivant;
    private IntegerProperty pv;

    public Ennemies(double x, double y, double v, int hp) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.vitesse = v;
        nbEnnemi++;
        this.id="E"+nbEnnemi;
        this.pv= new SimpleIntegerProperty(hp);
        this.vivant = true;
    }

    public Ennemies(double v, int hp){
        this.x= new SimpleDoubleProperty(Math.floor(Math.random()*450+50));
        this.y= new SimpleDoubleProperty(Math.floor(Math.random()*450+50));
        this.vitesse = v;
        nbEnnemi++;
        this.id=""+nbEnnemi;
        this.pv = new SimpleIntegerProperty(hp);
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

    public IntegerProperty getPV(){
        return this.pv;
    }

    public int getPvValue() {
        return pv.getValue();
    }

    public void setPvValue(int pv) {
        this.pv.setValue(pv);
    }

    public String toStringPV(){
        return ""+this.pv;
    }

    public void seDeplace(){
        SetX( this.getXValues()+this.vitesse);
    }

    public boolean isVivant() {
        return this.getPvValue()>0;
    }

    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }

    public abstract void prendreDesDgt(int dgt);
}
