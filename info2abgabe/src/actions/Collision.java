package actions;

import game.Snake;

public class Collision {
	public static boolean collideSelf() {
		for(int i = 0; i < Snake.tails.size(); i++) {
			if(Snake.head.getX() == Snake.tails.get(i).getX() && Snake.head.getY() == Snake.tails.get(i).getY() && !Snake.tails.get(i).isWait()) {
				Snake.tails.clear();
				Snake.score = 0;
				System.exit(0);
			}
		}
		return false;
	}
	public static boolean collideWall() {	
		if(Snake.head.getX() < 0 || Snake.head.getX() > 23 || Snake.head.getY() < 0 || Snake.head.getY() > 23) {
			Snake.tails.clear();
			Snake.score = 0;
			System.exit(0);
			return true;
		}
		else {
			return false;
		}
	}
	public static void collidePickUp() {
		if(Snake.head.getX() == Snake.pickup.getX() && Snake.head.getY() == Snake.pickup.getY()) {
			Snake.pickup.reset();
			Snake.addTail();
			
			//score
			Snake.score +=1;
			if(Snake.score > Snake.bestscore) {
				Snake.bestscore = Snake.score;
			}
			
		}
	}
	public static void collideSnail() {
		if(Snake.head.getX() == Snake.snail.getX() && Snake.head.getY() == Snake.snail.getY()) {
			Snake.snail.reset();
			Snake.addTail();
			
			//score
			Snake.score +=1;
		}
		if(Snake.head.getX() == Snake.snail2.getX() && Snake.head.getY() == Snake.snail2.getY()) {
			Snake.snail2.reset();
			Snake.addTail();
			
			//score
			Snake.score +=1;
		}
		if(Snake.head.getX() == Snake.snail3.getX() && Snake.head.getY() == Snake.snail3.getY()) {
			Snake.snail3.reset();
			Snake.addTail();
			
			//score
			Snake.score +=1;
		}
		
			
	}
		
		public static void collideSnailWall() {
			if(Snake.snail.getX() < 0 || Snake.snail.getX() > 23 || Snake.snail.getY() < 0 || Snake.snail.getY() > 23){
				Snake.snail.reset();
				}
			if(Snake.snail2.getX() < 0 || Snake.snail2.getX() > 23 || Snake.snail2.getY() < 0 || Snake.snail2.getY() > 23){
				Snake.snail2.reset();
				}
			if(Snake.snail3.getX() < 0 || Snake.snail3.getX() > 23 || Snake.snail3.getY() < 0 || Snake.snail3.getY() > 23){
				Snake.snail3.reset();
				}
				
			
	}
}
