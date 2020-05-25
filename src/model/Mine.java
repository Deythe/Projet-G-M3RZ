package model;

public class Mine extends Piege {

    boolean declenchee;
    int degatsdeclenchement;
    double x,y;

    public Mine(double x, double y, Jeu j) {
        super(x, y,j);
        this.degatsdeclenchement=40;
    }

    public void activation(){

    }
}
