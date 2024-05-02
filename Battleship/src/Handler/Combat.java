package Handler;

import Main.Player;

public class Combat {
    public void attack(Player p, Double x, Double y){
        int hitX = (int) Math.round(x);
        int hitY = (int) Math.round(y);
        x *= 50;
        y *= 50;
        // Check if they hit ship one
        if(p.getShipArray()[hitX][hitY] == 1){
            if(p.getHitArray()[hitX][hitY] != 1){ // check if they have hit this location before
                p.getBoard().setHit(x, y);
                Encounters encounter = new Encounters();
                encounter.start(p);
                p.addHit();
                p.documentHit(hitX,hitY);
            } else {
                System.out.println("THIS PLAYER ALREADY HIT HERE!");
            }
        }
        // Check if they hit ship two
        else if(p.getShipArray()[hitX][hitY] == 2){
            if(p.getHitArray()[hitX][hitY] != 1){ // check if they have hit this location before
                p.getBoard().setHit(x, y);
                Encounters encounter = new Encounters();
                encounter.start(p);
                p.addHit();
                p.documentHit(hitX,hitY);
            } else {
                System.out.println("THIS PLAYER ALREADY HIT HERE!");
            }
        } else {
            p.getBoard().setMiss(x, y);
            Encounters encounter = new Encounters();
            encounter.start(p);
        }
    }
    public void checkLoseStatus(Player p){
        if(p.getHits() == 5){
            p.setLoser();
        }
    }
}
