import javax.swing.JFrame;

/*
 * MineSweeper tutorial som anv�ndes:)
 *  https://www.youtube.com/watch?v=dMFlS9tVO3c
 */

public class MS {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        Sweep sw = new Sweep();
        sw.setExtendedState(JFrame.MAXIMIZED_BOTH);
       //sw.setVisable(); 
        //setVisable ska det vara, men d� funkar det inte utan att jag �ndrar mer.
        sw.show();
    }
}