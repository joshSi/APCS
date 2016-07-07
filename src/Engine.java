import java.awt.*;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.awt.event.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.*;

/**
 * The Engine class
 * 
 * @author Joshua and Nathon
 *
 */
public class Engine extends JFrame implements Runnable {

	private Meteor meteor;
	private Meteor meteor2;
	private Meteor meteor3;
	private Meteor meteor4;
	private Meteor meteor5;
	private Player player;
	private int score;

	/**
	 * This constructor creates the image for the meteor and sets the overall
	 * layout of the meteor.
	 */

	public Engine() {
		addKeyListener(new KeyHandler());
		JPanel panel = new JPanel();
		// Sets the background as black
		panel.setBackground(Color.black);

		Container c = getContentPane();
		c.add(panel, BorderLayout.CENTER);

		init();
	}

	/**
	 * Method to paint the meteor and player
	 * 
	 * @param g
	 *            Graphics class used to paint the GUI
	 */

	public void paint(Graphics g) {
		// Draws everything with the paint class from JFrame
		super.paint(g);
		g.drawImage(meteor.getImage(), meteor.getX(), meteor.getY(), this);
		g.drawImage(meteor2.getImage(), meteor2.getX(), meteor2.getY(), this);
		g.drawImage(meteor3.getImage(), meteor3.getX(), meteor3.getY(), this);
		g.drawImage(meteor4.getImage(), meteor4.getX(), meteor4.getY(), this);
		g.drawImage(meteor5.getImage(), meteor5.getX(), meteor5.getY(), this);
		g.drawImage(player.getImage(), player.getX(), player.getY(), this);
		g.dispose();
	}

	/**
	 * Method to initialize the components of the game, including meteors and
	 * player. There are always 5 meteors in the game, but in the beginning,
	 * they are hidden above the screen. NOTE: There are no try-exception
	 * blocks, so if the png files are not there, java will not report an error.
	 * All pictures must be in the bin folder to run normally.
	 */
	public void init() {
		// All 5 meteors are already created, but their y-coordinates are -5, so
		// they are hidden above the screen.
		meteor = new Meteor(250, -5, "meteor.png");
		meteor2 = new Meteor(250, -5, "meteor.png");
		meteor3 = new Meteor(250, -5, "meteorite.png");
		meteor4 = new Meteor(250, -5, "meteor.png");
		meteor5 = new Meteor(250, -5, "meteorite.png");
		player = new Player(250, 400, "player.png");
	}

	/**
	 * Method to run the game Engine A set of meteors move across the Space
	 * (frame) in a random direction and reset back every time they move outside
	 * of the space dimension The run terminates when the player's space ship
	 * crashes with any of the meteors. A collision occurs if a player position
	 * is within the fixed range of a meteor
	 */

	public void run() {
		// Plays background music in a try/catch block
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("back.wav"));
			clip.open(inputStream);
			// loops the music
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		// Sets the size of meteors for collisions
		int size = 20;
		// Sets the initial directions of the 5 meteors by setting their change
		// in x for every iteration
		// int x, x1, x2, x3, x4, and x5 are the change in x during the move
		int x = (int) (2 - Math.random() * 5);
		int x2 = (int) (2 - Math.random() * 5);
		int x3 = (int) (2 - Math.random() * 5);
		int x4 = (int) (2 - Math.random() * 5);
		int x5 = (int) (2 - Math.random() * 5);
		repaint();
		Graphics g = this.getGraphics();
		// Sets the font options for displaying score
		g.setColor(Color.white);
		g.setFont(new Font("Norman", Font.BOLD, 15));
		// The while loop that makes the game keep running until the player
		// "collides" with a meteor (aka when the player's distance from the
		// meteor is less than the meteor size)
		while (!(Math.abs(player.getX() - meteor.getX()) < size && Math.abs(player.getY() - meteor.getY()) < size)
				&& !(Math.abs(player.getX() - meteor2.getX()) < size && Math.abs(player.getY() - meteor2.getY()) < size)
				&& !(Math.abs(player.getX() - meteor3.getX()) < size && Math.abs(player.getY() - meteor3.getY()) < size)
				&& !(Math.abs(player.getX() - meteor4.getX()) < size && Math.abs(player.getY() - meteor4.getY()) < size)
				&& !(Math.abs(player.getX() - meteor5.getX()) < size
						&& Math.abs(player.getY() - meteor5.getY()) < size)) {
			// Repaints the GUI, refreshing the screen
			repaint();
			// The score increases every iteration the player survives
			score++;
			g.drawString("SCORE:  " + score, 440, 50);
			int spd = (int) (3 + score / 200);
			// Makes the thread sleep to slow down the process, otherwise the
			// game would be too fast for anyone to play.
			try {
				Thread.sleep(12);
			} catch (InterruptedException e) {
				System.out.println("The game has stopped");
			}

			if (meteor.getY() < this.getHeight() && meteor.getX() < getWidth() && meteor.getX() > 0) {
				meteor.move(meteor.getX() + x, meteor.getY() + spd);
			} else {
				meteor.reset();
				// Changes direction of meteor 1
				x = (int) (2 - Math.random() * 5);
			}

			// Once the score is
			if (score > 1000) {
				if (meteor2.getY() < this.getHeight() && meteor2.getX() < getWidth() && meteor2.getX() > 0) {
					meteor2.move(meteor2.getX() + x2, meteor2.getY() + spd);
				} else {
					meteor2.reset();
					// Changes direction of meteor2
					x2 = (int) (2 - Math.random() * 5);
				}
				if (meteor3.getY() < this.getHeight() && meteor3.getX() < getWidth() && meteor3.getX() > 0) {
					meteor3.move(meteor3.getX() + x3, meteor3.getY() + spd);
				} else {
					meteor3.reset();
					// Changes direction of meteor 3
					x3 = (int) (2 - Math.random() * 5);
				}

				if (score > 2000) {
					if (meteor4.getY() < this.getHeight() && meteor4.getX() < getWidth() && meteor4.getX() > 0) {
						meteor4.move(meteor4.getX() + x4, meteor4.getY() + spd);
					} else {
						meteor4.reset();
						// Changes direction of meteor 4
						x4 = (int) (2 - Math.random() * 5);
					}
					if (meteor5.getY() < this.getHeight() && meteor5.getX() < getWidth() && meteor5.getX() > 0) {
						meteor5.move(meteor5.getX() + x5, meteor5.getY() + spd);
					} else {
						meteor5.reset();
						// Changes direction of meteor 5
						x5 = (int) (2 - Math.random() * 5);
					}
				}
			}
		}
		// End of while loop: Anything after this happens after the player dies
		repaint();
		// Plays screaming sound when player dies
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("scream.wav"));
			clip.open(inputStream);
			clip.start();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		//Prints score and "Game Over" to the screen
		g.setFont(new Font("Norman", Font.BOLD, 20));
		g.drawString("SCORE: " + score, 220, 200);
		g.drawString("GAME OVER", 220, 230);
		g.drawString("HIGH SCORE: " + Highscore.replaceHighscore(score), 200, 300);
	}

	/**
	 * This class extends KeyAdapter for handling the Key events for Player
	 */
	private class KeyHandler extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);

		}

		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);

		}
	}
}