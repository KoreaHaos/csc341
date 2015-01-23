package assignment01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Intent {
	public static void save(String intent) throws IOException {
		JSONArray intentsArray = null;
		String intentsFile = "/Users/henrysnopek/school/csc341/assignments/assignment01/src/assignment01/intents.json";		
		JSONParser parser = new JSONParser();

		try {
			// load file
			Object obj = parser.parse(new FileReader(intentsFile));
			
			// grab intents array
			intentsArray = (JSONArray) obj;
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// add new intent to existing JSONArray ("intents")
		intentsArray.add(sort(intent));
		
		// overwrite file & save
		FileWriter f = new FileWriter(intentsFile);
		try {
			f.write(intentsArray.toJSONString());
			f.close();
		} catch (IOException e) {
            e.printStackTrace();
        }   
		
	}
	
	// TODO
	// Add better parsing via regex to figure out name, phone, and intent
	public static JSONObject sort(String intent) {
		String[] temp = intent.split(",");
		JSONObject tempObj = new JSONObject();
		
		tempObj.put("name", temp[0]);
		tempObj.put("phone", temp[1]);
		tempObj.put("intent", temp[2]);
		
		return tempObj;
	}
}
