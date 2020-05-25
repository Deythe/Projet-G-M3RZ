package model;

public class Trappe extends Piege{
    boolean ouvert;
    int duree;
    public Trappe(double x, double y,Jeu j) {
        super(x, y,j);
        this.duree=5;
    }

    public boolean estDetruit(){
        if(duree==0){
            return true;
        }
        return  false;
    }

    public void reduitTimer(){
        this.duree-=1;
    }
}
