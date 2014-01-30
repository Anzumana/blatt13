import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private BreakoutGame game;
	
	public GamePanel(BreakoutGame game) {
		this.game = game;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(BreakoutGame.GAME_WIDTH, BreakoutGame.GAME_HEIGHT);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(Color.BLUE);
		g2.fillRect(0, 0, BreakoutGame.GAME_WIDTH, BreakoutGame.GAME_HEIGHT);

		game.draw(g2);
	} 
}
