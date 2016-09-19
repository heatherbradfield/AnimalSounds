import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by heather.bradfield823 on 9/14/16.
 */
class GamePanel extends JPanel {
    int i = 0;
    public GamePanel(final Animal newanimal) {

        JButton sound = new JButton("Play Sound");
        ArrayList<String> wavs = new ArrayList<String>() {{
            add("/Audio/CowMoo.wav");
            add("/Audio/Duckquack.wav");
            add("/Audio/Monkey.wav");
            add("/Audio/Owlhoot.wav");
        }};

        sound.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                URL url = getClass().getResource(wavs.get(i));
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
            public void actionPerformed(ActionEvent e) {
                if (i == 0) {
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
            public void actionPerformed(ActionEvent e) {
                if (i == 1) {
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
            public void actionPerformed(ActionEvent e) {
                if (i == 2) {
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
            public void actionPerformed(ActionEvent e) {
                if (i == 3) {
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
            public void actionPerformed(ActionEvent e){
                newanimal.swapCard(Animal.menuPan);
            }
        });
        add(menu);
    }
}
