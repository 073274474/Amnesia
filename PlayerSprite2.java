/**
 * january 9, 2018
 * adi gelb
 * basic movement
 * requires map.txt and spriteSheet.png
 * errors: breaks when it hits the edge, only moves one tile at a time, movement is wonky (switch to keyPressed) 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*; 
import java.util.Scanner;
import java.awt.image.*;
import javax.imageio.*;

//This class is used to start the program and manage the windows
class PlayerSprite2 { 
  
  public static void main(String[] args) { 
    GameWindow game= new GameWindow();  
  }
  
}

//This class represents the game window
class GameWindow extends JFrame { 
  
  JPanel main;
  
  //Window constructor
  public GameWindow() { 
    setTitle("player sprite 2");
    this.setUndecorated(true);
    setResizable(true);  // set my window to allow the user to resize it
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // set the window up to end the program when closed
    
    main = new JPanel();
    
    main.add(new GamePanel());
    main.add(new NarrPanel());
    
    this.add(main);
    pack(); //makes the frame fit the contents
    setVisible(true);
    
  }
  
    
    static class NarrPanel extends JPanel{
      
      JTextArea textArea;
      Narrator narr;
      String[] words;
      
      NarrPanel(){
        
        narr = new Narrator();
        
        Sound.playMusic(narr);
        
        textArea = new JTextArea();
        words = narr.startDialogue();
        for (int i = 0; i < words.length; i++){
          textArea.append(words[i]);
          System.out.println(words[i]);
        }
        
        this.add(textArea);
        
      }
      
    }
    
    
// An inner class representing the panel on which the game takes place
    static class GamePanel extends JPanel implements KeyListener{ 
      
      Map map;  
      Player player;
      int size;
      Crystal crystal;
      
      //constructor
      public GamePanel() { 
        size = 500;
        setPreferredSize(new Dimension(size,size));
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        player = new Player();
        map = new Map(1024,768, player);
        
        
        
      }
      
      
      public void paintComponent(Graphics g) { 
        super.paintComponent(g); //required to ensure the panel si correctly redrawn
        //update the content
        player.update();
        //draw the screen
        map.draw(g);
        // crystal.draw(g, 72, 72);
        player.draw(g);
        repaint();
      }
      
      
      public void keyTyped(KeyEvent e) {      
      }
      
      public void keyPressed(KeyEvent e) {
        if (player.direction.equals("stand")){
          if(e.getKeyChar() == 'a' ){   //Good time to use a Switch statement
            player.move("left");
            if (map.checkMoveA(map.playerX, map.playerY) == true){
              map.playerX--;
            }
          } else if(e.getKeyChar() == 's' ){
            System.out.println("down");
            player.move("down");
            if (map.checkMoveS(map.playerX, map.playerY) == true){
              map.playerY++;
            }
          } else if(e.getKeyChar() == 'd' ){
            System.out.println("right");
            player.move("right");
            if (map.checkMoveD(map.playerX, map.playerY) == true){
              map.playerX++;
            }
          } else if(e.getKeyChar() == 'w' ){
            System.out.println("up");
            player.move("up");
            if (map.checkMoveW(map.playerX, map.playerY) == true){
              map.playerY--;
            }
          }  
        }
      }
      
      public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() =='a'){
          // System.out.println("stop");
        }else if (e.getKeyChar() == 's'){
          // System.out.println("stop");
        }else if (e.getKeyChar() =='d'){
          // System.out.println("stop");
        }else if (e.getKeyChar() =='w'){
          // System.out.println("stop");
        }
      }  
    }
  }
  
  class Map {
    boolean debug = true;
    
    int mapHeight;
    int mapWidth;
    int visibleWidth;
    int visibleHeight;
    
    Player player;
    int playerX, playerY;  //assigns player's place on map, not on screen
    int map[][] = loadMapData("map.txt");
    int boxWidth, boxHeight;
    Tile worldMap[][];
    
    public Map(int xResolution,int yResolution, Player player) { 
      visibleWidth=10; //The size of the visible portion of the map
      visibleHeight=10;  
      
      this.player = player;
      playerX = map[1].length/2;
      playerY = map.length/2;
      
      boxWidth = 50;
      boxHeight = 50;
      createWorldMap();
      
    }
    
    public boolean checkMoveA(int playerX, int playerY){
      if (((worldMap[playerY][playerX-1].colour).toString()).equals("java.awt.Color[r=0,g=0,b=0]")){
        return false;
      }
      return true;
    }
    public boolean checkMoveS(int playerX, int playerY){
      if (((worldMap[playerY+1][playerX].colour).toString()).equals("java.awt.Color[r=0,g=0,b=0]")){
        return false;
      }
      return true;
    }
    public boolean checkMoveD(int playerX, int playerY){
      if (((worldMap[playerY][playerX+1].colour).toString()).equals("java.awt.Color[r=0,g=0,b=0]")){
        return false;
      }
      return true;
    }
    public boolean checkMoveW(int playerX, int playerY){
      if (((worldMap[playerY-1][playerX].colour).toString()).equals("java.awt.Color[r=0,g=0,b=0]")){
        return false;
      }
      return true;
    }
    
    
    
    public void createWorldMap(){
      worldMap = new Tile[map.length][map[1].length];
      if (debug == false){
        System.out.println("worldmap length: " + worldMap.length);
        System.out.println("worldmap1 length: " + worldMap[1].length);
      }
      for (int j = 0; j < map.length; j++){
        for (int i = 0; i < map[1].length; i++){
          if (map[j][i]==0){
            worldMap[j][i]=new Tile(Color.BLUE,(i-1)*boxWidth, (j-1)*boxHeight,boxWidth,boxHeight);
          }else if (map[j][i]==1){
            worldMap[j][i]=new Tile(Color.BLACK,(i-1)*boxWidth, (j-1)*boxHeight,boxWidth,boxHeight);
          }else if (map[j][i]==2) {
            worldMap[j][i]=new Tile(Color.BLACK,(i-1)*boxWidth, (j-1)*boxHeight,boxWidth,boxHeight);
          }
        }
      }
    }
    
    
    public int[][] loadMapData(String filename) { 
      int data[][]=null;
      try {                                      
        File f = new File(filename);
        Scanner input = new Scanner(f);
        mapHeight = input.nextInt();
        mapWidth = input.nextInt();
        data = new int[mapHeight][mapWidth]; // first two line are map size
        
        for (int j=0;j<data.length;j++){
          for (int i=0;i<data[0].length;i++)   {    
            data[j][i]=input.nextInt();
          }
        }
        input.close();    
      } catch(Exception E){};
      return data;
    }
    
    public void draw(Graphics g) {
      int drawY, drawX;
      
      for (int j = 0; j < visibleHeight; j++){
        drawY = playerY-visibleHeight/2+j;
        for (int i = 0; i < visibleWidth; i++){
          drawX = playerX-visibleWidth/2+i;
          worldMap[drawY][drawX].draw(g, j, i); 
          
        }
      }
    }
  }
  
  class Tile {
    int xPosMap, yPosMap;
    int width, height;
    Color colour;
    
    public Tile(Color c, int x, int y, int w, int h){
      colour = c;
      xPosMap = x;
      yPosMap = y;
      width = w;
      height = h;
    }
    
    public void draw(Graphics g, int yScreen, int xScreen){
      g.setColor(colour);
      g.fillRect((xScreen)*width, (yScreen)*height, width-1, height-1);
    }
  }

