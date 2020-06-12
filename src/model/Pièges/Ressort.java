package model.Pièges;

import model.Ennemies.Ennemis;
import model.Jeu;

public class Ressort extends Piege {
    //Piège qui renvoie l'ennemi qui passe sur lui a un des spawn de manière aléatoire

    private Ennemis cible;
    private static int valeur = 100;

    public Ressort( Jeu j, double x, double y) {
        super(j, x, y);
        this.cible=null;
    }

    @Override
    public void agit() {
        checkEnnemi();
        if(this.actif && this.cible!=null){
            activation();
            this.actif=false;
        }
    }

    @Override
    public boolean checkEnnemi(){
        for (Ennemis n:  this.jeu.getEnnemis()) {
            if((n.getX()==this.x || n.getHitboxX()==this.x) && (n.getY()==this.y || n.getHitboxY()==this.y)){
                this.cible=n;
                return true;
            }
        }

        return false;
    }

    //Méthode qui renvoie l'ennemi dessus à l'un des spawn de façon aléatoire
    public void activation(){
        int choix = ((int) (Math.random() * (this.jeu.getMap().getSpawns().size() - 1) / 2)) * 2;
        int spawnX = this.jeu.getMap().getSpawns().get(choix);
        int spawnY = this.jeu.getMap().getSpawns().get(choix + 1);
        this.cible.SetX(spawnX);
        this.cible.SetY(spawnY);
        this.cible.setSommetActu(this.cible.checkSommet());
        this.cible=null;
    }

    public static int getValeur() {
        return valeur;
    }

}
