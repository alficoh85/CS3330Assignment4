package hw4.maze;

/** The Cell class creates a cell with components left, right, up, and down, which can be a wall, an aperture, 
 * or an exit. */

public class Cell {
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;
	
	/** Default constructor, creates a Cell object
	 * @param left - The cell component located on the west part of the cell
	 * @param right - The cell component located on the east part of the cell
	 * @param up - The cell component located on the north part of the cell
	 * @param down - The cell component located on the south part of the cell */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		super();
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}

	/** Accessor method for left
	 * @return The cell component on the left of the cell */
	public CellComponents getLeft() {
		return left;
	}

	/** Mutator method for left
	 * @param left - Tells what component to set to the left of the cell */
	public void setLeft(CellComponents left) {
		this.left = left;
	}

	/** Accessor method for right
	 * @return The cell component on the right of the cell */
	public CellComponents getRight() {
		return right;
	}

	/** Mutator method for right
	 * @param right - Tells what component to set to the right of the cell */
	public void setRight(CellComponents right) {
		this.right = right;
	}

	/** Accessor method for up
	 * @return The cell component on the north part of the cell */
	public CellComponents getUp() {
		return up;
	}

	/** Mutator method for up
	 * @param up - Tells what component to set for the north part of the cell */
	public void setUp(CellComponents up) {
		this.up = up;
	}

	/** Accessor method for down
	 * @return The cell component on the south part of the cell */
	public CellComponents getDown() {
		return down;
	}

	/** Mutator method for down
	 * @param down - Tells what component to set for the south part of the cell */
	public void setDown(CellComponents down) {
		this.down = down;
	}

	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
}
