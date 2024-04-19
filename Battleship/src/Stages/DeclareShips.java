package Stages;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DeclareShips extends Stage{
    public DeclareShips(){
        this.setTitle("Declare Ship Locations");

        // 2x1 Ship
        Rectangle shipOne = new Rectangle();
        shipOne.setX(0);
        shipOne.setY(0);
        shipOne.setWidth(100);
        shipOne.setHeight(50);

        // 3x1 Ship
        Rectangle shipTwo = new Rectangle();
        shipTwo.setX(0);
        shipTwo.setY(0);
        shipTwo.setWidth(150);
        shipTwo.setHeight(50);

        Pane grid = new Pane();
        HBox gridBox = new HBox(grid);
        gridBox.setAlignment(Pos.CENTER);
        RadioButton rb1 = new RadioButton("2x1 Ship");
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("3x1 Ship");
        ToggleGroup tg = new ToggleGroup();
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);

        VBox vb1 = new VBox(rb1,rb2);
        vb1.setSpacing(20);
        vb1.setAlignment(Pos.CENTER);
        
        // Create Grid Horizontal
        for (int i = 0; i <= 250; i+= 50){
            Rectangle r = new Rectangle();
            grid.getChildren().add(r);
            r.setX(i);
            r.setY(0);
            r.setWidth(2.5);
            r.setHeight(250);
        }
        // Create Grid vertical
        for (int i = 0; i <= 250; i+= 50){
            Rectangle r = new Rectangle();
            grid.getChildren().add(r);
            r.setX(0);
            r.setY(i);
            r.setWidth(250);
            r.setHeight(2.5);
        }

        VBox root = new VBox(vb1, gridBox);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(150);

        Scene sc = new Scene(root,800, 800);
        sc.getStylesheets().add("BattleshipGrid.css");

        grid.setOnMouseMoved(event -> {
            //get mouse POS
            double x = event.getX();
            double y = event.getY();

            x /= 50;
            y /= 50;

            x = Math.floor(x);
            y = Math.floor(y);
            System.out.print("Array Index: ");
            System.out.print("[");
            System.out.print(x);
            System.out.print("]");
            System.out.print("[");
            System.out.print(y);
            System.out.println("]");
            x *= 50;
            y *= 50;

            if(rb1.isSelected()){
                if(grid.getChildren().contains(shipOne) == false){
                    grid.getChildren().remove(shipTwo);
                    grid.getChildren().add(shipOne);
                }
                shipOne.setX(x);
                shipOne.setY(y);
            }
            if(rb2.isSelected()){
                if(grid.getChildren().contains(shipTwo) == false){
                    grid.getChildren().remove(shipOne);
                    grid.getChildren().add(shipTwo);
                }
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
                
            }
        });

        this.setScene(sc);
    }
}
