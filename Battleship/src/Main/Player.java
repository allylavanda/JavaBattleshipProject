package Main;
import StageObjects.Grid;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
public class Player {
    private Color color;
    private boolean isTurn;
    private boolean isLoser;
    private Image pfp;
    private int[][] shipBoard = new int [5][5];
    private final Grid board;
    public Player(){
        this.board = new Grid();
        board.generate();
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
    /**public void setShipOneInt(){ THIS IS AN EXAMPLE
        shipOneInt = new int[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.println(shipOneInt[i][j]);
            }
        }
        shipOneInt[0][0] = 1;
    } **/
    public void setShipOneLoc(Double x, Double y){ // add ship one location to array
        int x1 = (int) Math.round(x);
        int y1 = (int) Math.round(y);
        shipBoard[x1][y1] = 1;
        shipBoard[x1+1][y1] = 1;
    }
    public void setShipTwoLoc(Double x, Double y){ // add ship two location to array
        int x1 = (int) Math.round(x);
        int y1 = (int) Math.round(y);
        shipBoard[x1][y1] = 2;
        shipBoard[x1+1][y1] =2;
        shipBoard[x1+2][y1] = 2;
    }
    public void setPfpImage(int playerNumber){ // set pfp for player
        if(playerNumber == 1){
            pfp = new Image("player1.png");
        }
        if(playerNumber == 2){
            pfp = new Image("player2.png");
        }
    }
    public void setLoser(){this.isLoser = true;} // set the loser
    public void endTurn(){this.isTurn = false;
    System.out.println(this.isTurn);} // end player turn
    public void beginTurn(){this.isTurn = true;
    System.out.println(this.isTurn);} // begin player turn   
    public boolean getTurn(){return this.isTurn;} // get player turn
    public Image getImage(){return pfp;}
    public Color getColor(){return color;}
    public int[][] getShipArray(){return this.shipBoard;}
    public Grid getBoard(){return board;} // get player board
    public boolean checkLoser(){return this.isLoser;}
}
