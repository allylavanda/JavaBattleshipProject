package StageObjects;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Grid extends HBox {
    private Pane grid;
    private Double[] shipOneHits;
    private Double[] shipTwoHits;
    private final Image hit = new Image("hit.png");
    private final Image miss = new Image("miss.png");
    private ImageView hitView, missView;
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
    public void setHit(Double x, Double y){
        hitView = new ImageView(hit);
        hitView.setX(x);
        hitView.setY(y);
    }
    public void setMiss(Double x, Double y){
        missView = new ImageView(miss);
        missView.setX(x);
        missView.setY(y);
    }
}
