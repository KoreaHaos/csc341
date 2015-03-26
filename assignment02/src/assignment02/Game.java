package assignment02;

import java.io.Console;

// Game reads and writes to the current game state, thus keeping
// track of the current game. This allows the players to stop a
// a game and return to it at a later time.
public class Game {
	
	static Console console = System.console();
	static String response = "";
	
	// Creates a new game
	public static void New() {
		
	}
	
	public void Move(int player, int type) {
		int roll = Dice.Roll();
		
		// find roll type based on lifetime
		
		switch (type) {
		case 1: {
			// If the die throw is 3, 4, 5, or 6, then the change in position is positive
			// otherwise it is negative.
			if ((roll == 1) || (roll == 2))
				roll = -roll;
			
			// die throw + ( position of leading player – player’s position ) / 2
			roll = roll + ((Score.LeadingScore() - Score.Position(player)) / 2);
		}
		case 2: {
			// 3 times the die throw if the die throw is an even number;
			// otherwise the die throw if the die throw is an odd number.
			if (roll % 2 == 0) roll = (roll * 3);
		}
		case 3: {			
			// If the die throw is 1 or 2, then the change in position is positive
			// otherwise it is negative.
			if (!((roll == 1) || (roll == 2)))
				roll = -roll;

			// die throw + (player’s position – position of the trailing player) / 2
			roll = roll + ((Score.LeadingScore() - Score.Position(player)) / 2);
		}
		}
		
		Score.SavePlayerScore(player, roll);
	}
	
	public void Delete() {
		if (ask("Are you sure you would like to delete your game? (y/n): ")) Score.Delete();
		else System.exit(1);
	}

	public static void EndGame() {
		// Displays all scores
		Score.Display();
		
		// Check if you'd like to play a new game
		if (ask("Would you like to play again? (y/n): ")) New();

		// Exits game
		else System.exit(1);
	}
	
	public static boolean ask(String question) {
		System.out.print(question);
		response = console.readLine();
		if (response.equalsIgnoreCase("y")) return true;
		else return false;
	}
}
