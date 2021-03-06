
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameOfLifeGUI extends JFrame implements ActionListener {

	public static void main(String[] args) {
		GameOfLifeGUI gui = new GameOfLifeGUI();
	}

	/** Icon for an empty position in the pasture */

	private final ImageIcon II_EMPTY = new ImageIcon("src/empty.gif");
	private final ImageIcon II_THING = new ImageIcon("src/unknown.gif");

	/** The pasture this class should display */
	private GameOflifegraph golgraph;
	/** The grid, i.e., the field containing the images to display. */
	private JLabel[][] grid;
	/** The button for starting the simulation. */
	private JButton startButton = new JButton("Start");
	private JButton stopButton = new JButton("Stop");
	private JButton exitButton = new JButton("Exit");
	private JButton resetButton = new JButton("Reset");

	public GameOfLifeGUI() {
		golgraph = new GameOflifegraph(this);
		initGameOfLifeGUI();
	}

	private void initGameOfLifeGUI() {
		setSize(golgraph.getWidth() * 30, golgraph.getHeight() * 30);

		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		resetButton.addActionListener(this);

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1, 4));
		buttons.add(startButton);
		buttons.add(stopButton);
		buttons.add(exitButton);
		buttons.add(resetButton);

		JPanel field = new JPanel();
		field.setBackground(new Color(227, 204, 89));
		field.setLayout(new GridLayout(golgraph.getHeight(), golgraph.getWidth()));
		grid = new JLabel[golgraph.getWidth()][golgraph.getHeight()];

		for (int y = 0; y < golgraph.getHeight(); y++) {
			for (int x = 0; x < golgraph.getWidth(); x++) {
				grid[x][y] = new JLabel(II_EMPTY);
				grid[x][y].setVisible(true);
				field.add(grid[x][y]);
			}
		}

		Container display = getContentPane();
		display.setBackground(new Color(27, 204, 89));
		display.setLayout(new BorderLayout());
		display.add(field, BorderLayout.CENTER);
		display.add(buttons, BorderLayout.SOUTH);

		startButton.setEnabled(true);
		stopButton.setEnabled(false);
		resetButton.setEnabled(false);
		exitButton.setEnabled(true);

		golgraph.setSeed();
		updateAll();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			startButton.setEnabled(false);
			stopButton.setEnabled(true);
			resetButton.setEnabled(true);
			golgraph.start();
		}
		if (e.getSource() == stopButton) {
			stopButton.setEnabled(false);
			startButton.setEnabled(true);
			resetButton.setEnabled(true);
			golgraph.stop();
		}
		if (e.getSource() == exitButton) {
			System.exit(0);
		}
		if(e.getSource() == resetButton){
			golgraph.initWorld();
			golgraph.setSeed();
			updateAll();
		}
	}

	public void updateAll() {
		int width = golgraph.getWidth();
		int height = golgraph.getHeight();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				ImageIcon icon;
				char whatishere = golgraph.world[x][y];
				if (whatishere == 'X') {
					icon = II_THING;

				} else {
					icon = II_EMPTY;
				}
				grid[x][height - y - 1].setIcon(icon);
			}

		}
	}
}