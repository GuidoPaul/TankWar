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

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();  // *
		g.setColor(Color.RED);
		g.fillRect(x, y, 30, 30);
		g.setColor(c);  // *
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_UP :
				y -= 5;
				break;
			case KeyEvent.VK_DOWN :
				y += 5;
				break;
			case KeyEvent.VK_LEFT :
				x -= 5;
				break;
			case KeyEvent.VK_RIGHT :
				x += 5;
				break;
		}

	}

}
