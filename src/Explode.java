/*************************************************************************
	> File Name: Explode.java
	> Author: Bslin
	> Mail:  
	> Created Time: 2014年02月11日 星期二 22时07分17秒
 ************************************************************************/

import java.awt.*;

public class Explode {
	int x, y;
	private TankClient tc = null;
	private boolean live = true;

	int[] diameter = {4, 7, 12, 18, 26, 32, 49, 30, 14, 6};
	int step = 0;

	public Explode(int x, int y, TankClient tc) {
		this.x = x;
		this.y = y;
		this.tc = tc;
	}

	public void draw(Graphics g) {
		if(!live) {
			tc.explodes.remove(this);
			return ;
		}

		if(step == diameter.length) {
			live = false;
			step = 0;
			return ;
		}

		Color c = g.getColor();
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, diameter[step], diameter[step]);
		g.setColor(c);
		step ++;
	}
}
