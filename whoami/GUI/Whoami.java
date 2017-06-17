
package whoami.GUI;

import java.io.File;
import java.io.IOException;
/**
 *
 * @author mrmgl
 */
public class Whoami {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        new File(Constants.iconpath + "GraphicsIcons").mkdir();
        new GraphicsInitialization();

        CapitalFrame mainFrame = new CapitalFrame();

        mainFrame.setVisible(true);
        mainFrame.setSize(Constants.ResolutionWidth, Constants.ResolutionHeight);
        mainFrame.setLocationRelativeTo(null);
        
    }
    
    
    /**
     * Method being called on the application exit, it will remove all the graphics components which application drew and stored in GraphicsIcons directory.
     * @throws IOException 
     */
    public static void CloseApp() throws IOException {
        deleteFileOrDirectory(new File(Constants.iconpath + "GraphicsIcons"));
    }

    
    /**
     * This method deletes every file or directory found in entry varriable.
     * @param file file or directory which you want to remove
     * @throws IOException 
     */
    public static void deleteFileOrDirectory(File file) throws IOException {

        if (file.isDirectory()) {

            //directory is empty, then delete it
            if (file.list().length == 0) {

                file.delete();

            } else {

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    File fileDelete = new File(file, temp);

                    //recursive delete
                    deleteFileOrDirectory(fileDelete);
                }

                //check the directory again, if empty then delete it
                if (file.list().length == 0) {
                    file.delete();
                }
            }

        } else {
            //if file, then delete it
            file.delete();
        }
    }

}
