package models;
import java.util.Random;

/* Typing Game with the theme of Random
 * Does not contain the words of any domain
 * */
public class RandomTypingGame extends TypingGame {

	public RandomTypingGame() {
		
	}
	
	@Override
	public String getTheme() {
		return "Random";
	}
	
	@Override
	public String generateRandomString() {
		Random randomizer = new Random();
		String alphanumericLetters = "abcdefghijklmnopqrstuvwyxz0123456789";
		StringBuilder toReturn = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			toReturn.append(alphanumericLetters.charAt(randomizer.nextInt(alphanumericLetters.length())));
			toReturn.setCharAt(i, randomizer.nextInt(2) == 0 ? toReturn.charAt(i) : Character.toUpperCase(toReturn.charAt(i)));
		}
	    return toReturn.toString();
	}

}
