import org.code.theater.*;
import org.code.media.*;
/*
 * Represents a blurred image
 */
public class ImageFilter extends ImagePlus {

  /*
   * Calls the superclass constructor to initialize pixels
   */
  public ImageFilter(String filename) {
    super(filename);
  }

  /*
   * Applies a pixel filter to the image
   */
public void pixelate(int gridSize) {
// get access to the pixels using ImagePlus
  Pixel[][] pixels = getImagePixels();
  //traverse through the pixels (by gridsize)
    for (int row = 0; row < pixels.length; row += gridSize) {
      for (int col = 0; col < pixels[0].length; col += gridSize) {
        //variables to store colors (avg) and the end row/ column
        int endRow = Math.min(row + gridSize, pixels.length);
        int endCol = Math.min(col + gridSize, pixels[0].length);
        int avgRed = 0;
        int avgGreen = 0;
        int avgBlue = 0;
/*
*traversing through the region row/ col to get the average 
* cant use pixels outside of region (which is within the area inside of end row/col)
*/
        for (int regionRow = row; regionRow < endRow; regionRow++) {
          for (int regionCol = col; regionCol < endCol; regionCol++) {
            avgRed += pixels[regionRow][regionCol].getRed();
            avgGreen += pixels[regionRow][regionCol].getGreen();
            avgBlue += pixels[regionRow][regionCol].getBlue();
          }
        }

        int totalPixelsInRegion = (endRow - row) * (endCol - col);
        //actually getting the avg
        avgRed /= totalPixelsInRegion;
        avgGreen /= totalPixelsInRegion;
        avgBlue /= totalPixelsInRegion;
//traversing to change the data and setting the colors to the average in region
        for (int regionRow = row; regionRow < endRow; regionRow++) {
          for (int regionCol = col; regionCol < endCol; regionCol++) {
            pixels[regionRow][regionCol].setRed(avgRed);
            pixels[regionRow][regionCol].setGreen(avgGreen);
            pixels[regionRow][regionCol].setBlue(avgBlue);
          }
        }
      }
    }
  }

  /*
   * Applies a colorize filter by converting each Pixel to grayscale and applying
   * a color to it based on its grayscale value
   */
  public void colorize() {
    // get access to the pixels using ImagePlus
    Pixel[][] pixels = getImagePixels();
//traverse through pixels
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
        int grayValue = currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue();
        grayValue /= 3;
// depending on the color (due to scale) color will change to a different color using nummbers
        if (grayValue < 85) {
          currentPixel.setRed(255);
          currentPixel.setGreen(0);
          currentPixel.setBlue(0);
        }
        else if (grayValue < 170) {
          currentPixel.setRed(0);
          currentPixel.setGreen(255);
          currentPixel.setBlue(0);
        }
        else {
          currentPixel.setRed(0);
          currentPixel.setGreen(0);
          currentPixel.setBlue(255);
        }
      }
    }

    
  }
  /*
   * Applies a motion blur to the image
   */
  public void motionBlur(int length, String direction) {

    // Create a pixel 2D array that uses accessor method in ImagePlus
 Pixel[][] pixels = getPixelsFromImage();

    // Traverses through the pixels
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
    int reds =0;
    int blues =0;
    int greens=0;
        
    int count =0;
    int x = col;
    int y = row;
        
        //getting the color of the pixels in the image
        while ((count < length) &&(x<pixels[0].length)&&(y<pixels.length)){
        Pixel currentPixel = pixels[y][x];
reds += currentPixel.getRed();
blues += currentPixel.getBlue();
greens += currentPixel.getGreen();
          count++;

       /* 
      *depending on the argument for direction, 
      *the image will blur in a certain direction
      */
          
        if (direction.equals("horizontal")){
          x++;
        } else if (direction.equals("vertical")){
          y++;
        }else{
          x++;
          y++;
        }
      }
//setting it to the average
int avgRed = reds/count;
int avgGreen = greens/count;
int avgBlue = blues/count;

        //actually changing the color of the pixels in image
        Pixel currentPixel = pixels[row][col];
        currentPixel.setRed(avgRed);
        currentPixel.setGreen(avgGreen);
        currentPixel.setBlue(avgBlue);
      }
    }
    
  }

  /*
   * Applies a threshold filter to the image
   */
 
  public void threshold(int value) {
 // get access to the pixels using ImagePlus
 Pixel[][] pixels = getPixelsFromImage();
    int average = 0;
//traverse through the pixels
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

//adding all the pixels (colors) together and diving them by 3
// dividing by 3 because 3 colors
        average = (int) (currentPixel.getRed() +currentPixel.getGreen() +currentPixel.getBlue())/3;
//depending on the value and average (compare), the image will turn pixels into black/ white
        if (average < value){
          currentPixel.setColor(Color.BLACK);
        } else{
          currentPixel.setColor(Color.WHITE);
        }
        
             
      }
    }
}
}