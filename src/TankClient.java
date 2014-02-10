/*************************************************************************
	> File Name: TankClient.java
	> Author: Bslin
	> Mail:  
	> Created Time: 2014年02月10日 星期一 14时25分19秒
 ************************************************************************/

import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame {

	public void launchFrame() {
		setSize(800, 600);
		setLocation(400, 300);
		setTitle("TankWar");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TankClient().launchFrame();
	}

}
