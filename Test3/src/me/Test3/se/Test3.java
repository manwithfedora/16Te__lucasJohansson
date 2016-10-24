package me.Test3.se;
import javax.swing.*;
import java.awt.*;
public class Test3 extends JFrame {
	private int width = 100;
	private int height = 100;
    private int d = 50;
    
	public Test3(){
        setSize(700, 800);//x,y
		setLocation(300, 200);
		setDefaultCloseOperation(3);
        setTitle("Mitt första grafiska object");
		setResizable(false);
		setVisible(true);
	}
public static void main(String args[]){
	new Test3();
}
public void paint(Graphics g){
        g.setColor(Color.black);
	    g.fillRect(0, 0, 700, 800);
		g.setColor(Color.RED);
	    g.drawRect(70, 100, width, height);
        g.setColor(Color.GREEN);
        g.fillRect(160, 200, width, height);
        g.setColor(Color.blue);
        g.drawOval(30, 250, d, d);
        g.setColor(Color.ORANGE);
        g.fillOval(400, 50, d, d);
}
}