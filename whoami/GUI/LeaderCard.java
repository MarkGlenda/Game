
package whoami.GUI;

import GUI.Animations.CardFocusAnimation;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mrmgl
 */
public class LeaderCard extends javax.swing.JPanel {

    //Init stats
    private int xMouse;
    private int yMouse;
    private byte Corner = 0;
    private JLabel background;
    private JLabel warrior;
    //Stats for Focused Animation
    private int startingX;
    private int startingY;
    private boolean isFocused = false;
    private CardFocusAnimation focusAnimation = null;
    //Stats for icon changing
    private String cardBack;
    private String cardFront;
    private String imageName;
    private String backName;

    public LeaderCard() {
        initCard();
    }

    private void initCard() {

        background = new JLabel();
        warrior = new JLabel();

        this.setSize(Constants.LeaderCardWidth, Constants.LeaderCardHeight);
        this.setOpaque(false);
        this.setLayout(null);

        warrior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        this.add(warrior);

        warrior.setBounds(Constants.LeaderCardPictureX, Constants.LeaderCardPictureY, Constants.LeaderCardPictureWidth, Constants.LeaderCardPictureHeight);

        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        this.add(background);

        background.setBounds(0, 0, Constants.LeaderCardWidth, Constants.LeaderCardHeight);

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CardMousePressed(evt);
            }
        });
<<<<<<< HEAD

=======
>>>>>>> edit
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CardMouseReleased(evt);
            }
        });
<<<<<<< HEAD
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CardMouseClicked(evt);
            }
        });
    }

    private void CardMouseReleased(java.awt.event.MouseEvent evt) {
        if(getFocused() == false){
            setFocused(true);
            if(getFocusAni() == null){
            setFocusAni(new CardFocusAnimation(this));
            }
            setHandSize();
        }
        else {
            setFocused(false);
            if(this.getFocusAni() == null){
            setFocusAni(new CardFocusAnimation(this));
            }
        }
    }
    
    private void CardMouseClicked(java.awt.event.MouseEvent evt){
=======
    }

    private void CardMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }
    
    private void CardMouseReleased(java.awt.event.MouseEvent evt) {
>>>>>>> edit
        if(getFocused() == false){
            setFocused(true);
            if(getFocusAni() == null){
            setFocusAni(new CardFocusAnimation(this));
            }
            setHandSize();
        }
        else {
            setFocused(false);
            if(this.getFocusAni() == null){
            setFocusAni(new CardFocusAnimation(this));
            }
<<<<<<< HEAD
        }
    }

    private void CardMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

=======
            setHandSize();
        }
    }

