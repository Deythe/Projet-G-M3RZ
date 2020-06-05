package model;

import java.util.ArrayList;
import java.util.Objects;

public class Sommet {
    private int x;
    private int y;
    private ArrayList<Sommet> adjacents;

    public Sommet(int x, int y) {
        this.x = x;
        this.y = y;
        this.adjacents = new ArrayList<Sommet>();
    }

    public boolean estAdjacent(Sommet m){
        if(this.getX()==m.getX()+1){
            if(this.getY()==m.getY()){
                return true;
            }
        }

        if(this.getX()==m.getX()-1){
            if(this.getY()==m.getY()){
                return true;
            }
        }

        if(this.getY()==m.getY()+1){
            if(this.getX()==m.getX()){
                return true;
            }
        }

        if(this.getY()==m.getY()-1){
            if(this.getX()==m.getX()){
                return true;
            }
        }

        return false;
    }

    public double xPixel(){
        return this.getX()*32;
    }

    public double yPixel(){
        return this.getY()*32;
    }

    public ArrayList<Sommet> getAdjacents() {
        return adjacents;
    }

    public void ajouteAdjacent(Sommet a){
        this.adjacents.add(a);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sommet sommet = (Sommet) o;
        return Double.compare(sommet.x, x) == 0 &&
                Double.compare(sommet.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Je suis Sommet{" + "x=" + x + ", y=" + y + '}';
    }
}


