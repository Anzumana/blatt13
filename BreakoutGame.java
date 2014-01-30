import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;


public class BreakoutGame {
	public static int GAME_WIDTH = 300;
	public static int GAME_HEIGHT = 500;
	
	private static double NANOSECONDS_PER_UPDATE = 1000000000 / 60.0; // run at 60fps
	
	public Ball ball;
	public Ball ball2;
	public Paddle paddle;
	
	public PowerUp curPowerUp;
	private double powerUpTimer = 0.0;
	
	List gameObjects = new List();

	public BreakoutGame() {
		resetGame();
	}
	
	private void resetGame() {
		gameObjects.clear();
		
		for(int i = 0; i < 96; ++i) {
			double x = 20.0 + 22.0 * (i % 12);
			double y = 20.0 + 22.0 * (Math.floor(i / 12.0));
			gameObjects.add(new Block(x, y));
		}
		
		ball = new Ball(Ball.DEFAULT_BALL_SIZE);
		paddle = new Paddle(50, 480, 100);
		curPowerUp = PowerUp.getRandomPowerUp();
	}
	
	public void update(double secondsPassed) {	
		paddle.update(secondsPassed);
		ball.update(secondsPassed);
		if(ball2!= null){
			ball2.update(secondsPassed);
		}

		if(powerUpTimer > 15.0 && curPowerUp == null) {
			curPowerUp = PowerUp.getRandomPowerUp();
		}
		powerUpTimer = (powerUpTimer + secondsPassed) % 20.0;
		
		paddle.testIntersection(ball);
		if(ball2!= null){
		paddle.testIntersection(ball2);
		}

		if(curPowerUp != null) {
			curPowerUp.testIntersection(ball);
			if(ball2!= null){
			curPowerUp.testIntersection(ball2);
			}
			if(curPowerUp.active == false) {
				curPowerUp = null;
			}
		}
		
		List.Iterator it = gameObjects.iterator();
		while(it.hasNext()) {
			GameObject go = it.next();
		
			go.testIntersection(ball);
			if(ball2!= null){
				go.testIntersection(ball2);
			}
					
			if(go.active == false) {
				it.remove();
			}
		}
		
		if(ball.active == false) {
			ball = new Ball(Ball.DEFAULT_BALL_SIZE);
		}
		if(ball2!= null){
			if(ball2.active == false) {
				ball2 = new Ball(Ball.DEFAULT_BALL_SIZE);
			}
		}
		
		if(gameObjects.size() == 0) {
			resetGame();
		}
	}
	
	public void draw(Graphics2D g) {
		ball.draw(g);
		if(ball2!= null){
			ball2.draw(g);
		}
		paddle.draw(g);
		
		List.Iterator it = gameObjects.iterator();
		while(it.hasNext()) {
			it.next().draw(g);
		}
		
		if(curPowerUp != null) {
			curPowerUp.draw(g);
		}
	}

	public static void main(String[] args) {
		BreakoutGame game = new BreakoutGame();
		PowerUp.setGame(game);

		JFrame frame = new JFrame("Breakout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.addKeyListener(new InputHandler(game));
		
		GamePanel panel = new GamePanel(game);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		double lastTick = System.nanoTime();
		while(true) {
			double tickTime = System.nanoTime();
			
			game.update((tickTime - lastTick) / 1000000000.0);
			panel.repaint();
			
			lastTick = tickTime;

			while(tickTime - lastTick < NANOSECONDS_PER_UPDATE) {
				try {
					Thread.sleep(1);
				} catch(InterruptedException e) {}
				tickTime = System.nanoTime();
			}
		}
	}	
	
}
