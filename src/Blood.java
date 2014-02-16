/*************************************************************************
	> File Name: Blood.java
	> Author: Bslin
	> Mail:  
	> Created Time: 2014年02月12日 星期三 10时15分19秒
 ************************************************************************/

import java.awt.*;
import java.util.*;

public class Blood {
	private int x, y, w, h;
	private TankClient tc;
	private boolean live = true;

	private Random r = new Random();
	private boolean go = false;

	// 血块运动轨迹
	private int[][] pos = {
		{50, 350}, {50, 340}, {50, 330}, {50, 320}, {50, 310}, 
		{60, 310}, {70, 310}, {80, 310}, {90, 310}, {100, 310},
		{100, 300}, {100, 290}, {100, 280}, {100, 270}, {100, 260},
		{110, 260}, {120, 260}, {130, 260}, {140, 260}, {150, 260},
		{150, 270}, {150, 280}, {150, 290}, {150, 300}, {150, 310},
		{150, 320}, {150, 330}, {150, 340}, {150, 350}, {140, 350}, 
		{130, 350}, {120, 350}, {110, 350}, {100, 350}, {90, 350}, 
		{80, 350}, {70, 350}, {60, 350},
	};

	private int step = 0;
	private int num = 5;

	public Blood(TankClient tc) {
		x = pos[0][0];
		y = pos[0][1];
		w = 15;
		h = 15;
		this.tc = tc;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void draw(Graphics g) {
		if(!live) {
			return ;
		}
		if(step == 0 && num == 5) {
			if(r.nextInt(100) == 1) {
				go = true;
			} else return;
		}

		Color c = g.getColor();
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, w, h);
		g.setColor(c);

		move();
	}

	public void move() {
		step ++;
		if(step == pos.length) {
			step = 0;
			num --;
			if(num == 0) {
				go = false;
				num = 5;
			}
		}
		if(go) {
			x = pos[step][0];
			y = pos[step][1];
		}
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, w, h);
	}
}
