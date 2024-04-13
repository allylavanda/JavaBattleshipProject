package Main;
import javafx.scene.paint.Color;
public class Player {
    private Color color;
    public Player(){

    }
    public void setColor(String inputColor){
        switch (inputColor) {
            case "red":
                color = Color.RED;
            case "blue":
                color = Color.BLUE;
            case "green":
                color = Color.GREEN;
            case "yellow":
                color = Color.YELLOW;
        }
    }
    public Color getColor(){
        return color;
    }
}
