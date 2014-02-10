/*************************************************************************
	> File Name: Tank.java
	> Author: Bslin
	> Mail:  
	> Created Time: 2014年02月10日 星期一 18时28分33秒
 ************************************************************************/

import java.awt.*;
import java.awt.event.*;

public class Tank {
	int x, y;
	private static final int XSPEED = 5;
	private static final int YSPEED = 5;

	private boolean  bL = false, bU = false, bR = false, bD = false;
	enum Direction {L, LU, U, RU, R, RD, D, LD, STOP};
	private Direction dir = Direction.STOP;

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();  // *
		g.setColor(Color.RED);
		g.fillRect(x, y, 30, 30);
		g.setColor(c);  // *
		move();
	}

	void move() {
		switch(dir) {
			case L:
				x -= XSPEED;
				break;
			case LU:
				x -= XSPEED;
				y -= YSPEED;
				break;
			case U:
				y -= YSPEED;
				break;
			case RU:
				x += XSPEED;
				y -= YSPEED;
				break;
			case R:
				x += XSPEED;
				break;
			case RD:
				x += XSPEED;
				y += YSPEED;
				break;
			case D:
				y += YSPEED;
				break;
			case LD:
				x -= XSPEED;
				y += YSPEED;
				break;
			case STOP:
				break;
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_LEFT :
				bL = true;
				break;
			case KeyEvent.VK_UP :
				bU = true;
				break;
			case KeyEvent.VK_RIGHT :
				bR = true;
				break;
			case KeyEvent.VK_DOWN :
				bD = true;
				break;
		}
		locateDirection();
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_LEFT :
				bL = false;
				break;
			case KeyEvent.VK_UP :
				bU = false;
				break;
			case KeyEvent.VK_RIGHT :
				bR = false;
				break;
			case KeyEvent.VK_DOWN :
				bD = false;
				break;
		}
		locateDirection();
	}

	void locateDirection() {
		if(bL && !bU && !bR && !bD) dir = Direction.L;
		else if(bL && bU && !bR && !bD) dir = Direction.LU;
		else if(!bL && bU && !bR && !bD) dir = Direction.U;
		else if(!bL && bU && bR && !bD) dir = Direction.RU;
		else if(!bL && !bU && bR && !bD) dir = Direction.R;
		else if(!bL && !bU && bR && bD) dir = Direction.RD;
		else if(!bL && !bU && !bR && bD) dir = Direction.D;
		else if(bL && !bU && !bR && bD) dir = Direction.LD;
		else if(!bL && !bU && !bR && !bD) dir = Direction.STOP;
	}

}
