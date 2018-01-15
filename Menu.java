import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
   this.setSize(500,500);
   this.setLocationRelativeTo(null);
   this.setUndecorated(true);
   
   main = new JPanel();
  // main.setLayout(new Flowlayout());
   main.setBackground(new Color(0,0,0,0));
   main.setPreferredSize(new Dimension(500,500));
   
   ImageIcon gb = new ImageIcon("gameButton.png");
   gameButton = new JButton(gb);
   gameButton.addActionListener(new GameButtonListener());
   gameButton.setBackground(new Color(0,0,0,0));
   gameButton.setBorder(BorderFactory.createEmptyBorder());
      
   helpButton = new JButton("instructions.");
   helpButton.addActionListener(new HelpButtonListener());
   helpButton.setBackground(Color.RED);
   helpButton.setBorder(BorderFactory.createEmptyBorder());
   
   exitButton = new JButton("exit.");
   exitButton.addActionListener(new ExitButtonListener());
   exitButton.setBackground(Color.BLUE);
   exitButton.setBorder(BorderFactory.createEmptyBorder());
    
   
   label = new JLabel("<HTML><H1><font color = 'black'>Welcome to amnesia!!!</H1><HTML>");
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
      new GameWindow();
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
    