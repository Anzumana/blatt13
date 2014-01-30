
public class Rectangle implements IShape {
	public double x;
	public double y;
	public double width;
	public double height;
	
	public Rectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public boolean intersects(IShape other) {
		return other.intersects(this);
	}
	
	@Override
	public boolean intersects(Rectangle other) {
		return IntersectHelper.intersect(this, other);
	}
	
	@Override
	public boolean intersects(Circle other) {
		return IntersectHelper.intersect(this, other);
	}
}
