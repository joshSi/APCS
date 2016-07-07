import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Space contains the main method, creating an engine and runnable threads of
 * the game.
 * 
 * @author Joshua and Nathon
 *
 */
public class Space extends JFrame {

	/**
	 * This main method runs the game.
	 */
	public static void main(String[] args) {		
		// Creates an engine, which creates the game window through JFrame.
		Engine myspace = new Engine();
		myspace.setSize(550, 550);
		myspace.setVisible(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		myspace.setLocation(dim.width/2-myspace.getSize().width/2, dim.height/2-myspace.getSize().height/2);
		
		// A thread is used to run the game with the interface Runnable.
		Thread fly = new Thread((Runnable) myspace);
		fly.start();

		// Makes the default close operation to exit. Without this, the program
		// would run in the background even after it is closed, continually
		// playing the background music and also taking up computing power.
		myspace.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}