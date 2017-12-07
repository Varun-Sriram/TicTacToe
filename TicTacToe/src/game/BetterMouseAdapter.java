package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BetterMouseAdapter extends MouseAdapter {
	private TicTacToeGrid ref;
	private Tile[][] gridRef;
	
	public BetterMouseAdapter(TicTacToeGrid ref, Tile[][] gridRef) {
		this.ref = ref;
		this.gridRef = gridRef;
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
				}
			}
		}
		
		//set the tile to have it being marked
		grab.setMarked(true);
		
		//repaint the canvas
		ref.repaint();
	}
}