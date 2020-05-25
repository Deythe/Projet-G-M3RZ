package model;

public class EnnemiIem extends Ennemi {
    private int prime;
    private static int tempsIem =20;
    public EnnemiIem(double x, double y,Jeu j){
        super(75,x,y,20,j);
        this.prime=20;
    }

    @Override
    public void agit() {
        seDeplacer();
        Iem();
    }

    public static int getTempsIem() {
        return tempsIem;
    }

    public void Iem(){
        for (int i=0; i<this.jeu.getTourelles().size();i++){
            if (this.jeu.getTourelle(i).getX()-this.getXValues()<=5 && this.jeu.getTourelle(i).getY()-this.getYValues()<=5){
                this.jeu.getTourelle(i).setTempsInactif(this.tempsIem);
            }
        }
    }
}
