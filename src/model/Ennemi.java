package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Ennemi {
    private static int nbEnnemi = 0;
    private DoubleProperty x,y;
    private double vitesse;
    private String id;
    private int pv;
    protected Jeu jeu;

    public Ennemi(int pv, double x, double y, double v, Jeu j) {
        this.pv=pv;
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.vitesse = v;
        nbEnnemi++;
        this.id="e"+nbEnnemi;
        this.pv=10;
        this.jeu=j;
    }

    public Ennemi(double v){
        this.x= new SimpleDoubleProperty(Math.floor(Math.random()*450+50));
        System.out.println(x.getValue());
        this.y= new SimpleDoubleProperty(Math.floor(Math.random()*450+50));
        System.out.println(y.getValue());
        this.vitesse = v;
        nbEnnemi++;
        this.id="e"+nbEnnemi;
        this.pv=10;
    }

    public void decrementerPv(int a){
        this.pv-=a;
    }

    public abstract void agit();

    public void kamikaze(){

    }

    public abstract void prendreDesDgt(int dgt);

    public int getPv(){
        return this.pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public double getVitesse() {
        return vitesse;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
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

    public void seDeplacer(){
        System.out.println("Se déplace");
        /*int choix=(int)Math.floor(Math.random());*/

        SetX( this.getXValues()+this.vitesse);
        SetY( this.getYValues()+this.vitesse);
    }
}
