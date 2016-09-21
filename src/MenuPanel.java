import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
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

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel name = new JLabel("Animal Sounds",SwingConstants.CENTER);
        name.setFont(new Font("Chalkboard", Font.BOLD, 32));
        name.setForeground(Color.BLUE);
        add(name,gbc);

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
        add(game,gbc);

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

        JButton quit= new JButton("Quit");
        quit.addActionListener(new ActionListener(){
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


        this.setLayout(new SpringLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel instrLabel = new JLabel("Instructions", SwingConstants.CENTER);
        instrLabel.setFont(new Font("Courier New", Font.BOLD, 26));
        instrLabel.setForeground(Color.RED);
        this.add(instrLabel, gbc);

        add(new JTextArea("Animal Sounds Will Play As Follows:"), gbc);
        Icon arrIcon = new ImageIcon(getClass().getResource("Images/arrow.png"));
        ImageIcon arrow = new ImageIcon("Images/arrow.png");
        JLabel arrLabel = new JLabel("", arrIcon, JLabel.CENTER);
        add(arrLabel, gbc);

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