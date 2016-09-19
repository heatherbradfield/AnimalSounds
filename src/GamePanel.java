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
class GamePanel extends JPanel {
    int i = 0;
    String soundKey = "";
    public GamePanel(final Animal newanimal) {

        JButton sound = new JButton("Play Sound");
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
             * @param e mouseClicked or mousePressed event
             */
            public void actionPerformed(ActionEvent e) {
                soundKey = keys.get(i);
                URL url = getClass().getResource(animals.get(soundKey));
                AudioClip clip = Applet.newAudioClip(url);
                clip.play();
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
             * TODO: if right generate green box around img, if wrong generate red box around img
             *
             * @param e the mouseClicked or mousePressed event
             */
            public void actionPerformed(ActionEvent e) {
                if (soundKey.equals("cow")) {
                    image0.setVisible(false);
                    i++;
                } else {
//                    JLabel jlabel = new JLabel("Try again!");
//                    jlabel.setFont(new Font("Verdana",1,20));
//                    add(jlabel);
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
             * TODO: if right generate green box around img, if wrong generate red box around img
             *
             * @param e the mouseClicked or mousePressed event
             */
            public void actionPerformed(ActionEvent e) {
                if (soundKey.equals("duck")) {
                    image1.setVisible(false);
                    i++;
                } else {
//                    JLabel jlabel = new JLabel("Try again!");
//                    jlabel.setFont(new Font("Verdana",1,20));
//                    add(jlabel);
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
             * TODO: if right generate green box around img, if wrong generate red box around img
             *
             * @param e the mouseClicked or mousePressed event
             */
            public void actionPerformed(ActionEvent e) {
                if (soundKey.equals("monkey")) {
                    image2.setVisible(false);
                    i++;
                } else {
//                    JLabel jlabel = new JLabel("Try again!");
//                    jlabel.setFont(new Font("Verdana",1,20));
//                    add(jlabel);
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
             * TODO: if right generate green box around img, if wrong generate red box around img
             *
             * @param e the mouseClicked or mousePressed event
             */
            public void actionPerformed(ActionEvent e) {
                if (soundKey.equals("owl")) {
                    image3.setVisible(false);
                    i++;
                } else {
//                    JLabel jlabel = new JLabel("Try again!");
//                    jlabel.setFont(new Font("Verdana",1,20));
//                    add(jlabel);
                }
            }
        });
        add(image3);

        JButton menu= new JButton("Back to Menu");
        menu.addActionListener(new ActionListener(){
            /**
             * Changes panel back to Main Menu
             * TODO: allow user to start new game in main menu when "Play" is selected
             * @param e
             */
            public void actionPerformed(ActionEvent e){
                newanimal.swapCard(Animal.menuPan);
            }
        });
        add(menu);
    }
}
