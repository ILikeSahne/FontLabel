import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

public class FontStringLabel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Graphics2D g;
	
	private ArrayList<FontString> fontStrings;
	
	public FontStringLabel(ArrayList<FontString> fontStrings) {
		this.fontStrings = fontStrings;
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        drawOutline();
        drawFontStrings();
        //repaint();
	}
	
	private void drawOutline() {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}
	
	private void drawFontStrings() {
		ArrayList<ArrayList<FontString>> splitFontStrings = new ArrayList<>();
		int x = 5;
		final int WIDTH = getWidth();
		ArrayList<FontString> currentLine = new ArrayList<>();
		for(FontString fs : fontStrings) {
			while(!fs.getString().isEmpty()) {
				FontString split = fs.split(g, x, WIDTH);
				if(split == null) {
					currentLine.add(fs.clone());
					x += fs.getWidth(g);
					fs.setString("");
				} else {
					currentLine.add(split.clone());
					x = 5;
					splitFontStrings.add(currentLine);
					currentLine = new ArrayList<>();
				}
			}
		}
		splitFontStrings.add(currentLine);
		for(ArrayList<FontString> fss : splitFontStrings) {
			if(fss.size() == 0)
				continue;
			System.out.println("test");
			g.fillRect(0, 0, 100, 100);
		}
	}
	
}
