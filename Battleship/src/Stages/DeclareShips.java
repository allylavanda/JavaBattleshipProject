package Stages;

import Main.Player;
import StageObjects.Grid;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DeclareShips extends Stage{
    public DeclareShips(Player p){
        this.setTitle("Declare Ship Locations");

        // 2x1 Ship
        Rectangle shipOne = new Rectangle();
        shipOne.setX(0);
        shipOne.setY(0);

        // 3x1 Ship
        Rectangle shipTwo = new Rectangle();
        shipTwo.setX(0);
        shipTwo.setY(0);
        
        // Create Grid
        Grid gridBox = new Grid();
        gridBox.generate();

        // Buttons to choose which ship to place and check box for rotate
        RadioButton rb1 = new RadioButton("2x1 Ship");
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("3x1 Ship");
        CheckBox cb1 = new CheckBox("Rotate Ship?");
        ToggleGroup tg = new ToggleGroup();
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);

        // Radio button VBOX
        VBox vb1 = new VBox(rb1,rb2,cb1);
        vb1.setSpacing(20);
        vb1.setAlignment(Pos.CENTER);

        // Status label to declare if ship has been placed, and button to move to next player or end scene
        Label status = new Label();
        Button complete = new Button("Complete Placement");
        VBox root = new VBox(vb1, gridBox,status,complete);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(100);

        Scene sc = new Scene(root,800, 800);
        sc.getStylesheets().add("BattleshipGrid.css");

        /**switch(p.getColor()){  THIS WILL BE USED TO CHANGE BACKGROUND TO PLAYER CHOSEN COLOR
            case Color.RED: root.getStyleClass().add("red-player");
            case Color.GREEN: root.getStyleClass().add("green-player");
            case Color.YELLOW: root.getStyleClass().add("yellow-player");
            case Color.BLUE: root.getStyleClass().add("blue-player");
        } **/

        // Event Handlers
        Pane grid = gridBox.getPane();
        grid.setOnMouseMoved(event -> {
            //get mouse POS
            double x = event.getX();
            double y = event.getY();

            x /= 50;
            y /= 50;

            x = Math.floor(x);
            y = Math.floor(y);
            // FOR DEBUGGING PURPOSES
            System.out.print("Array Index: ");
            System.out.print("[");
            System.out.print(x);
            System.out.print("]");
            System.out.print("[");
            System.out.print(y);
            System.out.println("]");
            x *= 50;
            y *= 50;

            if(rb1.isSelected() && x < 200 && y < 250){ // move ship one on hover
                if(grid.getChildren().contains(shipOne) == false){
                    grid.getChildren().remove(shipTwo);
                    grid.getChildren().add(shipOne);
                }
                shipOne.setWidth(100);
                shipOne.setHeight(50);
                shipOne.setX(x);
                shipOne.setY(y);
            }
            if(rb1.isSelected() && cb1.isSelected() && x < 250 && y < 200){ // move rotated ship one on hover 
                if(grid.getChildren().contains(shipOne) == false){
                    grid.getChildren().remove(shipTwo);
                    grid.getChildren().add(shipOne);
                }
                shipOne.setWidth(50);
                shipOne.setHeight(100);
                shipOne.setX(x);
                shipOne.setY(y);
            }
            if(rb2.isSelected() && x < 150 && y < 250){ // move ship two on hover
                if(grid.getChildren().contains(shipTwo) == false){
                    grid.getChildren().remove(shipOne);
                    grid.getChildren().add(shipTwo);
                }
                shipTwo.setWidth(150);
                shipTwo.setHeight(50);
                shipTwo.setX(x);
                shipTwo.setY(y);
            }
            if(rb2.isSelected() && cb1.isSelected() && x < 250 && y < 150){ // move rotated ship two on hover
                if(grid.getChildren().contains(shipTwo) == false){
                    grid.getChildren().remove(shipOne);
                    grid.getChildren().add(shipTwo);
                }
                shipTwo.setHeight(150);
                shipTwo.setWidth(50);
                shipTwo.setX(x);
                shipTwo.setY(y);
            }
        });
        grid.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();

            x /= 50;
            y /= 50;

            x = Math.floor(x);
            y = Math.floor(y);

            if(rb1.isSelected()){
                p.setShipOneLoc(x, y, ++x, y);
                status.setText("Ship One Has Been Placed!");
                // Double[] test = p.getShipOneLoc(); DEBUG IF PLAYER CLASS RECEIVES DATA
                // System.out.println(test[0]);
            }
            if(rb2.isSelected()){
                p.setShipTwoLoc(x, y, 2+x, y);
                status.setText("Ship Two Has Been Placed!");
            }
            System.out.println(x);
        });
        complete.setOnAction(event -> {
            this.close();
        });
        this.setScene(sc);
    }
}
