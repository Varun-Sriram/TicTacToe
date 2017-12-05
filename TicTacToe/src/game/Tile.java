package game;

public class Tile {
	private final int ROW;
	private final int COL;
	private final int WIDTH;
	private final int HEIGHT;
	
	public Tile(int row, int col) {
		this.ROW = row;
		this.COL = col;
		this.WIDTH = 800 / 3;
		this.HEIGHT = 600 / 3;
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public int getRow() {
		return ROW;
	}
	
	public int getCol() {
		return COL;
	}
}
