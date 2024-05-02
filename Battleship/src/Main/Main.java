package Main;
import Stages.Battle;
import Stages.DeclareShips;
import Stages.GameOver;
import Stages.Intermission;
import Stages.LoginMenu;
import Stages.PlayerSelectMenu;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
        System.exit(0);
    }
    public void start(Stage s){
        DeclareShips ds;
        Battle bt;

        boolean inCombat = true;
        Player p1 = new Player();
        Player p2 = new Player();
        p1.setPfpImage(1);
        p2.setPfpImage(2);
        LoginMenu lm = new LoginMenu(p1,p2);
        lm.showAndWait();
        PlayerSelectMenu ps = new PlayerSelectMenu(p1,p2);
        ps.showAndWait();
        ds = new DeclareShips(p1);
        ds.showAndWait();
        ds = new DeclareShips(p2);
        ds.showAndWait();
        p1.beginTurn();
        while(inCombat){
            bt = new Battle(p1,p2);
            bt.showAndWait();
            if(p1.checkLoser() || p2.checkLoser()){
                inCombat = false;
                GameOver endGame = new GameOver(p1,p2);
                endGame.showAndWait();
                System.exit(0);
            }
            Intermission inter = new Intermission(p1,p2);
            inter.showAndWait();
        }
    }
}
