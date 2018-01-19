
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
import javax.swing.JScrollPane;

class HelpFrame extends JFrame{
   
  JFrame thisFrame;
  JPanel main;
  JLabel title;
  JLabel label;
  JLabel[] labels;
  JLabel text;
  JButton backButton;
  JScrollPane scrollPane;
  
  JTextField textField;
  
  HelpFrame(){
    super("instructions");
    this.thisFrame = this;
    
    this.setSize(500,300);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setUndecorated(true);
    
    main = new JPanel();
    main.setBackground(Color.BLACK);
    label = new JLabel("<HTML><H1><font color = 'white'>INSTRUCTIONS.</H1></HTML>");
    main.add(label);
    
    labels = new JLabel[5];
    
    labels[0] = new JLabel("<HTML><H3><font color = 'white'>\n Use W, S, A & D to navigate up, down, left and right respectively. \n</H1></HTML>");
    labels[1] = new JLabel("<HTML><H3><font color = 'white'>The goal is to collect all the gems.... \n</H1></HTML>");
    labels[2] = new JLabel("<HTML><H3><font color = 'white'> Or is it? \n</H1></HTML>");
    labels[3] = new JLabel("<HTML><H3><font color = 'white'>You may listen to the narrator.... or not. \n</H1></HTML>");
    labels[4] = new JLabel("<HTML><H3><font color = 'white'> The choice is yours! </H1></HTML>");
    
    backButton = new JButton("BACK.");
    backButton.addActionListener(new BackButtonListener());
    backButton.setBackground(Color.GREEN);
    backButton.setBorder(BorderFactory.createEmptyBorder()); 
    
    
    for (int i = 0; i < labels.length; i ++){
      main.add(labels[i]);
    }
    main.add(backButton);
    this.add(main);
    this.setVisible(true);
  }
  
  class BackButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      new Menu();
      thisFrame.dispose();
    }
  }
  
  public static void main(String[]args){
    new HelpFrame();
  }
}
  
  
  