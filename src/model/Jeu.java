package model;

import java.util.ArrayList;

public class Jeu {
    private ArrayList<Ennemies> ennemies;
    private ArrayList<Tourelles> tourelles;
    private Map map;

    public Jeu() {
        this.ennemies = new ArrayList<>();
        this.tourelles = new ArrayList<>();
        this.map = new Map();
    }

    public ArrayList<Ennemies> getEnnemies() {
        return ennemies;
    }

    public void setEnnemies(ArrayList<Ennemies> ennemies) {
        this.ennemies = ennemies;
    }

    public ArrayList<Tourelles> getTourelles() {
        return tourelles;
    }

    public void setTourelles(ArrayList<Tourelles> tourelles) {
        this.tourelles = tourelles;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void Init(){
        for(int i=0; i<5;i++){
            this.ennemies.add(new BananaMan(2));
        }
    }
}
