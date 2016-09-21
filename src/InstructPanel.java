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
//        instructions.append("In order to make a guess, you must click the \"Play Sound\" button.\n");
//        instructions.append("If you guess correctly, the animal will disappear.\n");
//        instructions.append("If you guess incorrectly, try again!\n");
//        instructions.append("You win the game once you all the animals disappear.\n");
//        instructions.append("Have fun!");
        add(instructions,gbc);
        add(new JTextArea("Match the sound to the correct Animal, and if correct, that animal will disappear. Click below to see progression:"), gbc);
        Icon arrIcon = new ImageIcon(getClass().getResource("Images/arrow.png"));
        ImageIcon arrow = new ImageIcon("Images/arrow.png");
        JLabel arrLabel = new JLabel("", arrIcon, JLabel.CENTER);
        arrLabel.setMaximumSize(new Dimension(200, 100));
        arrLabel.setPreferredSize(new Dimension(190, 80));
        arrLabel.setMinimumSize(new Dimension(150, 70));
        add(arrLabel, gbc);

//        ImageIcon imageIcon = new ImageIcon("./img/imageName.png"); // load the image to a imageIcon
//        Image image = imageIcon.getImage(); // transform it
//        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
//        imageIcon = new ImageIcon(newimg);  // transform it back

        ImageIcon[] stateImg = new ImageIcon[]{
                new ImageIcon(getClass().getResource("Images/firstState.png")),
                new ImageIcon(getClass().getResource("Images/secState.png")),
                new ImageIcon(getClass().getResource("Images/finalState.png")),
        };

        JButton[] stateImgBut = new JButton[] {
                        new JButton(stateImg[0]),
                        new JButton(stateImg[1]),
                        new JButton(stateImg[2]),
        };

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
