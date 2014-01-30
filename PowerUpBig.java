public class PowerUpBig extends PowerUp {	
	public PowerUpBig(double x, double y) {
		super(x, y);
	}

	@Override
	public char getSymbol() {
		return '\u26C3'; // http://unicode-table.com/en/2620/
	}

	@Override
	public void onCollision(GameObject other) {		
// code removes ball and power up from screen
		if(other instanceof Ball) {
			game.ball = new Ball(50);
//			other.active = false;// this is the ball getting deleted
			active = false;// this is the power up getting set to false
		}
	}

}
