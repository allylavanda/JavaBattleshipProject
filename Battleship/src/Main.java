import Stages.Intermission;
import Stages.LoginMenu;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage s){
        LoginMenu lm = new LoginMenu();
        lm.show();
        Intermission inter = new Intermission(2);
        inter.show();
    }
}
