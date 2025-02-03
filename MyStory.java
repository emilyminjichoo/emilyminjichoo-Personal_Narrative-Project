import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

 // Instance Variables
  private String[][] kdramas;
  private ImageFilter[][] filters;
  
  // Constructor
  public MyStory(String[][] kdramas, ImageFilter[][] filters) {
    this.kdramas = kdramas;
    this.filters = filters;
  }
  
  // methods for drawing scene

public void drawScene(){
  //call each part of animation/ filter/ pictures
  drawR1988Scene();
  drawSWScene();
  drawQOTScene();
  drawKTLScene();
}

  //draw the first kdrama: Reply 1988
public void drawR1988Scene(){
  // 1. Clear the scene and draw background
  clear("gold");
  //2. Set any style for text (height)
setTextHeight(30);
  //3. play the sound 
  playSound("reply1988.wav");
  //4. Input the Image using the instance variable (list)
drawText(kdramas[0][0], 30, 35);
  drawImage(filters[0][0], 50, 50, 280);
  //5. Pause to allow viewers to see original and filtered
  pause(4);
  //6. apply the filter by calling from ImageFilter
  filters[0][0].pixelate(10);
  drawImage(filters[0][0], 50, 50, 280);
  //7. pause before moving onto the nextscene
  pause(3);
}

  //draw the second kdrama: Strong Woman Do Bong Soon
  public void drawSWScene(){
     // 1. Clear the scene and draw background
  clear("pink");
  //2. Set any style for text
setTextHeight(30);
  //3. play the sound
    playSound("swdbs.wav");
  //4. Input the Image
drawText(kdramas[0][1], 0, 40);
  drawImage(filters[0][1], 50, 60, 280);
 //5. Pause to allow viewers to see original and filtered
  pause(4);
 //6. apply the filter by calling from ImageFilter
  filters[0][1].colorize();
  drawImage(filters[0][1], 50, 60, 280);
  //7. pause before moving onto the nextscene
  pause(3);
  }

  //draw the third kdrama: Queen of Tears
  public void drawQOTScene(){
     // 1. Clear the scene and draw background
  clear("red");
  //2. Set any style for text
setTextHeight(30);
  //3. play the sound
playSound("qot.wav");
  //4. Input the Image
drawText(kdramas[1][0], 20, 30);
  drawImage(filters[1][0], 60, 40, 250);
  //5. Pause to allow viewers to see original and filtered
  pause(3);
  //6. apply the filter by calling from ImageFilter
  filters[1][0].motionBlur(10, "diagonal");
  drawImage(filters[1][0], 60, 40, 250);
  //7. pause before moving onto the nextscene
  pause(2);
  }

  // draw the last kdrama: King the Land
  public void drawKTLScene(){
     // 1. Clear the scene and draw background
  clear("blue");
  //2. Set any style for text
setTextHeight(30);
 //3. play the sound
playSound("ktl.wav");
  //4. Input the Image
drawText(kdramas[1][1], 40, 40);
  drawImage(filters[1][1], 25, 50, 330);
  //5. Pause to allow viewers to see original and filtered
  pause(2);
  //6. apply the filter by calling from ImageFilter
  filters[1][1].threshold(3);
  drawImage(filters[1][1], 25, 50, 330);
  //7. pause before moving onto the nextscene
  pause(3);
}
}