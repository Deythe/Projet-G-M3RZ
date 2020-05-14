package model;

public abstract class Tourelles {

    public static void setNbTourelle(int nbTourelle) {
        Tourelles.nbTourelle = nbTourelle;
    }

    private double x,y;
    private int pv;
    private String id;
    private static int nbTourelle=0;

    public Tourelles(double x, double y, int pv) {
        this.x = x;
        this.y = y;
        this.pv = pv;
        this.id = "t"+nbTourelle;
    }

    public abstract void agit();

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getNbTourelle() {
        return nbTourelle;
    }

}
