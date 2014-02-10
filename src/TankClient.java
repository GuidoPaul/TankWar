/*************************************************************************
	> File Name: TankClient.java
	> Author: Bslin
	> Mail:  
	> Created Time: 2014年02月10日 星期一 14时25分19秒
 ************************************************************************/

import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame {

	public void paint(Graphics g) {
		Color c = g.getColor();  // *
		g.setColor(Color.red);
		g.fillOval(50, 50, 30, 30);
		// g.setColor(Color.blue);
		// g.fillOval(100, 100, 30, 30);
		g.setColor(c);  // *
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
	}

	public static void main(String[] args) {
		new TankClient().launchFrame();
	}

}
