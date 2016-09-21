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
    final int num_of_animals = 4;
    String soundKey = "";
    AudioClip clip;
    JLabel congrats = new JLabel("GOOD JOB, YOU DID IT!", SwingConstants.CENTER);

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

        JButton sound = new JButton("Play Sound");
        sound.addActionListener(new ActionListener() {
            /**
             * Plays sound of current animal.
             * @param e The mouseClicked or mousePressed event
             */
            public void actionPerformed(ActionEvent e) {
                if (i < num_of_animals) {
                    soundKey = keys.get(i);
                    URL url = getClass().getResource(animals.get(soundKey));
                    clip = Applet.newAudioClip(url);
                    clip.play();
                }
            }
        });
        add(sound);

        JButton image0 = new JButton(Animal.animalImg[0]);
        image0.setOpaque(false);
        image0.setBorderPainted(false);
        image0.setContentAreaFilled(false);
        image0.setFocusPainted(false);
        image0.addActionListener(new ActionListener() {
            /**
             * If image0 selected, check if animal matches sound.
             * If it matches, hide image and choose next sound.
             * Else, do nothing.
             *
             * @param e The mouseClicked or mousePressed event
             */
            public void actionPerformed(ActionEvent e) {
                if (soundKey.equals("cow")) {
                    URL url = getClass().getResource("/Audio/correctAnswer.wav");
                    clip = Applet.newAudioClip(url);
                    clip.play();
                    image0.setVisible(false);
                    i++;
                    if (i == num_of_animals) {
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
        add(image0);

        JButton image1 = new JButton(Animal.animalImg[1]);
        image1.setOpaque(false);
        image1.setContentAreaFilled(false);
        image1.setBorderPainted(false);
        image1.setFocusPainted(false);
        image1.addActionListener(new ActionListener() {
            /**
             * If image1 selected, check if animal matches sound.
             * If it matches, hide image and choose next sound.
             * Else, do nothing.
             *
             * @param e The mouseClicked or mousePressed event
             */
            public void actionPerformed(ActionEvent e) {
                if (soundKey.equals("duck")) {
                    URL url = getClass().getResource("/Audio/correctAnswer.wav");
                    clip = Applet.newAudioClip(url);
                    clip.play();
                    image1.setVisible(false);
                    i++;
                    if (i == num_of_animals) {
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
        add(image1);

        JButton image2 = new JButton(Animal.animalImg[2]);
        image2.setOpaque(false);
        image2.setContentAreaFilled(false);
        image2.setBorderPainted(false);
        image2.setFocusPainted(false);
        image2.addActionListener(new ActionListener() {
            /**
             * If image2 selected, check if animal matches sound.
             * If it matches, hide image and choose next sound.
             * Else, do nothing.
             *
             * @param e The mouseClicked or mousePressed event
             */
            public void actionPerformed(ActionEvent e) {
                if (soundKey.equals("monkey")) {
                    URL url = getClass().getResource("/Audio/correctAnswer.wav");
                    clip = Applet.newAudioClip(url);
                    clip.play();
                    image2.setVisible(false);
                    i++;
                    if (i == num_of_animals) {
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
        add(image2);
        JButton image3 = new JButton(Animal.animalImg[3]);
        image3.setOpaque(false);
        image3.setContentAreaFilled(false);
        image3.setBorderPainted(false);
        image3.setFocusPainted(false);
        image3.addActionListener(new ActionListener() {
            /**
             * If image3 selected, check if animal matches sound.
             * If it matches, hide image and choose next sound.
             * Else, do nothing.
             *
             * @param e The mouseClicked or mousePressed event
             */
            public void actionPerformed(ActionEvent e) {
                if (soundKey.equals("owl")) {
                    URL url = getClass().getResource("/Audio/correctAnswer.wav");
                    clip = Applet.newAudioClip(url);
                    clip.play();
                    image3.setVisible(false);
                    i++;
                    if (i == num_of_animals) {
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
        add(image3);

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
}
