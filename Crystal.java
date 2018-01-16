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
  Crystal[] crystals;
    
  Crystal(){
    this.xPos = xPos;
    this.yPos = yPos;
    this.taken = false;
  }
  
  public int getNearCrystal(int cryRemain, int xPlayer, int yPlayer){
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
  }
  
  public void makeCrystals(){
    loadSprites();
  }

    public void loadSprites(){
      try{
        BufferedImage sheet = ImageIO.read(new File("crystals.png"));
        
        //size of image:
        final int width = 960;
        final int height = 720;
        final int rows = 2;
        final int cols = 4;
        sprites = new BufferedImage[6];
        
        //adding images from sheet to array
        
        for (int j = 0; j < rows; j++){
          for (int i = 0; i < cols; i++){
            while((j*i) < 8){
              sprites[(j * cols) + i] = sheet.getSubimage(i * width,j * height,width,height);
            }
          }
        }
        } catch(Exception e) { 
        System.out.println("error loading sheet");
      }
    }
    
    public void draw(Graphics g, int xMap, int yMap){
      int x, y;
      for (int i = 0; i <7; i ++){
        x =((int)Math.floor(Math.random()*xMap));
        y =((int)Math.floor(Math.random()*yMap));
        g.drawImage(sprites[i], x, y, null);
      }
    }

}