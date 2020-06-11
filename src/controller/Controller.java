package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.*;
import model.ListeObservable.ObsListEnnemies;
import model.ListeObservable.ObsListPièges;
import model.ListeObservable.ObsListTirs;
import model.ListeObservable.ObsListTourelle;
import model.Pièges.Mine;
import model.Pièges.Ressort;
import model.Pièges.Trappe;
import model.Tourelles.Tourelle2Base;
import model.Tourelles.Tourelle2Slow;
import model.Tourelles.Tourelle2Zone;
import model.Tourelles.Tourelles;
import view.ViewEnnemi;
import view.ViewMap;
import view.ViewPiege;
import view.ViewTourelle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Jeu jeu;

    private Timeline gameLoop;

    private int temps;

    private boolean choix ;

    private String IDchoix;

    @FXML
    private Button start;

    @FXML
    private Label Gluttons;

    @FXML
    private VBox menu;

    @FXML
    private Button T1;

    @FXML
    private Button T2;

    @FXML
    private Button T3;

    @FXML
    private Button P1;

    @FXML
    private Button P2;

    @FXML
    private Button P3;

    @FXML
    private Label description;

    @FXML
    private TilePane Tilepane;

    @FXML
    private Pane pane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.jeu = new Jeu();
        this.choix=false;
        this.menu.setVisible(false);
        this.Tilepane.setVisible(false);
        ViewEnnemi viewEnnemi = new ViewEnnemi(this.pane);
        ViewPiege viewPiege = new ViewPiege(this.pane);
        ViewTourelle viewTourelle = new ViewTourelle(this.pane);
        ViewMap viewMap = new ViewMap(this.Tilepane);
        viewMap.affichermap(this.jeu.getMap());
        this.Gluttons.textProperty().bind(this.jeu.getBase().getArgent().asString());
        this.jeu.getTourelles().addListener(new ObsListTourelle(this.pane, viewTourelle));
        this.jeu.getEnnemies().addListener(new ObsListEnnemies(this.pane, viewEnnemi));
        this.jeu.getTirs().addListener(new ObsListTirs(this.pane));
        this.jeu.getPieges().addListener(new ObsListPièges(this.pane, viewPiege));
        initAnimation();
    }

    public void lancerJeu(ActionEvent e){
        this.pane.getChildren().remove(start);
        this.menu.setVisible(true);
        this.Tilepane.setVisible(true);
        this.gameLoop.play();
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
                    if (!this.jeu.getBase().estVivant()){
                        System.out.println("GAME OVER");
                        gameLoop.stop();
                    }

                    if(temps%1==0){
                        this.jeu.unTour();
                    }
                    temps++;
                })
        );

        gameLoop.getKeyFrames().add(kf);
    }

    public void placeObjet(MouseEvent e){
        if(this.choix) {
            int mouseX = (int) e.getX();
            int mouseY = (int) e.getY();

            if (!this.jeu.existeTourelle(mouseX / 32 * 32, mouseY / 32 * 32) && this.jeu.getMap().quelleCase(mouseX, mouseY)!=0 && this.jeu.getMap().quelleCase(mouseX, mouseY)!=100) {
                if (this.IDchoix.equals(T1.getId()) && this.jeu.getBase().depenserArgent(Tourelle2Base.getValeur())) {
                    this.jeu.getTourelles().add(new Tourelle2Base(this.jeu, mouseX / 32 * 32, mouseY / 32 * 32));
                } else if (this.IDchoix.equals(T2.getId()) && this.jeu.getBase().depenserArgent(Tourelle2Slow.getValeur())) {
                    this.jeu.getTourelles().add(new Tourelle2Slow(this.jeu, mouseX / 32 * 32, mouseY / 32 * 32));
                } else if (this.IDchoix.equals(T3.getId()) && this.jeu.getBase().depenserArgent(Tourelle2Zone.getValeur())) {
                    this.jeu.getTourelles().add(new Tourelle2Zone(this.jeu, mouseX / 32 * 32, mouseY / 32 * 32));
                }

            }

            else if(this.jeu.getMap().quelleCase(mouseX, mouseY)==0 && !this.jeu.existePiege(mouseX / 32 * 32, mouseY / 32 * 32)){
                if (!this.jeu.existePiege(mouseX / 32 * 32, mouseY / 32 * 32) && this.jeu.getMap().quelleCase(mouseX, mouseY)==0) {
                    if (this.IDchoix.equals(P1.getId())  && this.jeu.getBase().depenserArgent(Ressort.getValeur())) {
                        this.jeu.getPieges().add(new Ressort(this.jeu, mouseX / 32 * 32, mouseY / 32 * 32));
                    } else if (this.IDchoix.equals(P2.getId()) && this.jeu.getBase().depenserArgent(Mine.getValeur())) {
                        this.jeu.getPieges().add(new Mine(this.jeu, mouseX / 32 * 32, mouseY / 32 * 32));
                    } else if (this.IDchoix.equals(P3.getId()) && this.jeu.getBase().depenserArgent(Mine.getValeur())) {
                        this.jeu.getPieges().add(new Trappe(this.jeu, mouseX / 32 * 32, mouseY / 32 * 32));
                    }
                }
            }

        }
    }

    public void choisir(ActionEvent e){
        if(this.choix){
            this.choix=false;
            T1.setStyle("-fx-background-color: grey");
            T2.setStyle("-fx-background-color: grey");
            T3.setStyle("-fx-background-color: grey");
            P1.setStyle("-fx-background-color: grey");
            P2.setStyle("-fx-background-color: grey");
            P3.setStyle("-fx-background-color: grey");
            this.description.setText("");
            this.IDchoix=null;
        }
        else{
            this.choix=true;
            if(T1.isArmed()){
                T1.setStyle("-fx-background-color: red");
                this.description.setText("Tourelle : Basique \nDégats : 2\nRange \nCoût : 100 Gluttons");
                this.IDchoix=T1.getId();
            }

            else if(T2.isArmed()){
                T2.setStyle("-fx-background-color: red");
                this.description.setText("Tourelle : Slow \nDégats : Ø \nRange \nCoût : 150 Gluttons");
                this.IDchoix=T2.getId();
            }

            else if(T3.isArmed()){
                T3.setStyle("-fx-background-color: red");
                this.description.setText("Tourelle : Zone \nDégats : 5\nRange \nCoût : 200 Gluttons");
                this.IDchoix=T3.getId();
            }

            else if(P1.isArmed()){
                P1.setStyle("-fx-background-color: red");
                this.description.setText("Piège : Ressort \nDégats : Ø \nRange : Ø \nCoût : 100 Gluttons");
                this.IDchoix=P1.getId();
            }

            else if(P2.isArmed()){
                P2.setStyle("-fx-background-color: red");
                this.description.setText("Piège : Mine \nDégats :  \nRange \nCoût : 100 Gluttons");
                this.IDchoix=P2.getId();
            }

            else if(P3.isArmed()){
                P3.setStyle("-fx-background-color: red");
                this.description.setText("Piège : Trappe \nDégats : \nRange \nCoût : 100 Gluttons");
                this.IDchoix=P3.getId();
            }
        }
    }

}
