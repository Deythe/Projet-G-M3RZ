package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Tir {
    private Jeu jeu;
    private int degat;
    protected Ennemi cible;

    private DoubleProperty x;
    private DoubleProperty y;
    private String id;
    private int v, range;
    private static int nbTir;

    public Tir(Jeu j, Ennemi cible, double x, double y, int dégat) {
        this.jeu=j;
        this.degat = dégat;
        this.cible = cible;
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.v = 2;
        this.range=5 ;
        this.id = "Tir :"+nbTir;
        nbTir++;
    }

    public int getV() {
        return v;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public int getRange() {
        return range;
    }

    public int getDegat() {
        return degat;
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

    public abstract void seDeplace();

    public abstract void touche();


}