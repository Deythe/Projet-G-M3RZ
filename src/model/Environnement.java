package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Ennemies.BananaMan;
import model.Ennemies.Ennemies;
import model.Tourelles.Tourelles;

import java.util.ArrayList;

public class Environnement {
    private ObservableList<Ennemies> ennemies;
    private ObservableList<Tourelles> tourelles;
    private ObservableList<Tir> tirs;
    private Map map;
    private Graphe graphe;
    private BFS bfs;
    private static int nbTour=0;

    public Environnement() {
        this.ennemies = FXCollections.observableArrayList();
        this.tourelles = FXCollections.observableArrayList();
        this.tirs = FXCollections.observableArrayList();
        this.map = new Map();
        this.graphe = new Graphe( this.map.getMap());
        this.bfs = new BFS(this.graphe);
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

    public Graphe getGraphe() {
        return graphe;
    }

    public BFS getBfs() {
        return bfs;
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

    public void unTour(){
        this.enleverMob();
        if(nbTour%1000==0){
            System.out.println("Pop");
            this.ennemies.add(new BananaMan(this, 0,128,0.25));
        }

        if(nbTour%50==0){
            for(Tourelles t : this.tourelles){
                t.Tire();
            }
        }
        if(nbTour%100==0){
            for(Ennemies a : this.ennemies) {
                a.seDeplace();
            }
        }

        try {
            for (Tir t : this.tirs) {
                t.seDeplace();
            }
        }catch (Exception ignored){

        }

        nbTour++;
    }

}
