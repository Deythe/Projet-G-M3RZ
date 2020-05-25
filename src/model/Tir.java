package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Tir {
    private Environnement e;
    private int degat;
    private Ennemies cible;

    private DoubleProperty x;
    private DoubleProperty y;
    private String id;
    private int v, range;
    private static int nbTir;

    public Tir(Environnement e, Ennemies cible, double x, double y) {
        this.e=e;
        this.degat = 2;
        this.cible = cible;
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.v = 2;
        this.range=5 ;
        this.id = "Tir :"+nbTir;
        nbTir++;
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
        if(this.cible.getXValues() + this.range >this.getXValues()){
            this.SetX(this.getXValues()+v);
        }

        else if(this.cible.getXValues() - this.range <this.getXValues()){
            this.SetX(this.getXValues()-v);
        }

        if(this.cible.getYValues() + this.range>this.getYValues()){
            this.SetY(this.getYValues()+v);
        }

        else if(this.cible.getYValues() - this.range <this.getYValues()){
            this.SetY(this.getYValues()-v);
        }

        this.touche();
    }

    public void touche() {

        if (this.getXValues() >= this.cible.getXValues() - this.range && this.getXValues() <= this.cible.getXValues() + this.range && this.getYValues() >= this.cible.getYValues() - this.range && this.getYValues() <= this.cible.getYValues() + this.range) {
            System.out.println("Touché");
            this.cible.prendreDesDgt(this.degat);
            this.e.getTirs().remove(this);

        }
    }
}
