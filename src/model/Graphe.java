package model;

import java.util.ArrayList;

public class Graphe {

    private ArrayList<Sommet> listeSommet;
    private int[][] tableau;
    private int xDépart, yDépart;

    public Graphe(int[][] t) {
        this.listeSommet = new ArrayList<>();
        this.tableau = t;
        creationSommet();
        creationArret();
    }

    public int getxDépart() {
        return xDépart;
    }

    public int getxDépartPixel() {
        return xDépart*32;
    }

    public int getyDépart() {
        return yDépart;
    }

    public int getyDépartPixel() {
        return yDépart*32;
    }

    public ArrayList<Sommet> getListeSommet() {
        return listeSommet;
    }

    public void setListeSommet(ArrayList<Sommet> listeSommet) {
        this.listeSommet = listeSommet;
    }

    public void creationSommet(){
        for (int i = 0; i <this.tableau.length ; i++) {
            for (int j = 0; j <this.tableau[i].length ; j++) {
                if(this.tableau[i][j]==0){
                    this.listeSommet.add(new Sommet(i,j));
                }
                else if(this.tableau[i][j]==100){
                    this.listeSommet.add(new Sommet(i,j));
                    this.xDépart = i;
                    this.yDépart = j;
                }
            }
        }
    }

    public void creationArret(){
        for (Sommet t : this.listeSommet) {
            for (Sommet tAdjacent: this.listeSommet) {
                if(!t.equals(tAdjacent)){
                    if(t.estAdjacent(tAdjacent)){
                        t.ajouteAdjacent(tAdjacent);
                    }
                }
            }
        }
    }
}

