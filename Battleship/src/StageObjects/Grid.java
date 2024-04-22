package StageObjects;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Grid {
    public void create(Pane grid){
        // Create Grid Horizontal
        for (int i = 0; i <= 250; i+= 50){
            Rectangle r = new Rectangle();
            grid.getChildren().add(r);
            r.setX(i);
            r.setY(0);
            r.setWidth(2.5);
            r.setHeight(250);
        }
        // Create Grid Vertical
        for (int i = 0; i <= 250; i+= 50){
            Rectangle r = new Rectangle();
            grid.getChildren().add(r);
            r.setX(0);
            r.setY(i);
            r.setWidth(250);
            r.setHeight(2.5);
        }
    }
}
