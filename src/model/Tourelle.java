package model;

public abstract class Tourelle {


    public static void setNbTourelle(int nbTourelle) {
        Tourelle.nbTourelle = nbTourelle;
    }

    private double x,y;
    private String id;
    private static int nbTourelle=0;
    protected Jeu jeu;
    private int tempsInactif;
    public Tourelle(double x, double y, Jeu j) {
        this.x = x;
        this.y = y;
        this.id = "t"+nbTourelle;
        this.jeu=j;
        this.tempsInactif=0;
    }

    public boolean verifInactif(){
        if(this.tempsInactif!=0){
            return true;
        }return false;
    }
    public abstract void agit();

    public int getTempsInactif(){
        return this.tempsInactif;
    }
    public void setTempsInactif(int temps) {
            this.tempsInactif=temps;
    }

    public void decrementertempsIncactif(int montant){
        if (this.tempsInactif-montant>=0){
            this.tempsInactif-=montant;
        }else this.setTempsInactif(0);
    }
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
