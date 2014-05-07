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

/**
 * TankWar的主窗口
 * @author Bslin
 */

public class TankClient extends Frame {

	/**
	 * 整个坦克游戏的宽度-高度
	 */
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;

	Tank myTank = new Tank(400, 500, true, this);
	Wall w1 = new Wall(200, 200, 50, 200, this);
	Wall w2 = new Wall(500, 200, 200, 50, this);
	Blood b = new Blood(this);

	List<Tank> tanks = new ArrayList<Tank>();
	List<Missile> missiles = new ArrayList<Missile>();
	List<Explode> explodes = new ArrayList<Explode>();

	Image offScreenImage = null;

	public void paint(Graphics g) {
		/*
		 * 显示子弹-爆炸-坦克的数量
		 * 显示坦克的生命值
		 * */
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("missiles count: " + missiles.size(), 10, 50);
		g.drawString("explodes count: " + explodes.size(), 10, 70);
		g.drawString("tanks count: " + tanks.size(), 10, 90);
		g.drawString("tanks life: " + myTank.getLife(), 10, 110);

		g.setColor(c);

		myTank.draw(g);
		myTank.hitWall(w1);
		myTank.hitWall(w2);
		myTank.hitTanks(tanks);
		myTank.eat(b);

		w1.draw(g);
		w2.draw(g);
		b.draw(g);

		if(tanks.size() <= 0) {
			for (int i = 0; i < 15; i++) {
				tanks.add(new Tank((50 + 40 * (i + 1)), 50, false, this));
			}
		}

		for (int i = 0; i < tanks.size(); i ++) {
			Tank t = tanks.get(i);
			t.hitTanks(tanks);
			t.hitWall(w1);
			t.hitWall(w2);
			t.draw(g);
		}

		for (int i = 0; i < missiles.size(); i ++) {
			Missile m = missiles.get(i);
			m.hitTanks(tanks);
			m.hitTank(myTank);
			m.hitWall(w1);
			m.hitWall(w2);
			m.draw(g);
		}

		for(int i = 0; i < explodes.size(); i ++) {
			Explode e = explodes.get(i);
			e.draw(g);
		}
	}

	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics goffScreen = offScreenImage.getGraphics();
		Color c = goffScreen.getColor();
		goffScreen.setColor(Color.BLACK);
		goffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		goffScreen.setColor(c);
		paint(goffScreen);  // 先画到背面的虚拟图片
		g.drawImage(offScreenImage, 0, 0, null);  // 再画到前面图片上
	}

	/**
	 * launchFrame方法显示坦克主窗口
	 */

	public void launchFrame() {

		for (int i = 0; i < 15; i ++) {
			tanks.add(new Tank((50 + 40 * (i + 1)), 50, false, this));
		}

		setBounds(400, 300, GAME_WIDTH, GAME_HEIGHT);
		setTitle("TankWar");

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setResizable(false);
		setBackground(Color.BLACK);
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
