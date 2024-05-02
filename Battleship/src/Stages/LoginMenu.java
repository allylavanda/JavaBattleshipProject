package Stages;

import Main.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginMenu extends Stage{
    public LoginMenu(Player p1, Player p2){
        this.setTitle("Battleship Game"); // set title
        // Create Logo Image
        Image logo = new Image("logo.png");
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(400);
        logoView.setFitHeight(200);

        // create username and password fields for player 1
        Label l1 = new Label("Player 1 Login");
        l1.getStyleClass().add("subtitle");
        Text text1 = new Text("Username:");
        text1.getStyleClass().add("login");
        TextField tf = new TextField();
        tf.setMaxSize(200, 0);
        Text text2 = new Text("Password:");
        text2.getStyleClass().add("login");
        PasswordField pf = new PasswordField();
        pf.setMaxSize(200,0);

        // create username and password fields for player 2
        Label l2 = new Label("Player 2 Login");
        l2.getStyleClass().add("subtitle");
        Text text3 = new Text("Username:");
        text3.getStyleClass().add("login");
        TextField tf2 = new TextField();
        tf2.setMaxSize(200, 0);
        Text text4 = new Text("Password:");
        text4.getStyleClass().add("login");
        PasswordField pf2 = new PasswordField();
        pf2.setMaxSize(200,0);


        // create submit and forgot buttons
        Button submit = new Button("Submit");
        Button forgot = new Button("Forgot?");
        submit.setPadding(new Insets(5));
        forgot.setPadding(new Insets(5));
        GridPane buttonGrid = new GridPane();

        // Add submit and forgot to grid, and set spacing between both. Align to center
        buttonGrid.add(submit, 0, 0);
        buttonGrid.add(forgot, 1, 0);
        buttonGrid.setPadding(new Insets(10));
        buttonGrid.setVgap(5);
        buttonGrid.setHgap(5);
        buttonGrid.setAlignment(Pos.CENTER);

        // Event Handlers
        submit.setOnAction(event -> {
            p1.setUsername(tf.getText());
            p2.setUsername(tf.getText());
            this.close();
        });

        Button leader = new Button("Leaderboards");
        
        // add to vbox to align vertically
        VBox vb = new VBox(logoView,l1,text1,tf,text2,pf,l2,text3,tf2,text4,pf2,buttonGrid, leader);
        vb.setAlignment(Pos.TOP_CENTER);
        vb.setPadding(new Insets(100));

        // add to scene and display
        Scene sc = new Scene(vb, 800,800);
        sc.getStylesheets().add("Framework.css");
        this.setScene(sc);
    }
}
