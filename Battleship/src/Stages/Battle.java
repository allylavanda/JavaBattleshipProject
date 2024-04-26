package Stages;

import Handler.Combat;
import StageObjects.Grid;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import Main.Player;

public class Battle extends Stage{
    private Grid gridOne, gridTwo;
    final double width = 800;
    final double height = 800;
    private double hitX,hitY;
    public Battle(Player p1, Player p2){
        this.setTitle("Battleship - Battle!");

        Rectangle select = new Rectangle();
        select.setX(0);
        select.setY(0);

        Label l1 = new Label("Your Board");
        l1.getStyleClass().add("header");
        Label l2 = new Label("Opponent's Board\nSelect where to fire!");
        l2.getStyleClass().add("header");
        Button fire = new Button("FIRE!");
        fire.getStyleClass().add("fire-button");

        // Check player turn and generate boards
        generateBoards(p1,p2);
        VBox root = new VBox(30,l1,gridOne,l2,gridTwo,fire);
        root.setAlignment(Pos.CENTER);

        // Event Listener
        Pane grid = gridTwo.getPane();
        grid.getChildren().add(select);
        grid.setOnMouseMoved(event -> {
            double x = event.getX();
            double y = event.getY();
            x /= 50;
            y /= 50;
            x = Math.floor(x);
            y = Math.floor(y);
            x *= 50;
            y *= 50;
            if(x <= 200 && y <= 200){
                select.setWidth(50);
                select.setHeight(50);
                select.setX(x);
                select.setY(y);
            }
        });
        grid.setOnMouseClicked(event ->{
            double x = event.getX();
            double y = event.getY();
            x /= 50;
            y /= 50;
            x = Math.floor(x);
            y = Math.floor(y);
            x *= 50;
            y *= 50;
            hitX = x;
            hitY = y;


        });
        fire.setOnAction(event ->{
            if(p1.getTurn()){
                Combat cb = new Combat();
                cb.attack(p2,hitX,hitY);
                p1.endTurn();
                p2.beginTurn();
            }
            if(p2.getTurn()){
                Combat cb = new Combat();
                cb.attack(p1,hitX,hitY);
                p2.endTurn();
                p1.beginTurn();
            }
            this.close();
            grid.getChildren().remove(select);
        });

        Scene sc = new Scene(root,width,height);
        sc.getStylesheets().add("BattleshipGrid.css");
        this.setScene(sc);
    }
    private void generateBoards(Player p1, Player p2){ // get boards from players
        if(p1.getTurn()){ // if it is player one's turn, display their board at the top
            this.gridOne = p1.getBoard();
            this.gridTwo = p2.getBoard();
        }
        if(p2.getTurn()){ // if it is player two's turn, display their board at the top
            this.gridOne = p2.getBoard();
            this.gridTwo = p2.getBoard();
        }
    }
}
