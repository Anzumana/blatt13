import java.awt.Color;
import java.awt.Graphics2D;

public class Ball extends GameObject {
	public static int DEFAULT_BALL_SIZE = 13;
	
	public double size;
	public double vx;
	public double vy;
	private Color ballColor = Color.WHITE;//getHSBColor(0.55f, 0.8f, 0.7f);
	
	public Ball(double size) {
		this(
			10.0 + Math.random() * (BreakoutGame.GAME_WIDTH - 20.0), 
			200.0 + Math.random() * 100, 
			size);
	}
	
	public Ball(double startx, double starty, double size) {
		super(startx, starty);
		this.size = size;
		this.vx = (Math.random() - 0.5) * 300.0;
		this.vy = 95.0 + Math.random() * 80.0; 
		
		if(Math.abs(vx) < 50.0) {
			vx += 50.0 * Math.signum(vx);
		}
	}

	@Override
	public void onCollision(GameObject other) {
		
	}

	@Override
	public void update(double secondsPassed) {
		x += vx * secondsPassed;
		y += vy * secondsPassed;
		
		if(x < size * 0.5 || x > (BreakoutGame.GAME_WIDTH - size * 0.5)) {
			vx *= -1;
		}
		
		if(y < size * 0.5) {
			vy *= -1;
		} else if(y > (BreakoutGame.GAME_HEIGHT - size * 0.5)) {
			active = false;
			System.out.println("-1 life ");
			}
	}

	@Override
	public void draw(Graphics2D g) {		
		g.setColor(ballColor);
		g.fillOval((int)(x - size * 0.5), (int)(y - size * 0.5), (int)size, (int)size);
	}

	@Override
	public IShape getShape() {
		return new Circle(x, y, size * 0.5);
	}
}
