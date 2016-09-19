
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import java.awt.*;
import javax.swing.*;


public class Animal extends JApplet {
    public static final String menuPan = "Menu";
    public static final String instrPan = "Instructions";
    public static final String settPan = "Settings";
    public static final String gamePan = "Game";

    public static Icon[] animalImg;

    private CardLayout cardlayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardlayout);
    Label testLabel;
    Image bgImage = null;

    public void init() {
        animalImg = new Icon[]{   //put .png in array
                new ImageIcon(getClass().getResource("Images/cow.png")),
                new ImageIcon(getClass().getResource("Images/duck.png")),
                new ImageIcon(getClass().getResource("Images/Monkey.png")),
                new ImageIcon(getClass().getResource("Images/Owl.png")),
        };

        try {
            MediaTracker tracker = new MediaTracker(this);
            bgImage = getImage
                    (getClass().getResource("Images/farm.jpg"));
            tracker.addImage(bgImage, 0);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        testLabel = new Label("Testing");
        add(testLabel);

        try

        {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createGUI();
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't successfully complete");
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bgImage, 0, 0, this);
    }


    private void createGUI() { //create all panels
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

    public void swapCard(String name) {
        cardlayout.show(mainPanel, name);
    }
}



















