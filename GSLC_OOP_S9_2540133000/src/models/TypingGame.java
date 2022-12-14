package models;
import java.io.IOException;
import java.util.Scanner;

import main.Console;

public abstract class TypingGame {
	
	private Scanner scanf = new Scanner(System.in);

	/* Generate target string for the player to guess 
	 * generation based on a set of words group by a common theme
	 * or by specific rules generated by a function
	 * */
	public abstract String generateRandomString();
	
	// Returns the theme of the specific game played by the player
	public abstract String getTheme();

	// Starts the game
	public int start(int passes, int difficulty) {
		// Declare and initialize game variables
		String guess = "";
		String target;
		int time = 0;
		int wins = 0;

		Console.clearScreen();
		System.out.println("Press enter to START");
		scanf.nextLine();

		for (int i = 1; i <= passes; i++) {
			target = generateRandomString();
			
			/* Configure the time to type the word 
			 * based on length of the target string
			 * and difficulty of the game chosen by
			 * the player
			 * */
			switch (difficulty) {
			case 0:
				time = (target.length() * 6) / 8;
				break;
			
			case 1:
				time = (target.length() * 5) / 8;
				break;
			
			case 2:
				time = (target.length() * 4) / 8;
				break;

			default:
				break;
			}
			
			// Main game loop
			while (time != 0) {
				// Captures user input
				try {
					if (System.in.available() > 0) {
						guess = scanf.nextLine();
						// Strips leading and trailing spaces of the input string
						guess = guess.strip();
						// Breaks the game loop once player successfully typed the target string
						if (guess.equals(target)) {
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				Console.clearScreen();
				System.out.printf("Theme: %s\n", getTheme());
				System.out.printf("Round: %d/%d\n", i, passes);
				System.out.printf("Time Left: %03d s\n", time);
				System.out.printf("Type '%s' >> ", target);
				
				// Idle for 1 second to simulate time count down
				try {
					Thread.sleep(1000);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				time--;
			}

			/* Clears the input buffer from delayed input from the player
			 * after the player tries to type the target string after time <= 0
			*/
			try {
				if (time == 0 && System.in.available() > 0) {
					scanf.nextLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// Show the result of the round
			Console.clearScreen();
			
			if (guess.equals(target)) {
				System.out.println("===========================");
				System.out.println("| NICE, YOU GOT IT RIGHT! |");
				System.out.println("===========================");
				wins++;
			} else {
				System.out.println("===============================");
				System.out.println("| TIME'S UP, NICE TRY THOUGH! |");
				System.out.println("===============================");
			}

			System.out.println("\nPress enter to CONTINUE");
			scanf.nextLine();
		}
		
		// Show the amount of rounds the players won
		Console.clearScreen();
		System.out.println("===============================================");
		System.out.printf("| YOU HAVE SUCCESSFULLY TYPED %d out %d WORDS! |\n", wins, passes);
		System.out.println("===============================================");
	
		System.out.println("\nPress enter to CONTINUE");
		scanf.nextLine();
		
		/* Return the number wins out of 
		 * the number of passes to be then 
		 * processed by the player to calculate earned points
		 * */
		return wins;
	}

}
