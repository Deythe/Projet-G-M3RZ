package model.Pièges;

import model.Ennemies.Ennemis;
import model.Jeu;

public class Trappe extends Piege {
    //Piège qui s'ouvre pendant un temps dès que le premier ennemi passe dessus et les ennemis suivant meurts instantanéments

    boolean ouvert;

    //On stocke le première tour d'utlisation
    int tourDebut;
    private static int valeur = 150;

    public Trappe(Jeu j, double x, double y) {
        super(j, x, y);
        this.actif=true;
    }

    //Si elle est fermé et actif elle appelle la méthode ouverture
    public void agit(){
        if (!this.ouvert && this.actif){
            if (this.jeu.getNbTour()==this.tourDebut+250){
                this.actif=false;
                this.ouvert=true;
            }else {
                this.activation();
            }
        }else{
            this.ouverture();
        }
    }

    //Regarde si elle est active et si un ennemi est dessus et le tourDebut prend la valeur du tour actuel
    public void ouverture(){
        if(this.actif && this.checkEnnemi()){
            this.actif=true;
            this.tourDebut=this.jeu.getNbTour();
        }
    }

    public boolean checkEnnemi(){
        for (Ennemis n:  this.jeu.getEnnemis()) {
            if((n.getX()==this.x || n.getHitboxX()==this.x) && (n.getY()==this.y || n.getHitboxY()==this.y)){
                return true;
            }
        }

        return false;
    }

    //Méthode qui met les PV de l'ennemi à zéro quand il passe sur la trappe
    public void activation() {
        for (Ennemis n:  this.jeu.getEnnemis()) {
            if((n.getX()==this.x || n.getHitboxX()==this.x) && (n.getY()==this.y || n.getHitboxY()==this.y)){
                n.setPv(0);
            }
        }
    }

    public static int getValeur() {
        return valeur;
    }
}
