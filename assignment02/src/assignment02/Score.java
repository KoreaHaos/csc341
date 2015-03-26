package assignment02;

import java.io.Console;
import com.google.gson;

// Score reads and writes to the current game state, thus keeping
// track of the current game. This allows the players to stop a
// a game and return to it at a later time.
public class Score {
	
	static ScoreCard scoreCard = new ScoreCard();
	static int totalPlayers = 0;
	public static int currentLeaderScore = 0;
	static String currentGameFile = "/Users/henrysnopek/school/csc341/assignments/assignment02/src/assignment02/currentGame.json";
	
	
	
	// Creates new game
	public void New() {
		Delete();
		Setup();
	}
	
	// Sets up new score card
	private void Setup() {
		Console console = System.console();
		
		// Asks for player amount
		System.out.print("How many players? ");
		totalPlayers = Integer.parseInt(console.readLine());

		// create player spots
		for (int i = 0; i < totalPlayers; i++) {
			
		}
		
		// Asks for score to play to
		System.out.print("What would you like to play up to? ");
		scoreCard.scoreLimit = Integer.parseInt(console.readLine());
		
	}
	
	// Saves player's latest score; Players score is the last roll
	public static void SavePlayerScore(int player, int score) {
		// Find player within JSONArray
		
		// Add to players latest score
		
		// Save the score
		
		// Check to see if the score has beat the limit
		if (ReachLimit(score)) Game.EndGame();

		// Check for new high score
		else HighScore(score);
		
		
		// Save last player to move
		
	}
	
	// Checks if score is higher than the limit
	private static boolean ReachLimit(int score) {
		if (score >= scoreCard.scoreLimit) return true;
		else return false;
	}
	
	// Check for highest score
	private static void HighScore(int score) {
		if (score > currentLeaderScore) {
			currentLeaderScore = score;
		}
	}
	
	public static int LeadingScore() {
		return currentLeaderScore;
	}
	
	// Displays current score
	public static void Display() {
		// Grab latest game state
		// Players JSONArray
		Gson gson = new Gson();
		Players = 
		
		// Player
		System.out.print("Player\t");
		for (int i = 1; i < totalPlayers; i++) {
			System.out.print(i + "\t");
		}
		
		// Position
		System.out.print("\nPosition\t");
		for(int i = 1; i < totalPlayers; i++) {
			System.out.print(Players.get(i).get("score") + "\t");
		}
		
		
	}
	
	// Deletes the current game
	public static void Delete() {
		// remove all players from players JSONArray
		
	}

	public static int Position(int player) {
		// TODO Auto-generated method stub
		return 0;
	}
}
