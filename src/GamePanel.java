import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * The actual game.
 * Generates animal images and sounds.
 *
 * @author Heather Bradfield
 * @version 09/19/2016
 */
public class GamePanel extends JPanel {
    int i = 0;
    String soundKey = "";
    AudioClip clip;
    JLabel congrats = new JLabel("GOOD JOB, YOU DID IT!", SwingConstants.CENTER);
    JButton sound = new JButton("Play Sound");

    /**
     * Creates a hash map of animal names and their corresponding sounds.
     * Creates a sound button and plays a random animal sound.
     * Displays images and makes logic checks (user clicked on correct animal).
     * @param newanimal The Animal Sounds applet.
     */
    public GamePanel(final Animal newanimal) {

        congrats.setFont(new Font("Chalkboard", Font.BOLD, 26));
        congrats.setForeground(Color.BLUE);
        congrats.setVisible(false);
        add(congrats);

        HashMap<String,String> animals = new HashMap<>();
        animals.put("cow","/Audio/CowMoo.wav");
        animals.put("duck","/Audio/Duckquack.wav");
        animals.put("monkey","/Audio/Monkey.wav");
        animals.put("owl","/Audio/Owlhoot.wav");
        ArrayList<String> keys = new ArrayList<String>() {{
            add("cow");
            add("duck");
            add("monkey");
            add("owl");
        }};
        Collections.shuffle(keys);

        sound.addActionListener(new ActionListener() {
            /**
             * Plays sound of current animal.
             * @param e The mouseClicked or mousePressed event
             */
            public void actionPerformed(ActionEvent e) {
                if (i < Animal.animals.length) {
                    soundKey = keys.get(i);
                    URL url = getClass().getResource(animals.get(soundKey));
                    clip = Applet.newAudioClip(url);
                    clip.play();
                }
            }
        });
        add(sound);

        for (int idx = 0; idx < Animal.animals.length; idx++) {
            addImage(idx, Animal.animals[idx]);
        }

        JButton menu= new JButton("Back to Menu");
        menu.addActionListener(new ActionListener(){
            /**
             * Changes panel back to Main Menu.
             * @param e the mouseClicked or mousePressed event.
             */
            public void actionPerformed(ActionEvent e){
                newanimal.createGUI();  // used to generate an entire new game
                                        // not the best practice, but was not given enough time
                                        // to change how the previous group generated a new game.
                newanimal.swapCard(Animal.menuPan);
            }
        });
        add(menu);
    }
    
    public void addImage(int idx, String animal) {
        JButton image = new JButton(Animal.animalImg[idx]);
        image.setOpaque(false);
        image.setBorderPainted(false);
        image.setContentAreaFilled(false);
        image.setFocusPainted(false);
        image.addActionListener(new ActionListener() {
            /**
             * If image selected, check if animal matches sound.
             * If it matches, hide image and choose next sound.
             * Else, do nothing.
             *
             * @param e The mouseClicked or mousePressed event
             */
            public void actionPerformed(ActionEvent e) {
                if (soundKey.equals(animal)) {
                    URL url = getClass().getResource("/Audio/correctAnswer.wav");
                    clip = Applet.newAudioClip(url);
                    clip.play();
                    image.setVisible(false);
                    i++;
                    if (i == Animal.animals.length) {
                        congrats.setVisible(true);
                        sound.setVisible(false);
                    }
                } else {
                    URL url = getClass().getResource("/Audio/wrongAnswer.wav");
                    clip = Applet.newAudioClip(url);
                    clip.play();
                }
            }
        });
        add(image);
    }
}
