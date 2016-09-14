import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;


public class Animal extends JApplet {
    public static final String menuPan = "Menu";
    public static final String instrPan = "Instructions";
    public static final String settPan = "Settings";
    public static final String gamePan = "Game";

    public static Icon[] animalImg;
    public static Icon backgroundImg;

    private CardLayout cardlayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardlayout);

    public void init() {
        animalImg = new Icon[]{   //put .png in array
                new ImageIcon(getClass().getResource("Images/cow.png")),
                new ImageIcon(getClass().getResource("Images/duck.png")),
                new ImageIcon(getClass().getResource("Images/Monkey.png")),
                new ImageIcon(getClass().getResource("Images/Owl.png")),
                new ImageIcon(getClass().getResource("Images/goat.png"))
        };

        //test this
        backgroundImg = new ImageIcon(getClass().getResource("Images/farm.png"));

        try {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createGUI();
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't successfully complete");
        }
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



















