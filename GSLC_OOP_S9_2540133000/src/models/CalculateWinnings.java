package models;

/* An interface for classes that are 
 * able to calculate earned points based on the game
 * the class played
 * */
public interface CalculateWinnings {
	
	public int getWinnings(int wins, TypingGame game);
	
}
