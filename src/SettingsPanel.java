import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A class that allows the user to change game settings.
 *
 * @author Heather Bradfield
 * @version 09/21/2016
 */
public class SettingsPanel extends JPanel {
    /**
     * The list of settings the user can change in the applet.
     * @param newanimal The game applet.
     */
    public SettingsPanel(final Animal newanimal){

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel setLabel = new JLabel("Settings", SwingConstants.CENTER);
        setLabel.setFont(new Font("Chalkboard", Font.BOLD, 26));
        setLabel.setForeground(Color.MAGENTA);
        this.add(setLabel, gbc);

        JTextArea settings = new JTextArea();
        settings.append("To change the volume of the game, use the sound keys on your keyboard!\n");
        settings.append("To make the game larger, in the top left corner of the applet select the + button!\n");
        add(settings,gbc);

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
        add(menu,gbc);
    }
}
