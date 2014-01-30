import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
	private BreakoutGame game;
	private boolean leftDown;
	private boolean rightDown;
	
	public InputHandler(BreakoutGame game) {
		this.game = game;
	}

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			leftDown = true;
			game.paddle.setVelocity(-150.0);
			break;
		case KeyEvent.VK_RIGHT:
			rightDown = true;
			game.paddle.setVelocity(150.0);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { 
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			leftDown = false;
			break;
		case KeyEvent.VK_RIGHT:
			rightDown = false;
			break;
		}
		
		if(leftDown) {
			game.paddle.setVelocity(-150.0);
		} else if(rightDown) {
			game.paddle.setVelocity(150.0);
		}else {
			game.paddle.setVelocity(0.0);
		}
	}
}
