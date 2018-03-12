/**
 * The Main-class of the application. This class only holds the main()-method
 * to start the application.
 * 
 * @author asty
 * @version 1.0
 */
public class ApplicationMain
{
    /**
     * The main entry for the application.
     * @param args arguments provided during startup of the application
     */
    public static void main (String[] args)
    {
        ApplicationUI applUI = new ApplicationUI();
        applUI.start();
    }
}
