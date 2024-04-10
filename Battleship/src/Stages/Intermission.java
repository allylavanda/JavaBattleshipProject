package Stages;

import Handler.CurrentPlayer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Intermission extends Stage{
    final double width = 800;
    final double height = 800;
    private Image player;
    private CurrentPlayer currentPlayer = new CurrentPlayer();
    public Intermission(int p){
        this.setTitle("Battle Ship - Intermission");
        Label l1 = new Label("Intermission");
        l1.getStyleClass().add("title");
        // player image
        currentPlayer.set(p);
        setPlayerImage(p);
        ImageView pView = new ImageView(player);
        pView.setFitWidth(400);
        pView.setFitHeight(200);

        Label l2 = new Label("Waiting on next player...");
        l2.getStyleClass().add("waiting");
        Button b1 = new Button("START TURN");
        b1.setMinHeight(100);
        b1.setMinWidth(600);
        b1.getStyleClass().add("start-turn-button");
        Button b2 = new Button("FORFEIT");
        b2.setMinHeight(100);
        b2.setMinWidth(600);
        b2.getStyleClass().add("forfeit-button");

        // root box
        VBox root = new VBox(20,l1,pView,l2,b1,b2);
        root.setAlignment(Pos.CENTER);
        // add to scene and display
        Scene sc = new Scene(root, width, height);
        sc.getStylesheets().add("Framework.css");
        this.setScene(sc);
    }
    private void setPlayerImage(int p){
        if(currentPlayer.get() == 1){
            player = new Image("player1.png");
        }
        if(currentPlayer.get() == 2) {
            player = new Image("player2.png");
        }
    }
}
