
public class PowerUpKillBall extends PowerUp {	
	public PowerUpKillBall(double x, double y) {
		super(x, y);
	}

	@Override
	public char getSymbol() {
		return '\u2620'; // http://unicode-table.com/en/2620/
	}

	@Override
	public void onCollision(GameObject other) {		
		if(other instanceof Ball) {
			other.active = false;
			active = false;
		}
	}

}
