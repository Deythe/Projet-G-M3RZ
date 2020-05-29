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
        LinkedList<Sommet> test = new LinkedList<>();
        ArrayList<Sommet> déjaPassé = new ArrayList<>();
        test.addFirst(this.début);
        while(!test.isEmpty()){
            Sommet s = test.removeLast();
            déjaPassé.add(s);
            for(Sommet adj : s.getAdjacents()){
                if(!déjaPassé.contains(adj)){
                    test.addFirst(adj);
                    this.hashmap.put(adj, s);
                }
            }
        }
        System.out.println(this.hashmap);
    }

    public HashMap<Sommet, Sommet> getHashmap() {
        return hashmap;
    }
}
