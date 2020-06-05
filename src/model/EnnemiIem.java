package model;

public class EnnemiIem extends Ennemi {
    private int prime;
    private static final int TEMPSIEM = 20;
    public EnnemiIem(double x, double y,Jeu j){
        super(75,x,y,20,j);
        this.prime=20;
    }

    @Override
    public void agit() {
        seDeplacer();
        Iem();
    }

    @Override
    public void prendreDesDgt(int dgt) {

    }

    public static int getTempsIem() {
        return TEMPSIEM;
    }

    public void Iem(){
        for (int i=0; i<this.jeu.getTourelles().size();i++){
            if (this.jeu.getTourelle(i).getXValues()-this.getXValues()<=5 && this.jeu.getTourelle(i).getYValues()-this.getYValues()<=5){
                this.jeu.getTourelle(i).setTempsInactif(this.TEMPSIEM);
            }
        }
    }
}
