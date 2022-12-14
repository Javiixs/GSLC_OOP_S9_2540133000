package models;

public class Player implements CalculateWinnings {
	private String name;
	private String rank = "Beginner";
	private int points = 0;
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int money) {
		this.points = money;
	}
	
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public int getWinnings(int wins, TypingGame game) {
		if (game instanceof RandomTypingGame) {
			return wins * 7;
		} else if (game instanceof ScienceTypingGame || game instanceof CivicsTypingGame) {
			return wins * 3;
		} else if (game instanceof FoodBeverageTypingGame) {
			return wins * 2;
		} else {
			return wins * 1;
		}
	}

}
