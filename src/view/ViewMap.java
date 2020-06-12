package view;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import model.Exceptions.*;
import model.Map;

public class ViewMap {

    private TilePane p;

    public ViewMap(TilePane p) {
        this.p = p;
    }

    //On crée une image view pour chaque élément du tableau du modèle et en fonction de la classe de la donnée de celui il aura une image différente
    public void affichermap(Map map){
        Image image = new Image("/images/tileset.png");
        for(int x=0; x<map.getMap().length; x++){
            for(int y=0; y<map.getMap()[x].length;y++){
                ImageView test = new ImageView();
                test.setImage(image);
                if(map.getMap()[x][y]==100){
                    test.setViewport(new Rectangle2D(32, 0, 32, 32));
                }
                else{
                    try{
                        if(map.getMap()[x][y]<0 || map.getMap()[x][y]>55){
                            throw new GenerationMapException();
                        }
                    } catch (GenerationMapException e){
                        map.getMap()[x][y]=29;
                    }
                    test.setViewport(new Rectangle2D(map.getMap()[x][y]%7*32, (map.getMap()[x][y]/7)*32, 32, 32));
                }
                this.p.getChildren().add(test);
            }
        }
    }
}
