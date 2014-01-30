public class PowerUpSlow extends PowerUp {	
	public PowerUpSlow(double x, double y) {
		super(x, y);
	}

	@Override
	public char getSymbol() {
		return '\u26D4'; // http://unicode-table.com/en/2620/
	}

	@Override
	public void onCollision(GameObject other) {		
		if(other instanceof Ball) {
			game.ball.vx = 50;
			game.ball.vy = 50;
			//other.active = false;
			active = false;
		}
	}

}
