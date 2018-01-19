import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*; 
import java.util.Scanner;
import java.awt.image.*;
import javax.imageio.*;

class Flower{
  int xPos, yPos;
  BufferedImage[] sprites;
  int num;
  
  Flower(){
    loadSprites();
    this.num = ((int)(Math.floor(Math.random()*8)+1));
    this.xPos = ((int)(Math.floor(Math.random()*500)));
    this.yPos = ((int)(Math.floor(Math.random()*500)));
    
  }
  
  public void loadSprites(){
    try { 
      BufferedImage image = ImageIO.read(new File("lotusSheet.png"));
     final int rows = 3;
     final int cols = 3;
     final int width = 160/3;
     final int height = 40;
     
       sprites = new BufferedImage[rows*cols];
       
       for (int j = 0; j < rows; j++){
         for (int i = 0; i < cols; i++){
           sprites[(j * cols) + i] = image.getSubimage(i * width,j * height,width,height);
         }
       }
    } catch(Exception e) { System.out.println("error loading sheet");};
  }
  
 
  public void draw(Graphics g){
    g.drawImage(sprites[num], xPos, yPos, null);
  }
  
  public void move(String str){
    if(str.equals("a")){
       this.xPos = xPos + 100;
       
      }else if (str.equals("s")){
          this.yPos = yPos - 50;
        
      }else if (str.equals("w")){
          this.yPos = yPos + 50;
        
      }else if (str.equals("d")){
          this.xPos = xPos -50;        
      }
      
      
    }

}
