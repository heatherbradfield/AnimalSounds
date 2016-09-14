import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Animal extends JApplet {
 public static final String menuPan = "Menu";
 public static final String instrPan = "Instructions";
 public static final String settPan = "Settings";
 public static final String gamePan = "Game";
 
 public static Icon[] animalImg;

 private CardLayout cardlayout = new CardLayout();
 private JPanel mainPanel = new JPanel(cardlayout);

 public void init() {
  animalImg = new Icon[] {   //put .png in array
         new ImageIcon(getClass().getResource("cow.png")),
         new ImageIcon(getClass().getResource("duck.png")),
         new ImageIcon(getClass().getResource("Monkey.png")),
         new ImageIcon(getClass().getResource("Owl.png")),
         new ImageIcon(getClass().getResource("goat.png"))
     };

  try {
         javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
          public void run() {
           createGUI();
          }
         });
        }
        catch (Exception e) {
         System.err.println("createGUI didn't successfully complete");
        }
    }

    private void createGUI() { //create all panels
     MenuPanel menu = new MenuPanel(this);
     InstructPanel instr = new InstructPanel(this);
     SettingsPanel sett = new SettingsPanel(this);
     GamePanel game = new GamePanel(this);

     mainPanel.add(menu, menuPan);
     mainPanel.add(instr, instrPan);
     mainPanel.add(sett, settPan);
     mainPanel.add(game, gamePan);
     getContentPane().add(mainPanel);
    }
    
    public void swapCard(String name) {
     cardlayout.show(mainPanel, name);
    }
}

class MenuPanel extends JPanel{
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

class GamePanel extends JPanel{
 public GamePanel(final Animal newanimal){
   
   JButton image0 = new JButton(Animal.animalImg[0]);
     image0.setOpaque(false);
     image0.setContentAreaFilled(false);
     image0.setBorderPainted(false);
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













