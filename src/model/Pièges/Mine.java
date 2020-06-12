package model.Pièges;

import model.Ennemies.Ennemis;
import model.Jeu;

public class Mine extends Piege {
    //Piège qui fait des dégats de zone quand l'ennemi marche dessus


    int degatsDeclenchement;
    int range;

    //Valeur d'achat de l'objet
    private static int valeur = 50;

    public Mine(Jeu j, double x, double y) {
        super(j, x, y);
        this.degatsDeclenchement=20;
        this.range=64;
    }

    //Si conditions remplies, elle s'active
    public void agit(){
        if(this.actif && this.checkEnnemi()) {
            this.activation();
            this.actif = false;
        }
    }

    //regarde si les coordonnées d'un ennemi se situe a l'endroit de l'objet
    public boolean checkEnnemi(){
        for (Ennemis n:  this.jeu.getEnnemis()) {
            if((n.getX()==this.x || n.getHitboxX()==this.x) && (n.getY()==this.y || n.getHitboxY()==this.y)){
                return true;
            }
        }

        return false;
    }

    //BOOM elle explose sur tout les ennemie dans la range
    public void activation(){
        for (Ennemis n:  this.jeu.getEnnemis()) {
            if((n.getX()==this.x || n.getHitboxX()==this.x) && (n.getY()==this.y || n.getHitboxY()==this.y)){
                 n.prendreDesDgt(this.degatsDeclenchement);
                 this.jeu.getPieges().remove(this);
            }
       }
    }


    public static int getValeur() {
        return valeur;
    }

}
