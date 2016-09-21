import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import java.awt.*;
import javax.swing.*;

/**
 * A class that initializes the applet and creates the GUI.
 *
 * TODO: add background
 *
 * @author Heather Bradfield
 * @version 09/19/2016
 */
public class Animal extends JApplet {
    public static final String menuPan = "Menu";
    public static final String instrPan = "Instructions";
    public static final String settPan = "Settings";
    public static final String gamePan = "Game";

    //array of animal images
    public static Icon[] animalImg;


    //instantiating game logic layouts
    private CardLayout cardlayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardlayout);
    Label testLabel;
    Image bgImage = null;

    /**
     * Creates animal icons and runs applet
     *
     *
     */
    public void init() {
        //sets icon array to images in images folder
        animalImg = new Icon[]{   //put .png in array
                new ImageIcon(getClass().getResource("Images/cow.png")),
                new ImageIcon(getClass().getResource("Images/duck.png")),
                new ImageIcon(getClass().getResource("Images/Monkey.png")),
                new ImageIcon(getClass().getResource("Images/Owl.png")),
        };

        setBackground(Color.CYAN);

//        getContentPane().setBackground(Color.CYAN);
//        try {
//            MediaTracker tracker = new MediaTracker(this);
//            bgImage = getImage
//                    (getClass().getResource("Images/farm.jpg"));
//            tracker.addImage(bgImage, 0);
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//        testLabel = new Label("Testing");
//        add(testLabel);


        //this will make the app runnable
        try

        {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    resize(1000,800);
                    createGUI();
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't successfully complete");
        }
    }

//    public void paint(Graphics g) {
//        super.paint(g);
//        g.setColor(Color.CYAN);
//        //g.drawImage(bgImage, 0, 0, this);
//    }

    /**
     * Creates all panels
     */
    private void createGUI() {
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
     * Swaps panels
     * @param name the name of the panel to be switched to
     */
    public void swapCard(String name) {
        cardlayout.show(mainPanel, name);
    }
}



















