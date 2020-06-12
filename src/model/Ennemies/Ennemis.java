package model.Ennemies;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.Jeu;
import model.Sommet;

public abstract class Ennemis {
    //Classe mère qui permet de donner les attribut de base aux ennemis

    protected Jeu e;
    private static int nbEnnemi = 1;

    private DoubleProperty x,y;
    private double hitboxX, hitboxY;

    private double vitesse;

    private String id;

    // Booléen qui contient l'information de si l'ennemi est ralentit ou non
    private boolean ralentit;

    //Permet de savoir sur qu'elle sommet du BFS on se trouve
    private Sommet sommetActu;

    private IntegerProperty pv;

    //Montant d'argent que le joueur gagne si il tue un ennemi
    private int prime;

    //Constructeur
    public Ennemis(Jeu e, double x, double y, double v, int hp, int p) {
        this.e = e;
        this.ralentit = false;
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.hitboxX = getX()+31;
        this.hitboxY = getY()+31;
        this.vitesse = v;
        this.prime = p;
        nbEnnemi++;
        this.id="E"+nbEnnemi;
        this.pv= new SimpleIntegerProperty(hp);
        this.sommetActu =checkSommet();
    }

    public final DoubleProperty getXProperty() {
        return x;
    }

    public final void SetX(double d){
        this.x.set(d);
    }

    public final double getX(){
        return x.getValue();
    }

    public final DoubleProperty getYProperty() {
        return y;
    }

    public final void SetY(double d){
        this.y.set(d);
    }

    public final double getY(){
        return y.getValue();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IntegerProperty getPVProperty(){
        return this.pv;
    }

    public int getPv() {
        return pv.getValue();
    }

    public void setPv(int pv) {
        this.pv.setValue(pv);
    }

    public String toStringPV(){
        return ""+this.pv;
    }

    public double getHitboxX() {
        return hitboxX;
    }

    public void setHitboxX(double hitboxX) {
        this.hitboxX = hitboxX;
    }

    public double getHitboxY() {
        return hitboxY;
    }

    public void setHitboxY(double hitboxY) {
        this.hitboxY = hitboxY;
    }

    public double getVitesse() {
        return vitesse;
    }

    public boolean isRalentit() {
        return ralentit;
    }

    public void setRalentit(boolean ralentit) {
        this.ralentit = ralentit;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    public Sommet getSommetActu() {
        return sommetActu;
    }

    public void setSommetActu(Sommet sommetActu) {
        this.sommetActu = sommetActu;
    }

    public abstract int getVitesseDeBase();

    public int getPrime() {
        return prime;
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }

    //Permettant d'infliger des dégâts a l'ennemi
    public void prendreDesDgt(int dgt) {
        this.setPv(this.getPv() - dgt);
    }

    public void seDeplace(){
        //Condition pour savoir si l'ennemi peut se déplacer
        if(this.e.getNbTour()%this.vitesse==0) {
            //On regarde si le sommet d'après est null donc si c'est la fin du chemin
            if (this.e.getBfs().getHashmap().get(this.sommetActu) == null) {
                //On met des dégâts à la base du joueur + on retire l'ennemi
                this.e.getBase().decrementerPv(5);
                this.e.getEnnemis().remove(this);
            }
            //On déplace l'ennemie de pixel en pixel, et ducoup il regarde ou se situe les coordonnées du sommet suivant pour si diriger
            else {
                if (this.e.getBfs().getHashmap().get(this.sommetActu).getY() > this.sommetActu.getY()) {
                    this.SetX(this.getX() + 1);
                } else if (this.e.getBfs().getHashmap().get(this.sommetActu).getY() < this.sommetActu.getY()) {
                    this.SetX(this.getX() - 1);
                }

                if (this.e.getBfs().getHashmap().get(this.sommetActu).getX() > this.sommetActu.getX()) {
                    this.SetY(this.getY() + 1);
                } else if (this.e.getBfs().getHashmap().get(this.sommetActu).getX() < this.sommetActu.getX()) {
                    this.SetY(this.getY() - 1);
                }

                if (checkSommet() == this.e.getBfs().getHashmap().get(this.sommetActu)) {
                    this.sommetActu = this.e.getBfs().getHashmap().get(this.sommetActu);
                }

                //Hitbox permettant que l'ennemi prenne 32pixel, qui suit l'ennemi
                this.setHitboxX(this.getX() + 31);
                this.setHitboxY(this.getY() + 31);
            }
        }
    }

    //Si l'ennemi est vivant return true
    public boolean isVivant() {
        return this.getPv()>0;
    }

    //Vérifie si les coordonnées de l'ennemi sont équivalentes à celles d'un sommet du BFS
    public Sommet checkSommet(){
        for(Sommet m : this.e.getGraphe().getListeSommet()){
            if(m.getY()*32 == this.getX() && m.getX()*32 == this.getY()){
                return m;
            }
        }

        return null;
    }

    //Permet a l'ennemi d'agir, elle est abstract car chaque ennemi à un comportement différent
    public abstract void agit();

}
