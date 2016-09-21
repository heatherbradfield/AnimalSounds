import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * A class that displays the instructions for the game.
 *
 * @author Heather Bradfield
 * @version 09/21/2016
 */
public class InstructPanel extends JPanel {
    /**
     * The list of instructions for how to play the game.
     * @param newanimal The game applet.
     */
    public InstructPanel(final Animal newanimal){

//        add(new JLabel("Instructions"));

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel instrLabel = new JLabel("Instructions", SwingConstants.CENTER);
        instrLabel.setFont(new Font("Chalkboard", Font.BOLD, 26));
        instrLabel.setForeground(Color.RED);
        this.add(instrLabel, gbc);

        JTextArea instructions = new JTextArea();
        instructions.append("Match the sound to the correct animal!\n");
        instructions.append("In order to make a guess, you must click the \"Play Sound\" button.\n");
        instructions.append("If you guess correctly, the animal will disappear.\n");
        instructions.append("If you guess incorrectly, try again!\n");
        instructions.append("You win the game once you all the animals disappear.\n");
        instructions.append("Have fun!");
        add(instructions,gbc);

        JButton menu= new JButton("Back to Menu");
        menu.addActionListener(new ActionListener(){
            /**
             * Returns back to Main Menu
             * @param e The mouseClicked or mouseClicked event
             */
            public void actionPerformed(ActionEvent e){
                newanimal.swapCard(Animal.menuPan);
            }
        });
        add(menu,gbc);
    }
}
