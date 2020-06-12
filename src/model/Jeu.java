package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Ennemies.Ennemis;
import model.Tirs.Tir;
import model.Tourelles.Tourelles;
import model.Pièges.Piege;

//C'est ici que tout le déroulement du jeu s'effectu
public class Jeu {
    private ObservableList<Ennemis> ennemis;
    private ObservableList<Tourelles> tourelles;
    private ObservableList<Tir> tirs;
    private ObservableList<Piege> pieges;
    private Map map;
    private Graphe graphe;
    private Base base;
    private BFS bfs;
    private int nbTour;
    private Vague wave;
    private IntegerProperty noVague;
    private IntegerProperty noNiveau;
    boolean vaguePrete;


    public Jeu(int n){
        this.ennemis = FXCollections.observableArrayList();
        this.tourelles = FXCollections.observableArrayList();
        this.tirs = FXCollections.observableArrayList();
        this.pieges = FXCollections.observableArrayList();
        this.noNiveau = new SimpleIntegerProperty(n);
        this.map = new Map(getnoNiveau());
        this.graphe = new Graphe( this.map.getMap());
        this.bfs = new BFS(this.graphe);
        this.base = new Base(50);
        this.wave = new Vague(this);
        this.noVague = new SimpleIntegerProperty(0);
        this.nbTour=0;
        this.vaguePrete = false;
    }

    public final IntegerProperty getnoVagueProperty() {
        return noVague;
    }

    public final void SetboVague(int d){
        this.noVague.set(d);
    }

    public final int getnoVague(){
        return this.noVague.getValue();
    }

    public final IntegerProperty getnoNiveauProperty() {
        return noNiveau;
    }

    public final void SetnoNiveau(int d){
        this.noNiveau.set(d);
    }

    public final int getnoNiveau(){
        return this.noNiveau.getValue();
    }

    public ObservableList<Ennemis> getEnnemis() {
        return ennemis;
    }

    public void setEnnemis(ObservableList ennemis) {
        this.ennemis = ennemis;
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

    public int getNbTour() {
        return nbTour;
    }

    public BFS getBfs() {
        return bfs;
    }

    public Base getBase() {
        return base;
    }

    public ObservableList<Piege> getPieges() {
        return pieges;
    }

    public void setPieges(ObservableList pieges) {
        this.pieges = pieges;
    }


    //Méthode qui permet de retirer tous les ennemis du modèle s'ils sont morts
    public void enleverMob(){
        for(int i = 0; i<this.ennemis.size(); i++){
            if(!this.ennemis.get(i).isVivant()){
                this.base.gagnerArgent(this.ennemis.get(i).getPrime());
                this.ennemis.remove(this.ennemis.get(i));
            }
        }
    }

    //Méthode qui renvoie true si une tourelle existe déjà au coordonées passées en paramètre
    public boolean existeTourelle(int x, int y){
        for(Tourelles t : this.tourelles){
            if(t.getX()==x && t.getY()==y){
                return true;
            }
        }
        return false;
    }
    //Méthode qui renvoie true si un piège existe déjà au coordonées passées en paramètre
    public boolean existePiege(int x, int y){
        for(Piege p: this.pieges){
            if(p.getX()==x && p.getY()==y){
                return true;
            }
        }
        return false;
    }

    //Méthode appelée pour CHAQUE tour de jeu et retourne vrai si la wave est encore active
    public boolean unTour(){
        //On vérifie si une vague n'est pas prête
        if(!vaguePrete) {
            this.wave.nouvelleVague(getnoNiveau(), getnoVague());
            vaguePrete = true;
        }

        if(this.wave.gestionVague()) {
            //Premièrement tous les tirs se déplacent
            for(int i=0;i< this.tirs.size(); i++){
                this.tirs.get(i).seDeplace();
            }

            //Deuxièment tous les ennemis agissent
            for(int i = 0; i<this.ennemis.size(); i++){
                this.ennemis.get(i).agit();
            }

            //Troisièmement toutes les tourelles tirent
            for(Tourelles t : this.tourelles){
                t.checkRange(this.ennemis);
                t.tirer();
            }

            //Quatrièmement tous les pièges agissent
            for(int i=0; i<this.pieges.size(); i++){
                this.pieges.get(i).agit();
            }

            //On enlève les mob
            this.enleverMob();

            //On incrémente de un les tours
            this.nbTour++;
            return true;
        }
        else {
            //On réactive tous les pièges sauf la mine
            for (Piege p : pieges){
                p.setActif(true);
            }

            //On donne les valeur de la vague suivante
            this.wave.nouvelleVague(getnoNiveau(), getnoVague());
            nbTour = 0;
            SetboVague(getnoVague()+1);
            vaguePrete = false;
            return false;
        }

    }

}
