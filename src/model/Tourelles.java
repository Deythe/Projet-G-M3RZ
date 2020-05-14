package model;

public abstract class Tourelles {
    private double x,y;
    private int pv;
    private String id;
    private static int nbTourelle=0;
    private int type;

    public Tourelles(double x, double y, int pv, int type) {
        this.x = x;
        this.y = y;
        this.pv = pv;
        this.id = ""+nbTourelle;
        this.type = type;
    }
}
