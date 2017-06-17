
package whoami.GUI;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author mrmgl
 * Important, deckPanel width is 1.37x lower than resolution width
 * deckPanel height is 4.15x of resolution height
 * card width is 12.8x resolution width
 * card height is 5.14x resolution height
 *
 */
public final class GraphicsInitialization {

    private final List<String> AllCards = new ArrayList<String>();
    private final List<String> AllLeadingBackgrounds = new ArrayList<String>();
    private final List<String> AllCardBackgrounds = new ArrayList<String>();
    private final List<String> AllDeckBackgrounds = new ArrayList<String>();
    private final List<String> AllCardAreaBackgrounds = new ArrayList<String>();

    public GraphicsInitialization() throws IOException {
        InitializeIt();
    }
    
    public void InitializeIt() throws IOException {
        ResizeCards();
        ResizeLeadingBackgrounds();
        ResizeCardBacks();
        ResizeDeckBackgrounds();
        ResizeCardAreaBackground();
        AllCards.clear();
        AllLeadingBackgrounds.clear();
        AllCardBackgrounds.clear();
        AllDeckBackgrounds.clear();
        AllCardAreaBackgrounds.clear();
        
    }
    
    public void ResizeCardAreaBackground() throws IOException{
        LoadAllImages(AllCardAreaBackgrounds,new File(Constants.iconpath + "CardAreaBackgrounds\\"));
        BufferedImage back;
        String backPath;
        
        for(int i=0;i<AllCardAreaBackgrounds.size();i++){
            backPath = Constants.iconpath+"CardAreaBackgrounds\\"+AllCardAreaBackgrounds.get(i);
            back = ImageIO.read(new File(backPath));
            back = getScaledImage(back,Constants.DeckAbsolutWidth, Constants.DeckAbsolutHeight-Constants.DeckPanelHeight-20,1);
            backPath = Constants.iconpath+"GraphicsIcons\\"+AllCardAreaBackgrounds.get(i);
            saveImage(back,backPath,"png");
        }
    }
    
    //Resizes All CardsPictures and Store them to GraphicsIcons folder
    public void ResizeCards() throws IOException {
        LoadAllImages(AllCards,new File(Constants.iconpath + "Cards\\"));
        
        BufferedImage card;
        BufferedImage cardFocus;
        String cardPath;
        int cardNameLen;
        
        for(int i=0;i<AllCards.size();i++){
            cardPath = Constants.iconpath+"Cards\\"+AllCards.get(i);
            card = ImageIO.read(new File(cardPath));
            cardFocus = getScaledImage(card,Constants.CardFocusedPictureWidth, Constants.CardFocusedPictureHeight,1);
            card = getScaledImage(card,Constants.LeaderCardPictureWidth, Constants.LeaderCardPictureHeight,1);
            cardPath = Constants.iconpath+"GraphicsIcons\\"+AllCards.get(i);
            saveImage(card,cardPath,"png");
            cardNameLen = cardPath.length();
            cardPath = cardPath.substring(0, cardNameLen - 4)+"Focused.png";
            saveImage(cardFocus,cardPath,"png");
        }
        
    }
   //Resizes All CardsBackgrounds and Store them to GraphicsIcons folder    
    public void ResizeCardBacks() throws IOException {
        LoadAllImages(AllCardBackgrounds,new File(Constants.iconpath + "CardBackgrounds\\"));
        
        BufferedImage card;
        BufferedImage cardFocus;
        String cardPath;
        int cardNameLen;
        
        for(int i=0;i<AllCardBackgrounds.size();i++){
            cardPath = Constants.iconpath+"CardBackgrounds\\"+AllCardBackgrounds.get(i);
            card = ImageIO.read(new File(cardPath));
            cardFocus = getScaledImage(card,Constants.CardFocusedWidth, Constants.CardFocusedHeight,1);
            card = getScaledImage(card,Constants.LeaderCardWidth, Constants.LeaderCardHeight,1);
            cardPath = Constants.iconpath+"GraphicsIcons\\"+AllCardBackgrounds.get(i);
            saveImage(card,cardPath,"png");
            cardNameLen = cardPath.length();
            cardPath = cardPath.substring(0, cardNameLen - 4)+"Focused.png";
            saveImage(cardFocus,cardPath,"png");
        }
        
    }
    
    //Resizes All LeadingBackgrounds and Store them to GraphicsIcons folder  
    public void ResizeLeadingBackgrounds() throws IOException{
        LoadAllImages(AllLeadingBackgrounds,new File(Constants.iconpath + "LeadingBackgrounds\\"));
        BufferedImage back;
        String backPath;
        
        for(int i=0;i<AllLeadingBackgrounds.size();i++){
            backPath = Constants.iconpath+"LeadingBackgrounds\\"+AllLeadingBackgrounds.get(i);
            back = ImageIO.read(new File(backPath));
            back = getScaledImage(back,Constants.ResolutionWidth, Constants.ResolutionHeight,2);
            backPath = Constants.iconpath+"GraphicsIcons\\"+AllLeadingBackgrounds.get(i);
            saveImage(back,backPath,"jpg");
        }
    }
    //Resizes All ResizeDeckBackgrounds and Store them to GraphicsIcons folder 
    public void ResizeDeckBackgrounds() throws IOException{
        LoadAllImages(AllDeckBackgrounds,new File(Constants.iconpath + "DeckBackgrounds\\"));
        BufferedImage back;
        String backPath;
        
        for(int i=0;i<AllDeckBackgrounds.size();i++){
            backPath = Constants.iconpath+"DeckBackgrounds\\"+AllDeckBackgrounds.get(i);
            back = ImageIO.read(new File(backPath));
            back = getScaledImage(back,Constants.DeckPanelWidth, Constants.DeckPanelHeight,1);
            backPath = Constants.iconpath+"GraphicsIcons\\"+AllDeckBackgrounds.get(i);
            saveImage(back,backPath,"jpg");
        }
    }
    //Method which writes buffered image to File, using for saving resizable Images
    public static void saveImage(BufferedImage img, String path,String format) throws IOException{
        File outputfile = new File(path);
        ImageIO.write(img, format, outputfile);
    }

    // Resizing images method
    public static BufferedImage getScaledImage(BufferedImage srcImg, int w, int h, int format /*1 for png 2 for jpg*/) throws NullPointerException {
        BufferedImage resizedImg=null;
        switch(format){
            case 1:
                resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
                break;
            case 2:
                resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                break;
        }
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    //Get All Filenames from specific folder to List<String>
    public void LoadAllImages(List<String> list, File folder) {
        for (final File fileEntry : folder.listFiles()) {
            list.add(fileEntry.getName());
        }
    }
}
