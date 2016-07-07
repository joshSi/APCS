import java.awt.Image;

/**
 * The Sprite class controls all images in the game. Variables include:
 * myImage, the image
 * myX and myY, the x and y coordinates of the sprite in the game.
 * 
 * @author Joshua
 *
 */

public class Sprite {

        private Image myImage;
        private int myX;
        private int myY;

        public Sprite(int x, int y) {
        	myX = x;
        	myY = y;
        }

        /**
         * 
         * @param image		the image of the sprite
         * Sets the Sprite to an image
         */
        public void setImage(Image image) {
            myImage = image;
        }

        /**
         * 
         * @return 		the image of the sprite
         */
        public Image getImage() {
            return myImage;
        }
        
        /**
         * 
         * @param x		the x-coordinate to add
         * 
         * moves the sprite's x-coordinates by x
         */
        public void moveX(int x) {
        	myX += x;
        }
        
        /**
         * 
         * @param y		the y-coordinate to add
         * 
         * moves the sprite's y-coordinates by y
         */
        public void moveY(int y) {
        	myY += y;
        }
        /**
         * 
         * @param x		the x-coordinate to set
         * @param y		the y-coordinate to set
         * 
         * Sets the sprite in the coordinates (x,y)
         */
        public void set(int x, int y){
        	myX = x;
        	myY =y;
        }
        
        /**
         * 
         * @return The current x coordinate
         */
        public int getX() {
            return myX;
        }
        
        /**
         * 
         * @return The current y coordinate
         */
        public int getY() {
            return myY;
        }
}