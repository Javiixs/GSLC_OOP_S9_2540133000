package main;

public class Console {

	/* Console utility function to offset the console
	 * creating the illusion of a cleared console screen
	 * */
	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

}
