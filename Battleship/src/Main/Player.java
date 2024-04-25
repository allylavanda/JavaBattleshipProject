package Main;
import StageObjects.Grid;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
public class Player {
    private Color color;
    private boolean isTurn;
    private Image pfp;
    private Double[] shipOne;
    private Double[] shipTwo;
    private Grid board;
    public Player(){
    }
    public void setColor(String inputColor){ // set player color to use in backgrounds, uses javafx COLOR enums
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
    public void setShipOneLoc(Double x1, Double y1, Double x2, Double y2){ // add ship one location to array
        this.shipOne = new Double[] {x1,y1,x2,y2};
    }
    public void setShipTwoLoc(Double x1, Double y1, Double x2, Double y2){ // add ship two location to array
        this.shipTwo = new Double[] {x1,y1,x2,y2};
    }
    public void setPfpImage(int playerNumber){ // set pfp for player
        if(playerNumber == 1){
            pfp = new Image("player1.png");
        }
        if(playerNumber == 2){
            pfp = new Image("player2.png");
        }
    }
    public void endTurn(){
        this.isTurn = false;
    }
    public boolean getTurn(){
        return this.isTurn;
    }
    public Image getImage(){ // return pfp for player
        return pfp;
    }
    public Color getColor(){ // return color enum
        return color;
    }
    public Double[] getShipOneLoc(){ // return ship one location
        return this.shipOne;
    }
    public Double[] getShipTwoLoc(){ // return ship two location
        return this.shipTwo;
    }
    public Grid getBoard(){ // Get player's board
        return board;
    }
}
