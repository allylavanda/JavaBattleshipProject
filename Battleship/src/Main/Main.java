package Main;
import Stages.Battle;
import Stages.DeclareShips;
import Stages.Intermission;
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
        Battle bt;

        boolean inCombat = true;
        Player p1 = new Player();
        Player p2 = new Player();
        //LoginMenu lm = new LoginMenu();
        //lm.show();
        //PlayerSelectMenu ps = new PlayerSelectMenu(p1,p2);
        //ps.show();
        ds = new DeclareShips(p1);
        ds.showAndWait();
        ds = new DeclareShips(p2);
        ds.showAndWait();
        p1.beginTurn();
        while(inCombat){
            bt = new Battle(p1,p2);
            bt.showAndWait();
            Intermission inter = new Intermission(p1,p2);
            inter.showAndWait();
            if(p1.checkLoser() || p2.checkLoser()){
                inCombat = false;
            }
        }
    }
}
