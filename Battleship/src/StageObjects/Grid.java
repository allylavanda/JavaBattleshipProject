package StageObjects;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Grid extends HBox {
    private Pane grid;
    public Grid(){
    }
    private void createGridBox(Pane grid){
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
    public void generate(){
        grid = new Pane();
        this.getChildren().add(grid);
        this.setAlignment(Pos.CENTER);
        createGridBox(grid);
    }
    public Pane getPane(){
        return grid;
    }
}
