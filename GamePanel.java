import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by heather.bradfield823 on 9/14/16.
 */
class GamePanel extends JPanel {
    public GamePanel(final Animal newanimal){

        JButton image0 = new JButton(Animal.animalImg[0]);
        image0.setOpaque(false);
        image0.setContentAreaFilled(false);
        image0.setBorderPainted(true);
        image0.setBorder(new LineBorder(Color.RED));
        image0.setFocusPainted(false);
        image0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                image0.setVisible(false);
            }
        });
        add(image0);

        JButton image1 = new JButton(Animal.animalImg[1]);
        image1.setOpaque(false);
        image1.setContentAreaFilled(false);
        image1.setBorderPainted(false);
        image1.setFocusPainted(false);
        image1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                image1.setVisible(false);
            }
        });
        add(image1);

        JButton image2 = new JButton(Animal.animalImg[2]);
        image2.setOpaque(false);
        image2.setContentAreaFilled(false);
        image2.setBorderPainted(false);
        image2.setFocusPainted(false);
        image2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                image2.setVisible(false);
            }
        });
        add(image2);
        JButton image3 = new JButton(Animal.animalImg[3]);
        image3.setOpaque(false);
        image3.setContentAreaFilled(false);
        image3.setBorderPainted(false);
        image3.setFocusPainted(false);
        image3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                image3.setVisible(false);
            }
        });
        add(image3);
    }
}
