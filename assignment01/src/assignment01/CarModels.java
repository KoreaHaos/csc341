package assignment01;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CarModels {
	static JSONArray models = null;
	static int modelsAmount = 0;
	
	public static void getModels() {
		JSONArray modelsArray = null;
		String modelsFile = "/Users/henrysnopek/school/csc341/assignments/assignment01/src/assignment01/models.json";		
		JSONParser parser = new JSONParser();
		
		try {
			// load file
			Object obj = parser.parse(new FileReader(modelsFile));
			JSONObject modelsObj = (JSONObject) obj;
			
			// grab models array
			modelsArray = (JSONArray) modelsObj.get("models");
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// return models array
		models = modelsArray;
		modelsAmount = modelsArray.size();
		return;
	}
	
	public static void carInfo(int listNumber) {
		// This would access the models array and return the model's info
		JSONArray modelsArray = models;
		JSONObject tempObj = (JSONObject) modelsArray.get(listNumber - 1);
		System.out.print("Here is the description of " + tempObj.get("name"));
		System.out.print(": " + tempObj.get("description") + "\n");
	}
	
	public static void displayModels() {
		System.out.println("Pick a model from the following list (by typing the index number):");
		
		// create string array of models
		JSONArray modelsArray = models;
		for (int i = 0; i < modelsAmount; i++) {
			JSONObject tempObj = (JSONObject) modelsArray.get(i);
			System.out.println((i+1) + ". " + tempObj.get("name"));
		}
		Console console = System.console();
		carInfo(Integer.parseInt(console.readLine()));
		
	}
}
