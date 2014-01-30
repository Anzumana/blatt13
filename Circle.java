
public class Circle implements IShape {
	public double x;
	public double y;
	public double radius;
	
	public Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	@Override
	public boolean intersects(IShape other) {
		return other.intersects(this);
	}
	
	@Override
	public boolean intersects(Rectangle other) {
		return IntersectHelper.intersect(other, this);
	}
	
	@Override
	public boolean intersects(Circle other) {
		return IntersectHelper.intersect(this, other);
	}
}
