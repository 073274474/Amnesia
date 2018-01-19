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
import javax.swing.JTextArea;
import java.awt.Font;

class IntroGUI extends JFrame{
  
  JFrame thisFrame;
  
  public IntroGUI(){
    setTitle("intro gui");
    this.setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setUndecorated(true);
    
    this.thisFrame = this;
    
    this.add(new IntroPanel());
    
    pack(); 
    setVisible(true);    
    
  }
  
  class IntroPanel extends JPanel{
    
    JTextArea textArea;
    JLabel label;
    JButton nextButton;
    JButton gameButton;
    Narrator narr;
    String[] words;
    String text;
    int num;
    
    IntroPanel(){
      setPreferredSize(new Dimension(600,200));
      narr = new Narrator();
      try{
        narr.textReader();
      }catch(Exception e){
        System.out.println("textreader failed");
      }
      
      num = 0;
      textArea = new JTextArea();
      words = narr.startDialogue();
      nextButton = new JButton("next");
      nextButton.addActionListener(new nextButtonListener());
      
      label= new JLabel();
      label.setFont(new Font("Calibri", Font.PLAIN, 18));
      
      this.setBackground(Color.GRAY);
      this.add(label);
     // this.add(textArea);
      this.add(nextButton);
      
    }
    
    class nextButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
        if (num <= 12){
          label.setText(words[num]);
          System.out.println(num);
          num++;
        }
        if (num > 12){
          System.out.println("here");
          thisFrame.dispose();
          new GameWindow();
        }
        //num++;
      }
    }
  }
}