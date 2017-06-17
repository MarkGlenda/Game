
package whoami.GUI;

import javax.swing.JFrame;

/**
 *
 * @author mrmgl
 */
public class MainPanel extends javax.swing.JPanel {
    
    private javax.swing.JLabel Background;
    private DeckPanel deckPanel;
    
    public MainPanel(JFrame x) {
        initComponents();
    }
    
    private void initComponents() {

        Background = new javax.swing.JLabel();
        deckPanel = new DeckPanel();
        
        setLayout(null);
        setOpaque(false);
        
        add(deckPanel);
        deckPanel.setBounds(Constants.ResolutionWidth/2 - Constants.DeckAbsolutWidth/2, Constants.ResolutionHeight - Constants.DeckAbsolutHeight - 50, Constants.DeckAbsolutWidth, Constants.DeckAbsolutHeight);

        Background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Background.setIcon(new javax.swing.ImageIcon(Constants.iconpath+"GraphicsIcons\\"+Constants.leadBackName+".jpg")); // NOI18N
        add(Background);
        Background.setBounds(0, 0, Constants.ResolutionWidth, Constants.ResolutionHeight);
        
    }
    
    public void Terminate(){
        deckPanel.terminateAll();
    }
    
}
