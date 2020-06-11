package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Base {
    private int pv;
    private IntegerProperty argent;
    boolean estVivant;

    public Base(int pv){
        this.pv = pv;
        this.estVivant=true;
        this.argent = new SimpleIntegerProperty(10000);
    }

    public IntegerProperty getArgent() {
        return this.argent;
    }

    public void setArgent(int argent) {
        this.argent.setValue(argent);
    }

    public int getArgentValue() {
        return this.argent.getValue();
    }

    public int getPv() {
        return pv;
    }

    public void decrementerPv(int a){
        this.pv-=a;
    }

    public boolean estVivant(){
        return this.pv>0;
    }

    public void gagnerArgent(int gain) {
        this.setArgent(this.getArgentValue() + gain);
        System.out.println("Il gagne " + gain + " et a " + this.getArgentValue());
    }

    public boolean depenserArgent(int depense) {
        System.out.println("Thune = " + (this.getArgentValue()) + "Prix = " + depense);
        if(this.getArgentValue() - depense >= 0) {
            this.setArgent(this.getArgentValue() - depense);
            System.out.println("Il depense " + depense + " et a " + this.getArgentValue());
            return true;
        }
        else {
            System.out.println("Vous n'avez pas assez d'argent");
            return false;
        }
    }
}
