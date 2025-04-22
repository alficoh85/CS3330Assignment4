package hw4.maze;

import java.util.ArrayList;

/** The Row class contains a row of Cell objects. */
public class Row {
	private ArrayList<Cell> cells;
	
	/** Parameterized constructor, creates a Row object
	 * @param cells - The list of cells to make into a row */
	public Row(ArrayList<Cell> cells) {
		this.setCells(cells);
	}

	/** Accessor method for cells
	 * @return The ArrayList of Cell objects in the row */
	public ArrayList<Cell> getCells() {
		return cells;
	}

	/** Mutator method for cells
	 * @param cells - The ArrayList of Cell objects to set as the new row */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	@Override
	public String toString() {
		return "Row [cells=" + cells + "]";
	}
}
