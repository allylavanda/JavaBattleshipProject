package Stages;

import Main.Player;
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
    private final Image playerOne = new Image("player1.png");
    private final Image playerTwo = new Image("player2.png");
    private ImageView pView;
    public Intermission(Player p1, Player p2){
        this.setTitle("Battle Ship - Intermission");
        Label l1 = new Label("Intermission");
        l1.getStyleClass().add("title");
        // player image
        setPlayerImage(p1,p2);


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

        // event listeners
        b1.setOnAction(event -> {
            this.close();
        });

        // root box
        VBox root = new VBox(20,l1,pView,l2,b1,b2);
        root.setAlignment(Pos.CENTER);
        // add to scene and display
        Scene sc = new Scene(root, width, height);
        sc.getStylesheets().add("Framework.css");
        this.setScene(sc);
    }
    private void setPlayerImage(Player p1, Player p2){
        if(p2.getTurn()) {
            pView = new ImageView(playerOne);
            pView.setFitWidth(400);
            pView.setFitHeight(200);
        }
        if(p1.getTurn()){
            pView = new ImageView(playerTwo);
            pView.setFitWidth(400);
            pView.setFitHeight(200);
        }
    }
}
