package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BFS {
    private HashMap<Sommet, Sommet> hashmap;
    private Graphe graphe;
    private Sommet début;

    public BFS(Graphe graphe) {
        this.hashmap = new HashMap<>();
        this.graphe = graphe;
        trouvéPremier();
        créationBFS();
    }

    public void trouvéPremier(){
        for (Sommet m : this.graphe.getListeSommet()){
            if(m.getX() == this.graphe.getxDépart() && m.getY() == this.graphe.getyDépart()){
                this.début=m;
            }
        }
    }

    public void créationBFS(){
        LinkedList<Sommet> file = new LinkedList<>();
        ArrayList<Sommet> déjaPassé = new ArrayList<>();
        file.addFirst(this.début);
        déjaPassé.add(this.début);
        while(!file.isEmpty()){
            Sommet s = file.removeLast();
            for(int i=0; i<s.getAdjacents().size(); i++){
                if(!déjaPassé.contains(s.getAdjacents().get(i))){
                    file.addFirst(s.getAdjacents().get(i));
                    déjaPassé.add(s.getAdjacents().get(i));
                    this.hashmap.put(s.getAdjacents().get(i), s);
                }
            }
        }
    }

    public HashMap<Sommet, Sommet> getHashmap() {
        return hashmap;
    }
}
