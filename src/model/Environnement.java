package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
    private ObservableList<Ennemies> ennemies;
    private ObservableList<Tourelles> tourelles;
    private ObservableList<Tir> tirs;
    private Map map;

    public Environnement() {
        this.ennemies = FXCollections.observableArrayList();
        this.tourelles = FXCollections.observableArrayList();
        this.tirs = FXCollections.observableArrayList();
        this.map = new Map();
    }

    public ObservableList<Ennemies> getEnnemies() {
        return ennemies;
    }

    public void setEnnemies(ObservableList ennemies) {
        this.ennemies = ennemies;
    }

    public ObservableList<Tourelles> getTourelles() {
        return tourelles;
    }

    public void setTourelles(ObservableList<Tourelles> tourelles) {
        this.tourelles = tourelles;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public ObservableList<Tir> getTirs() {
        return this.tirs;
    }

    public void setTirs(ObservableList Tir) {
        this.tirs = Tir;
    }


    public void enleverMob(){
        for(int i=0; i<this.ennemies.size(); i++){
            if(!this.ennemies.get(i).isVivant()){
                System.out.println("mort");
                this.ennemies.remove(this.ennemies.get(i));
            }
        }
    }

    public boolean existeTourelle(int x, int y){
        for(Tourelles t : this.tourelles){
            if(t.getXValues()==x && t.getYValues()==y){
                return true;
            }
        }

        return false;
    }

}
