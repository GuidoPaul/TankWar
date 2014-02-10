/*************************************************************************
	> File Name: TankClient.java
	> Author: Bslin
	> Mail:  
	> Created Time: 2014年02月10日 星期一 14时25分19秒
 ************************************************************************/

import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame {

	int x = 50, y = 50;

	public void paint(Graphics g) {
		Color c = g.getColor();  // *
		g.setColor(Color.red);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);  // *

		y += 5;
	}

	public void launchFrame() {
		setBounds(400, 300, 800, 600);
		setTitle("TankWar");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setResizable(false);
		setBackground(Color.green);
		setVisible(true);

		new Thread(new PaintThread()).start();
	}

	private class PaintThread implements Runnable {
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new TankClient().launchFrame();
	}

}
