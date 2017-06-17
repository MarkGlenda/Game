/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whoami.GUI.Cards;

import GUI.Animations.CardFocusAnimation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import whoami.GUI.LeaderCard;
import whoami.GUI.Constants;

/**
 *
 * @author mrmgl
 */
public class BerserkCard extends LeaderCard {
    
    public BerserkCard() {
        initComponents();
    }
    
    private void initComponents() {
        setImageName(Constants.berserkImage);
        setCardFront(Constants.iconpath + "GraphicsIcons\\" + getImageName()+ ".png");
        setBackName(Constants.cardBackName);
        setCardBack(Constants.iconpath + "GraphicsIcons\\" + getBackName() + ".png");
        Repaint();
    }
    
    @Override
    public void setHandSize(){
        getBackgroundPic().setBounds(0, 0, Constants.LeaderCardWidth, Constants.LeaderCardHeight);
        getWarriorPic().setBounds(Constants.LeaderCardPictureX, Constants.LeaderCardPictureY, Constants.LeaderCardPictureWidth, Constants.LeaderCardPictureHeight);
        setCardBack(Constants.iconpath + "GraphicsIcons\\" + getBackName() + ".png");
        setCardFront(Constants.iconpath + "GraphicsIcons\\" + getImageName() + ".png");
        setBounds(this.getStartX(), (int) this.getLocation().getY(), Constants.LeaderCardWidth, Constants.LeaderCardHeight);
        Repaint();
    }
    @Override
    public void setFocusedSize(){
        getBackgroundPic().setBounds(0, 0, Constants.CardFocusedWidth,Constants.CardFocusedHeight);
        getWarriorPic().setBounds(Constants.CardFocusedPictureX,Constants.CardFocusedPictureY,Constants.CardFocusedPictureWidth,Constants.CardFocusedPictureHeight);
        setCardBack(Constants.iconpath + "GraphicsIcons\\" + getBackName() + "Focused.png");
        setCardFront(Constants.iconpath + "GraphicsIcons\\"+getImageName()+"Focused.png");
        setBounds((int) getStartX() - ((Constants.CardFocusedWidth - Constants.LeaderCardWidth)/2), (int) getStartY() - Constants.CardFocusedHeight-10, Constants.CardFocusedWidth,Constants.CardFocusedHeight);
        Repaint();
    }
    
    @Override
    public void Repaint(){
        setWarriorPic(getCardFront());
        setBackgroundPic(getCardBack());
    }
}
