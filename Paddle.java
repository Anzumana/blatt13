import java.awt.Color;
import java.awt.Graphics2D;

public class Paddle extends GameObject {
	public double length;
	public double height = 5.0;
	private double velocity = 0.0;
	
	public Paddle(double startx, double starty, double length) {
		super(startx, starty);
		this.length = length;
	}
	
	@Override
	public void onCollision(GameObject other) {
		if(other instanceof Ball) {
			Ball ball = (Ball)other;
			ball.vx += 0.1 * (Math.random() - 0.5); // introduce some randomness to make it interesting
			ball.vy *= -1;
		}
	}

	public void setVelocity(double vx) {
		this.velocity = vx;
	}
	
	@Override
	public void update(double timePassed) {
		x += velocity * timePassed;
		x = Math.max(x, 0.0);
		x = Math.min(x, BreakoutGame.GAME_WIDTH - length);
	}
	
	@Override
	public void draw(Graphics2D g) {		
		g.setColor(Color.DARK_GRAY);
		g.fillRect((int)x, (int)y, (int)length, (int)height);
	}

	@Override
	public IShape getShape() {
		return new Rectangle(x, y, length, height);
	}
}
