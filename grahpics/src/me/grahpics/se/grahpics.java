package me.grahpics.se;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class grahpics extends JPanel {
	
	private int Width = 100;
	private int Height = 100;
	private int d = 50; // diameter
	private int x = 0;
	private int y = 0;
    private int moveX = 1;
    private int moveY = 1;
    
	private void moveBall() {
		if(x + moveX <= 0)
			moveX = 1;
		if(x + moveX > getWidth() - d)
				moveX = -1;
		if(y + moveY < 0)
			    moveY = 1; 
		if(y + moveY > getHeight() - d)
			    moveY = -1; 
		
		x += moveX;
		y += moveY;
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval(x, y, d, d);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		grahpics grafik = new grahpics();

		frame.setSize(700, 800); // x,y
		frame.setLocation(300, 200);
		frame.setDefaultCloseOperation(3);
		frame.add(grafik);
		frame.setTitle("mitt object");
		frame.setResizable(false);
		frame.setVisible(true);

		while (true) {
			grafik.moveBall();
			grafik.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}
}
