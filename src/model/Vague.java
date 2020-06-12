package model;

import model.Ennemies.Carambo;
import model.Ennemies.Gladiem;
import model.Ennemies.Plank;
import model.Exceptions.*;

//C'est ici qu'on stocke le nombre d'ennemis par vague et le temps de spawn max entre chaque ennemi
public class Vague {
	private int nbCarambo, nbGladiem, nbPlank;
	private int tempsSpawnMax;
	private Jeu jeu;
	private static int cdSpawn;

	public Vague(Jeu jeu) {
		this.nbCarambo = 0;
		this.nbGladiem = 0;
		this.nbPlank = 0;
		this.jeu = jeu;
		this.tempsSpawnMax = 0;
		cdSpawn = 0;
	}

	//On récupère les données de la vague stockées dans la classe paramétrage
	public void nouvelleVague(int noNiveau, int noVague) {
		if(noNiveau == 1) {
			this.nbCarambo = Parametrage.vaguesLvl1[noVague][0];
			this.nbGladiem = Parametrage.vaguesLvl1[noVague][1];
			this.nbPlank = Parametrage.vaguesLvl1[noVague][2];
			this.tempsSpawnMax = Parametrage.vaguesLvl1[noVague][3];
		}
		else if(noNiveau == 2) {
			this.nbCarambo = Parametrage.vaguesLvl2[noVague][0];
			this.nbGladiem = Parametrage.vaguesLvl2[noVague][1];
			this.nbPlank = Parametrage.vaguesLvl2[noVague][2];
			this.tempsSpawnMax = Parametrage.vaguesLvl2[noVague][3];
		}

	}

	//Gère le nombre d'ennemi restant et la fréquence d'apparition et renvoie false si il n'y a plus d'ennemi vivant ou à faire spawn
	public boolean gestionVague() {
		if(this.jeu.getNbTour() % 100 == 0) {
			if(cdSpawn == 0) {
				cdSpawn = (int)(Math.random() * this.tempsSpawnMax + 1);
				if(nbCarambo != 0 || nbGladiem != 0 || nbPlank != 0) {
					this.randomMob();
					return true;
				}
				else if(this.jeu.getEnnemis().isEmpty()){
					return false;
				}
				else {
					return true;
				}
			}
			else {
				cdSpawn--;
				return true;
			}
		}
		else {
			return true;
		}
	}

	//Fait apparaitre un ennemi aléatoire à un spawn aléatoirement choisi dans la liste des spawns
	private void randomMob() {
		int spawnX = 0;
		int spawnY = 0;
		int nbRandom = (int)(Math.random() * 3);
		int choix;
		try {
			choix = ((int) (Math.random() * (this.jeu.getMap().getSpawns().size() - 1) / 2)) * 2;
			spawnX = this.jeu.getMap().getSpawns().get(choix);
			spawnY = this.jeu.getMap().getSpawns().get(choix + 1);
			if((spawnX%32 != 0 && spawnY%32 != 0 && (this.jeu.getMap().getMap()[spawnX/32][spawnY/32] < 0 || this.jeu.getMap().getMap()[spawnX/32][spawnY/32] > 9))) {
				throw new SpawnHorsMapException();
			}
		}
		catch(SpawnHorsMapException e){
			spawnX = 0;
			spawnY = 160;
		}
		while(nbRandom != -1) {
			if(nbRandom % 3 == 0) {
				if(nbCarambo > 0) {
					this.jeu.getEnnemis().add(new Carambo(jeu, spawnX, spawnY));
					nbCarambo--;
					nbRandom = -1;
				}
				else {
					nbRandom++;
				}
			}
			else if(nbRandom % 3 == 1){
				if(nbGladiem > 0) {
					this.jeu.getEnnemis().add(new Gladiem(jeu, spawnX, spawnY));
					nbGladiem--;
					nbRandom = -1;
				}
				else {
					nbRandom++;
				}
			}
			else {
				if(nbPlank > 0) {
					this.jeu.getEnnemis().add(new Plank(jeu, spawnX, spawnY));
					nbPlank--;
					nbRandom = -1;
				}
				else {
					nbRandom++;
				}
			}
		}
	}
	
	
	
	
}