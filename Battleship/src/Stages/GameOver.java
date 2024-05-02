package Stages;

import Main.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOver extends Stage {
    final double height = 800;
    final double width = 800;
    public GameOver(Player p1, Player p2){
        this.setTitle("Battleship - Game Over");
        Label l1 = new Label("GAME OVER!");
        l1.getStyleClass().add("title");
        Label l2 = new Label("winner label");
        l2.getStyleClass().add("title");
        if(p1.checkLoser()){
            l2.setText(p1.getUsername()+" wins!");
        } else if(p2.checkLoser()){
            l2.setText(p2.getUsername()+" wins!");
        }

        VBox root = new VBox(l1,l2);
        root.setAlignment(Pos.CENTER);
        Scene sc = new Scene(root, width, height);

        sc.getStylesheets().add("Framework.css");
        this.setScene(sc);

    }
}
