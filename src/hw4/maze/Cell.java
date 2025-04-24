package hw4.maze;

/** The Cell class creates a cell with components left, right, up, and down, which can be a wall, an aperture, 
 * or an exit. */

public class Cell {
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;
	
	/** Parameterized constructor, creates a Cell object
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

	/** Mutator method for left, sets to WALL if null
	 * @param left - Tells what component to set to the left of the cell */
	public void setLeft(CellComponents left) {
		if (left == null) {
			this.left = CellComponents.WALL;
		}
		else {
			this.left = left;
		}
	}

	/** Accessor method for right
	 * @return The cell component on the right of the cell */
	public CellComponents getRight() {
		return right;
	}

	/** Mutator method for right, sets to WALL if null
	 * @param right - Tells what component to set to the right of the cell */
	public void setRight(CellComponents right) {
		if (right == null) {
			this.right = CellComponents.WALL;
		}
		else {
			this.right = right;
		}
	}

	/** Accessor method for up
	 * @return The cell component on the north part of the cell */
	public CellComponents getUp() {
		return up;
	}

	/** Mutator method for up, sets to WALL if null
	 * @param up - Tells what component to set for the north part of the cell */
	public void setUp(CellComponents up) {
		if (up == null) {
			this.up = CellComponents.WALL;
		}
		else {
			this.up = up;
		}
	}

	/** Accessor method for down
	 * @return The cell component on the south part of the cell */
	public CellComponents getDown() {
		return down;
	}

	/** Mutator method for down, sets to WALL if null
	 * @param down - Tells what component to set for the south part of the cell */
	public void setDown(CellComponents down) {
		if (down == null) {
			this.down = CellComponents.WALL;
		}
		else {
			this.down = down;
		}
	}

	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
}