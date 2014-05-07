/*************************************************************************
	> File Name: Wall.java
	> Author: Bslin
	> Mail:  
	> Created Time: 2014年02月12日 星期三 00时26分51秒
 ************************************************************************/

import java.awt.*;

public class Wall {
	int x, y, w, h;
	TankClient tc;

	public Wall(int x, int y, int w, int h, TankClient tc) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.tc = tc;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, w, h);
		g.setColor(c);
	}

	/**
	 * 取得墙所在的矩形区域, 为检测是否碰撞
	 * */

	public Rectangle getRect() {
		return new Rectangle(x, y, w, h);
	}

}
