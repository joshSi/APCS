
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 * This is the Player class, which contains the spaceship image and contains the
 * user interface methods using key listener.
 * 
 * @author Joshua and Nathon
 * 
 */

public class Player extends Sprite {
	// The movement speed of the spaceship
	private final int speed = 25;
	// Declaring the right key value
	private boolean right_pressed = false;
	// Declaring the left key value
	private boolean left_pressed = false;
	// Declaring the up key value
	private boolean up_pressed = false;
	// Declaring the down key value
	private boolean down_pressed = false;

	/**
	 * This is the constructor for the player class that has the image and
	 * coordinates of the the spaceship.
	 *
	 **/
	public Player(int x, int y, String png) {

		super(x, y);
		// Setting the image for the spaceship
		ImageIcon ii = new ImageIcon(this.getClass().getResource(png));
		setImage(ii.getImage());
	}

	/**
	 * Method to move the player, set the x and y coordinates
	 * 
	 * @param int
	 *            x coordinate X position
	 * @param int
	 *            y coordinate Y position
	 * 
	 */
	public void move(int x, int y) {
		//If the spaceship is within the boundaries of the screen
		if (x < 525 && x > 5) {
			if (y < 525 && y > 5)
				set(x, y);
			else
				set(x, getY());
		}
	}

	/**
	 * Key listener method is called when key is pressed (ASWD) moves player in
	 * direction of the key(s) pressed
	 * 
	 * @param e
	 *            the key pressed event
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		// the right key has been pressed
		if (key == KeyEvent.VK_D) {
			right_pressed = true;
		}
		// the left key has been pressed
		if (key == KeyEvent.VK_A) {
			left_pressed = true;
		}
		// the down key has been pressed
		if (key == KeyEvent.VK_S) {
			down_pressed = true;
		}
		// the up key has been pressed
		if (key == KeyEvent.VK_W) {
			up_pressed = true;
		}
		// the spaceship will move diagonally depending on whether up or down is
		// pressed
		// while holding the left key
		if (left_pressed) {
			if (down_pressed)
				move(getX() - speed, getY() + speed);
			else if (up_pressed)
				move(getX() - speed, getY() - speed);
			else
				move(getX() - speed, getY());
		}
		// the spaceship will move diagonally depending on whether up or down is
		// pressed
		// while holding the right key
		else if (right_pressed) {
			if (down_pressed)
				move(getX() + speed, getY() + speed);
			else if (up_pressed)
				move(getX() + speed, getY() - speed);
			else
				move(getX() + speed, getY());
		}
		// the spaceship moves down
		else if (down_pressed)
			move(getX(), getY() + speed);
		// the spaceship moves up
		else if (up_pressed)
			move(getX(), getY() - speed);
	}

	/**
	 * This method controls the actions that happen if a certain key is
	 * released.
	 *
	 * @param e
	 *            the key that has been released
	 *
	 **/
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		// the right key has been released
		if (key == KeyEvent.VK_D) {
			right_pressed = false;
		}
		// the left key has been released
		if (key == KeyEvent.VK_A) {
			left_pressed = false;
		}
		// the down key has been released
		if (key == KeyEvent.VK_S) {
			down_pressed = false;
		}
		// the up key has been released
		if (key == KeyEvent.VK_W) {
			up_pressed = false;
		}
	}
}
