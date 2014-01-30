public class PowerUpSpeed extends PowerUp {	
	public PowerUpSpeed(double x, double y) {
		super(x, y);
	}

	@Override
	public char getSymbol() {
		return '\u2621'; // http://unicode-table.com/en/2620/
	}

	@Override
	public void onCollision(GameObject other) {		
		if(other instanceof Ball) {
			game.ball.vx = 200;
			game.ball.vy = 200;
			//other.active = false;
			active = false;
		}
	}

}
