package voicemail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.*;


// API
// This API allows you to access the Voicemail DB after authorization.

public class API {
	private boolean _authorized = false;
	private JsonObject DB;
	private JsonObject user;	// user for current session
	private String DBPath = "../Voicemail-DB.json";
	
	public API() {
		_loadDB();
	}
	
	// Authorize Voicemail API Usage for number (user)
	public boolean Auth(String number, int code) {
		
		// Load user from matching number
		user = DB.get(number).getAsJsonObject();
		
		// If user number is equal to code set _authorized to true
		if (user.get("code").getAsInt() == code) _authorized = true;
		
		return _authorized;
	}
	
	// Add voicemail to number, no authorization needed
	public boolean Add(String number, Voicemail voicemail) {
		
		// Add JsonElement to Voicemails JsonArray
		JsonArray _users = DB.get("users").getAsJsonArray();
		JsonObject _user = new JsonObject();
		
		// create JsonObject _voicemail
		JsonObject _voicemail = new JsonObject();
		_voicemail.addProperty("number", Voicemail.number);
		_voicemail.addProperty("message", Voicemail.message);
		_voicemail.addProperty("read", Voicemail.read);
		
		// Find _user with provided number
		for (int i = 0; i < _users.size(); i++) {
			_user = _users.get(i).getAsJsonObject();
			if (_user.get("number").getAsString() == number) break;
			else _user = null;
		}
		
		if (_user == null) return false;
			
		// Add voicemail to _user's voicemails
		_user.getAsJsonArray("voicemails").add(_voicemail);
		
		return true;
	}
	
	// Remove voicemail from current user session by index
	public boolean Remove(int index) {
		if (!_authorized) return false;
		
		user.get("voicemails").getAsJsonArray().remove(index);
		
		return true;
	}
	
	// GetAll: Returns all voicemails as JSONArray
	public JsonArray GetAll() {
		if (!_authorized) return null;
		
		JsonArray userVoicemails = user.get("voicemails").getAsJsonArray();
		
		return userVoicemails;
	}
	
	public String GetGreeting(String num) {
		
	}
	
	public boolean Search(String num) {
		JsonArray _users = DB.get("users").getAsJsonArray();
		JsonObject _user = new JsonObject();

		// Find _user with provided number
		for (int i = 0; i < _users.size(); i++) {
			_user = _users.get(i).getAsJsonObject();
			if (_user.getAsString() == num) break;
			else _user = null;
		}
		
		if (_user == null) return false;
		return true;
	}
	
	public void Login(String num) {
		JsonArray _users = DB.get("users").getAsJsonArray();
		JsonObject _user = new JsonObject();
		
		for (int i = 0; i < _users.size(); i++) {
			_user = _users.get(i).getAsJsonObject();
			if (_user.getAsString() == num) break;
			else _user = null;
		}
		
		if (_user.get("password").getAsString().equalsIgnoreCase(num)) {
			_authorized = true;
		}
	}
	
	// Loads DB
	private void _loadDB() {
		try {
			
			JsonParser parser = new JsonParser();
			JsonElement jsonElement = parser.parse(new FileReader(DBPath));
			DB = jsonElement.getAsJsonObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	// Saves the latest to the DB file
	private boolean _SaveDB() {		
		Gson gson = new Gson();
		String json = gson.toJson(DB);
		
		try {

			FileWriter writer = new FileWriter(DBPath);
			writer.write(json);
			writer.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	// Close session after saving, deauthorizes session
		public boolean CloseSession() {
			if (_SaveDB()) {
				_authorized = false;
				return true;
			} else return false;
		}
}
