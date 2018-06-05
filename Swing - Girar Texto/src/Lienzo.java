import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Lienzo extends JPanel {

	private String texto = "Texto de prueba";
	private int izda;
	private int dcha;
		
	public void setIzda(int izda) {
		this.izda = izda;
		repaint();
	}
	
	public void setDcha(int dcha) {
		this.dcha = dcha;
		repaint();
	}
	
	public Lienzo(int ancho, int alto) {
		setPreferredSize(new Dimension(ancho, alto));
		setFocusable(true);
		setFont(getFont().deriveFont((float)(getFont().getSize() * 4)));
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		FontMetrics fm = g.getFontMetrics();
		int x = (getWidth() - fm.stringWidth(texto)) / 2;
		int y = (getHeight() / 2) + ((fm.getAscent() - fm.getDescent()) / 2);
		g.setColor(Color.BLACK);

		g.drawString(texto, x, y);
		
		
		if (izda != 0) {
			removeAll();
			((Graphics2D) g).rotate(Math.PI, getWidth(), getHeight());
			g.setColor(Color.BLACK);
			g.drawString(texto, x, y);
		}
		
		if (dcha != 0) {
			removeAll();
			((Graphics2D) g).rotate(Math.PI / 6, getWidth() / 2, getHeight() / 2);
			g.setColor(Color.BLACK);
			g.drawString(texto, x, y);
		}
	}
	
}
