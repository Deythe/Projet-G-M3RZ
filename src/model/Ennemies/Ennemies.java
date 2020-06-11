package model.Ennemies;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.Jeu;
import model.Sommet;

public abstract class Ennemies  {
    protected Jeu e;
    private static int nbEnnemi = 1;

    private DoubleProperty x,y;
    private double hitboxX, hitboxY;

    private double vitesse;

    private String id;

    private boolean ralentit;

    private Sommet sommetActu;

    private IntegerProperty pv;

    private int prime;

    public Ennemies(Jeu e, double x, double y, double v, int hp, int p) {
        this.e = e;
        this.ralentit = false;
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.hitboxX = getXValues()+31;
        this.hitboxY = getYValues()+31;
        this.vitesse = v;
        this.prime = p;
        nbEnnemi++;
        this.id="E"+nbEnnemi;
        this.pv= new SimpleIntegerProperty(hp);
        this.sommetActu =checkSommet();
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

    public boolean isRalentit() {
        return ralentit;
    }

    public void setRalentit(boolean ralentit) {
        this.ralentit = ralentit;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    public Sommet getSommetActu() {
        return sommetActu;
    }

    public void setSommetActu(Sommet sommetActu) {
        this.sommetActu = sommetActu;
    }

    public abstract int getVitesseDeBase();

    public int getPrime() {
        return prime;
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }

    public void seDeplace(){
        if(this.e.getNbTour()%this.vitesse==0) {
            if (this.e.getBfs().getHashmap().get(this.sommetActu) == null) {
                this.e.getBase().decrementerPv(2);
                this.e.getEnnemies().remove(this);
                System.out.println(this.e.getBase().getPv());
            } else {
                if (this.e.getBfs().getHashmap().get(this.sommetActu).getY() > this.sommetActu.getY()) {
                    this.SetX(this.getXValues() + 1);
                } else if (this.e.getBfs().getHashmap().get(this.sommetActu).getY() < this.sommetActu.getY()) {
                    this.SetX(this.getXValues() - 1);
                }

                if (this.e.getBfs().getHashmap().get(this.sommetActu).getX() > this.sommetActu.getX()) {
                    this.SetY(this.getYValues() + 1);
                } else if (this.e.getBfs().getHashmap().get(this.sommetActu).getX() < this.sommetActu.getX()) {
                    this.SetY(this.getYValues() - 1);
                }

                if (checkSommet() == this.e.getBfs().getHashmap().get(this.sommetActu)) {
                    this.sommetActu = this.e.getBfs().getHashmap().get(this.sommetActu);
                }

                this.setHitboxX(this.getXValues() + 31);
                this.setHitboxY(this.getYValues() + 31);
            }
        }
    }

    public boolean isVivant() {
        return this.getPvValue()>0;
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
