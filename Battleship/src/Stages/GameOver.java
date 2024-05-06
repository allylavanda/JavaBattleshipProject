package Stages;

import Handler.LeaderboardDB;
import Main.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;

public class GameOver extends Stage {
    final double height = 800;
    final double width = 800;
    public GameOver(Player p1, Player p2) throws SQLException {
        this.setTitle("Battleship - Game Over");
        Label l1 = new Label("GAME OVER!");
        l1.getStyleClass().add("title");
        Label l2 = new Label("winner label");
        Label l3 = new Label("wins label");
        Label l4 = new Label("loss label");
        l3.getStyleClass().add("subtitle");
        l4.getStyleClass().add("subtitle");
        l2.getStyleClass().add("title");
        LeaderboardDB db = new LeaderboardDB();
        if(p1.checkLoser()){
            l2.setText(p2.getUsername()+" wins!");
            l3.setText(p2.getUsername()+" has "+db.getWins(p2.getUsername())+" total wins!");
            l4.setText(p2.getUsername()+" has "+db.getLosses(p2.getUsername())+" total losses!");
        } else if(p2.checkLoser()){
            l2.setText(p1.getUsername()+" wins!");
            l3.setText(p1.getUsername()+" has "+db.getWins(p1.getUsername())+" total wins!");
            l4.setText(p1.getUsername()+" has "+db.getLosses(p1.getUsername())+" total losses!");
        }
        db.close();
        VBox root = new VBox(l1,l2,l3,l4);
        root.setAlignment(Pos.CENTER);
        Scene sc = new Scene(root, width, height);

        sc.getStylesheets().add("Framework.css");
        this.setScene(sc);

    }
}
