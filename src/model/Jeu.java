package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Jeu {
    private ObservableList<Ennemi> ennemis;
    private ObservableList<Tourelle> tourelles;
    private ObservableList<Tir> tirs;
    private Map map;
    private static int nbTours;
    private Base b;
    int orJoueur;
    public Jeu() {
        this.ennemis = FXCollections.observableArrayList();
        this.tourelles = FXCollections.observableArrayList();
        this.tirs = FXCollections.observableArrayList();
        this.map = new Map(b);
    }

    public static int getNbTours() {
        return nbTours;
    }

    public static void setNbTours(int nbTours) {
        Jeu.nbTours = nbTours;
    }

    public ObservableList<Ennemi> getEnnemis(){
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

    public void setEnnemis(ObservableList<Ennemi> ennemis){
        this.ennemis = ennemis;
    }

    public ObservableList<Tourelle> getTourelles(){
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
    public void setTourelles(ObservableList<Tourelle> tourelles){
        this.tourelles = tourelles;
    }


    public Map getMap(){
        return map;
    }

    public void setMap(Map map){
        this.map = map;
    }
    public ObservableList<Tir> getTirs() {
        return this.tirs;
    }

    public void setTirs(ObservableList Tir) {
        this.tirs = Tir;
    }

    public void Init(){
        for(int i=0; i<5;i++){
            this.ennemis.add(new BananaMan(2));
        }
    }
}
