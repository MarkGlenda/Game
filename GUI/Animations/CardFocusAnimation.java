/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Animations;

import java.util.Timer;
import java.util.TimerTask;
import whoami.GUI.Constants;
import whoami.GUI.LeaderCard;

/**
 *
 * @author mrmgl
 */
public class CardFocusAnimation {

    Timer timer;
    LeaderCard c;

    public CardFocusAnimation(LeaderCard card) {
        c=card;
        timer = new Timer();
        timer.schedule(new Animation(),0, 8);
    }

    class Animation extends TimerTask {

        private int goalY;
        private final int travel;

        public Animation() {
<<<<<<< HEAD
            travel = (c.getStartY() - Constants.CardFocusedHeight -10)/100;
=======
            travel = (c.getStartY() - Constants.CardFocusedHeight -10)/150;
>>>>>>> edit
        }
        
        @Override
        public void run() {
            if (c.getFocused()) {
                goalY = c.getStartY() - Constants.CardFocusedHeight -10;
                if (c.getLocation().getY() <= goalY) { //its on focused position
                    CardOnTop();
                } else { //move card up
                    c.setLocation(c.getStartX(), (int) c.getLocation().getY() - travel);
                }
            } else {
                goalY = c.getStartY();
                if (c.getLocation().getY() >= goalY) {// its on start position
                    Terminate();
                    c.setLocation(c.getStartX(), c.getStartY());
                } else { //move card bot
                    c.setLocation(c.getStartX(), (int) c.getLocation().getY() + travel);
                }
            }
        }
    }
    
    public void CardOnTop(){
            Terminate();
            c.setFocusedSize();
       
    }
    
    public void Terminate(){
        c.setFocusAni(null);
        timer.cancel();
    }

}
