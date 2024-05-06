package Main;
import Handler.LeaderboardDB;
import Stages.Battle;
import Stages.DeclareShips;
import Stages.GameOver;
import Stages.Intermission;
import Stages.LoginMenu;
import Stages.PlayerSelectMenu;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.SQLException;

// Final Project for CIS-232
//

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
        System.exit(0);
    }
    public void start(Stage s) throws SQLException {
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
        while(inCombat){ // main game loop
            bt = new Battle(p1,p2);
            bt.showAndWait();
            if(p1.checkLoser() || p2.checkLoser()){
                LeaderboardDB db = new LeaderboardDB();
                if(p1.checkLoser()){
                    db.addWin(p2.getUsername());
                    db.addLoss(p1.getUsername());
                } else if(p2.checkLoser()){
                    db.addWin(p1.getUsername());
                    db.addLoss(p2.getUsername());
                }
                db.close();
                inCombat = false;
                GameOver endGame = new GameOver(p1,p2);
                endGame.showAndWait();
                System.exit(0);
            }
            Intermission inter = new Intermission(p1,p2);
            inter.showAndWait();
            if(p1.checkLoser() || p2.checkLoser()){
                LeaderboardDB db = new LeaderboardDB();
                if(p1.checkLoser()){
                    db.addWin(p2.getUsername());
                    db.addLoss(p1.getUsername());
                } else if(p2.checkLoser()){
                    db.addWin(p1.getUsername());
                    db.addLoss(p2.getUsername());
                }
                db.close();
                inCombat = false;
                GameOver endGame = new GameOver(p1,p2);
                endGame.showAndWait();
                System.exit(0);
            }
        }
    }
}
