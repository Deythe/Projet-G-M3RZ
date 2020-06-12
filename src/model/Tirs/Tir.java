package model.Tirs;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import model.Jeu;

public abstract class Tir {
    //Classe mère qui contient les attributs élementaires d'un tir

    protected Jeu e;
    private int dgt;
    private double v;
    private DoubleProperty x;
    private DoubleProperty y;
    private String id;


    private static int nbTir;

    public Tir(Jeu e, double x, double y, int degat, double vitesse) {
        this.e=e;
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.id = "Tir :"+nbTir;
        this.dgt = degat;
        this.v = vitesse;
        nbTir++;
    }

    public final DoubleProperty getXProperty() {
        return x;
    }

    public final void SetX(double d){
        this.x.set(d);
    }

    public final double getX(){
        return x.getValue();
    }

    public final DoubleProperty getYProperty() {
        return y;
    }

    public final void SetY(double d){
        this.y.set(d);
    }

    public final double getY(){
        return y.getValue();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDgt() {
        return dgt;
    }

    public void setDgt(int dgt) {
        this.dgt = dgt;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public abstract void seDeplace();

    public abstract void touche();

}
