import javax.swing.JFrame;

/*
 * MineSweeper tutorial som användes:)
 *  https://www.youtube.com/watch?v=dMFlS9tVO3c
 */

public class MS {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        Sweep sw = new Sweep();
        sw.setExtendedState(JFrame.MAXIMIZED_BOTH);
       //sw.setVisable(); 
        //setVisable ska det vara, men då funkar det inte utan att jag ändrar mer.
        sw.show();
    }
}