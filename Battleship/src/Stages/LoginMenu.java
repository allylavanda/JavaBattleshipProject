package Stages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginMenu extends Stage{
    public LoginMenu(){
        this.setTitle("Battleship Game"); // set title
        // Create Logo Image
        Image logo = new Image("logo.png");
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(400);
        logoView.setFitHeight(200);

        // create pve and pvp options
        RadioButton pve = new RadioButton("PvE");
        RadioButton pvp = new RadioButton("PvP");
        ToggleGroup tg = new ToggleGroup();
        pve.setToggleGroup(tg);
        pvp.setToggleGroup(tg);
        HBox mode = new HBox(pve,pvp);
        mode.setAlignment(Pos.CENTER);
        pvp.setPadding(new Insets(5));
        pve.setPadding(new Insets(5));

        // create username and password fields
        Text text1 = new Text("Username:");
        text1.getStyleClass().add("login");
        TextField tf = new TextField();
        tf.setMaxSize(200, 0);
        Text text2 = new Text("Password:");
        text2.getStyleClass().add("login");
        PasswordField pf = new PasswordField();
        pf.setMaxSize(200,0);

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
            SQLHandler accountManager = new SQLHandler();
            accountManager.login(tf.getText(),pf.getText());
            if(accountManager.isVerified()){
                this.close();
            }
        });

        Button leader = new Button("Leaderboards");
        
        // add to vbox to align vertically
        VBox vb = new VBox(logoView,mode,text1,tf,text2,pf,buttonGrid, leader);
        vb.setAlignment(Pos.TOP_CENTER);
        vb.setPadding(new Insets(100));

        // add to scene and display
        Scene sc = new Scene(vb, 800,800);
        sc.getStylesheets().add("Framework.css");
        this.setScene(sc);
    }
}
