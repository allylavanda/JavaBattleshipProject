package Main;
import Handler.LeaderboardDB;
import StageObjects.Grid;
import javafx.scene.image.Image;
public class Player {
    private String color;
    private int hits;
    protected String username;
    private boolean isTurn;
    private boolean isLoser;
    private Image pfp;
    private int[][] shipBoard = new int [5][5];
    private int[][] hitArray = new int[5][5];
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
    public void documentHit(int x, int y){ // documents player hit, so it can be checked if they attacked said spot already
        hitArray[x][y] = 1;
    }
    public void documentMiss(int x, int y){
        hitArray[x][y] = 2;
    }
    public void setPfpImage(int playerNumber){ // set pfp for player
        if(playerNumber == 1){
            this.pfp = new Image("player1.png");
        }
        if(playerNumber == 2){
            this.pfp = new Image("player2.png");
        }
    }
    public void setLoser(){
        this.isLoser = true;
        LeaderboardDB db = new LeaderboardDB();
    } // set the loser
    public void setUsername(String name){this.username = name;}
    public void addHit(){this.hits++;}
    public void endTurn(){this.isTurn = false;} // end player turn
    public void beginTurn(){this.isTurn = true;} // begin player turn
    public boolean getTurn(){return this.isTurn;} // get player turn
    public Image getImage(){return pfp;}
    public String getColor(){return color;}
    public String getUsername(){return this.username;}
    public int getHits(){return this.hits;}
    public int[][] getShipArray(){return this.shipBoard;}
    public int[][] getHitArray(){return this.hitArray;}
    public Grid getBoard(){return board;} // get player board
    public boolean checkLoser(){return this.isLoser;}
}
