
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
  JLabel text;
  JButton backButton;
  JScrollPane scrollPane;
  
  JTextField textField;
  
  HelpFrame(){
    super("instructions");
    this.thisFrame = this;
    
    this.setSize(500,500);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setUndecorated(true);
    
    main = new JPanel();
    main.setBackground(Color.BLACK);
    label = new JLabel("<HTML><H1><font color = 'white'>INSTRUCTIONS.</H1></HTML>");
    main.add(label);
    
    backButton = new JButton("BACK.");
    backButton.addActionListener(new BackButtonListener());
    backButton.setBackground(Color.GREEN);
    backButton.setBorder(BorderFactory.createEmptyBorder()); 
    
    
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
  
  
  