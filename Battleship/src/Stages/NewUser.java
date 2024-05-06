package Stages;

import Handler.LoginDB;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Random;

public class NewUser extends Stage {
    public NewUser(){
        this.setTitle("BattleShip - New User");

        Text text1 = new Text("Username:");
        text1.getStyleClass().add("login");
        TextField tf = new TextField();
        tf.setMaxSize(200, 0);
        Text text2 = new Text("Password:");
        text2.getStyleClass().add("login");
        PasswordField pf = new PasswordField();
        pf.setMaxSize(200,0);
        Button submit = new Button("Submit");

        // event handlers
        submit.setOnAction(event -> {
            LoginDB db = new LoginDB();
            Random rng = new Random();
            try {
                db.addUser(rng.nextInt(100000),tf.getText(),pf.getText());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                db.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            this.close();
        });

        VBox root = new VBox(text1,tf,text2,pf,submit);
        root.setAlignment(Pos.CENTER);

        Scene sc = new Scene(root, 400,400);
        sc.getStylesheets().add("Framework.css");
        this.setScene(sc);
    }
}
