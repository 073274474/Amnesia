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

class EndFrame extends JFrame{
  JFrame thisFrame;
  JPanel main;
  JButton exitButton;
  JLabel label;
  JLabel label2;
  
  EndFrame(){
   super("GAME OVER");
   this.thisFrame = this;
   this.setSize(500,250);
   this.setLocationRelativeTo(null);
   this.setUndecorated(true);
   
   main = new JPanel();
   main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
   main.setBackground(Color.BLACK);
   main.setPreferredSize(new Dimension(500,250));

   
   exitButton = new JButton("<HTML><H3><font color = 'white'>EXIT.</H3><HTML>");
   exitButton.addActionListener(new ExitButtonListener());
   exitButton.setBackground(Color.BLUE);
   exitButton.setBorder(BorderFactory.createEmptyBorder());
    
   
   label = new JLabel("<HTML><H1><font color = 'white'>GAME OVER.\n </H1><HTML>");
   label2 = new JLabel("<HTML><H3><font color = 'white'> \n thanks for playing! \n </H3><HTML>");
   main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
   main.add(label);
   main.add(label2);
   main.add(exitButton);
   this.add(main);
   this.setVisible(true);
   
  }
    
  class ExitButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("exit");
      thisFrame.dispose();
    
    }
  }
  
  public static void main(String[]args){
    new EndFrame();
  }
}
   

    