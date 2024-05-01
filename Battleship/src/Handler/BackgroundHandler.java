package Handler;

import Main.Player;
import javafx.scene.layout.VBox;

public class BackgroundHandler {
    public void set(Player p, VBox root){
        if(p.getColor().equalsIgnoreCase("red")){
            root.getStyleClass().add("red-player");
        } else if(p.getColor().equalsIgnoreCase("green")){
            root.getStyleClass().add("green-player");
        } else if(p.getColor().equalsIgnoreCase("yellow")) {
            root.getStyleClass().add("yellow-player");
        } else if(p.getColor().equalsIgnoreCase("blue")){
            root.getStyleClass().add("blue-player");
        }
    }
}
