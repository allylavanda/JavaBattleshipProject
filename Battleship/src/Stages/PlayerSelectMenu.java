package Stages;

import Main.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlayerSelectMenu extends Stage {
    private final ToggleGroup player1ColorGroup;
    private final ToggleGroup player2ColorGroup;
    private final StackPane player1ColorBox;
    private final StackPane player2ColorBox;

    public PlayerSelectMenu(Player p1, Player p2) {
        this.setTitle("Color Selection");

        // player 1 Color Selection
        Text player1Label = new Text("Player 1");
        player1Label.setStyle("-fx-font-size: 20px;");


        // radio buttons
        RadioButton red1 = new RadioButton("Red");
        RadioButton blue1 = new RadioButton("Blue");
        RadioButton green1 = new RadioButton("Green");
        RadioButton yellow1 = new RadioButton("Yellow");

        
        player1ColorGroup = new ToggleGroup();
        red1.setToggleGroup(player1ColorGroup);
        blue1.setToggleGroup(player1ColorGroup);
        green1.setToggleGroup(player1ColorGroup);
        yellow1.setToggleGroup(player1ColorGroup);

        player1ColorBox = new StackPane();
        player1ColorBox.setMinSize(50, 50);
        player1ColorBox.setStyle("-fx-border-color: black;");

        // player 2 Color Selection
        Text player2Label = new Text("Player 2");
        player2Label.setStyle("-fx-font-size: 20px;");

        RadioButton red2 = new RadioButton("Red");
        RadioButton blue2 = new RadioButton("Blue");
        RadioButton green2 = new RadioButton("Green");
        RadioButton yellow2 = new RadioButton("Yellow");

        player2ColorGroup = new ToggleGroup();
        red2.setToggleGroup(player2ColorGroup);
        blue2.setToggleGroup(player2ColorGroup);
        green2.setToggleGroup(player2ColorGroup);
        yellow2.setToggleGroup(player2ColorGroup);

        player2ColorBox = new StackPane();
        player2ColorBox.setMinSize(50, 50);
        player2ColorBox.setStyle("-fx-border-color: black;");

        // "begin Placement of Ships" Button
        Button beginPlacementButton = new Button("Begin Placement of Ships");
        beginPlacementButton.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");

        // layout Setup
        VBox player1ColorSelection = new VBox(10, player1Label, red1, blue1, green1, yellow1);
        VBox player2ColorSelection = new VBox(10, player2Label, red2, blue2, green2, yellow2);
        VBox player1Box = new VBox(player1ColorBox, player1ColorSelection);
        VBox player2Box = new VBox(player2ColorBox, player2ColorSelection);
        VBox.setMargin(beginPlacementButton, new Insets(20, 0, 0, 0));


        HBox colorSelection = new HBox(50, player1Box, player2Box);
        colorSelection.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20, colorSelection, beginPlacementButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(50));

        Scene scene = new Scene(layout, 600, 400);
        scene.getStylesheets().add("Framework.css");
        this.setScene(scene);

        // logic for updating color preview for Player 1 and locking Player 2 from the same color
        player1ColorGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                String selectedColor = ((RadioButton) newValue).getText();
                player1ColorBox.setBackground(new Background(new BackgroundFill(getColor(selectedColor), CornerRadii.EMPTY, Insets.EMPTY)));
                disableColorForPlayer2(selectedColor);
            }
        });

        // logic for updating color preview for Player 2
        player2ColorGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                String selectedColor = ((RadioButton) newValue).getText();
                player2ColorBox.setBackground(new Background(new BackgroundFill(getColor(selectedColor), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
        beginPlacementButton.setOnAction(event -> {
            if(red1.isSelected()){ // set player one color
                p1.setColor("red");
            } else if(blue1.isSelected()){
                p1.setColor("blue");
            } else if(green1.isSelected()){
                p1.setColor("green");
            } else if(yellow1.isSelected()){
                p1.setColor("yellow");
            }
            if(red2.isSelected()){ // set player 2 color
                p2.setColor("red");
            } else if(blue2.isSelected()){
                p2.setColor("blue");
            } else if(green2.isSelected()){
                p2.setColor("green");
            } else if(yellow2.isSelected()){
                p2.setColor("yellow");
            }
            this.close();
        });
    }

    private void disableColorForPlayer2(String color) {
        player2ColorGroup.getToggles().forEach(toggle -> {
            RadioButton button = (RadioButton) toggle;
            if (button.getText().equals(color)) {
                button.setDisable(true);
            } else {
                button.setDisable(false);
            }
        });
    }
    private Color getColor(String colorName) {
        switch (colorName.toLowerCase()) {
            case "red":
                return Color.RED;
            case "blue":
                return Color.BLUE;
            case "green":
                return Color.GREEN;
            case "yellow":
                return Color.YELLOW;
            default:
                return Color.BLACK; // default color if not recognized
        }
    }
}