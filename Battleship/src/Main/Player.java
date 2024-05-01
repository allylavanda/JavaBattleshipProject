package Main;
import StageObjects.Grid;
import javafx.scene.image.Image;
public class Player {
    private String color;
    private int hits;
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
        this.color = inputColor;
    }
    /**public void printShipOneInt(){ THIS IS TO DEBUG IF SHIP VALUES ARE WORKING
        shipOneInt = new int[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.println(shipOneInt[i][j]);
            }
        }
        shipOneInt[0][0] = 1;
    } **/
    public void setShipOneLoc(Double x, Double y, boolean rb1) { // add ship one location to array
        int x1 = (int) Math.round(x);
        int y1 = (int) Math.round(y);
        if (rb1) {
            shipBoard[x1][y1] = 1;
            shipBoard[x1][y1 + 1] = 1;
        } else {
            shipBoard[x1][y1] = 1;
            shipBoard[x1 + 1][y1] = 1;
        }
    }
        public void setShipTwoLoc(Double x, Double y, boolean rb1) { // add ship two location to array

            int x1 = (int) Math.round(x);
            int y1 = (int) Math.round(y);
            if (rb1) {
                shipBoard[x1][y1] = 2;
                shipBoard[x1][y1 + 1] = 2;
                shipBoard[x1][y1 + 2] = 2;

            } else {
                shipBoard[x1][y1] = 2;
                shipBoard[x1 + 1][y1] = 2;
                shipBoard[x1 + 2][y1] = 2;
            }
        }
    public void setPfpImage(int playerNumber){ // set pfp for player
        if(playerNumber == 1){
            this.pfp = new Image("player1.png");
        }
        if(playerNumber == 2){
            this.pfp = new Image("player2.png");
        }
    }
    public void setLoser(){this.isLoser = true;} // set the loser
    public void addHit(){this.hits++;}
    public void endTurn(){this.isTurn = false;} // end player turn
    public void beginTurn(){this.isTurn = true;} // begin player turn
    public boolean getTurn(){return this.isTurn;} // get player turn
    public Image getImage(){return pfp;}
    public String getColor(){return color;}
    public int getHits(){return this.hits;}
    public int[][] getShipArray(){return this.shipBoard;}
    public Grid getBoard(){return board;} // get player board
    public boolean checkLoser(){return this.isLoser;}
}
