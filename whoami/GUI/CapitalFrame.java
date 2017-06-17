
package whoami.GUI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.KeyStroke;
/**
 *
 * @author mrmgl
 */
public class CapitalFrame extends javax.swing.JFrame {
    
    public MainPanel Main;
                    
    public CapitalFrame() {
        initialComponents();
    }

    @SuppressWarnings("unchecked")                         
    
    private void initialComponents(){
        Main = new MainPanel(this);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        add(Main);
        Main.setBounds(0, 0, Constants.ResolutionWidth, Constants.ResolutionHeight);
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                javax.swing.JFrame x = (javax.swing.JFrame) e.getSource();
                if (((KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, java.awt.event.InputEvent.ALT_DOWN_MASK)) != null) && e.getKeyCode() == KeyEvent.VK_F4) {
                    try {
                        Main.Terminate();
                        x.dispose();
                        Whoami.CloseApp();
                    } catch (IOException ex) {
                        Logger.getLogger(CapitalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }

            }

        });

           
    }
                
}