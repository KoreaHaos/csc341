package assignment01;

import java.io.Console;
import java.io.IOException;

public class Main {
	static Console console = System.console();
	static String response = "";
	
	public static void main(String [] args) throws IOException {
		
		// load models
		CarModels.getModels();
		
		// run until they kill the program
		while(true) {
			ask();
		}
	}
	
	public static void ask() throws IOException {
		System.out.println("Query model info (q) or Enter a vehicle purchase intent (i) or Exit (e):");
		response = console.readLine();
		
		switch(response) {
		case "q":
			CarModels.displayModels();
			return;
		case "i":
			purchaseIntent();
			return;
		case "e":
			System.exit(1);
		}		
	}
	
	public static void purchaseIntent() throws IOException {
		// create object to hold both contact and intent
		response = "";
		
		System.out.println("Enter your contact info:");
		response += console.readLine();
		
		System.out.println("Enter your purchase intent:");
		response += ", " + console.readLine();
		
		Intent.save(response);
	}
}