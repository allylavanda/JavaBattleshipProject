package Stages;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LayoutShips extends Stage{
    final double width = 800, height = 800; 
    public LayoutShips(){
        this.setTitle("Battleship - Choose Your Grid");
        // Button row A
        Button a1 = new Button();
        a1.setMinSize(80,80);
        Button a2 = new Button();
        a2.setMinSize(80,80);
        Button a3 = new Button();
        a3.setMinSize(80,80);
        Button a4 = new Button();
        a4.setMinSize(80,80);
        Button a5 = new Button();
        a5.setMinSize(80,80);
        HBox rowA = new HBox(10,a1,a2,a3,a4,a5);
        rowA.setAlignment(Pos.CENTER);

        // Button row B
        Button b1 = new Button();
        b1.setMinSize(80,80);
        Button b2 = new Button();
        b2.setMinSize(80,80);
        Button b3 = new Button();
        b3.setMinSize(80,80);
        Button b4 = new Button();
        b4.setMinSize(80,80);
        Button b5 = new Button();
        b5.setMinSize(80,80);
        HBox rowB = new HBox(10,b1,b2,b3,b4,b5);
        rowB.setAlignment(Pos.CENTER);

        // Button row C
        Button c1 = new Button();
        c1.setMinSize(80,80);
        Button c2 = new Button();
        c2.setMinSize(80,80);
        Button c3 = new Button();
        c3.setMinSize(80,80);
        Button c4 = new Button();
        c4.setMinSize(80,80);
        Button c5 = new Button();
        c5.setMinSize(80,80);
        HBox rowC = new HBox(10,c1,c2,c3,c4,c5);
        rowC.setAlignment(Pos.CENTER);

        // Button Row D
        Button d1 = new Button();
        d1.setMinSize(80,80);
        Button d2 = new Button();
        d2.setMinSize(80,80);
        Button d3 = new Button();
        d3.setMinSize(80,80);
        Button d4 = new Button();
        d4.setMinSize(80,80);
        Button d5 = new Button();
        d5.setMinSize(80,80);
        HBox rowD = new HBox(10,d1,d2,d3,d4,d5);
        rowD.setAlignment(Pos.CENTER);
        
        // Button Row E
        Button e1 = new Button();
        e1.setMinSize(80,80);
        Button e2 = new Button();
        e2.setMinSize(80,80);
        Button e3 = new Button();
        e3.setMinSize(80,80);
        Button e4 = new Button();
        e4.setMinSize(80,80);
        Button e5 = new Button();
        e5.setMinSize(80,80);
        HBox rowE = new HBox(10,e1,e2,e3,e4,e5);
        rowE.setAlignment(Pos.CENTER);

        // create scene
        VBox vb = new VBox(rowA,rowB,rowC,rowD,rowE);
        vb.setAlignment(Pos.CENTER);
        setBackgroundColor(vb);
        Scene sc = new Scene(vb,width,height);
        this.setScene(sc);
    }
    private void setBackgroundColor(VBox vb){
        
    }
}