>>>>>>> edit
    private void CardMouseDragged(java.awt.event.MouseEvent evt) {
        int finalX;
        int finalY;
        byte xCorner = 0;
        byte yCorner = 0;
        JPanel theLabel = (JPanel) evt.getSource();
        JPanel parent = (JPanel) theLabel.getParent();
        double maxHeight = parent.getSize().getHeight() - theLabel.getSize().getHeight();
        double maxWidth = parent.getSize().getWidth() - theLabel.getSize().getWidth();

        theLabel.repaint();

        try {
            finalX = (int) parent.getMousePosition().getX() - xMouse;
            finalY = (int) parent.getMousePosition().getY() - yMouse;

            if (finalX <= 4) {
                finalX = 4;
                xCorner = Constants.left;
            }
            if (finalY <= 0) {
                finalY = 0;
                yCorner = Constants.top;
            }

            if (finalX >= maxWidth - 4) {
                finalX = (int) maxWidth - 4;
                xCorner = Constants.right;
            }

            if (finalY >= maxHeight - 4) {
                finalY = (int) maxHeight - 4;
                yCorner = Constants.bot;
            }

            Corner = getCorner(xCorner, yCorner);

            theLabel.setLocation(finalX, finalY);

        } catch (NullPointerException e) {
            finalX = 0;
            finalY = 0;

            try {
                if (Corner != 0) {
                    if (Corner == Constants.leftTopCorner) {
                        if (xMouse - evt.getX() > 0) {
                            finalX = 4;
                            finalY = ((int) theLabel.getLocation().getY() - ((yMouse - evt.getY())));
                        } else {
                            finalX = ((int) theLabel.getLocation().getX() - ((xMouse - evt.getX())));
                            finalY = 0;
                        }

                    }
                    if (Corner == Constants.leftBotCorner) {
                        if (xMouse - evt.getX() > 0) {
                            finalX = 4;
                            finalY = ((int) theLabel.getLocation().getY() - ((yMouse - evt.getY())));
                        } else {
                            finalX = ((int) theLabel.getLocation().getX() - ((xMouse - evt.getX())));
                            finalY = (int) maxHeight - 4;
                        }
                    }
                    if (Corner == Constants.rightTopCorner) {
                        if (xMouse - evt.getX() < 0) {
                            finalX = (int) maxWidth - 4;
                            finalY = ((int) theLabel.getLocation().getY() - ((yMouse - evt.getY())));
                        } else {
                            finalX = ((int) theLabel.getLocation().getX() - ((xMouse - evt.getX())));
                            finalY = 0;
                        }
                    }
                    if (Corner == Constants.rightBotCorner) {
                        if (xMouse - evt.getX() < 0) {
                            finalX = (int) maxWidth - 4;
                            finalY = ((int) theLabel.getLocation().getY() - ((yMouse - evt.getY())));
                        } else {
                            finalX = ((int) theLabel.getLocation().getX() - ((xMouse - evt.getX())));
                            finalY = (int) maxHeight - 4;
                        }
                    }
                } else {

                    if (theLabel.getLocation().getY() <= 0) {
                        finalX = ((int) theLabel.getLocation().getX() - ((xMouse - evt.getX())));
                        finalY = 0;
                    }

                    if (theLabel.getLocation().getY() >= maxHeight - 4) {
                        finalX = ((int) theLabel.getLocation().getX() - ((xMouse - evt.getX())));
                        finalY = (int) maxHeight - 4;

                    }

                    if (theLabel.getLocation().getX() <= 4) {
                        finalX = 4;
                        finalY = ((int) theLabel.getLocation().getY() - ((yMouse - evt.getY())));

                    }
                    if (theLabel.getLocation().getX() >= maxWidth - 4) {
                        finalX = (int) maxWidth - 4;
                        finalY = ((int) theLabel.getLocation().getY() - ((yMouse - evt.getY())));

                    }
                }

                if (finalX <= 4) {
                    finalX = 4;
                    xCorner = Constants.left;
                }

                if (finalY <= 0) {
                    finalY = 0;
                    yCorner = Constants.top;
                }

                if (finalX >= maxWidth - 4) {
                    finalX = (int) maxWidth - 4;
                    xCorner = Constants.right;
                }

                if (finalY >= maxHeight - 4) {
                    finalY = (int) maxHeight - 4;
                    yCorner = Constants.bot;
                }

                Corner = getCorner(xCorner, yCorner);

                theLabel.setLocation(finalX, finalY);
            } catch (NullPointerException ex) {
            }

        }

    }

    public byte getCorner(byte x, byte y) {

        if (x == Constants.left && y == Constants.top) {
            return Constants.leftTopCorner;
        }
        if (x == Constants.left && y == Constants.bot) {
            return Constants.leftBotCorner;
        }
        if (x == Constants.right && y == Constants.top) {
            return Constants.rightTopCorner;
        }
        if (x == Constants.right && y == Constants.bot) {
            return Constants.rightBotCorner;
        }

        return 0;
    }

    public void setHandSize() {
    }

    public void setFocusedSize() {
    }

    public void Repaint() {
    }

    public JLabel getWarriorPic() {
        return warrior;
    }

    public void setWarriorPic(String x) {
        warrior.setIcon(new javax.swing.ImageIcon(x));
    }

    public JLabel getBackgroundPic() {
        return background;
    }

    public void setBackgroundPic(String x) {
        background.setIcon(new javax.swing.ImageIcon(x));
    }

    public int getStartX() {
        return startingX;
    }

    public void setStartX(int x) {
        startingX = x;
    }

    public int getStartY() {
        return startingY;
    }

    public void setStartY(int y) {
        startingY = y;
    }

    public boolean getFocused() {
        return isFocused;
    }

    public void setFocused(boolean focus) {
        isFocused = focus;
    }

    public CardFocusAnimation getFocusAni() {
        return focusAnimation;
    }

    public void setFocusAni(CardFocusAnimation animation) {
        focusAnimation = animation;
    }

    public void setCardBack(String path) {
        cardBack = path;
    }

    public String getCardBack() {
        return cardBack;
    }

    public void setCardFront(String path) {
        cardFront = path;
    }

    public String getCardFront() {
        return cardFront;
    }

    public void setImageName(String name) {
        imageName = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setBackName(String name) {
        backName = name;
    }

    public String getBackName() {
        return backName;
    }
}
