package model;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Environnement {
    private ObservableList<Ennemies> ennemies;
    private ObservableList<Tourelles> tourelles;
    private Map map;

    public Environnement() {
        this.ennemies = FXCollections.observableArrayList();
        this.tourelles = FXCollections.observableArrayList();
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

}
