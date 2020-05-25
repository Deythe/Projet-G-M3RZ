package model;

import java.util.ArrayList;

public class Map {
    private int[][] map;
    private int x,y;
    private static int lvl = 0;

    public Map() {
        this.map = chargement();
        this.x = 640;
        this.y = 640;
        lvl++;
    }

    public int[][] chargement() {
        switch (lvl) {
            case 0:
                return new int[][]{
                        {5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {5, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1, 1, 1},
                        {5, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1, 1, 1},
                        {6, 2, 2, 7, 0, 0, 5, 1, 1, 1, 1, 1, 1, 3, 0, 0, 6, 2, 2, 1},
                        {0, 0, 0, 0, 0, 0, 5, 1, 1, 1, 1, 1, 1, 3, 0, 0, 0, 0, 0, 5},
                        {0, 0, 0, 0, 0, 0, 5, 1, 1, 1, 1, 1, 1, 3, 0, 0, 0, 0, 0, 1},
                        {4, 4, 4, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 8, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 0, 1},
                        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 7, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 0, 1},
                        {2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 7, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 5, 1, 1, 1, 1, 1, 1, 3, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 5, 1, 1, 1, 1, 1, 1, 3, 0, 0, 0, 0, 0, 5},
                        {9, 4, 4, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 4, 4, 1},
                        {1, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                        {5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

            case 2:
                break;

            default:break;
        }
        return null;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }
    
    public ArrayList<Case> BFS(int xDepart, int yDepart, int xArrivee, int yArrivee) {	
    	ArrayList<Case> listeCases = new ArrayList<Case>();
    	ArrayList<Case> casesAnalyses = new ArrayList<Case>();
    	ArrayList<Case> listeParent = new ArrayList<Case>();
    	
    	int[][] tableau = this.getMap();
    	int x = xDepart, y = yDepart;
    	boolean pareil = false;
    	Case parent;
    	
    	listeCases.add(new Case(x, y, null));
    	
    	while(x != xArrivee && y != yArrivee) {
    		//On analyse les 8 cases autour de la case actuelle
    		// x - 1, y
    		if(((x - 1) >= 0 && (x - 1) < tableau.length) && ((y >= 0) && (y < tableau[x].length))) {
    			Case nouvCase = new Case(x - 1, y, listeCases.get(0));
    			for(Case comparaison : listeCases) {
    				if(nouvCase.memeCase(comparaison)){
    					pareil = true;
    				}
    			}
   				if(!pareil) {
   					listeCases.add(nouvCase);
   				}
   				pareil = false;
    		}
    		//x - 1, y - 1
    		if(((x - 1) >= 0 && (x - 1) < tableau.length) && (((y - 1) >= 0) && ((y - 1) < tableau[x].length))) {
    			Case nouvCase = new Case(x - 1, y - 1, listeCases.get(0));
    			for(Case comparaison : listeCases) {
    				if(nouvCase.memeCase(comparaison)){
    					pareil = true;
    				}
    			}
   				if(!pareil) {
   					listeCases.add(nouvCase);
   				}
   				pareil = false;
    		}
    		//x, y-1
    		if((x >= 0 && x < tableau.length) && (((y - 1) >= 0) && ((y - 1) < tableau[x].length))) {
    			Case nouvCase = new Case(x, y - 1, listeCases.get(0));
    			for(Case comparaison : listeCases) {
    				if(nouvCase.memeCase(comparaison)){
    					pareil = true;
    				}
    			}
   				if(!pareil) {
   					listeCases.add(nouvCase);
   				}
   				pareil = false;
    		}
    		//x + 1, y - 1
    		if(((x + 1) >= 0 && (x + 1) < tableau.length) && (((y - 1) >= 0) && ((y - 1) < tableau[x].length))) {
    			Case nouvCase = new Case(x + 1, y - 1, listeCases.get(0));
    			for(Case comparaison : listeCases) {
    				if(nouvCase.memeCase(comparaison)){
    					pareil = true;
    				}
    			}
   				if(!pareil) {
   					listeCases.add(nouvCase);
   				}
   				pareil = false;
    		}
    		//x + 1, y
    		if(((x + 1) >= 0 && (x + 1) < tableau.length) && ((y >= 0) && (y < tableau[x].length))) {
    			Case nouvCase = new Case(x + 1, y, listeCases.get(0));
    			for(Case comparaison : listeCases) {
    				if(nouvCase.memeCase(comparaison)){
    					pareil = true;
    				}
    			}
   				if(!pareil) {
   					listeCases.add(nouvCase);
   				}
   				pareil = false;
    		}
    		//x + 1, y + 1
    		if(((x + 1) >= 0 && (x + 1) < tableau.length) && (((y + 1) >= 0) && ((y + 1) < tableau[x].length))) {
    			Case nouvCase = new Case(x + 1, y + 1, listeCases.get(0));
    			for(Case comparaison : listeCases) {
    				if(nouvCase.memeCase(comparaison)){
    					pareil = true;
    				}
    			}
   				if(!pareil) {
   					listeCases.add(nouvCase);
   				}
   				pareil = false;
    		}
    		//x, y + 1
    		if((x >= 0 && x < tableau.length) && (((y + 1) >= 0) && ((y + 1) < tableau[x].length))) {
    			Case nouvCase = new Case(x, y + 1, listeCases.get(0));
    			for(Case comparaison : listeCases) {
    				if(nouvCase.memeCase(comparaison)){
    					pareil = true;
    				}
    			}
   				if(!pareil) {
   					listeCases.add(nouvCase);
   				}
   				pareil = false;
    		}
    		//x - 1, y + 1
    		if(((x - 1) >= 0 && (x -1) < tableau.length) && (((y + 1) >= 0) && ((y + 1) < tableau[x].length))) {
    			Case nouvCase = new Case(x - 1, y + 1, listeCases.get(0));
    			for(Case comparaison : listeCases) {
    				if(nouvCase.memeCase(comparaison)){
    					pareil = true;
    				}
    			}
   				if(!pareil) {
   					listeCases.add(nouvCase);
   				}
   				pareil = false;
    		}
    		casesAnalyses.add(listeCases.get(0));
    		listeCases.remove(0);
    		x = listeCases.get(0).getX();
    		y = listeCases.get(0).getY();
    	}
    	
    	listeParent.add(casesAnalyses.get(casesAnalyses.size()-1));
    	while(listeParent.get(listeParent.size()-1).getParent() != null) {
    		listeParent.add(listeParent.get(listeParent.size()-1).getParent());
    	}
    	
    	return listeParent;
    }
}
