import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;

public class FontString {

	private String s;
	private Font f;
	private Color c;
	
	public FontString(String s, Font f, Color c) {
		this.s = s;
		this.f = f;
		this.c = c;
	}
	
	public int draw(Graphics g, int x, int y) {
		g.setFont(f);
		g.setColor(c);
		g.drawString(s, x, y + getHeight(g));
		return g.getFontMetrics().stringWidth(s);
	}
	
	public int getHeight(Graphics g) {
		return g.getFontMetrics(f).getAscent();
	}
	
	public int getWidth(Graphics g) {
		return g.getFontMetrics(f).stringWidth(s);
	}
	
	public FontString split(Graphics g, int x, int width) {
		if(x + getWidth(g) < width) {
			return null;
		}
		FontMetrics m = g.getFontMetrics(f);
		String min = "";
		int i = 0;
		int lastSpacePos = -1;
		for(; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '\n') {
				FontString minFs = clone();
				minFs.setString(minFs.getString().substring(0, i));
				s = s.substring(i + 1);
				return minFs;
			}
			if(c == ' ')
				lastSpacePos = i;
			min += c;
			if(m.stringWidth(min) > width)
				break;
		}
		FontString minFs = clone();
		if(lastSpacePos != -1) {
			minFs.setString(minFs.getString().substring(0, lastSpacePos));
			if(lastSpacePos + 1 < s.length())
				s = s.substring(lastSpacePos + 1);
			else
				s = s.substring(lastSpacePos);
		} else {
			minFs.setString(minFs.getString().substring(0, i));
			s = s.substring(i);
		}
		return minFs;
	}
	
	public void setString(String s) {
		this.s = s;
	}

	public void setFont(Font f) {
		this.f = f;
	}

	public void setColor(Color c) {
		this.c = c;
	}

	public String getString() {
		return s;
	}

	public Font getFont() {
		return f;
	}

	public Color getColor() {
		return c;
	}
	
	public FontString clone() {
		return new FontString(s, f, c);
	}
}
