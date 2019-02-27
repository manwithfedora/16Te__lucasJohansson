package me.sänkaskepp.se;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
*
* @author tobias
*/
public class skepp extends Canvas implements MouseListener {

static private int width = 300;
static private int height = 300;
static private int boxSize = 30;
static int board[][] = new int[10][10];

public skepp() {
addMouseListener(this);
}

public void paint(Graphics g) {
int boxWidth = width / 10 - 2;
int boxHeight = height / 10 - 2;
for (int i = 0; i < 10; i++) {
for (int j = 0; j < 10; j++) {
int posX = i * width / 10 + 1;
int posY = j * height / 10 + 1;
if (board[i][j] == 0) {
g.setColor(Color.GRAY);
g.draw3DRect(posX, posY, boxWidth, boxHeight, false);
} else if (board[i][j] == 1) {
g.setColor(Color.BLACK);
g.fill3DRect(posX, posY, boxWidth, boxHeight, true);
}
}
}
}

/**
* @param args the command line arguments
*/
public static void main(String[] args) {
JFrame win = new JFrame("Battle ship, or...");
win.setSize(width + 1, height + height / 10);
win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
for (int i = 0; i < 10; i++) {
for (int j = 0; j < 10; j++) {
board[i][j] = 0;
}
}
skepp canvas = new skepp();
win.add(canvas);
win.setVisible(true);
}

@Override
public void mouseClicked(MouseEvent e) {
int posX = e.getX();
int posY = e.getY();
int gridPosX = posX / boxSize;
int gridPosY = posY / boxSize;
board[gridPosX][gridPosY] = board[gridPosX][gridPosY] == 1 ? 0 : 1;
System.out.println(posX + "." + posY);
repaint();
}

@Override
public void mousePressed(MouseEvent e) {
}

@Override
public void mouseReleased(MouseEvent e) {
}

@Override
public void mouseEntered(MouseEvent e) {
}

@Override
public void mouseExited(MouseEvent e) {
}
}