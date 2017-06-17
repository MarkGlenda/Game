
package whoami.GUI;

import java.awt.Toolkit;


/**
 * @author mrmgl.
 * Important, deckPanel width is 1.7x lower than resolution width
 * deckPanel height is 6.23x of resolution height
 * card width is 19.2x resolution width
 * card height is 7.71x resolution height
 *
 */
public final class Constants {
    
    // define names of graphic sources + paths ect...
    
    /**
     * Returns a default file path where all the graphic components are stored by default.
     */
    public static String iconpath = "D:\\WhoAmIProject\\Graphics\\";
    /**
     * Defines name of Card Background graphics file.
     */
    public static String cardBackName = "LeaderCardBack";
    /**
     * Defines name of Main Background graphics file.
     */
    public static String leadBackName = "RainForestBackground";
    /**
     * Defines name of Hand Deck background graphics file.
     */
    public static String deckBackName = "DeckBackgroundGrayWood";
    /**
     * Defines name of graphics file, used for area where cards are placed, during game.
     */
    public static String cardAreaBackName = "Old";
    /**
     * Defines image file name of Berserk card.
     */
    public static String berserkImage = "BerserkBorder";
    /**
     * Defines image file name of Decoy Titan card.
     */
    public static String decoyImage = "DecoyTitanBorder";
    /**
     * Defines image file name of Hunter card.
     */
    public static String hunterImage = "HunterBorder";
    /**
     * Defines image file name of Lady card.
     */
    public static String ladyImage = "LadyBorder";
    /**
     * Defines image file name of Nomad card.
     */
    public static String nomadImage = "NomadBorder";
    /**
     * Defines image file name of Possesed card.
     */
    public static String possesedImage = "PossesedBorder";
    /**
     * Defines image file name of Twins card.
     */
    public static String twinsImage = "TwinsBorder";
    
    // Constant types, usable to define side, corner ect...
    /**
     * Byte constant set to 1.
     */
    public static byte left = 1;
    /**
     * Byte constant set to 2.
     */
    public static byte right = 2;
    /**
     * Byte constant set to 3.
     */
    public static byte top = 3;
    /**
     * Byte constant set to 4.
     */
    public static byte bot = 4;
    /**
     * Byte constants set to 1.
     */
    public static byte rightTopCorner = 1;
    /**
     * Byte constants set to 2.
     */
    public static byte rightBotCorner = 2;
    /**
     * Byte cosntants set to 3.
     */
    public static byte leftTopCorner = 3;
    /**
     * Byte constant set to 4.
     */
    public static byte leftBotCorner = 4;
    
    /**
     * Defines screen Height resolution.
     */
    public static int ResolutionHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    /**
     * Defines screen Width resolution.
     */
    public static int ResolutionWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    /**
     * Defines default Card Width.
     */
    public static int LeaderCardWidth = (int) ((double) (Constants.ResolutionWidth/(19.2)));
    /**
     * Defines default Card Height.
     */
    public static int LeaderCardHeight = (int) ((double) (Constants.ResolutionHeight/(7.71)));
    /**
     * Defines default Width of Hand Deck.
     */
    public static int DeckPanelWidth = (int) ((double) (Constants.ResolutionWidth/(1.7)));
    /**
     * Defines default Height of Hand Deck.
     */
    public static int DeckPanelHeight = (int) ((double) (Constants.ResolutionHeight/(6.23)));
    /**
     * Defines default Height of playing area.
     */
    public static int DeckAbsolutHeight = (int)(((double) Constants.ResolutionHeight*0.85)+25);
    /**
     * Defines default Width of playing area.
     */
    public static int DeckAbsolutWidth = (int)((double) Constants.DeckPanelWidth*1.05);
    /**
     * Defines the X coordination of Hand Deck panel.
     */
    public static int DeckPanelX = (Constants.DeckAbsolutWidth-Constants.DeckPanelWidth)/2;
    
    /**
     * Focused card state sizes are multiplied by this value. Default is 1,4.
     */
    public static double CardMultiplier =  1.4;
    /**
     * Defines default Width of card Image.
     */
    public static int LeaderCardPictureWidth = Constants.LeaderCardWidth - Constants.LeaderCardWidth / 5;
    /**
     * Defines default Height of card Image.
     */
    public static int LeaderCardPictureHeight = Constants.LeaderCardHeight - Constants.LeaderCardHeight / 5;
    /**
     * Defines default X coordinates of card Image.
     */
    public static int LeaderCardPictureX = (Constants.LeaderCardWidth / 5) / 2;
    /**
     * Defines default Y coordinates of card Image.
     */
    public static int LeaderCardPictureY = (Constants.LeaderCardWidth / 5) / 2;
    /**
     * Defines default X coordinates of card Image when card is in Focused state.
     */
    public static int CardFocusedPictureX = (int) (Constants.LeaderCardPictureX * Constants.CardMultiplier);
    /**
     * Defines default Y coordinates of card Image when card is in Focused state.
     */
    public static int CardFocusedPictureY = (int) (Constants.LeaderCardPictureY * Constants.CardMultiplier);
    /**
     * Defines default Width size of card in Focused state.
     */
    public static int CardFocusedWidth = (int) (Constants.LeaderCardWidth * Constants.CardMultiplier);
    /**
     * Defines default Height size of card in Focused state.
     */
    public static int CardFocusedHeight = (int) (Constants.LeaderCardHeight * Constants.CardMultiplier);
    /**
     * Defines default image Width of card in focused state.
     */
    public static int CardFocusedPictureWidth = (int) (Constants.LeaderCardPictureWidth * Constants.CardMultiplier);
    /**
     * Defines default image Height of card in focused state.
     */
    public static int CardFocusedPictureHeight = (int) (Constants.LeaderCardPictureHeight * Constants.CardMultiplier);
}
