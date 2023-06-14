package clocks;

import actions.Collision;
import game.Snake;

public class GameClock extends Thread {
	public static boolean running = true;

	public void run() {
		for (int i = 0; i < 9; i++) {
			Snake.addTail();
		}

		while (running) {
			try {
				sleep(200);
				Snake.move();
				Snake.moveSnails();
				Snake.waitToMove = false;
				Collision.collideSnailWall();
				Collision.collidePickUp();
				Collision.collideSnail();
				Collision.collideSelf();
				Collision.collideWall();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
