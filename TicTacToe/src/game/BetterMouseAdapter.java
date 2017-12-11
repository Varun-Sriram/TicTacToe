package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import game.Player.Shape;

public class BetterMouseAdapter extends MouseAdapter {
	private TicTacToeGrid ref;
	private Tile[][] gridRef;
	private int turnCount;
	
	public BetterMouseAdapter(TicTacToeGrid ref, Tile[][] gridRef) {
		this.ref = ref;
		this.gridRef = gridRef;
		this.turnCount = 0;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		Tile grab = null;
		for (Tile[] tilesRow : gridRef) {
			//cheap way to iterate over the last bit of the for loop if the tile touched has been found
			if (grab != null) {
				continue;
			}
			
			for (Tile t : tilesRow) {
				//cheap way to iterate over the last bit of the for loop if the tile touched has been found
				if (grab != null) {
					continue;
				}
				
				int xMin = t.getWidthRange()[0];
				int xMax = t.getWidthRange()[1];
				int yMin = t.getHeightRange()[0];
				int yMax = t.getHeightRange()[1];
				
				if (e.getX() >= xMin && e.getX() <= xMax && e.getY() >= yMin && e.getY() <= yMax) {
					grab = t;
					
					//check for re-writing values = do nothing if so
					if (grab.isMarked()) {
						return;
					}
					
					if (turnCount == 0) {
						//first player
						grab.mark(new Player(Shape.X));
						turnCount++;
					} else {
						//second player
						grab.mark(new Player(Shape.CIRCLE));
						turnCount--;
					}
				}
			}
		}
		
		//repaint the canvas
		ref.repaint();
	}
}
