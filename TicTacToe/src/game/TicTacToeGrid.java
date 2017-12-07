package game;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class TicTacToeGrid extends JComponent {
	private static final long serialVersionUID = 0L;
	
	private Tile[][] grid;
	private BetterMouseAdapter betterMouseAdapter;
	
	public static final int ROWS = 3;
	public static final int COLS = 3;
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	
	public TicTacToeGrid() {
		//fill the grid with Tile objects
		grid = new Tile[ROWS][COLS];
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				grid[row][col] = new Tile(row, col);
			}
		}
		
		// set dimensions
		this.setPreferredSize(new Dimension(800, 600));
		
		// add listeners for mouse
		this.betterMouseAdapter = new BetterMouseAdapter(this, grid);
		this.addMouseListener(betterMouseAdapter);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintGrid(g);
		paintMarks(g);
	}
	
	private void paintGrid(Graphics g) {
		for (Tile[] tilesRow : grid) {
			for (Tile t : tilesRow) {
				int height = t.getHeight();
				int width = t.getWidth();
				int row = t.getRow();
				int col = t.getCol();
				
				g.drawRect( (col) * width, (row) * height, width, height);
			}
		}
	}
	
	private void paintMarks(Graphics g) {
		for (Tile[] tilesRow : grid) {
			for (Tile t : tilesRow) {
				if (t.isMarked()) {
					drawMark(g, t.getWidthRange()[0], t.getHeightRange()[0], t.getWidth(), t.getHeight());
				}
			}
		}
	}

	private void drawMark(Graphics g, int leftCornerX, int leftCornerY, int width, int height) {
		g.drawRect(leftCornerX + (width / 4), leftCornerY + (height / 4), width / 2, height / 2);
	}
}
