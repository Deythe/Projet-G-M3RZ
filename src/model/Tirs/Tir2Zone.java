package model.Tirs;

import model.Jeu;

public class Tir2Zone extends Tir {
    //Tir beaucoup plus lent, mais qui fait plus de dégat en ZONE créé par la tourelleZone et qui ne suit pas un ennemi

    private double FinX, FinY;
    private int range;

    public Tir2Zone(Jeu j, double x, double y, double cibleX, double cibleY) {
        super(j, x, y, 4, 2);
        this.FinX =cibleX;
        this.FinY =cibleY;
        this.range = 64;
    }

    //Va au coordonée detecté au moment du tir
    @Override
    public void seDeplace() {
        if(this.e.getNbTour()%this.getV()==0){
            try {
                if (this.FinX > this.getX()) {
                    this.SetX(this.getX() + 1);
                } else if (this.FinX < this.getX()) {
                    this.SetX(this.getX() - 1);
                }

                if (this.FinY > this.getY()) {
                    this.SetY(this.getY() + 1);
                } else if (this.FinY < this.getY()) {
                    this.SetY(this.getY() - 1);
                }

                this.touche();
            }catch (Exception e){
                this.e.getTirs().remove(this);
            }
        }
    }

    //Arrivé à ses coordoonées de fin, il fera des dégats à tous les ennemis dans un certain rayon

    @Override
    public void touche() {
        if (this.getX() == this.FinX && this.getY() == this.FinY) {
            for(int i=0; i<this.e.getEnnemis().size(); i++){
                if ((this.e.getEnnemis().get(i).getX() < this.FinX + this.range && this.e.getEnnemis().get(i).getX() > this.FinX - this.range)){
                    if(this.e.getEnnemis().get(i).getY() < this.FinY + this.range && this.e.getEnnemis().get(i).getY() > this.FinY - this.range) {
                        this.e.getEnnemis().get(i).prendreDesDgt(this.getDgt());
                    }
                }
            }
            this.e.getTirs().remove(this);
        }
    }
}
