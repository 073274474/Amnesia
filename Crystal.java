import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*; 
import java.util.Scanner;
import java.awt.image.*;
import javax.imageio.*;

class Crystal{
  static int xPos, yPos;
  BufferedImage[] sprites;
  boolean taken;
  Rectangle box;
  int[][] locations;
  
  Crystal(){
    this.xPos = ((int)(Math.floor(Math.random()*500)));
    this.yPos = ((int)(Math.floor(Math.random()*500)));
    this.taken = false;
    this.box = new Rectangle(xPos, yPos, 240, 275); 
    loadSprites();
  }
  
/*  public int getNearCrystal(int cryRemain, int xPlayer, int yPlayer){
    int xDist;
    double r;
    int yDist;
    double[] radList = new double[cryRemain];
    double[] radList2 = new double[cryRemain];
    for (int i = 0; i < cryRemain-1; i++){
      xDist = xPlayer - crystals[i].xPos;
      yDist = yPlayer - crystals[i].yPos;
      r = Math.sqrt((double)(yDist^2) + (xDist^2));
      radList[i] = r;     
      
    }
    for (int i = 0; i < radList2.length; i ++){
      radList2[i] = radList[i];
    }
        
    Arrays.sort(radList);
    
    for(int j = 0; j < cryRemain; j++){
      if (radList2[j] == radList[0]){
        return j;
      }
    }
    return 0;
  }*/

    public void loadSprites(){
      try{
        BufferedImage sheet = ImageIO.read(new File("crystals.png"));
        
        //size of image:
        final int width = 40;
        final int height = 45;
        final int rows = 2;
        final int cols = 4;
        sprites = new BufferedImage[(cols*rows)];
       
        for (int j = 0; j < rows; j++){
          for (int i = 0; i < cols; i++){
            sprites[(j * cols) + i] = sheet.getSubimage(i * width,j * height,width,height);
            //System.out.println((j*cols)+i);
          }
        }
      } catch(Exception e) { 
        System.out.println("error loading sheet");
      }
    }    
     
    public void draw(Graphics g, int i){
       g.drawImage(sprites[i], xPos, yPos, null);
    }
       
    class Box{
      double xPosition, yPosition;
      int height, width;
      Rectangle boundingBox;
      
      public Rectangle Box(int x, int y, int w, int h){
        xPosition = x;
        yPosition = y;
        width = w;
        height = h;
        boundingBox = new Rectangle((int)xPosition, (int)yPosition, width, height);
        return boundingBox;
      }
    }

}