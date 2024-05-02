package Handler;

import Main.Player;
import java.util.Random;

public class Encounters {
    private double x,y;
    private int rand;
    public void start(Player p){
        Random rng = new Random();
        rand = rng.nextInt(5);
        switch(rand){ // Place randomly horizontally
            case 0: x = 0.0; break;
            case 1: x = 50.0; break;
            case 2: x = 100.0; break;
            case 3: x = 150.0; break;
            case 4: x = 200.0; break;
        }
        rand = rng.nextInt(5);
        switch(rand){ // Place random vertically
            case 0: y = 0.0; break;
            case 1: y = 50.0; break;
            case 2: y = 100.0; break;
            case 3: y = 150.0; break;
            case 4: y = 200.0; break;
        }
        if(rng.nextInt(5) == 1){
            int hitX = (int) Math.round(x);
            int hitY = (int) Math.round(y);
            hitX /= 50;
            hitY /= 50;
            if(p.getShipArray()[hitX][hitY] != 1 && p.getShipArray()[hitX][hitY] != 2){
                if(p.getHitArray()[hitX][hitY] != 1 && p.getHitArray()[hitX][hitY] !=2){ // make sure this spot has not been fired upon
                    p.getBoard().spawnKraken(x,y);
                }
            }
        }
    }
}
