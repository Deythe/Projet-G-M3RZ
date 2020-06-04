package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import model.*;
import model.Ennemies.BananaMan;
import model.ListeObservable.ObsListEnnemies;
import model.ListeObservable.ObsListTirs;
import model.ListeObservable.ObsListTourelle;
import model.Tourelles.Tourelle2Base;
import model.Tourelles.Tourelle2Slow;
import model.Tourelles.Tourelles;
import view.ViewEnnemi;
import view.ViewMap;
import view.ViewTourelle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Environnement environnement;

    private Timeline gameLoop;

    private int temps;

    private boolean choix ;

    private String IDchoix;

    @FXML
    private Button T1;

    @FXML
    private Button T2;

    @FXML
    private TilePane Tilepane;

    @FXML
    private Pane pane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.environnement = new Environnement();
        //this.environnement.getGraphe().creationDuGraphe();
        this.choix=false;
        ViewEnnemi viewEnnemi = new ViewEnnemi(this.pane);
        ViewTourelle viewTourelle = new ViewTourelle(this.pane);
        ViewMap viewMap = new ViewMap(this.Tilepane);
        viewMap.affichermap(this.environnement.getMap());
        this.environnement.getTourelles().addListener(new ObsListTourelle(this.pane, viewTourelle));
        this.environnement.getEnnemies().addListener(new ObsListEnnemies(this.pane, viewEnnemi));
        this.environnement.getTirs().addListener(new ObsListTirs(this.pane));
        initAnimation();
    }

    private void initAnimation() {
        gameLoop = new Timeline();
        temps=0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.017),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev ->{
                    if(temps==5000){
                        System.out.println("fini");
                        gameLoop.stop();
                    }

                    if(temps%1==0){
                        this.environnement.unTour();
                        for(Tourelles t : this.environnement.getTourelles()){
                            t.checkRange(this.environnement.getEnnemies());
                        }
                    }
                    temps++;
                })
        );

        gameLoop.getKeyFrames().add(kf);
    }

    public void placeTourelle(MouseEvent e){
        if(this.choix) {
            int mouseX = (int) e.getX();
            int mouseY = (int) e.getY();
            if (!this.environnement.existeTourelle(mouseX / 32 * 32, mouseY / 32 * 32) && this.environnement.getMap().quelleCase(mouseX, mouseY)!=0) {
                if(this.IDchoix.equals(T1.getId())){
                    this.environnement.getTourelles().add(new Tourelle2Base(this.environnement, mouseX / 32 * 32, mouseY / 32 * 32));
                }
                else if(this.IDchoix.equals(T2.getId())){
                    this.environnement.getTourelles().add(new Tourelle2Slow(this.environnement, mouseX / 32 * 32, mouseY / 32 * 32));
                }

            } else {
                System.out.println("Vous ne pouvez pas placer de tourelles ici");
            }
        }
    }

    public void Play(ActionEvent e){
        gameLoop.play();
    }

    public void choisir(ActionEvent e){
        if(this.choix){
            this.choix=false;
            T1.setStyle("-fx-background-color: white");
            T2.setStyle("-fx-background-color: white");
            this.IDchoix=null;
        }
        else{
            this.choix=true;
            if(T1.isArmed()){
                T1.setStyle("-fx-background-color: red");
                this.IDchoix=T1.getId();
            }

            else if(T2.isArmed()){
                T2.setStyle("-fx-background-color: red");
                this.IDchoix=T2.getId();
            }
        }
    }

}
