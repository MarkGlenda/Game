
package whoami.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import whoami.GUI.Cards.BerserkCard;
import whoami.GUI.Cards.DecoyTitanCard;
import whoami.GUI.Cards.HunterCard;
import whoami.GUI.Cards.LadyCard;
import whoami.GUI.Cards.NomadCard;
import whoami.GUI.Cards.PossesedCard;
import whoami.GUI.Cards.TwinsCard;


/**
 *
 * @author mrmgl
 */
public final class DeckPanel extends javax.swing.JPanel{
    
    private javax.swing.JLabel DeckBackground;
    private javax.swing.JLabel CardAreaBackground;
    private final List<LeaderCard> cardsInHands = new ArrayList<LeaderCard>();
    private final List<LeaderCard> allCards = new ArrayList<LeaderCard>();
    private int notCardComp = 0;
    
    int cardChange = 0;
    
    public DeckPanel(){
        initComponents();
    }
    
    public void initComponents(){
        DeckBackground = new javax.swing.JLabel();
        CardAreaBackground = new javax.swing.JLabel();
        
        setLayout(null);
        setOpaque(false);
        
        DeckBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeckBackground.setIcon(new javax.swing.ImageIcon(Constants.iconpath+"GraphicsIcons\\"+Constants.deckBackName+".png"));
        add(DeckBackground);
        notCardComp++;
        DeckBackground.setBounds(Constants.DeckPanelX, Constants.DeckAbsolutHeight-Constants.DeckPanelHeight, Constants.DeckPanelWidth, Constants.DeckPanelHeight);
        
        CardAreaBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CardAreaBackground.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        CardAreaBackground.setIcon(new javax.swing.ImageIcon(Constants.iconpath+"GraphicsIcons\\"+Constants.cardAreaBackName+".png"));
        add(CardAreaBackground);
        notCardComp++;
        CardAreaBackground.setBounds(0, 0, Constants.DeckAbsolutWidth, Constants.DeckAbsolutHeight);
        
        DeckPanel x = this;
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                cardChange++;
                if(cardChange==1) x.addLeaderCard(new BerserkCard());
                if(cardChange==2) x.addLeaderCard(new DecoyTitanCard());
                if(cardChange==3) x.addLeaderCard(new HunterCard());
                if(cardChange==4) x.addLeaderCard(new LadyCard());
                if(cardChange==5) x.addLeaderCard(new NomadCard());
                if(cardChange==6) x.addLeaderCard(new PossesedCard());
                if(cardChange==7){
                    x.addLeaderCard(new TwinsCard());
                    cardChange=0;
                }
            }
    
        });
    }
    
    public void addLeaderCard(LeaderCard newCard){
        add(newCard);
        setComponentZOrder(DeckBackground, getComponentCount()-1);
        setComponentZOrder(CardAreaBackground, getComponentCount()-1);
        cardsInHands.add(newCard);
        allCards.add(newCard);
        RepositionDeck();
    }
    
    public void RepositionDeck() {

        int startWidth;
        double x = (Constants.DeckPanelWidth-40) / (cardsInHands.size());
        int cardHeight = (Constants.DeckAbsolutHeight - Constants.LeaderCardHeight)-(Constants.DeckPanelHeight - Constants.LeaderCardHeight)/2; 
        double actualx;
        int move;
        int currentWidth;
        
       

        if (x >= Constants.LeaderCardWidth ) {
            startWidth = Constants.DeckPanelX + 20 + ((Constants.DeckPanelWidth) / (cardsInHands.size())/2)-(Constants.LeaderCardWidth/2) ;
            for (int i = 0; i <= cardsInHands.size() - 1; i++) {
                cardsInHands.get(i).setLocation((int) (i*x)+startWidth, cardHeight);
            }
        } else {
            startWidth = 25;
            x= (double) ( Constants.DeckPanelWidth - Constants.LeaderCardWidth - startWidth*2) / (cardsInHands.size() - 1);
            x = round(x, 1);
            actualx=0;
            currentWidth=0;
            startWidth += Constants.DeckPanelX;
            
            
            for (int i = 0; i <= cardsInHands.size() - 1; i++) {
                move = (int) (actualx + x);
                actualx = (double) x + actualx - move;
                cardsInHands.get(i).setLocation(currentWidth+startWidth, cardHeight);
                currentWidth+=move;
            }
        }
        
        setCardsXY();
    }
    
    public void setCardsXY(){
        for (int i = 0; i <= cardsInHands.size() - 1; i++) {
                cardsInHands.get(i).setStartX((int)cardsInHands.get(i).getLocation().getX());
                cardsInHands.get(i).setStartY((int)cardsInHands.get(i).getLocation().getY());
            }
    }
    
    public static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
        
    public void terminateAll(){
         for (int i = 0; i <= allCards.size() - 1; i++) {
            if(allCards.get(i).getFocusAni()!=null){
                allCards.get(i).getFocusAni().Terminate();
                }
            }
    }
    
    public int getNotCardComp(){
        return notCardComp;
    }
    
}

