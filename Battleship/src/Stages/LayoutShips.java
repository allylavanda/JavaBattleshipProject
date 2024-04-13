package Stages;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LayoutShips extends Stage{
    public LayoutShips(){
        this.setTitle("Battleship - Choose Your Grid");
        // Button row A
        Button a1 = new Button();
        Button a2 = new Button();
        Button a3 = new Button();
        Button a4 = new Button();
        Button a5 = new Button();
        HBox rowA = new HBox(a1,a2,a3,a4,a5);
        rowA.setAlignment(Pos.CENTER);

        // Button row B
        Button b1 = new Button();
        Button b2 = new Button();
        Button b3 = new Button();
        Button b4 = new Button();
        Button b5 = new Button();
        HBox rowB = new HBox(b1,b2,b3,b4,b5);
        rowB.setAlignment(Pos.CENTER);

        // Button row C
        Button c1 = new Button();
        Button c2 = new Button();
        Button c3 = new Button();
        Button c4 = new Button();
        Button c5 = new Button();
        HBox rowC = new HBox(c1,c2,c3,c4,c5);
        rowC.setAlignment(Pos.CENTER);

        // Button Row D
        Button d1 = new Button();
        Button d2 = new Button();
        Button d3 = new Button();
        Button d4 = new Button();
        Button d5 = new Button();
        HBox rowD = new HBox(d1,d2,d3,d4,d5);
        rowD.setAlignment(Pos.CENTER);
        
        // Button Row E
        Button e1 = new Button();
        Button e2 = new Button();
        Button e3 = new Button();
        Button e4 = new Button();
        Button e5 = new Button();
        HBox rowE = new HBox(e1,e2,e3,e4,e5);
        rowE.setAlignment(Pos.CENTER);

        // create scene
        VBox vb = new VBox(rowA,rowB,rowC,rowD,rowE);
        vb.setAlignment(Pos.CENTER);
        setBackgroundColor(vb);
        Scene sc = new Scene(vb);
        this.setScene(sc);
    }
    private void setBackgroundColor(VBox vb){
        
    }
}
