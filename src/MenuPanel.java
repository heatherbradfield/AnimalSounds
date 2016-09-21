import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * A class that sets up the main menu and its attributes.
 *
 * TODO: center buttons
 * TODO: make title look nicer; add instructions, delete settings
 * TODO: add background
 *
 * @author Heather Bradfield
 * @version 09/19/2016
 */
public class MenuPanel extends JPanel {
    public MenuPanel(final Animal newanimal){

        /*
        This will create a pre-defined layout from top bottom to order elements in as they are added to the JPanel Object
         */
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //new JLabel for game name
        JLabel name = new JLabel("Animal Sounds",SwingConstants.CENTER);
        //editting attributes
        name.setFont(new Font("Chalkboard", Font.BOLD, 32));
        name.setForeground(Color.BLUE);
        add(name,gbc);

        //play button - transfers control to game
        JButton game= new JButton("Play");
        game.addActionListener(new ActionListener(){
            /**
             * Starts game
             * @param e the mouseClicked or mouseClicked event
             */
            public void actionPerformed(ActionEvent e){
                newanimal.swapCard(Animal.gamePan);
            }
        });
        //adds game button to JPanel
        add(game,gbc);


        //instructions button
        JButton instruct= new JButton("Instructions");
        instruct.addActionListener(new ActionListener(){
            /**
             * Changes panel to Instructions
             * @param e the mouseClicked or mouseClicked event
             */
            public void actionPerformed(ActionEvent e){
                newanimal.swapCard(Animal.instrPan);
            }
        });
        add(instruct,gbc);

        JButton sett= new JButton("Settings");
        sett.addActionListener(new ActionListener(){
            /**
             * Changes panel to Settings
             * @param e the mouseClicked or mouseClicked event
             */
            public void actionPerformed(ActionEvent e){
                newanimal.swapCard(Animal.settPan);
            }
        });
        add(sett,gbc);

        //quit button -exits
        JButton quit= new JButton("Quit");
        quit.addActionListener(new ActionListener()
        {
            /**
             * Terminates the applet
             * @param e the mouseClicked or mouseClicked event
             */
            public void actionPerformed(ActionEvent e){
                System.exit(0); //change so it exits browser
            }
        });
        add(quit,gbc);
    }
}

class InstructPanel extends JPanel{
    public InstructPanel(final Animal newanimal){

        //setting layout for instruction panel as same as main menu - top to bottom Grid Bag
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //label and attributes
        JLabel instrLabel = new JLabel("Instructions", SwingConstants.CENTER);
        instrLabel.setFont(new Font("Courier New", Font.BOLD, 26));
        instrLabel.setForeground(Color.RED);
        this.add(instrLabel, gbc);

        //instructions text
        add(new JTextArea("Match the Sound to Each Animal, and if correct, that animal will disappear. Click below to see progression:"), gbc);
        //arrow pointing to diagrams for instructions
        Icon arrIcon = new ImageIcon(getClass().getResource("Images/arrow.png"));
        ImageIcon arrow = new ImageIcon("Images/arrow.png");
        JLabel arrLabel = new JLabel("", arrIcon, JLabel.CENTER);
        arrLabel.setMaximumSize(new Dimension(200, 100));
        arrLabel.setPreferredSize(new Dimension(190, 80));
        arrLabel.setMinimumSize(new Dimension(150, 70));
        add(arrLabel, gbc);


        //creating array for images to go through to illustrate state of game at different stages
        ImageIcon[] stateImg = new ImageIcon[]{   //put .png in array
                new ImageIcon(getClass().getResource("Images/firstState.png")),
                new ImageIcon(getClass().getResource("Images/secState.png")),
                new ImageIcon(getClass().getResource("Images/finalState.png")),
        };


        //stores images as buttons to illustrate progression through game

            JButton[] stateImgBut = new JButton[]
                {
                        new JButton(stateImg[0]),
                        new JButton(stateImg[1]),
                        new JButton(stateImg[2]),
                };


        //set attributes for each button/image
        for (int i = 0; i < stateImg.length; i++)
        {
            stateImgBut[i].setSize(new Dimension(50,20));
            stateImgBut[i].setVisible(false);
            stateImgBut[i].setOpaque(false);
            stateImgBut[i].setBorderPainted(false);
            stateImgBut[i].setContentAreaFilled(false);
            stateImgBut[i].setFocusPainted(false);
        }
        stateImgBut[0].setVisible(true);
        stateImgBut[0].addActionListener(new ActionListener() {

            //actions are set to go to next image in each set, and finally back to main menu after last image
            public void actionPerformed(ActionEvent e)
            {
                stateImgBut[0].setVisible(false);
                stateImgBut[1].setVisible(true);
                stateImgBut[1].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        stateImgBut[1].setVisible(false);
                        stateImgBut[2].setVisible(true);
                        stateImgBut[2].addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                newanimal.swapCard(Animal.menuPan);
                            }
                        });
                    }
                });
            }
        });

        add(stateImgBut[0], gbc);
        add(stateImgBut[1], gbc);
        add(stateImgBut[2], gbc);
        JButton menu= new JButton("Back to Menu");
        menu.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e){
                newanimal.swapCard(Animal.menuPan);
            }
        });
        add(menu);
    }
}

//settings panel
class SettingsPanel extends JPanel{
    public SettingsPanel(final Animal newanimal){

        add(new JLabel("Settings"));

        JButton menu= new JButton("Back to Menu");
        menu.addActionListener(new ActionListener(){
            /**
             * Returns back to Main Menu
             * @param e the mouseClicked or mouseClicked event
             */
            public void actionPerformed(ActionEvent e){
                newanimal.swapCard(Animal.menuPan);
            }
        });
        add(menu);
    }
}