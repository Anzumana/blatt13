import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public abstract class PowerUp extends GameObject {
	private static Font font = new Font("Sans-Serif", Font.BOLD, 18);
	private static double size = 30.0;
	protected static BreakoutGame game = null; // You can use this instance in your power ups
	
	public PowerUp(double x, double y) {
		super(x, y);
	}
	
	public abstract char getSymbol();
	
	@Override
	public void draw(Graphics2D g) {
		if(!active) {
			return;
		}
		
		// upper left corner coordinates
		double cx = x - size * 0.5;
		double cy = y - size * 0.5;
		
		g.setColor(Color.WHITE);
		g.fillOval((int)cx, (int)cy, (int)size, (int)size);
		
		g.setColor(Color.BLACK);
		g.drawOval((int)cx, (int)cy, (int)size, (int)size);

		String text = String.valueOf(getSymbol());
		
		g.setFont(font);
		FontMetrics metrics = g.getFontMetrics(font);
		Rectangle2D bounds = metrics.getStringBounds(text, g);
				
		g.drawString(text, (int)(cx + 0.5 * (size - bounds.getWidth())), (int)(cy + size - (size - bounds.getHeight())));
	}
	
	@Override
	public IShape getShape() {
		return new Circle(x, y, size * 0.5);
	}
	
	public static void setGame(BreakoutGame gameInst) {
		game = gameInst;
	}
	
	public static PowerUp getRandomPowerUp() {
		double x = 20.0 + Math.random() * (BreakoutGame.GAME_WIDTH - 40.0);
		double y = 200.0 + Math.random() * 100;
		
		// TODO: change this function to randomly choose one of the available power ups
		int randomPowerUp =  (int)(Math.random()* 100);
		//System.out.println(randomPowerUp);
		if(randomPowerUp < 20){
			return new PowerUpBig(x, y);
		} else if( randomPowerUp >20 && randomPowerUp <40){
			return new PowerUpSmall(x,y);
		} else if ( randomPowerUp > 40 && randomPowerUp < 60){
			return new PowerUpNewBall(x, y);
		} else if ( randomPowerUp > 60 && randomPowerUp < 80){
			return new PowerUpSlow(x,y);
		} else if ( randomPowerUp > 80 && randomPowerUp < 90){
			return new PowerUpSpeed(x,y);
		} else if (randomPowerUp > 90 && randomPowerUp < 95){
			return new PowerUpBigPaddle(x,y);
		} else if (randomPowerUp > 95 && randomPowerUp < 100){
			return new PowerUpSmallPaddle(x, y);
		}
		return new PowerUpKillBall(x,y);
	}
}
