package main;
import java.util.Scanner;

import models.CivicsTypingGame;
import models.FoodBeverageTypingGame;
import models.Player;
import models.RandomTypingGame;
import models.ScienceTypingGame;
import models.WeaponsTypingGame;

public class Main {

	private Scanner scanf = new Scanner(System.in);
	
	public Main() {
		play();
	}

	public static void main(String[] args) {
		new Main();
	}
	
	public void play() {
		// Initializes all games that are going to be played by the player
		RandomTypingGame game1 = new RandomTypingGame();
		ScienceTypingGame game2 = new ScienceTypingGame();
		CivicsTypingGame game3 = new CivicsTypingGame();
		WeaponsTypingGame game4 = new WeaponsTypingGame();
		FoodBeverageTypingGame game5 = new FoodBeverageTypingGame();
		
		// Game opening message
		System.out.println("Typing Game");
		System.out.println("See how fast you can type these words!\n");
		System.out.print("How do you want to be known as: ");
		
		// Set the player's name and initial points
		Player player = new Player(scanf.nextLine());
		
		int opt = 0;
		while (opt != 6) {
			Console.clearScreen();
			System.out.println("Typing Game");
			System.out.println("See how fast you can type these words!\n");
			System.out.printf("Player: %s\n", player.getName());
			System.out.printf("Rank: %s\n", player.getRank());
			System.out.printf("Points: %d\n\n", player.getPoints());
			System.out.println("Pick a theme:");
			System.out.println("1. Random");
			System.out.println("2. Science");
			System.out.println("3. Civics");
			System.out.println("4. Weapons");
			System.out.println("5. Food & Beverage");
			System.out.println("6. Exit");
			System.out.print(">> ");
			
			try {
				opt = Integer.parseInt(scanf.nextLine());
				
				if (opt == 6) {
					break;
				}
				
				int difficulty = -1;
				
				/*
				 * Difficulty validation for the typing game
				 * Easy = 0
				 * Normal = 1
				 * Hard = 2
				 * 
				 * */
				
				do {
					Console.clearScreen();
					System.out.println("Type '0' for easy difficulty");
					System.out.println("Type '1' for normal difficulty");
					System.out.println("Type '2' for hard difficulty");
					System.out.print("Chooose difficulty: ");
					try {
						difficulty = Integer.parseInt(scanf.nextLine());
					} catch (Exception e2) {
						System.out.println("Input is not a number!");
						e2.printStackTrace();
					}
				} while (difficulty < 0 || difficulty > 2);
				
				// Play the chosen game, and calculate points earned based on the game (by player)
				switch (opt) {
				case 1:
					player.setPoints(player.getPoints() + player.getWinnings(game1.start(5, difficulty), game1));
					break;
					
				case 2:
					player.setPoints(player.getPoints() + player.getWinnings(game2.start(5, difficulty), game2));
					break;
					
				case 3:
					player.setPoints(player.getPoints() + player.getWinnings(game3.start(5, difficulty), game3));
					break;
					
				case 4:
					player.setPoints(player.getPoints() + player.getWinnings(game4.start(5, difficulty), game4));
					break;
					
				case 5:
					player.setPoints(player.getPoints() + player.getWinnings(game5.start(5, difficulty), game5));
					break;
					
				default:
					break;
				}
				
				// Rank up messages
				if (player.getPoints() >= 75) {
					System.out.println("================================");
					System.out.println("|       Congratulations!       |");
					System.out.println("================================");
					System.out.println("| You Rank Up to Intermediate! |");
					System.out.println("================================");
					player.setRank("Intermediate");
				} else if (player.getPoints() >= 150) {
					System.out.println("============================");
					System.out.println("|     Congratulations!     |");
					System.out.println("============================");
					System.out.println("| You Rank Up to Advanced! |");
					System.out.println("============================");
					player.setRank("Advanced");
				} else if (player.getPoints() >= 225) {
					System.out.println("==========================");
					System.out.println("|    Congratulations!    |");
					System.out.println("==========================");
					System.out.println("| You Rank Up to Expert! |");
					System.out.println("==========================");
					player.setRank("Expert");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Console.clearScreen();
		System.out.println("Thanks for playing!");
	}
	
}
