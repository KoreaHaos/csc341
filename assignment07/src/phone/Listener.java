package phone;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import voicemail.API;
import voicemail.Voicemail;

public class Listener {
	private UI _ui;
	private String _ownerNum;
	private String text = "";
	private JTextArea textArea;
	private API voicemail = new API();
	
	public Listener(UI ui, String num) {
		_ui = ui;
		_ownerNum = num;
		textArea = _ui.getTextArea();
	}
	
	// Login
	public void forLogin() {
		
	}
	
	// Dial number
	public void forDial() {
		textArea.getDocument().addDocumentListener(
			new DocumentListener() {				
				@Override
				public void insertUpdate(DocumentEvent e) { detectNumber(); }

				@Override
				public void removeUpdate(DocumentEvent e) {  }

				@Override
				public void changedUpdate(DocumentEvent e) {  }
			 }
		);
	}
	
	private void detectNumber() {
		text = textArea.getText();
		String number = text.split(" ")[0];
		
		if (text.split(" ")[1].equalsIgnoreCase("Dialing...")) {
			switch(number.length()) {
				case 4:
					voicemail.Login(number);
				case 7:
					call(number);
			}
		}

	}
	
	private void call(String number) {
		
		
		String _msg = "";
		
		// verify number is within the DB
		if (voicemail.Search(number)) {
			// Display greeting message
			String greeting = voicemail.GetGreeting(number);
			_ui.updateTextArea(greeting);
			// listen for pound button to be hitx
			

			// after pound key is hit save the message in new Voicemail Object
			textArea.split(" ")[1]
		}
			
		
		// if not, cancel call
	}
	
	// Leave Voicemail
	private void leaveVoicemail() {
		
	}
	
}
