public class PowerUpSmallPaddle extends PowerUp{
	public PowerUpSmallPaddle(double x, double y){
		super(x,y);
	}

	@Override
	public char getSymbol() {
		return '\u28A6'; // http://unicode-table.com/en/2620/
	}

	@Override
	public void onCollision(GameObject other) {		
// code removes ball and power up from screen
		if(other instanceof Ball) {
			game.paddle.length =5;
			other.active = false;// this is the old ball getting deleted
			active = false;// this is the power up getting set to false
		}
	}

}
