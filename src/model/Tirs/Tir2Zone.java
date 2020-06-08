package model.Tirs;

import model.Ennemies.Ennemies;
import model.Jeu;

import java.util.ArrayList;

public class Tir2Zone extends Tir {
    private double FinX, FinY;
    private int range;
    public Tir2Zone(Jeu j, double x, double y, double cibleX, double cibleY) {
        super(j, x, y, 5, 2);
        this.FinX =cibleX;
        this.FinY =cibleY;
        this.range = 64;
    }

    @Override
    public void seDeplace() {
        if(this.e.getNbTour()%this.getV()==0){
            try {
                if (this.FinX > this.getXValues()) {
                    this.SetX(this.getXValues() + 1);
                } else if (this.FinX < this.getXValues()) {
                    this.SetX(this.getXValues() - 1);
                }

                if (this.FinY > this.getYValues()) {
                    this.SetY(this.getYValues() + 1);
                } else if (this.FinY < this.getYValues()) {
                    this.SetY(this.getYValues() - 1);
                }

                this.touche();
            }catch (Exception e){
                this.e.getTirs().remove(this);
            }
        }
    }

    @Override
    public void touche() {
        if (this.getXValues() == this.FinX && this.getYValues() == this.FinY) {
            System.out.println("touché");
            for(int i=0; i<this.e.getEnnemies().size(); i++){
                if(this.e.getEnnemies().get(i).getXValues()-this.FinX <=this.range && this.e.getEnnemies().get(0).getHitboxX()-this.FinX <=this.range && this.e.getEnnemies().get(0).getYValues()-this.FinY <=this.range && this.e.getEnnemies().get(0).getHitboxY()-this.FinY <=this.range){
                    this.e.getEnnemies().get(i).prendreDesDgt(this.getDgt());
                }
            }
            this.e.getTirs().remove(this);
        }
    }
}
