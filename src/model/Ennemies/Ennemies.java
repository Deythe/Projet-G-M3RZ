package model.Ennemies;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.Environnement;
import model.Sommet;

public abstract class Ennemies  {
    private Environnement e;
    private static int nbEnnemi = 1;

    private DoubleProperty x,y;
    private double hitboxX, hitboxY;

    private double vitesse;

    private String id;

    private Sommet test;

    private boolean vivant;

    private IntegerProperty pv;

    public Ennemies(Environnement e, double x, double y, double v, int hp) {
        this.e = e;
        this.x = new SimpleDoubleProperty(0);
        this.y = new SimpleDoubleProperty(128);
        this.hitboxX = getXValues()+31;
        this.hitboxY = getYValues()+31;
        this.vitesse = v;
        nbEnnemi++;
        this.id="E"+nbEnnemi;
        this.pv= new SimpleIntegerProperty(hp);
        this.vivant = true;
        this.test=checkSommet();
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

    public double getHitboxX() {
        return hitboxX;
    }

    public void setHitboxX(double hitboxX) {
        this.hitboxX = hitboxX;
    }

    public double getHitboxY() {
        return hitboxY;
    }

    public void setHitboxY(double hitboxY) {
        this.hitboxY = hitboxY;
    }

    public double getVitesse() {
        return vitesse;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    public Environnement getE() {
        return e;
    }

    public void seDeplace(){
        if(this.e.getBfs().getHashmap().get(this.test).getY()>this.test.getY()) {
            this.SetX(this.getXValues() + this.vitesse);
        }

        else if(this.e.getBfs().getHashmap().get(this.test).getY()<this.test.getY()) {
            this.SetX(this.getXValues() - this.vitesse);
        }

        if(this.e.getBfs().getHashmap().get(this.test).getX()>this.test.getX()) {
            this.SetY(this.getYValues() + this.vitesse);
        }

        else if(this.e.getBfs().getHashmap().get(this.test).getX()<this.test.getX()) {
            this.SetY(this.getYValues() - this.vitesse);
        }

        if(checkSommet()==this.e.getBfs().getHashmap().get(this.test)){
            this.test=this.e.getBfs().getHashmap().get(this.test);
        }
        /*

        this.SetX(this.e.getBfs().getHashmap().get(this.test).getY()*32);

        this.setHitboxX(this.getXValues()+31);
        this.setHitboxY(this.getYValues()+31);

         */
    }

    public boolean isVivant() {
        return this.getPvValue()>0;
    }

    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }

    public abstract void prendreDesDgt(int dgt);

    public Sommet checkSommet(){
        for(Sommet m : this.e.getGraphe().getListeSommet()){
            if(m.getY()*32 == this.getXValues() && m.getX()*32 == this.getYValues()){
                return m;
            }
        }

        return null;
    }

    public abstract void agit();

}
