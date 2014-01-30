import java.awt.Color;
import java.awt.Graphics2D;


public class Block extends GameObject {
	public double size;
	
	public Block(double x, double y) {
		super(x, y);
		this.size = 20.0;
	}
	
	@Override
	public void draw(Graphics2D g) {
		if(!active) {
			return;
		}
		
//		g.setColor(Color.getHSBColor(0.2f, 0.3f, 0.6f));
		g.setColor(Color.getHSBColor(0.83f, 0.9f, 0.96f));
		g.fillRect((int)x, (int)y, (int)size, (int)size);
	}

	@Override
	public void onCollision(GameObject other) {
		if(other instanceof Ball) {
			Ball ball = (Ball)other;
			ball.vx += 0.1 * (Math.random() - 0.5); // introduce some randomness to make it interesting
			ball.vy *= -1;
			active = false;
		}
	}

	@Override
	public IShape getShape() {
		return new Rectangle(x, y, size, size);
	}

}
