package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import model.*;
import view.ViewEnnemi;
import view.ViewMap;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Environnement environnement;

    private Timeline gameLoop;

    private int temps;

    @FXML
    private TilePane Tilepane;

    @FXML
    private Pane pane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.environnement = new Environnement();
        ViewMap.affichermap(this.Tilepane, this.environnement.getMap());
        this.environnement.getTourelles().addListener(new ObsListTourelle(this.pane));
        this.environnement.getEnnemies().addListener(new ObsListEnnemies(this.pane));

        /*for(int i=0; i<this.pane.getChildren().size();i++){
            for(Ennemies a : this.environnement.getEnnemies()){
                if (a.getId().equals(this.pane.getChildren().get(i).getId())){
                    this.pane.getChildren().get(i).translateXProperty().bind(a.getX());
                    this.pane.getChildren().get(i).translateYProperty().bind(a.getY());
                    break;
                }
            }
        }

         */
        initAnimation();
        gameLoop.play();
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
                    if(temps==1000){
                        System.out.println("fini");
                        gameLoop.stop();
                    }

                    if(temps%20==0){
                        System.out.println("Pop");
                        this.environnement.getEnnemies().add(new BananaMan(0,0,2));
                    }

                    if (temps%5==0){
                        System.out.println("Tour");
                        for(Ennemies a : this.environnement.getEnnemies()) {
                            a.seDeplace();
                        }

                        for(Tourelles t : this.environnement.getTourelles()){
                            t.checkRange(this.environnement.getEnnemies());
                            //t.Tire();
                        }
                    }


                    temps++;
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }

    public void placeTourelle(MouseEvent e){
        int mouseX = (int)e.getX();
        int mouseY = (int)e.getY();
        this.environnement.getTourelles().add(new Tourelle2Base(mouseX, mouseY));
    }

}
