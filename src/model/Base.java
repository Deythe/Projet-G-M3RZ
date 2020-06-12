package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Base {
    //Il s'agit de classe tout les élements qui représentent le joueur

    private IntegerProperty pv;
    private IntegerProperty argent;

    public Base(int pv){
        this.pv = new SimpleIntegerProperty(pv);
        this.argent = new SimpleIntegerProperty(300);
    }

    public IntegerProperty getArgentProperty() {
        return this.argent;
    }

    public void setArgent(int argent) {
        this.argent.setValue(argent);
    }

    public int getArgent() {
        return this.argent.getValue();
    }

    public IntegerProperty getPvProperty() {
        return pv;
    }

    public int getPvValue() {
        return pv.getValue();
    }

    public void setPv(int n) {
        this.pv.setValue(n);
    }

    public void decrementerPv(int a){
        setPv(getPvValue()-a);
    }

    //Si les pv tombe a zéro la base est détruite
    public boolean estVivant(){
        return getPvValue()>0;
    }

    //On peut acquérir de l'argent dans le jeux, elle est appelé lorsqu'un ennemi meurt ou que l'on vent un objet
    public void gagnerArgent(int gain) {
        this.setArgent(this.getArgent() + gain);
    }

    //Méthode utilisée permettant de baisser l'argent du joueur lorsqu'il effectue un achat
    public boolean depenserArgent(int depense) {
        if(this.getArgent() - depense >= 0) {
            this.setArgent(this.getArgent() - depense);
            return true;
        }
        else {
            return false;
        }
    }
}
