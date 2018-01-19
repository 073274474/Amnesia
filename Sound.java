import java.io.File; 
import java.util.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


class Sound{
  
  
  static ArrayList<File> sounds = new ArrayList<>();
  static ArrayList<File> music = new ArrayList<>();
  static int controlNum;
  
  //method that plays sounds
  static void playSound(int sound){
    //if statment determines if the user has opted for sound
    try{
      //creates and plays audio clip
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(sounds.get(sound)));
      clip.start();
    }catch(Exception e)
    {
    }
    
  }//end of playSound method

  //Method that plays music
  static void playMusic(Narrator narr){
    //Creates runnable that can run indepentantly of the main program
    Runnable r = new Runnable() {
      //Method that runs seperately
      public void run(){
        
        System.out.println("MUSIC");
        //loads all necessary music files
        loadMusic();
        
        //While loop that keeps the music playing
        while(true){
          
          //loop through checking if controlNum changed
          do{
            
            controlNum=interpretCN(narr.getControlNum());
            try{
              //Creates and plays clip of the game music
              int originalControlNum = controlNum;
              Clip clip = AudioSystem.getClip();
              clip.open(AudioSystem.getAudioInputStream(music.get(1)));
              clip.start();
              
              //Takes music playing time and reruns the music when the music is over
              long startTime = System.currentTimeMillis();
              long endTime = System.currentTimeMillis() + (clip.getMicrosecondLength()/1000);
              while(System.currentTimeMillis() <= endTime){
                
                controlNum = interpretCN(narr.getControlNum());
                System.out.println("CN:"+interpretCN(narr.getControlNum()));
                
                if (controlNum!=originalControlNum){
                  //System.out.println("in: "+controlNum);
                  clip.close();
                  clip.open(AudioSystem.getAudioInputStream(music.get(controlNum)));
                  clip.setMicrosecondPosition((System.currentTimeMillis()-startTime)*1000);
                  clip.start();
                }
                
                originalControlNum = controlNum;
                
              }
              clip.close();
            }catch(Exception e){e.printStackTrace();}
          }while(true);//end of do while
        }//end of while loop
      }//end of run method
    };//end of runnable
    //starts thread
    new Thread(r).start();
  }//end of playMusic method
  
  static int interpretCN(int CN){
    
    if (CN>60){
      return 6;
    }else if(CN>50){
      return 5;
    }else if(CN>40){
      return 4;
    }else if(CN>30){
      return 3;
    }else if(CN>20){
      return 2;
    }else if(CN>10){
      return 1;
    }else{
      return 0;
    }
    
  }
  
  static void loadMusic(){
    for (int i=0; i<7;i++){
      music.add(new File("Amnesia"+i+".wav"));
    }
  }
  
}
