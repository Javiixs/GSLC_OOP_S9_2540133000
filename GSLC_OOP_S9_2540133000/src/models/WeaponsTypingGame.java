package models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/* Typing Game with the theme of Human Weapons
 * contains words used in the domain of Human Weapons
 * */
public class WeaponsTypingGame extends TypingGame {

	@Override
	public String getTheme() {
		return "Weapons";
	}
	
	// Generated based on a word list text file
	@Override
	public String generateRandomString() {
		Random randomizer = new Random();
		String[] words = {};
		try {
			BufferedReader reader = new BufferedReader(new FileReader("weapons.txt"));
			words = reader.readLine().split(",");
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words[randomizer.nextInt(words.length)];
	}

}
