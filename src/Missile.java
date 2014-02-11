/*************************************************************************
	> File Name: Missile.java
	> Author: Bslin
	> Mail:  
	> Created Time: 2014年02月10日 星期一 19时55分57秒
 ************************************************************************/

import java.awt.*;
import java.util.List;

public class Missile {
	int x, y;
	private TankClient tc = null;
	private boolean live = true;
	private boolean good;

	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;

	Tank.Direction ptDir;

	public Missile(int x, int y, Tank.Direction ptDir) {
		this.x = x;
		this.y = y;
		this.ptDir = ptDir;
	}

	public Missile(int x, int y, Tank.Direction ptDir, boolean good, TankClient tc) {
		this(x, y, ptDir);
		this.good = good;
		this.tc = tc;
	}

	public boolean isLive() {
		return this.live;
	}

	public void draw(Graphics g) {
		if(!live) {
			tc.missiles.remove(this);
			return ;
		}
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		move();
	}

	private void move() {
		switch(ptDir) {
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
		}
		if(x < 0 || y < 0 || x > TankClient.GAME_WIDTH || y > TankClient.GAME_HEIGHT) {
			live = false;
		}
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public boolean hitTank(Tank t) {
		if(getRect().intersects(t.getRect()) && t.isLive() && this.good != t.isGood() && this.live) {
			t.setLive(false);
			this.live = false;
			Explode e = new Explode(x, y, tc);
			tc.explodes.add(e);
			return true;
		}
		return false;
	}

	public boolean hitTanks(List<Tank> tanks) {
		for (int i=0; i<tanks.size(); i++) {
			if(hitTank(tanks.get(i))) {
				return true;
			}
		}
		return false;
	}

	public boolean hitWall(Wall w) {
		if(this.live && this.getRect().intersects(w.getRect()) ) {
			this.live = false;
			return true;
		}
		return false;
	}
}
