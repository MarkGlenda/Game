
package whoami.GUI;

import java.awt.Frame;
import java.awt.MouseInfo;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author mrmgl
 */
public class TopFramePanel extends javax.swing.JPanel {
    
    private JLabel ExitLabel;
    private JLabel MinimizeLabel;
    private boolean isExitPressed = false;
    private boolean isMinimizePressed = false;
    private final JFrame mother;
    
    private int xMouse;
    private int yMouse;
    private final int Width;
    
    public TopFramePanel(JFrame x, int w){
        mother = x;
        Width = w;
        initComponents();
    }
    
    private void initComponents(){
        ExitLabel = new JLabel();
        MinimizeLabel = new JLabel();
        
        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(null);   
        
        ExitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExitLabel.setIcon(new javax.swing.ImageIcon("D:\\Soft\\Icon Pack\\Delete-35-white.png")); // NOI18N
        ExitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitLabelMouseClicked(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitLabelMouseEntered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitLabelMouseExited(evt);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExitLabelMousePressed(evt);
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ExitLabelMouseReleased(evt);
            }
        });
        
        MinimizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MinimizeLabel.setIcon(new javax.swing.ImageIcon("D:\\Soft\\Icon Pack\\Minimize-35-White.png"));
        MinimizeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeLabelMouseClicked(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinimizeLabelMouseEntered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinimizeLabelMouseExited(evt);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MinimizeLabelMousePressed(evt);
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MinimizeLabelMouseReleased(evt);
            }
        });
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FrameDragMousePressed(evt);
            }
        });
        this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                FrameDragMouseDragged(evt);
            }
        });
        
        add(ExitLabel);
        ExitLabel.setBounds(Width - 80, 0, 80, 50);
        add(MinimizeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(Width - 160, 0, 80, 50));
        MinimizeLabel.setBounds(Width - 160, 0, 80, 50);
    }
    
    private void ExitLabelMouseEntered(java.awt.event.MouseEvent evt) {                                       
        JLabel theLabel = (JLabel) evt.getSource();
        
        if (isExitPressed) {
            theLabel.setIcon(new ImageIcon(Constants.iconpath+"Delete-80-55-black+LightRedBack.png"));
        }
        else{
            theLabel.setIcon(new ImageIcon(Constants.iconpath+"Delete-80-55-white+redback.png"));
        }
    }                                      

    private void ExitLabelMouseExited(java.awt.event.MouseEvent evt) {                                      
        JLabel theLabel = (JLabel) evt.getSource();
        
        theLabel.setIcon(new ImageIcon(Constants.iconpath+"Delete-35-white.png"));

    }                                     

    private void ExitLabelMouseClicked(java.awt.event.MouseEvent evt) {                                       
        System.exit(0);
    }                                      

    private void ExitLabelMouseReleased(java.awt.event.MouseEvent evt) {                                        
        JLabel theLabel = (JLabel) evt.getSource();
        
        double currentMouseX = MouseInfo.getPointerInfo().getLocation().getX();
        double currentMouseY = MouseInfo.getPointerInfo().getLocation().getY();
        double currentExitX = theLabel.getLocationOnScreen().getX();
        double currentExitY = theLabel.getLocationOnScreen().getY();
        
        isExitPressed = false;
        if (currentMouseX >= currentExitX && currentMouseX <= currentExitX + 79 && currentMouseY >= currentExitY && currentMouseY <= currentExitY + 49) {
            System.exit(0);
            
        }
        
        theLabel.setIcon(new ImageIcon(Constants.iconpath+"Delete-35-white.png"));

    }                                       

    private void ExitLabelMousePressed(java.awt.event.MouseEvent evt) {                                       
        isExitPressed = true;
        JLabel theLabel = (JLabel) evt.getSource();
        
        theLabel.setIcon(new ImageIcon(Constants.iconpath+"Delete-80-55-black+LightRedBack.png"));
    }
    
        private void MinimizeLabelMouseClicked(java.awt.event.MouseEvent evt) {                                           
        mother.setState(Frame.ICONIFIED);
    }                                          

    private void MinimizeLabelMouseEntered(java.awt.event.MouseEvent evt) {                                           
        JLabel theLabel = (JLabel) evt.getSource();
        
        if (isMinimizePressed) {
            theLabel.setIcon(new ImageIcon(Constants.iconpath+"Minimize-80-55-LightBlackBack.png"));
        }
        else{
            theLabel.setIcon(new ImageIcon(Constants.iconpath+"Minimize-80-55-LessBlackBack.png"));
        }
    }                                          

    private void MinimizeLabelMouseExited(java.awt.event.MouseEvent evt) {                                          
        JLabel theLabel = (JLabel) evt.getSource();
        
        theLabel.setIcon(new ImageIcon(Constants.iconpath+"Minimize-35-White.png"));
    }                                         

    private void MinimizeLabelMousePressed(java.awt.event.MouseEvent evt) {                                           
        isMinimizePressed = true;
        JLabel theLabel = (JLabel) evt.getSource();
        
        theLabel.setIcon(new ImageIcon(Constants.iconpath+"Minimize-80-55-LightBlackBack.png"));
    }                                          

    private void MinimizeLabelMouseReleased(java.awt.event.MouseEvent evt) {                                            
        JLabel theLabel = (JLabel) evt.getSource();
        
        double currentMouseX = MouseInfo.getPointerInfo().getLocation().getX();
        double currentMouseY = MouseInfo.getPointerInfo().getLocation().getY();
        double currentExitX = theLabel.getLocationOnScreen().getX();
        double currentExitY = theLabel.getLocationOnScreen().getY();
        
        isMinimizePressed = false;
        if (currentMouseX >= currentExitX && currentMouseX <= currentExitX + 79 && currentMouseY >= currentExitY && currentMouseY <= currentExitY + 49) {
            mother.setState(Frame.ICONIFIED);
        }
        
        theLabel.setIcon(new ImageIcon(Constants.iconpath+"Minimize-35-White.png"));
    } 
    
    private void FrameDragMousePressed(java.awt.event.MouseEvent evt) {                                       
        xMouse = evt.getX();
        yMouse = evt.getY();
    }                                      

    private void FrameDragMouseDragged(java.awt.event.MouseEvent evt) {                                       
                                      
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        mother.setLocation(x - xMouse , y - yMouse);                                  
    } 
    
}
