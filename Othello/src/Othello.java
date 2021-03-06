import java.awt.Canvas;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
/*
Spelplan av rektanglar?
H�ll reda p� spelpj�ser i en array.
Klicka inom rutor f�r att s�tta dit en spelpj�s.
H�lla reda p� po�ng.
Hantera att v�nda brickor.
R�kna ut vinnare.
AI som kollar m�jliga platser att s�tta pj�ser.
AI som kan spela.
AI som kan spela med en strategi. (max antal brickor eller annan)
*/
public class Othello extends Canvas implements MouseListener {

private static int width = 400;
private static int height = 400;
static private int boxSize = 30;
private Color boardColor = Color.green;
private Color playerOne = Color.black;
private Color playerTwo = Color.white;
private Color[] colorArray = {boardColor, playerOne, playerTwo};
private boolean onTheFrame = true;

private int[][] board = new int[8][8];

public Othello() {
for(int i=0; i<8; i++)
for (int j=0;j<8;j++)
board[i][j] = 0;

board[3][3] = 1;
board[3][4] = 2;
board[4][3] = 2;
board[4][4] = 1;
addMouseListener(this);
}

public void paint(Graphics g) {
int sizeX = width/8-2;
int sizeY = height/8-2;
g.setColor(Color.GRAY);
for (int i=0; i<8; i++) {
for(int j=0; j<8; j++) {
int posX = i*width/8+1;
int posY = j*height/8+1;

if(board[i][j] == 1) {
g.setColor(playerOne);
g.fill3DRect(posX, posY, sizeX, sizeY, true);

}
else if (board[i][j] == 2) {
g.setColor(playerTwo);
g.fill3DRect(posX, posY, sizeX, sizeY, true);

} 
else {
g.setColor(Color.gray);
g.draw3DRect(posX, posY, sizeX, sizeY, false); 

}
}
}
}

/**
* @param args the command line arguments
*/
public static void main(String[] args) {
JFrame win = new JFrame("Battle ship, or...");
win.setSize(width+1, height+height/8);
win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Othello canvas = new Othello();
win.add( canvas );
win.setVisible(true);
}

public void mouseClicked(MouseEvent e) {
	
}

public void mousePressed(MouseEvent e) {
}

public void mouseReleased(MouseEvent e) {
}

public void mouseEntered(MouseEvent e) {
}

public void mouseExited(MouseEvent e) {

}
}