package assignment03;

import java.awt.GridLayout;

import javax.swing.*;

public class ShapeDrawing {

	private static void frameSetup() {
		JFrame frame = new JFrame("Shape Drawing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2,1));
		
//		frame.add(new ShapesBar());
//		frame.add(new Canvas());

		frame.setSize(400, 400);
		frame.setVisible(true);
		
	}
	
	// ShapesBar holds three buttons: Triangle, Rectangle, Circle
	private class ShapesBar extends JPanel {
		
		private void setup() {
			
		}
		
		class ButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg) {
				
			}
		}
	}
	
	// Canvas allows click to draw abilities based on the selected button in the ShapesBar
	private class Canvas extends JPanel {
		
		
		private void setup() {
			
		}
	}
	
	public static void main(String[] args) {
		// Start app here
		frameSetup();
	}
}
