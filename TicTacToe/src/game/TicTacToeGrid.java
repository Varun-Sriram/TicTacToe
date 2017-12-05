package game;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

public class TicTacToeGrid extends JComponent {
	private static final long serialVersionUID = 0L;
	
	private Tile[][] grid;
	private final int ROWS = 3;
	private final int COLS = 3;

	public TicTacToeGrid() {
		grid = new Tile[ROWS][COLS];
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				grid[row][col] = new Tile(row, col);
			}
		}
		
		this.setPreferredSize(new Dimension(800, 600));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintGrid(g);
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
	
	//...
}
