import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*; 
import java.util.Scanner;
import java.awt.image.*;
import javax.imageio.*;


class Gem{
  
  static int x;
  static int y;
  BufferedImage[] sprites;
  static boolean collected;
  
  //constructor
  public Gem (int x, int y){
    this.x = x;
    this.y = y;
    this.collected = false;
  }
  
  public void setCollected(){
    collected = true;
  }
  
  public boolean getCollected(){
    return this.collected;
  }
  
  public int getX(){
    return this.x;
  }
  
  public int getY(){
    return this.y;
  }
  
  public int sendAway(int playerX, int playerY){
    int distX = Math.abs(x-playerX);
    int distY = Math.abs(y-playerY);
    
    if (distX>distY){
      if (playerX<x){
        return 0;
      }else{
        return 1;
      }
    }else{
      if (playerY>y){
        return 2;
      }else{
        return 3;
      }
    }
  }
  
  public int distance(int playerX, int playerY){
    int distX = Math.abs(x-playerX);
    int distY = Math.abs(y-playerY);
    
    int dist = (int)Math.sqrt((distX*distX)+(distY*distY));
    return dist;
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
  
  
