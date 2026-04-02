import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {

	public static void main(String[] args) {
		double LowestVelocity = 0.005; ///lowest velocity of balls 
		double highVelocity = 0.01;  ///highest velocity  of balls 
		int balls = 3; ///num of balls
		double radius = 0.025;  /// radius of balls and players 
		int score = 0; ///score
		int highscore = 0; ///high score 
		double playerx = 0.5; //player x
		double playery = 0.5; ///player y 
		double ps = 0.01;  /// player speed 
		double[] ballx = new double[b]; ///ball x  formely bx 
		double[] ballY = new double[b];  /// ball y coordinate  formely bY 
		double[] ballXvelocity = new double[b];  /// ball x velocity bxv
		double[] ballYvelocity = new double[b];  /// ball y velocity bYv 
		
		
		//initialize ball positions and velocities
		public static void initalizeBalls(){ 
           for (int i = 0; i < balls; i++) {
     		ballx[i] = Math.random();
			ballY[i] = Math.random();
			ballXvelocity[i] = Math.random() * (highVelocity - LowestVelocity) + LowestVelocity; //sets v between lv and uv 
			ballYvelocity[i] = Math.random() * (highVelocity - LowestVelocity) + LowestVelocity; 
			}

            ///buffering 
			StdDraw.enableDoubleBuffering();

			long starttime = System.currentTimeMillis(); ///renamme st to start time 
			long deltatime = System.currentTimeMillis(); /// renamed dt to delta time for clarity 


			/////
		}
	    
      
		
		while (true) {
		    StdDraw.clear(); /// clear the screen before starting the game loop
		    boolean collision = false; 
            
			StdDraw.clear(); /// 
			boolean collison = false; 
		


			for(int i = 0; i < balls; i++) {
				 
			//// set ball postion 
			///ballx and ball
				ballx[i] = ballx[i] + ballXvelocity[i]; 
				ballY[i] = ballY[i] + ballYvelocity[i];
				if(ballXvelocity[i] + radius > 1 || ballx[i] - r < 0) { 
					ballXvelocity[i] = -ballXvelocity[i];
				}
				if(ballY[i] + radius > 1 || ballY[i] - r < 0) { 
					ballYvelocity[i] = -ballYvelocity[i];
				}
				for(int j = 0; j < balls; j++) {
					if(i != j) {
						double distance = Math.sqrt(Math.pow(ballx[i] - ballx[j], 2) + Math.pow(ballY[i] - ballY[j], 2));
						if(distance < 2 * radius) { 
							ballXvelocity[i] = -ballXvelocity[i];
							ballYvelocity[i] = -ballYvelocity[i];
						}
					}
				}
				
				double d = Math.sqrt(Math.pow(ballx[i] - playerx, 2) + Math.pow(ballY[i] - playery, 2));
				if(distance < 2 * radius) {
					c = true;
				}
			}
			
			if(c) {
				balls = 3;
				for(int i = 0; i < balls; i++) {
					ballx[i] = Math.random();
					ballY[i] = Math.random();
					bxv[i] = Math.random() * (highVelocity - LowestVelocity) + LowestVelocity;
					bYv[i] = Math.random() * (highVelocity - LowestVelocity) + LowestVelocity;
					score = 0;
					starttime = System.currentTimeMillis();
					deltatime = System.currentTimeMillis();
					playerx = 0.5;
					playery = 0.5;
				}
				
				
			}
			///if statments for player moment 
			//// WSD keys 
			public static void playerMovement() {  
			if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
				playery = playery + ps;
			}
			if(StdDraw.isKeyPressed(KeyEvent.VK_S)) {
				playery = playery - ps;
			}
			if(StdDraw.isKeyPressed(KeyEvent.VK_A)) {
				playerx = playerx - ps;
			}
			if(StdDraw.isKeyPressed(KeyEvent.VK_D)) {
				playerx = px + ps;
			}
			
			if(playerx > 1) {
				playerx = 1;
			}
			if(playerx < 0) {
				playerx = 0;
			}
			if(playery > 1) {
				playery = 1;
			}
			if(playery < 0) {
				playery = 0;
			}
			} 
			public static void scoreAndBallIncrease() {
			long now = System.currentTimeMillis();
		
			if(now > starttime + 1000) {
				score++;
				if(score > highscore) {
					highscore = score;
				}
				starttime = now;
			}
			// add new ball every 10 seconds 
			if(now > deltatime + 10000) {
				balls++;
				double[] ballXnew = new double[b];
				double[] ballYnew = new double[b];
				double[] ballXVnew = new double[b];
				double[] ballYVnew = new double[b];
				for(int i = 0; i < balls - 1; i++) {
					ballXnew[i] = bx[i];
					ballYnew[i] = bY[i];
					ballXVnew[i] = bxv[i];
					ballYVnew[i] = bYv[i];
				}
				ballXnew[balls-1] = Math.random();
				ballYnew[balls-1] = Math.random();
				ballXVnew[balls-1] = Math.random() * (uv - LowestVelocity) + LowestVelocity;
				ballYVnew[balls-1] = Math.random() * (uv - LowestVelocity) + LowestVelocity;
				ballx = ballXnew;
				ballY = ballYnew;
				ballXVnew = ballXVnew;
				ballYVnew = ballYVnew;
				deltatime = now; //reset timer for next ball 
			}
			StdDraw.setPenColor(Color.red);
			for(int i = 0; i < balls ; i++) {
				StdDraw.filledCircle(ballx[i], ballY[i], radius);
			}
			
			StdDraw.setPenColor(Color.black);
			StdDraw.filledCircle(playerx, playery, radius);
			StdDraw.text(0.5, 0.1, "Score: " + score + " High Score: " + highscore);
			
			StdDraw.show();
			StdDraw.pause(10);
			
		}
		} 
	}
}
