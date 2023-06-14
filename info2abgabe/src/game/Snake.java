package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import gui.Gui;

public class Snake {

	public static int score = 0, bestscore = 0;

	public static boolean waitToMove = false;

	public static Head head = new Head(12, 12);

	public static ArrayList<Tail> tails = new ArrayList<>();

	public static PickUp pickup = new PickUp();

	public static Snail snail = new Snail();
	public static Snail snail2 = new Snail();
	public static Snail snail3 = new Snail();

	public static Random random = new Random();

	public static void addTail() {
		if (tails.size() < 1) {
			tails.add(new Tail(head.getX(), head.getY()));
		} else {
			tails.add(new Tail(tails.get(tails.size() - 1).x, tails.get(tails.size() - 1).y));
		}
	}

	public static void move() throws InterruptedException {
		// move tails
		if (tails.size() >= 2) {
			for (int i = tails.size() - 1; i >= 1; i--) {
				if (tails.get(i).isWait()) {
					tails.get(i).setWait(false);
				} else {
					tails.get(i).setX(tails.get(i - 1).getX());
					tails.get(i).setY(tails.get(i - 1).getY());
				}
			}
		}

		// move tail to head
		if (tails.size() >= 1) {
			if (tails.get(0).isWait()) {
				tails.get(0).setWait(false);
			} else {
				tails.get(0).setX(head.getX());
				tails.get(0).setY(head.getY());
			}
		}

		// move head
		switch (head.getDir()) {
			case RIGHT:
				head.setX(head.getX() + 1);
				break;
			case LEFT:
				head.setX(head.getX() - 1);
				break;
			case UP:
				head.setY(head.getY() - 1);
				break;
			case DOWN:
				head.setY(head.getY() + 1);
				break;
		}
	}

	// move snail
	public static void moveSnail() {

		// Set min and max to randomize within [-1,1]
		int min = -1;
		int max = 1;

		// Snail 1
		snail.incrementX(random.nextInt(max - min) + min);
		snail.incrementY(random.nextInt(max - min) + min);

		// Snail 2
		snail2.incrementX(random.nextInt(max - min) + min);
		snail2.incrementY(random.nextInt(max - min) + min);

		// Snail 2
		snail3.incrementX(random.nextInt(max - min) + min);
		snail3.incrementY(random.nextInt(max - min) + min);

	}

	// position to coordinates
	public static Point ptc(int x, int y) {
		Point p = new Point(0, 0);
		p.x = x * 30 + Gui.xoff;
		p.y = y * 30 + Gui.yoff;

		return p;
	}

}
