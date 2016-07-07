import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.*;

/**
 * @author Joshua and Nathon
 *
 *         This class saves the highest score in the game for other players to
 *         try to   beat.
 *
 */
public class Highscore {
	/**
	 * This method creates the text file for the scores to be saved and displays
	 * the info within the file.
	 * 
	 * @param score
	 *            the player's score
	 * @return the highscore
	 **/
	public static int replaceHighscore(int score) {
		int highscore = score;
		
		try {
			File file = new File("highscore.txt");
			Scanner sc = new Scanner(new BufferedReader(new FileReader(file))); 
			 
			while (sc.hasNextLine()) {
				int current = Integer.parseInt(sc.nextLine());
				if (score < current) {
					highscore = current;
					break;
			    }
			}
		
			sc.close();
			if(highscore == score){
				System.out.print(highscore);
				FileWriter fileWriter = new FileWriter(file);
				BufferedWriter bufferedWriter =
						new BufferedWriter(fileWriter);
				bufferedWriter.write(Integer.toString(highscore));
				fileWriter.flush();
				bufferedWriter.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return highscore;
	}

	/**
	 * This main method runs the replaceHighscore method and changes as a new
	 * highscore is reached.
	 **/
	public static void main(String[] args) {
		replaceHighscore(16);

	}

}