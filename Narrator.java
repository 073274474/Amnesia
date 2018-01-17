
import java.util.*;
import java.io.*;
import java.io.IOException;



  class Narrator{
    int playerX = 0;
    int playerY = 0;
    int playerXLastInstruction = 0;
    int playerYLastInstruction = 0;
    int controlNum = 50;
    int instructionDirection;
    ArrayList<gem> gemList = new ArrayList<>();
    
    String[] gameDialogue = new String[13];
    String[][] directions = new String[4][3];
    String[] angery = new String[5];
    
    Narrator(){
      this.playerX = playerX;
      this.playerY = playerY;
      textReader();
    }

    public void textReader() throws IOException{
      File dialogue = new File("Dialogue.txt");
      Scanner readFile = new Scanner(dialogue);
      String tempS = "";

      for (int i=0;i<13;i++){
        gameDialogue[i] = readFile.nextLine();
       // System.out.println(gameDialogue[i]);
      }

      for (int i=0;i<4;i++){
        for(int j=0;j<3;j++){
          tempS=readFile.nextLine();
          directions[i][j] = tempS.substring(1);
        }
      }

      for (int i=0;i<4;i++){
        tempS = readFile.nextLine();
        angery[i] = tempS.substring(1);
      } 
    }
    
    
    public setGemList(ArrayList<gem> GL){
      gemList = GL;
    }

    
    public String[] startDialogue(){
      for (int i = 0; i < gameDialogue.length; i ++){
       System.out.println(gameDialogue[i]);
      }
      return gameDialogue;
     
    }
    
    
    public String command(){
      
      gem closestGem;
      closestGem = getClosestGem();
      
      instructionDirection = closestGem.sendAway(playerX,playerY);
      setPlayerLastInstruction(playerX,playerY);
      
      return(directions[instructionDirection][howAngery(controlNum)]);

    }
    
    public boolean getObeyed(){
      
      if (instructionDirection==0&&playerX<playerXLastInstruction){
        return true;
      }else if(instructionDirection==1&&playerX>playerXLastInstruction){
        return true;
      }else if(instructionDirection==2&&playerY>playerYLastInstruction){
        return true;
      }else if(instructionDirection==3&&playerY>playerYLastInstruction){
        return true;
      }else{
        return false;
      }
      
    }
    
    public int getControlNum(){
      return this.controlNum();
    }
  
    public gem getClosestGem(){
        
        gem closestGem = gemList.get(0);
        
        for (int i=1;i<gemList.size();i++){
          if (closestGem.distance(playerX,playerY)>gemList.get(i).distance(playerX,playerY)&&!gemList.get(i).getCollected()){
            closestGem = gemList.get(i);
          }
        }
        
        return closestGem;
        
    }
    
    public void setPlayer(int x, int y, int cN){
      playerX = x;
      playerY = y;
      controlNum = cN;
    }
    
    public void setPlayerLastInstruction(int x, int y){
      playerXLastInstruction = x;
      playerYLastInstruction = y;
    }
    
    public int howAngery(int cN){
      if (cN>40){
        return 0;
      }else if(cN>20){
        return 1;
      }else{
        return 2;
      }
    }
    
  }
  
 
