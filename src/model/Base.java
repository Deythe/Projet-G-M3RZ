package model;

public class Base {
    private double x,y;
    private int pv;
    boolean estVivant;
    public Base(double x, double y, int pv){
        this.x = x;
        this.y = y;
        this.pv = pv;
        this.estVivant=true;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getPv() {
        return pv;
    }

    public void decrementerPv(int a){
        this.pv-=a;
    }

    public void destructionBase(){
        if (this.getPv() == 0){
            this.estVivant=false;
        }
    }
}
