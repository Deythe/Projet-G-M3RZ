package model;

import java.util.ArrayList;

public class Jeu {
    private ArrayList<Ennemi> ennemis;
    private ArrayList<Tourelle> tourelles;
    private Map map;
    int temps;
    Base b;
    int orJoueur;
    public Jeu() {
        this.ennemis = new ArrayList<>();
        this.tourelles = new ArrayList<>();
        this.map = new Map(b);
    }

    public ArrayList<Ennemi> getEnnemis(){
        return ennemis;
    }
    public Ennemi getEnnenmi(String id){
        for (int i = 0; i< ennemis.size(); i++){
            if (ennemis.get(i).getId() == id){
                return ennemis.get(i);
            }
        }
        return null;
    }

    public Ennemi getEnnemi(int index){
        return  this.ennemis.get(index);

    }

    public Tourelle getTourelle(int index){
        return this.tourelles.get(index);
    }

    public void incrementerOrJoueur(int montant){
        this.orJoueur+=montant;
    }

    public void setEnnemis(ArrayList<Ennemi> ennemis){
        this.ennemis = ennemis;
    }

    public ArrayList<Tourelle> getTourelles(){
        return tourelles;
    }

    public void unTour(){
        if (map.getBaseAllie().getPv()<=0){
            System.out.println("GAME OVER");
        }
    }

    public void ajouterEnnemi(Ennemi e){
        this.ennemis.add(e);
    }
    public void setTourelles(ArrayList<Tourelle> tourelles){
        this.tourelles = tourelles;
    }


    public Map getMap(){
        return map;
    }

    public void setMap(Map map){
        this.map = map;
    }

    public void Init(){
        for(int i=0; i<5;i++){
            this.ennemis.add(new BananaMan(2));
        }
    }
}
