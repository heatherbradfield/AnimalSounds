import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by heather.bradfield823 on 9/14/16.
 */
public class MenuPanel extends JPanel {
    public MenuPanel(final Animal newanimal){

        add(new JLabel("Animal Sounds"));

        JButton instruct= new JButton("Instructions");
        instruct.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                newanimal.swapCard(Animal.instrPan);
            }
        });
        add(instruct);

        JButton game= new JButton("Play");
        game.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                newanimal.swapCard(Animal.gamePan);
            }
        });
        add(game);

        JButton sett= new JButton("Settings");
        sett.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                newanimal.swapCard(Animal.settPan);
            }
        });
        add(sett);

        JButton quit= new JButton("Quit");
        quit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0); //change so it exits browser
            }
        });
        add(quit);
    }
}

class InstructPanel extends JPanel{
    public InstructPanel(final Animal newanimal){

        add(new JLabel("Instructions"));

        JButton menu= new JButton("Back to Menu");
        menu.addActionListener(new ActionListener(){
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
            public void actionPerformed(ActionEvent e){
                newanimal.swapCard(Animal.menuPan);
            }
        });
        add(menu);
    }
}