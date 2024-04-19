package Main;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
public class Player {
    private Color color;
    private Image pfp;
    
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
    public void setPfpImage(int playerNumber){
        if(playerNumber == 1){
            pfp = new Image("player1.png");
        }
        if(playerNumber == 2){
            pfp = new Image("player2.png");
        }
    }
    public Image getImage(){
        return pfp;
    }
}
