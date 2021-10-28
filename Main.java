import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
		frame.setSize(800, 500);
		FontStringLabel t = new FontStringLabel(generateFontStrings());
		t.setPreferredSize(new Dimension(750, 400));
		frame.add(t);
		frame.setVisible(true);
	}
	
	private static ArrayList<FontString> generateFontStrings() {
		Font arial = new Font("Arial", Font.PLAIN, 30);
		ArrayList<FontString> fontStrings = new ArrayList<>();
		fontStrings.add(new FontString("Lorem ipsum dolor sit amet, \nconsetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed", arial, Color.GREEN));
		fontStrings.add(new FontString("Test123!", arial, Color.BLUE));
		return fontStrings;
	}

}
