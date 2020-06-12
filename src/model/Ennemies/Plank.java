package model.Ennemies;

import model.Jeu;

public class Plank extends Ennemis {
    //Ennemi très lent mais tanky qui deviens un sppawner à pepino quand il meurt

    private int prime;

    //Booléen qui contient l'information de l'ennemi est mort ou non
    private boolean planté;

    public Plank(Jeu e, double x, double y){
        super(e,x,y, 5,20, 75);
        this.planté = false;
    }

    public int getVitesseDeBase(){
        return 7;
    }

    @Override
    public void agit() {
        //Si le mob est mort et qu'il n'est pas planté, il à une seconde vie mais ne peut plus se déplacer
        if(!this.isVivant() && !this.planté){
            this.planté=true;
            this.setPv(20);
        }

        if(!planté){
            this.seDeplace();
        }

        else{
            largage();
        }

    }

    //Méthode qui permet à l'ennemi de faire spawn des Pepino, à des coordonées que peuvent suivre le bfs
    public void largage(){
        if (this.e.getNbTour() % 100 == 0) {
            this.e.getEnnemis().add(new Pepino(this.e, (int)this.getX()/32*32, (int)this.getY()/32*32));
            System.out.println("pop");
        }
    }
}
