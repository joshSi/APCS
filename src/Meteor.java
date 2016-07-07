
/**
 *  This Meteor class contains all the properties of a meteor.
 * 
 * @author Joshua and Nathon
 * 
 */
import javax.swing.ImageIcon;

public class Meteor extends Sprite {

	/**
	 * The constructor sets the location, speed, and size of the meteor.
	 * 
	 * @param int
	 *            x this is the starting location of the meteor on the x axis
	 * @param int
	 *            y this is the starting location of the meteor on the y axis
	 * @param String
	 *            png the file name of the meteor image as a String, for example
	 *            "meteor.png" NOTE: The string MUST be in the bin folder.
	 */
	public Meteor(int x, int y, String png) {
		// Super constructor from Sprite class that determines location in x & y
		// coordinates
		super(x, y);

		// Sets the Image by creating a temporary ImageIcon class from the png
		// parameter.
		ImageIcon ii = new ImageIcon(this.getClass().getResource(png));
		setImage(ii.getImage());
	}

	/**
	 * This method sets the location of the meteor.
	 * 
	 * @param x
	 *            this is the location of the meteor on the x axis.
	 * @param y
	 *            this is the location of the meteor on the y axis.
	 */
	public void move(int x, int y) {
		set(x, y);
	}

	/**
	 * This method resets the meteor's coordinates, making an illusion of a new
	 * meteor.
	 */
	public void reset() {
		// a is a random x coordinate for the meteor to reset at.
		int a = (int) (Math.random() * 550);
		// sets the meteor above the screen. The y-coordinate is at -5 so that
		// the meteor is above the screen and not seen. The extra random 20
		// makes the meteors come at a random "time", so it is not obvious that
		// it is the same meteor(s) going down predictably.
		set(a, -5 - (int) (Math.random() * 20));
	}
}