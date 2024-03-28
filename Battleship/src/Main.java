import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage s){
        s.setTitle("Battleship Game");
        // Create Logo Image
        Image logo = new Image("logo.png");
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(400);
        logoView.setFitHeight(200);

        Text text1 = new Text("Username:");
        TextField tf = new TextField();
        tf.setMaxSize(200, 0);
        Text text2 = new Text("Password:");
        PasswordField pf = new PasswordField();
        pf.setMaxSize(200,0);

        Button submit = new Button("Submit");
        Button forgot = new Button("Forgot?");
        submit.setPadding(new Insets(5));
        forgot.setPadding(new Insets(5));
        GridPane buttonGrid = new GridPane();

        buttonGrid.add(submit, 0, 0);
        buttonGrid.add(forgot, 1, 0);
        buttonGrid.setPadding(new Insets(10));
        buttonGrid.setVgap(5);
        buttonGrid.setHgap(5);
        buttonGrid.setAlignment(Pos.CENTER);
    

        VBox vb = new VBox(logoView, text1,tf,text2,pf,buttonGrid);
        vb.setAlignment(Pos.TOP_CENTER);
        vb.setStyle("-fx-background-color: #8F8C8C;");
        vb.setPadding(new Insets(100));


        Scene sc = new Scene(vb, 800,800);
        s.setScene(sc);
        s.show();
    }
}
