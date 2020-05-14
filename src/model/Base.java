package model;

public class Base {
    private double x,y;
    private int pv;

    public Base(double x, double y, int pv){
        this.x = x;
        this.y = y;
        this.pv = pv;
    }

    public void decrementerPv(int a){
        this.pv-=a;
    }

    public boolean estVivant(){
        if (this.pv>0){
            return true;
        }else return false;
    }
}
