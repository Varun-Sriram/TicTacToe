package game;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

import game.Player.Shape;

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
		determineWinnerAndOutput();
		determineDraw();
	}
	
	/**
	 *	Check for draw if there are no winners.
	 */
	private void determineDraw() {
		boolean atLeastOneEmpty = false;
		
		for (Tile[] tilesRow : grid) {
			for (Tile t : tilesRow) {
				if (t.getPlayer() == null) {
					atLeastOneEmpty = true;
				}
			}
		}
		
		if (atLeastOneEmpty) {
			return;
		}
		
		System.out.println("It's a draw!");
		System.exit(0);
	}
	
	/**
	 * State machine method to determining winner, since it's only necessary to test 8 ways to get all possibilities.
	 */
	private void determineWinnerAndOutput() {			
		//left column (1)
		if (grid[0][0].getPlayer() != null && grid[0][1].getPlayer() != null && grid[0][2].getPlayer() != null) {
			if (grid[0][0].getPlayer().getShape() == Shape.X 
					&& grid[0][1].getPlayer().getShape() == Shape.X
					&& grid[0][2].getPlayer().getShape() == Shape.X) {
				System.out.println("X is the winner!");
				System.exit(0);
			}
			
			if (grid[0][0].getPlayer().getShape() == Shape.CIRCLE
					&& grid[0][1].getPlayer().getShape() == Shape.CIRCLE
					&& grid[0][2].getPlayer().getShape() == Shape.CIRCLE) {
				System.out.println("O is the winner!");
				System.exit(0);
			}	
		}
		
		//middle column (2)
		if (grid[1][0].getPlayer() != null && grid[1][1].getPlayer() != null && grid[1][2].getPlayer() != null) {
			if (grid[1][0].getPlayer().getShape() == Shape.X && 
					grid[1][1].getPlayer().getShape() == Shape.X &&
					grid[1][2].getPlayer().getShape() == Shape.X) {
				System.out.println("X is the winner!");
				System.exit(0);
			}
			
			if (grid[1][0].getPlayer().getShape() == Shape.CIRCLE && 
					grid[1][1].getPlayer().getShape() == Shape.CIRCLE &&
					grid[1][2].getPlayer().getShape() == Shape.CIRCLE) {
				System.out.println("O is the winner!");
				System.exit(0);
			}
		}
		
		//right column (3)
		if (grid[2][0].getPlayer() != null && grid[2][1].getPlayer() != null && grid[2][2].getPlayer() != null) {
			if (grid[2][0].getPlayer().getShape() == Shape.X && 
					grid[2][1].getPlayer().getShape() == Shape.X &&
					grid[2][2].getPlayer().getShape() == Shape.X) {
				System.out.println("X is the winner!");
				System.exit(0);
			}
			
			if (grid[2][0].getPlayer().getShape() == Shape.CIRCLE && 
					grid[2][1].getPlayer().getShape() == Shape.CIRCLE &&
					grid[2][2].getPlayer().getShape() == Shape.CIRCLE) {
				System.out.println("O is the winner!");
				System.exit(0);
			}
		}		
		
		
		//top row (4)
		if (grid[0][0].getPlayer() != null && grid[1][0].getPlayer() != null && grid[2][0].getPlayer() != null) {
			if (grid[0][0].getPlayer().getShape() == Shape.X &&
					grid[1][0].getPlayer().getShape() == Shape.X &&
					grid[2][0].getPlayer().getShape() == Shape.X) {
				System.out.println("X is the winner!");
				System.exit(0);
			}
			
			if (grid[0][0].getPlayer().getShape() == Shape.CIRCLE &&
					grid[1][0].getPlayer().getShape() == Shape.CIRCLE &&
					grid[2][0].getPlayer().getShape() == Shape.CIRCLE) {
				System.out.println("O is the winner!");
				System.exit(0);
			}
		}
		
		//middle row (5)
		if (grid[0][1].getPlayer() != null && grid[1][1].getPlayer() != null && grid[2][1].getPlayer() != null) {
			if (grid[0][1].getPlayer().getShape() == Shape.X &&
					grid[1][1].getPlayer().getShape() == Shape.X &&
					grid[2][1].getPlayer().getShape() == Shape.X) {
				System.out.println("X is the winner!");
				System.exit(0);
			}
			
			if (grid[0][1].getPlayer().getShape() == Shape.CIRCLE &&
					grid[1][1].getPlayer().getShape() == Shape.CIRCLE &&
					grid[2][1].getPlayer().getShape() == Shape.CIRCLE) {
				System.out.println("O is the winner!");
				System.exit(0);
			}
		}
		
		//bottom row (6)
		if (grid[0][2].getPlayer() != null && grid[1][2].getPlayer() != null && grid[2][2].getPlayer() != null) {
			if (grid[0][2].getPlayer().getShape() == Shape.X &&
					grid[1][2].getPlayer().getShape() == Shape.X &&
					grid[2][2].getPlayer().getShape() == Shape.X) {
				System.out.println("X is the winner!");
				System.exit(0);
			}
			
			if (grid[0][2].getPlayer().getShape() == Shape.CIRCLE &&
					grid[1][2].getPlayer().getShape() == Shape.CIRCLE &&
					grid[2][2].getPlayer().getShape() == Shape.CIRCLE) {
				System.out.println("O is the winner!");
				System.exit(0);
			}
		}
		
		//diagonal down-right (7)
		if (grid[0][0].getPlayer() != null && grid[1][1].getPlayer() != null && grid[2][2].getPlayer() != null) {
			if (grid[0][0].getPlayer().getShape() == Shape.X && 
					grid[1][1].getPlayer().getShape() == Shape.X &&
					grid[2][2].getPlayer().getShape() == Shape.X) {
				System.out.println("X is the winner!");
				System.exit(0);
			}
			
			if (grid[0][0].getPlayer().getShape() == Shape.CIRCLE && 
					grid[1][1].getPlayer().getShape() == Shape.CIRCLE &&
					grid[2][2].getPlayer().getShape() == Shape.CIRCLE) {
				System.out.println("O is the winner!");
				System.exit(0);
			}
		}
		
		//diagonal down-left (8)
		if (grid[2][0].getPlayer() != null && grid[1][1].getPlayer() != null && grid[0][2].getPlayer() != null) {
			if (grid[2][0].getPlayer().getShape() == Shape.X && 
					grid[1][1].getPlayer().getShape() == Shape.X &&
					grid[0][2].getPlayer().getShape() == Shape.X) {
				System.out.println("X is the winner!");
				System.exit(0);
			}
			
			if (grid[2][0].getPlayer().getShape() == Shape.CIRCLE && 
					grid[1][1].getPlayer().getShape() == Shape.CIRCLE &&
					grid[0][2].getPlayer().getShape() == Shape.CIRCLE) {
				System.out.println("O is the winner!");
				System.exit(0);
			}
		}
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
					drawMark(g, t, t.getWidthRange()[0], t.getHeightRange()[0], t.getWidth(), t.getHeight());
				}
			}
		}
	}

	private void drawMark(Graphics g, Tile tileRef, int leftCornerX, int leftCornerY, int width, int height) {
		if (tileRef.getPlayer().getShape() == Shape.CIRCLE) {
			g.drawOval(leftCornerX + (width / 4), leftCornerY + (height / 4), width / 2, height / 2);			
		} else {
			//diagonal down right
			g.drawLine(leftCornerX + (width / 4), leftCornerY + (height / 4), leftCornerX + 3 * (width / 4), leftCornerY + 3 * (height / 4));
			//diagonal down left
			g.drawLine(leftCornerX + 3 * (width / 4), leftCornerY + (height / 4), leftCornerX + (width / 4), leftCornerY + 3 * (height / 4));
		}
	}
}
