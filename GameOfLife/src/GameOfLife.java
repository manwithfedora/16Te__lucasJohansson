
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameOfLife {

	private int worldWidth = 40;
	private int worldHeight = 20;
	private char[][] world = new char[worldWidth][worldHeight];

	public GameOfLife() {
		initWorld();
		setSeed();
		startGame();
	}

	private void initWorld() {
		for (int i = 0; i < worldWidth; i++) {
			for (int j = 0; j < worldHeight; j++) {
				world[i][j] = '.';
			}
		}
	}

	private void setSeed() {
		for (int i = 0; i < worldWidth; i++) {
			for (int j = 0; j < worldHeight; j++) {
				if (Math.random() < 0.2) {
					world[i][j] = 'X';
				}
			}
		}
	}

	private int checkSurroundings(int xPos, int yPos) {

		int countNeighbours = 0;
		for (int x = xPos - 1; x <= xPos + 1; x++) {
			for (int y = yPos - 1; y <= yPos + 1; y++) {
				if (!(x == xPos && y == yPos)) {
					try {
						if (world[x][y] == 'X') {
							countNeighbours++;
						}
					} catch (Exception ex) {

					}
				}
			}
		}
		return countNeighbours;

	}

	private void updateWorld() {

		char[][] newWorld = new char[worldWidth][worldHeight];

		int border = 0;

		for (int i = 0 + border; i < worldWidth - border; i++) {
			for (int j = 0 + border; j < worldHeight - border; j++) {
				newWorld[i][j] = '.';

				int neighbours = checkSurroundings(i, j);

				if (world[i][j] == 'X') {

					if (neighbours < 2) {
						newWorld[i][j] = '.';
					}
					if (neighbours >= 2 && neighbours <= 3) {
						newWorld[i][j] = 'X';
					}
					if (neighbours > 3) {
						newWorld[i][j] = '.';
					}
				}
				if (neighbours == 3 && world[i][j] == '.') {
					newWorld[i][j] = 'X';
				}
			}
		}
		for (int i = 0; i < worldWidth; i++) {
			for (int j = 0; j < worldHeight; j++) {
				world[i][j] = newWorld[i][j];
			}
		}
	}

	private void printWorld() {
		System.out.println("=========================================");
		for (int i = 0; i < this.worldHeight; i++) {
			for (int j = 0; j < this.worldWidth; j++) {
				System.out.print(world[j][i]);
			}
			System.out.println();
		}
	}

	private void startGame() {
		printWorld();
		while (true) {
			try {
				Thread.sleep(1000);
				updateWorld();
				printWorld();
			} catch (InterruptedException ex) {
				Logger.getLogger(GameOfLife.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		new GameOfLife();
	}

}