/**
 * january 8
 * Adi gelb
 * player class
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*; 
import java.util.Scanner;
import java.awt.image.*;
import javax.imageio.*;

class Player{
  static int xPos, yPos;
  String direction;
  BufferedImage[] sprites;
  int currentSprite;
  int currentStep;
  
  static int controlNum;
   
  public Player(){
    loadSprites();
    currentSprite = 0;
    currentStep = 0;
    this.xPos = 250;
    this.yPos = 225;
    this.direction= "stand";
    this.controlNum = 50;
  }
    
    public void loadSprites(){
      try{
        BufferedImage sheet = ImageIO.read(new File("spriteSheet.png"));
        
        //size of image:
        final int width = 30;
        final int height = 60;
        final int rows = 4;
        final int cols = 3;
        sprites = new BufferedImage[cols*rows];
        
        //adding images from sheet to array
        
        for (int j = 0; j < rows; j++){
          for (int i = 0; i < cols; i++){
            sprites[(j * cols) + i] = sheet.getSubimage(i * width,j * height,width,height);
          }
        }
        } catch(Exception e) { 
        System.out.println("error loading sheet");
      }
    }
    
    public void draw(Graphics g){
      g.drawImage(sprites[currentSprite], xPos, yPos, null);
    }
    
      public void update() { 
    
    if (currentStep>=128) {
      currentStep=0;
      direction="stand";
    }
    
    if(direction.equals("down")) { 
      currentSprite++;
      currentStep++;
      if (currentSprite>=2) {
        currentSprite=0;
      } 
    }
    
    if(direction.equals("left")) { 
      currentSprite++;
      currentStep++;
      if (currentSprite>=5) {
        currentSprite=3;
      } 
    }
    
    if(direction.equals("right")) { 
      currentSprite++;
      currentStep++;
      if (currentSprite>=8) {
        currentSprite=6;
      } 
    }
    
    if(direction.equals("up")) { 
      currentSprite++;
      currentStep++;
      if (currentSprite>=11) {
        currentSprite=9;
      } 
    }
  }
    
   public void move(String movement) { 
    if (currentStep==0 && direction.equals("stand")) { //not moving
      currentStep++;
      direction=movement;
      if(movement.equals("left")) {       
        currentSprite=0;
      } else if(movement.equals("up")) {
        currentSprite=2;
      } else if(movement.equals("right")) {
        currentSprite=5;
      } else if(movement.equals("down")) {
        currentSprite=8;
      }
    }
  }   
      
  }
  
  