package models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/* Typing Game with the theme of Civics
 * contains words used in the domain of civics
 * */
public class CivicsTypingGame extends TypingGame {

	public CivicsTypingGame() {
		
	}
	
	@Override
	public String getTheme() {
		return "Civics";
	}
	
	// Generated based on a word list text file
	@Override
	public String generateRandomString() {
		Random randomizer = new Random();
		String[] words = {};
		try {
			BufferedReader reader = new BufferedReader(new FileReader("civics.txt"));
			words = reader.readLine().split(",");
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words[randomizer.nextInt(words.length)];
	}
	
}
