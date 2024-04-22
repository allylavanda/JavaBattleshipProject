package Main;
import Stages.DeclareShips;
//import Stages.LoginMenu;
//import Stages.PlayerSelectMenu;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage s){
        DeclareShips ds;
        Player p1 = new Player();
        Player p2 = new Player();
        //LoginMenu lm = new LoginMenu();
        //lm.show();
        //Intermission inter = new Intermission(2);
        //inter.show();
        //PlayerSelectMenu ps = new PlayerSelectMenu(p1,p2);
        //ps.show();
        ds = new DeclareShips(p1);
        ds.showAndWait();
        ds = new DeclareShips(p2);
        ds.showAndWait();

    }
}
