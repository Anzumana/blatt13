import java.awt.Graphics2D;


public abstract class GameObject {
	public double x;
	public double y;
	public boolean active = true;
	
	public GameObject(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void testIntersection(GameObject other) {
		if(!active) {
			return;
		}
		
		if(getShape().intersects(other.getShape())) {
			onCollision(other);
		}
	}
	
	public abstract IShape getShape();
		
	public void update(double secondsPassed) {
		// do nothing by default
	}
	
	public abstract void draw(Graphics2D g);
	public abstract void onCollision(GameObject other);
}
