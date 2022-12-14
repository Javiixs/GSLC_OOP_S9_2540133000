package models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/* Typing Game with the theme of Food and Beverages
 * contains words used in the domain of Food and Beverages
 * */
public class FoodBeverageTypingGame extends TypingGame {

	public FoodBeverageTypingGame() {
		
	}
	
	@Override
	public String getTheme() {
		return "Food and Beverage";
	}
	
	// Generated based on a word list text file
	@Override
	public String generateRandomString() {
		Random randomizer = new Random();
		String[] words = {};
		try {
			BufferedReader reader = new BufferedReader(new FileReader("food_beverage.txt"));
			words = reader.readLine().split(",");
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words[randomizer.nextInt(words.length)];
	}

}
