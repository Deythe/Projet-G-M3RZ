package model.Tirs;

import model.Ennemies.Ennemis;
import model.Jeu;

public class Tir2Base extends Tir {
    //Tir que crée la tourelle de base

    private Ennemis cible;

    public Tir2Base(Jeu j, Ennemis cible, double x, double y) {
        super(j, x, y, 2, 1);
        this.cible=cible;
    }

    //Suit les coordonées d'un ennemi pour se déplacer
    @Override
    public void seDeplace() {
        if(this.e.getNbTour()%this.getV()==0) {
            try {
                if (this.cible.getX() > this.getX()) {
                    this.SetX(this.getX() + 1);
                } else if (this.cible.getX() < this.getX()) {
                    this.SetX(this.getX() - 1);
                }

                if (this.cible.getY() > this.getY()) {
                    this.SetY(this.getY() + 1);
                } else if (this.cible.getY() < this.getY()) {
                    this.SetY(this.getY() - 1);
                }

                this.touche();
            } catch (Exception e) {
                this.e.getTirs().remove(this);
            }
        }
    }

    //lorsque le tir atteint les coordonnées d'un ennemi il prend des dégats
    @Override
    public void touche() {
        if (this.getX() >= this.cible.getX() && this.getX() <= this.cible.getHitboxX()){
            if(this.getY() >= this.cible.getY() && this.getY() <= this.cible.getHitboxY()) {
                this.cible.prendreDesDgt(super.getDgt());
                this.e.getTirs().remove(this);
            }
        }
    }
}
