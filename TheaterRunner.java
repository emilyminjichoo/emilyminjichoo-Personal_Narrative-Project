import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    /*
    *create the lists that are used for the argument for MyStory
    *kdrama has the list of the kdramas (used for text in MyStory)
    *filtersList has 
      */
 String[][] kdramaList = {
      {"Reply 1988", "Strong Woman Do Bong Soon"},
      {"Queen of Tears", "King the Land"},
    };

ImageFilter[][] filtersList = {
      { new ImageFilter("reply1988.jpg"), new ImageFilter("strongwomandobongsoon.jpg") },
      { new ImageFilter("queenoftears.jpg"), new ImageFilter("kingtheland.jpg") },
    };

// MyStory object
   MyStory kdrama = new MyStory(kdramaList, filtersList);

    // draw the Scene using the drawScene method
    kdrama.drawScene();
    Theater.playScenes(kdrama);
    
    
  }
}