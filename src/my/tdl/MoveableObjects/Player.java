package my.tdl.MoveableObjects;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import my.project.gop.main.Vector2F;
import my.tdl.gameLoop.GameLoop;
import my.tdl.main.Check;
import my.tdl.main.Main;

public class Player implements KeyListener {


	Vector2F pos;
	private int width = 42;
	private int height = 42;
	private static boolean up,down,left,right;
	private float maxSpeed = 3*32F;

	//TODO
	private float speedUp = 0;
	private float speedDown = 0;
	private float speedLeft = 0;
	private float speedRight = 0;

	private float slowdown = 4.093F;

	private float fixDt = 1f/60F;

	private boolean mapMove = true;

	public Player() {
		pos = new Vector2F(Main.width / 2 - width / 2, Main.height / 2 - height / 2);
	}
	public void init() {

	}

	public void tick(double deltaTime) {
		
		

		float moveAmountu = (float) (speedUp * fixDt);
		float moveAmountd = (float) (speedDown * fixDt);
		float moveAmountl = (float) (speedLeft * fixDt);
		float moveAmountr = (float) (speedRight * fixDt);

		if(!mapMove){
			if(up){
				
				if(!Check.CollisionPlayerBlock(
						new Point((int)(pos.xpos + GameLoop.map.xpos) ,
							      (int)(pos.ypos + GameLoop.map.ypos - moveAmountu)),
						new Point((int)(pos.xpos + GameLoop.map.xpos + width), 
								  (int)(pos.ypos + GameLoop.map.ypos - moveAmountu))  )){
					
					

					if(speedUp < maxSpeed){
						speedUp += slowdown;
					}else{
						speedUp = maxSpeed;
					}
					pos.ypos-=moveAmountu;
					
				}else{
					speedUp = 0;
				}
				
			}else{
				if(!Check.CollisionPlayerBlock(
						new Point((int)(pos.xpos + GameLoop.map.xpos) ,
							      (int)(pos.ypos + GameLoop.map.ypos - moveAmountu)),
						new Point((int)(pos.xpos + GameLoop.map.xpos + width), 
								  (int)(pos.ypos + GameLoop.map.ypos - moveAmountu))  )){
					if(speedUp != 0){
						speedUp -= slowdown;

						if(speedUp < 0){
							speedUp = 0;
						}
					}
					pos.ypos-=moveAmountu;
				}else{
					speedUp = 0;
				}
			}

			
			

			if(down){
				
				if(!Check.CollisionPlayerBlock(
						new Point((int)(pos.xpos + GameLoop.map.xpos) ,
							      (int)(pos.ypos + GameLoop.map.ypos + height + moveAmountd)),
						new Point((int)(pos.xpos + GameLoop.map.xpos + width), 
								  (int)(pos.ypos + GameLoop.map.ypos + height + moveAmountd))  )){
					if(speedDown < maxSpeed){
						speedDown += slowdown;
					}else{
						speedDown = maxSpeed;
					}
					pos.ypos+=moveAmountd;
				}else{
					speedDown = 0;
				}
				
				
			}else{
				
				if(!Check.CollisionPlayerBlock(
						new Point((int)(pos.xpos + GameLoop.map.xpos) ,
								(int)(pos.ypos + GameLoop.map.ypos + height + moveAmountd)),
						new Point((int)(pos.xpos + GameLoop.map.xpos + width), 
								(int)(pos.ypos + GameLoop.map.ypos + height + moveAmountd))  )){

					if(speedDown != 0){
						speedDown -= slowdown;
						
						if(speedDown < 0){
							speedDown = 0;
						}
					}
					pos.ypos+=moveAmountd;
				}else{
					speedDown = 0;
				}
			}

			
			
			if(left){

				if(speedLeft < maxSpeed){
					speedLeft += slowdown;
				}else{
					speedLeft = maxSpeed;
				}

				pos.xpos-=moveAmountl;
			}else{

				if(speedLeft != 0){
					speedLeft -= slowdown;

					if(speedLeft < 0){
						speedLeft = 0;
					}

				}

				pos.xpos-=moveAmountl;

			}


			if(right){

				if(speedRight < maxSpeed){
					speedRight += slowdown;
				}else{
					speedRight = maxSpeed;
				}

				pos.xpos+=moveAmountr;
			}else{

				if(speedRight != 0){
					speedRight -= slowdown;

					if(speedRight < 0){
						speedRight = 0;
					}

				}

				pos.xpos+=moveAmountr;

			}

			
			
			
			
			
			
			
		}else{


			
			
			
			
			
			
			if(up){
				if(speedUp < maxSpeed){
					speedUp += slowdown;
				}else{
					speedUp = maxSpeed;
				}
				
				GameLoop.map.ypos-=moveAmountu;
			}else{

				if(speedUp != 0){
					speedUp -= slowdown;

					if(speedUp < 0){
						speedUp = 0;
					}

				}

				GameLoop.map.ypos-=moveAmountu;

			}


			if(down){

				if(speedDown < maxSpeed){
					speedDown += slowdown;
				}else{
					speedDown = maxSpeed;
				}

				GameLoop.map.ypos+=moveAmountd;
			}else{

				if(speedDown != 0){
					speedDown -= slowdown;

					if(speedDown < 0){
						speedDown = 0;
					}

				}

				GameLoop.map.ypos+=moveAmountd;

			}


			if(left){

				if(speedLeft < maxSpeed){
					speedLeft += slowdown;
				}else{
					speedLeft = maxSpeed;
				}

				GameLoop.map.xpos-=moveAmountl;
			}else{

				if(speedLeft != 0){
					speedLeft -= slowdown;

					if(speedLeft < 0){
						speedLeft = 0;
					}

				}

				GameLoop.map.xpos-=moveAmountl;

			}


			if(right){

				if(speedRight < maxSpeed){
					speedRight += slowdown;
				}else{
					speedRight = maxSpeed;
				}

				GameLoop.map.xpos+=moveAmountr;
			}else{

				if(speedRight != 0){
					speedRight -= slowdown;

					if(speedRight < 0){
						speedRight = 0;
					}

				}

				GameLoop.map.xpos+=moveAmountr;

			}
		}
	}

	public void render(Graphics2D g) {
		g.fillRect((int)pos.xpos, (int)pos.ypos, width, height);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_W){
			up = true;
		}
		if(key == KeyEvent.VK_S){
			down = true;
		}
		if(key == KeyEvent.VK_A){
			left = true;
		}
		if(key == KeyEvent.VK_D){
			right = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_W){
			up = false;
		}
		if(key == KeyEvent.VK_S){
			down = false;
		}
		if(key == KeyEvent.VK_A){
			left = false;
		}
		if(key == KeyEvent.VK_D){
			right = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {


	}

}
