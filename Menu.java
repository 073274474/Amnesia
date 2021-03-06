import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;

class Menu extends JFrame{
  
  JFrame thisFrame;
  JPanel main;
  JButton gameButton;
  JButton exitButton;
  JButton helpButton;
  JLabel label;
    
  Menu(){
   super("AMNESIA");
   this.thisFrame = this;
   this.setSize(500,250);
   this.setLocationRelativeTo(null);
   this.setUndecorated(true);
   
   main = new JPanel();
   main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
   main.setBackground(Color.BLACK);
   main.setPreferredSize(new Dimension(500,250));
   
  // ImageIcon gb = new ImageIcon("gameButton.png");
   gameButton = new JButton("<HTML><H2><font color = 'white'>START GAME.</H2><HTML>");
   gameButton.addActionListener(new GameButtonListener());
   gameButton.setBackground(Color.GREEN);
   gameButton.setBorder(BorderFactory.createEmptyBorder());
   
   //ImageIcon ib = new ImageIcon("instructions.png");
   helpButton = new JButton("<HTML><H2><font color = 'white'>INSTRUCTIONS.</H2><HTML>");
   helpButton.addActionListener(new HelpButtonListener());
   helpButton.setBackground(Color.RED);
   helpButton.setBorder(BorderFactory.createEmptyBorder());
   
   exitButton = new JButton("<HTML><H2><font color = 'white'>EXIT.</H2><HTML>");
   exitButton.addActionListener(new ExitButtonListener());
   exitButton.setBackground(Color.BLUE);
   exitButton.setBorder(BorderFactory.createEmptyBorder());
    
   
   label = new JLabel("<HTML><H1><font color = 'white'>AMNESIA.</H1><HTML>");
   main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
   main.add(label);
   main.add(gameButton);
   main.add(helpButton);
   main.add(exitButton);
   this.add(main);
   this.setVisible(true);
   
  }
  
  class GameButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Starting new Game");
      new IntroGUI();
      thisFrame.dispose();
    }
  }
  
  class HelpButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Help");
      thisFrame.dispose();
      new HelpFrame();
    }
  }
  
  class ExitButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("exit");
      thisFrame.dispose();
      //creidts frame
    }
  }
  
  public static void main(String[]args){
    new Menu();
    
  }
}
    