/*************************************************************************
	> File Name: TankClient.java
	> Author: Bslin
	> Mail:  
	> Created Time: 2014年02月10日 星期一 14时25分19秒
 ************************************************************************/

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class TankClient extends Frame {

	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;

	Tank myTank = new Tank(50, 50, true, this);
	Tank enemyTank = new Tank(100, 100, false, this);
	List<Missile> missiles = new ArrayList<Missile>();

	Image offScreenImage = null;

	public void paint(Graphics g) {
		g.drawString("missiles count : " + missiles.size(), 10, 50);

		myTank.draw(g);
		enemyTank.draw(g);

		for (int i=0; i<missiles.size(); i++) {
			Missile m = missiles.get(i);
			m.hitTank(enemyTank);
			m.draw(g);
		}
	}

	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics goffScreen = offScreenImage.getGraphics();
		Color c = goffScreen.getColor();
		goffScreen.setColor(Color.GREEN);
		goffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		goffScreen.setColor(c);
		paint(goffScreen);  // 先画到背面的虚拟图片
		g.drawImage(offScreenImage, 0, 0, null);  // 再画到前面图片上
	}

	public void launchFrame() {
		setBounds(400, 300, GAME_WIDTH, GAME_HEIGHT);
		setTitle("TankWar");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setResizable(false);
		setBackground(Color.GREEN);
		addKeyListener(new KeyMonitor());
		setVisible(true);

		new Thread(new PaintThread()).start();
	}

	public static void main(String[] args) {
		new TankClient().launchFrame();
	}

	private class PaintThread implements Runnable {
		public void run() {
			while(true) {
				repaint();  // -> update() ->paint().
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private class KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			myTank.keyReleased(e);
		}
	}

}
