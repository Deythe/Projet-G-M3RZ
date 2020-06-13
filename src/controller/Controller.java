package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import model.*;
import model.ListeObservable.ObsListEnnemies;
import model.ListeObservable.ObsListPièges;
import model.ListeObservable.ObsListTirs;
import model.ListeObservable.ObsListTourelle;
import model.Pièges.Mine;
import model.Pièges.Piege;
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

    private int temps, tempsStop;

    private boolean choix ;

    private String IDchoix;

    private boolean vagueActive=true;

    private int niveau = 1;

    @FXML
    private Label fin;

    @FXML
    private ImageView logo;

    @FXML
    private Button niveau1;

    @FXML
    private Button niveau2;

    @FXML
    private Button start;

    @FXML
    private Button choixNiveau;

    @FXML
    private Label barreDeVie;

    @FXML
    private Label contenantBarreDeVie;

    @FXML
    private Button vendre;

    @FXML
    private HBox menuAccueil;

    @FXML
    private HBox menuNiveau;

    @FXML
    private Label numVague;

    @FXML
    private Label numNiveau;

    @FXML
    private Label Gluttons;

    @FXML
    private VBox menuAchat;

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
    private TilePane tilepane;

    @FXML
    private Pane pane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //On rend visible que ce que le menuAccueil
        this.choix=false;
        this.barreDeVie.setVisible(false);
        this.contenantBarreDeVie.setVisible(false);
        this.menuNiveau.setVisible(false);
        this.menuAchat.setVisible(false);
        this.tilepane.setVisible(false);
    }

    public void lancerJeu(){

        //On rend visible les éléments nécessaires du jeu + on initialise le jeu"
        this.logo.setVisible(false);
        this.pane.getChildren().remove(this.fin);
        this.pane.getChildren().remove(menuAccueil);
        this.menuAchat.setVisible(true);
        this.tilepane.setVisible(true);
        this.barreDeVie.setVisible(true);
        this.contenantBarreDeVie.setVisible(true);
        this.jeu = new Jeu(niveau);

        //On crée les images view pour afficher les sprites du jeu
        ViewEnnemi viewEnnemi = new ViewEnnemi(this.pane);
        ViewPiege viewPiege = new ViewPiege(this.pane);
        ViewTourelle viewTourelle = new ViewTourelle(this.pane);
        ViewMap viewMap = new ViewMap(this.tilepane);
        viewMap.affichermap(this.jeu.getMap());

        //On bind les différents labels/propriétés et crée les observables listes
        this.barreDeVie.prefWidthProperty().bind(this.jeu.getBase().getPvProperty().multiply(10));
        this.Gluttons.textProperty().bind(this.jeu.getBase().getArgentProperty().asString());
        this.numNiveau.textProperty().bind((this.jeu.getnoNiveauProperty().asString()));
        this.numVague.textProperty().bind((this.jeu.getnoVagueProperty().add(1).asString()));
        this.jeu.getTourelles().addListener(new ObsListTourelle(this.pane, viewTourelle));
        this.jeu.getEnnemis().addListener(new ObsListEnnemies(this.pane, viewEnnemi));
        this.jeu.getTirs().addListener(new ObsListTirs(this.pane));
        this.jeu.getPieges().addListener(new ObsListPièges(this.pane, viewPiege));

        //Initialise la boucle de jeu
        initAnimation();
        this.gameLoop.play();
    }

    public void menuChoixNiveau(ActionEvent e){
        //Affiche les menu des choix de niveau
        this.menuNiveau.setVisible(true);
        this.pane.getChildren().remove(menuAccueil);
    }

    public void choixNiveau(ActionEvent e){
        //Permet de sélectionné le niveau souhaité
        if(niveau1.isArmed()){
            this.niveau=1;
        }
        else if(niveau2.isArmed()){
            this.niveau=2;
        }
        this.pane.getChildren().remove(menuNiveau);
        this.menuAccueil.setVisible(false);
        lancerJeu();
    }


    private void initAnimation() {
        //Création de la boucle de jeu, permettant le déroulement de celui-ci
        gameLoop = new Timeline();
        temps=0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.017),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev ->{

                    //Le jeu se termine si la valeur de la valeur dépasse 5 donc que le niveau est fini ou que la base est détruite
                    if(this.jeu.getnoVague()>=5 || !this.jeu.getBase().estVivant()){
                        System.out.println("fini");
                        gameLoop.stop();
                        this.gameOver();
                    }

                    //On lance un tour si la vague est en cours et on stocke le temps à chaque tour afin de savoir quand la vague se termine
                    else if(temps%1==0 && vagueActive == true){
                        vagueActive = this.jeu.unTour();
                        tempsStop = temps;
                    }

                    //Permet de mettre le temps de pause entre deux vagues
                    else if(temps - tempsStop >= 350 && vagueActive == false){
                        vagueActive = true;
                    }
                    temps++;
                })
        );

        //On ajoute la frame à la boucle
        gameLoop.getKeyFrames().add(kf);
    }

    //Permet de vendre et d'acheter des objets
    public void interractionObjet(MouseEvent e){
            if(this.choix) {

                //On stocke les coordonées de la souris
                int mouseX = (int) e.getX();
                int mouseY = (int) e.getY();

                // Vente : On fait des vérifications si il y a un objet à cet emplacement
                if(this.IDchoix.equals(vendre.getId())) {
                    if(this.jeu.existeTourelle(mouseX / 32 * 32, mouseY / 32 * 32)) {
                        for(Tourelles t : this.jeu.getTourelles()) {
                            if(t.getX() == mouseX /32 * 32 && t.getY() == mouseY / 32 * 32) {
                                if(t instanceof Tourelle2Base) {
                                    this.jeu.getBase().gagnerArgent(Tourelle2Base.getValeur()/2);
                                }
                                else if(t instanceof Tourelle2Zone) {
                                    this.jeu.getBase().gagnerArgent(Tourelle2Zone.getValeur()/2);
                                }
                                else if(t instanceof Tourelle2Slow) {
                                    this.jeu.getBase().gagnerArgent(Tourelle2Slow.getValeur()/2);
                                }
                                this.jeu.getTourelles().remove(t);
                                break;
                            }
                        }
                    }

                    else if (this.jeu.existePiege(mouseX / 32 * 32, mouseY / 32 * 32)){
                        for(Piege p : this.jeu.getPieges()) {
                            if(p.getX() == mouseX /32 * 32 && p.getY() == mouseY / 32 * 32) {
                                if(p instanceof Mine) {
                                    this.jeu.getBase().gagnerArgent(Mine.getValeur()/2);
                                }
                                else if(p instanceof Ressort) {
                                    this.jeu.getBase().gagnerArgent(Ressort.getValeur()/2);
                                }
                                else if(p instanceof Trappe) {
                                    this.jeu.getBase().gagnerArgent(Trappe.getValeur()/2);
                                }
                                this.jeu.getPieges().remove(p);
                                break;
                            }
                        }
                    }
                }

                // Achat : On vérifie si on a l'argent et qu'on peut placer un objet ici
                else {
                    if (!this.jeu.existeTourelle(mouseX / 32 * 32, mouseY / 32 * 32)) {
                        if(!this.mauvaiseCase(mouseX, mouseY)) {
                            if (this.IDchoix.equals(T1.getId()) && this.jeu.getBase().depenserArgent(Tourelle2Base.getValeur())) {
                                this.jeu.getTourelles().add(new Tourelle2Base(this.jeu, mouseX / 32 * 32, mouseY / 32 * 32));
                            } else if (this.IDchoix.equals(T2.getId()) && this.jeu.getBase().depenserArgent(Tourelle2Slow.getValeur())) {
                                this.jeu.getTourelles().add(new Tourelle2Slow(this.jeu, mouseX / 32 * 32, mouseY / 32 * 32));
                            } else if (this.IDchoix.equals(T3.getId()) && this.jeu.getBase().depenserArgent(Tourelle2Zone.getValeur())) {
                                this.jeu.getTourelles().add(new Tourelle2Zone(this.jeu, mouseX / 32 * 32, mouseY / 32 * 32));
                            }
                        }
                    }

                    if(!this.jeu.existePiege(mouseX / 32 * 32, mouseY / 32 * 32)){
                        if(this.mauvaiseCase(mouseX, mouseY)) {
                            if (this.IDchoix.equals(P1.getId()) && this.jeu.getBase().depenserArgent(Ressort.getValeur())) {
                                this.jeu.getPieges().add(new Ressort(this.jeu, mouseX / 32 * 32, mouseY / 32 * 32));
                            } else if (this.IDchoix.equals(P2.getId()) && this.jeu.getBase().depenserArgent(Mine.getValeur())) {
                                this.jeu.getPieges().add(new Mine(this.jeu, mouseX / 32 * 32, mouseY / 32 * 32));
                            }
                            if (this.IDchoix.equals(P3.getId()) && this.jeu.getBase().depenserArgent(Trappe.getValeur())) {
                                this.jeu.getPieges().add(new Trappe(this.jeu, mouseX / 32 * 32, mouseY / 32 * 32));
                            }
                        }
                    }
                }
            }
    }

    //Méthode qui renvoie true si on ne peut pas placer d'objet ici en fonction du numéro de la case correspondante
    public boolean mauvaiseCase(int x, int y){
        for(int i=0; i<10; i++){
            if(this.jeu.getMap().quelleCase(x, y)==i){
                return true;
            }
        }

        if(this.jeu.getMap().quelleCase(x,y)==10){
            return true;
        }

        return false;
    }

    //Méthode qui se lance à la fin du niveau
    public void gameOver(){
        //On rend visible seulement le menu de départ, et le message de défaite/victoire et on remet à zéro le pane et tilepane
        this.choix=false;
        this.barreDeVie.setVisible(false);
        this.contenantBarreDeVie.setVisible(false);
        this.menuAchat.setVisible(false);
        this.menuNiveau.setVisible(false);
        this.tilepane.setVisible(false);
        this.tilepane.getChildren().clear();
        this.pane.getChildren().clear();

        this.fin = new Label();
        this.fin.setTranslateX(340);
        this.fin.setTranslateY(150);
        this.fin.setFont(Font.font ("Verdana", 50));

        if(!this.jeu.getBase().estVivant()){
            this.fin.setTextFill(Color.RED);
            this.fin.setText("Défaite!");
        }

        else{
            this.fin.setTextFill(Color.GREEN);
            this.fin.setText("Victoire!");
        }

        this.pane.getChildren().add(this.tilepane);
        this.pane.getChildren().add(this.fin);
        this.pane.getChildren().add(this.menuAccueil);
        this.pane.getChildren().add(menuNiveau);
    }

    //Permet de savoir quel bouton est enclenché et ducoup de le mettre en couleur
    public void choisir(ActionEvent e){
        if(this.choix){
            this.choix=false;
            T1.setStyle("-fx-background-color: grey");
            T2.setStyle("-fx-background-color: grey");
            T3.setStyle("-fx-background-color: grey");
            P1.setStyle("-fx-background-color: grey");
            P2.setStyle("-fx-background-color: grey");
            P3.setStyle("-fx-background-color: grey");
            vendre.setStyle("-fx-background-color: grey");
            this.description.setText("");
            this.IDchoix=null;
        }
        else{
            this.choix=true;
            if(T1.isArmed()){//Si le bouton est enclanché
                T1.setStyle("-fx-background-color: red");
                this.description.setText("Tourelle : Basique \nDégats : 2\nRange : 2 Cases \nCoût : 100 Gluttons");
                this.IDchoix=T1.getId();
            }

            else if(T2.isArmed()){
                T2.setStyle("-fx-background-color: red");
                this.description.setText("Tourelle : Slow \nDégats : Ø \nRange : 3 Cases \nCoût : 150 Gluttons");
                this.IDchoix=T2.getId();
            }

            else if(T3.isArmed()){
                T3.setStyle("-fx-background-color: red");
                this.description.setText("Tourelle : Zone \nDégats : 5\nRange : 2 Cases \nCoût : 200 Gluttons");
                this.IDchoix=T3.getId();
            }

            else if(P1.isArmed()){
                P1.setStyle("-fx-background-color: red");
                this.description.setText("Piège : Ressort \nDégats : Ø \nRange : Ø \nCoût : 100 Gluttons");
                this.IDchoix=P1.getId();
            }

            else if(P2.isArmed()){
                P2.setStyle("-fx-background-color: red");
                this.description.setText("Piège : Mine \nDégats :  \nRange \nCoût : 50 Gluttons");
                this.IDchoix=P2.getId();
            }

            else if(P3.isArmed()){
                P3.setStyle("-fx-background-color: red");
                this.description.setText("Piège : Trappe \nDégats : \nRange \nCoût : 150 Gluttons");
                this.IDchoix=P3.getId();
            }

            else if(vendre.isArmed()) {
                vendre.setStyle("-fx-background-color: red");
                this.IDchoix = vendre.getId();
            }
        }
    }

}
