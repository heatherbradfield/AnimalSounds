import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import java.awt.*;
import javax.swing.*;

/**
 * A class that initializes the applet and creates the GUI.
 *
 * TODO: Add background.
 *
 * @author Heather Bradfield
 * @version 09/19/2016
 */
public class Animal extends JApplet {

    /**
     * The name of the main menu panel.
     */
    public static final String menuPan = "Menu";

    /**
     * The name of the instructions panel.
     */
    public static final String instrPan = "Instructions";

    /**
     * The name of the settings panel.
     */
    public static final String settPan = "Settings";

    /**
     * The name of the game panel.
     */
    public static final String gamePan = "Game";

    /**
     * Array of animal images.
     */
    public static Icon[] animalImg;

    public CardLayout cardlayout = new CardLayout();
    public JPanel mainPanel = new JPanel(cardlayout);

    /**
     * Creates animal icons and runs applet.
     *
     */
    public void init() {

        animalImg = new Icon[]{
                new ImageIcon(getClass().getResource("Images/cow.png")),
                new ImageIcon(getClass().getResource("Images/duck.png")),
                new ImageIcon(getClass().getResource("Images/Monkey.png")),
                new ImageIcon(getClass().getResource("Images/Owl.png")),
        };

        try
        {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    resize(1024,768);
                    createGUI();
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't successfully complete");
        }
    }

    /**
     * Creates all panels.
     */
    public void createGUI() {
        MenuPanel menu = new MenuPanel(this);
        InstructPanel instr = new InstructPanel(this);
        SettingsPanel sett = new SettingsPanel(this);
        GamePanel game = new GamePanel(this);

        mainPanel.add(menu, menuPan);
        mainPanel.add(instr, instrPan);
        mainPanel.add(sett, settPan);
        mainPanel.add(game, gamePan);
        getContentPane().add(mainPanel);
    }

    /**
     * Swaps panels.
     * @param name the name of the panel to be switched to
     */
    public void swapCard(String name) {
        cardlayout.show(mainPanel, name);
    }
}



















