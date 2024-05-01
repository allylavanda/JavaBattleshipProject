package Stages;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GameOver extends Stage {
    final double height = 800;
    final double width = 800;
    public GameOver(){
        this.setTitle("Battleship - Game Over");
        Label l1 = new Label("GAME OVER!");
        l1.getStyleClass().add("title");
        Label l2 = new Label("winner label");

        VBox root = new VBox(l1,l2);
        Scene sc = new Scene(root, width, height);
        sc.getStylesheets().add("Framework.css");
        this.setScene(sc);

    }
}
