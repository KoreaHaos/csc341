package phone;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

// UI
// Renders all the UI: window, panels, buttons

public class UI extends JFrame {
	
	private JTextArea textArea = new JTextArea();
	
	public UI() {
		_InitUI();
	}
	
	public JTextArea getTextArea() { return textArea; }
	
	public void updateTextArea(String str) { textArea.setText(str); }
	
	// Initiates UI
	private void _InitUI() {
		setTitle("Cool Phone");
        setSize(new Dimension(350, 600));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        
        // add panels
        add(_Dialog());
        add(_KeyPad());
        
        setVisible(true);
	}
	
	// Dialog Panel
	private JPanel _Dialog() {
		JPanel dialog = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		
		textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        scrollPane.getViewport().add(textArea);
        scrollPane.setPreferredSize(new Dimension(350, 280));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        
		dialog.add(scrollPane);
		dialog.setBackground(new Color(0x00ffffff));
		
		return dialog;
	}
	
	// KeyPad Panel
	private JPanel _KeyPad() {
		JPanel keypad = new JPanel(new BorderLayout());
		
		keypad.setBackground(new Color(0x00ffffff));
		keypad.setLayout(new GridLayout(4, 3));
		
		for (int i = 9; i > -1; i--) {
			if (i == 0) keypad.add(_dialButton());
			
			keypad.add(_numButton(i));
		}
		keypad.add(_poundKey());
		
		return keypad;
	}
	
	private JButton _numButton(int num) {
		JButton _button = new JButton(Integer.toString(num));
		
		_button.setPreferredSize(new Dimension(25,50));
		_button.addActionListener(new _buttonListener());
		_button.setFont(new Font("Dialog", Font.PLAIN, 22));
		_button.setBorder(null);
		
		return _button;
	}
	
	private JButton _dialButton() {
		JButton _dial = new JButton();
		
		try {
			Image img = ImageIO.read(getClass().getResource("../images/telephone.png"));
			_dial.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		_dial.addActionListener(new _buttonListener(" Dialing..."));
		_dial.setBorder(null);
		
		return _dial;
	}
	
	private JButton _poundKey() {
		JButton _pound = new JButton("#");
		
		_pound.addActionListener(new _buttonListener());
		_pound.setFont(new Font("Dialog", Font.PLAIN, 22));
		_pound.setBorder(null);
		
		return _pound;
	}
	
	@SuppressWarnings("serial")
	private class _buttonListener extends AbstractAction {
		private String value = "";
		
		private _buttonListener() {  }
		private _buttonListener(String str) {
			value = str;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!value.equalsIgnoreCase("")) textArea.append(value);
			else textArea.append(e.getActionCommand());
		}
	}
}
