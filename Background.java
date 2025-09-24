import java.awt.Color;
import java.awt.Point;

/**background of the game, all variable and functions are static (can access without create object)*/
public class Background {
    public static final int ARRAY_WIDTH = 40;
    public static final int ARRAY_HEIGHT = 30;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    public static final int ZOOM_RATIO = 20;

    /**
     * get the Color object by input x-axis and y-axis
     * @param xAxis the pixel x-axis position
     * @param yAxis the pixel y-axis position
     * @param pictureNum the picture No. (0 or 1)
     * @return the Color object that from "java.awt.Color"
    */
    public static Color get(int xAxis, int yAxis, int pictureNum) {
        xAxis /= ZOOM_RATIO;
        yAxis /= ZOOM_RATIO;
        return colorPixels[pictureNum][xAxis][yAxis];
    }

    /**
     * get the Color object by input x-axis and y-axis
     * @param xyAxis the pixel x-axis and y-axis position as {x,y}
     * @param pictureNum the picture No. (0 or 1)
     * @return the Color object that from "java.awt.Color"
     */
    public static Color get(final int[] xyAxis, int pictureNum) {
        int xAxis = xyAxis[0] / ZOOM_RATIO;
        int yAxis = xyAxis[1] / ZOOM_RATIO;
        return colorPixels[pictureNum][xAxis][yAxis];
    }

    /**
     * get the Color object by input x-axis and y-axis
     * @param xyAxis the pixel x-axis and y-axis position as Point object that from "java.awt.Point"
     * @param pictureNum the picture No. (0 or 1)
     * @return the Color object that from "java.awt.Color"
     */
    public static Color get(final Point xyAxis, int pictureNum) {
        int xAxis = xyAxis.x / ZOOM_RATIO;
        int yAxis = xyAxis.y / ZOOM_RATIO;
        return colorPixels[pictureNum][xAxis][yAxis];
    }

    /**
     * get whole array of the color of all x-axis and y-axis.
     * @param pictureNum the picture No. (0 or 1)
     * @return the return array is like that: returnArray[x-axis(start from 0)][y-axis(start from 0)] = Color
     * @implNote the store array in this class is 40*30 2D array, the return array is 800*600 2D array
     */
    public static Color[][] getWholeArray(int pictureNum) {
        Color[][] returnArray = new Color[WINDOW_WIDTH][WINDOW_HEIGHT];
        for (int x = 0; x < WINDOW_WIDTH; x++) {
            for (int y = 0; y < WINDOW_HEIGHT; y++) {
                returnArray[x][y] = colorPixels[pictureNum][x/ZOOM_RATIO][y/ZOOM_RATIO];
            }
        }
        return returnArray;
    }

    //[background No.][x][y] initizar size: [2][ARRAY_WIDTH][ARRAY_HEIGHT]
    public static final Color[][][] colorPixels = 
    //No.1
    {{{new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(136,255,133),new Color(136,255,133),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(136,255,133),new Color(136,255,133),new Color(136,255,133),
    new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(136,255,133),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(136,255,133),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(136,255,133),new Color(136,255,133),new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(136,255,133),new Color(136,255,133),new Color(136,255,133),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(136,255,133),new Color(136,255,133),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(136,255,133),new Color(136,255,133),new Color(136,255,133),new Color(136,255,133),
    new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(136,255,133),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(136,255,133),
    new Color(136,255,133),new Color(136,255,133),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(136,255,133),new Color(136,255,133),
    new Color(136,255,133),new Color(136,255,133),new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(136,255,133),new Color(136,255,133),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(136,255,133),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    }},
    //No.2
    {{new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(136,255,133),new Color(136,255,133),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(136,255,133),new Color(136,255,133),new Color(136,255,133),
    new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(136,255,133),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(136,255,133),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(136,255,133),new Color(136,255,133),new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(136,255,133),new Color(136,255,133),new Color(136,255,133),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(180,86,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(180,86,0),new Color(255,196,143),
    new Color(255,196,143),new Color(255,196,143),new Color(255,196,143),new Color(255,196,143),new Color(255,196,143),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(180,86,0),new Color(255,196,143),new Color(255,196,143),
    new Color(255,196,143),new Color(255,196,143),new Color(255,196,143),new Color(180,86,0),new Color(180,86,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(180,86,0),new Color(255,196,143),new Color(255,196,143),new Color(179,246,255),
    new Color(255,196,143),new Color(221,251,255),new Color(255,196,143),new Color(255,196,143),new Color(255,196,143),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(180,86,0),new Color(255,196,143),new Color(255,196,143),
    new Color(255,196,143),new Color(221,251,255),new Color(179,246,255),new Color(179,246,255),new Color(255,196,143),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(180,86,0),new Color(255,196,143),
    new Color(255,196,143),new Color(255,196,143),new Color(255,196,143),new Color(255,196,143),new Color(255,196,143),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(180,86,0),
    new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(136,255,133),
    new Color(136,255,133),new Color(136,255,133),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(136,255,133),new Color(136,255,133),
    new Color(136,255,133),new Color(136,255,133),new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(180,86,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(136,255,133),new Color(136,255,133),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(136,255,133),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    },{new Color(0,176,240),new Color(0,176,240),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(255,255,255),new Color(0,176,240),new Color(0,176,240),
    new Color(0,176,240),new Color(0,176,240),new Color(0,176,240),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),
    new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(5,192,0),new Color(170,255,163),new Color(170,255,163),new Color(5,192,0),new Color(5,192,0)
    }}};
}
