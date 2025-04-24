package hw4.player;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Row;

/** The Player class created a player to play the game using Grid class. */
public class Player {
    private Row currentRow;
    private Cell currentCell;

    /** Parameterized constructor, creates a Player object
     * @param row - The row containing the current cell the player is on
     * @param cell - The cell to use as the current cell the player is on in the row the player is on */
    public Player(Row row, Cell cell) {
        this.currentRow = row;
        this.currentCell = cell;
    }

    /** Accessor method for currentRow
     * @return The row containing the cell the player is currently on */
    public Row getCurrentRow() {
        return currentRow;
    }

    /** Accessor method for currentCell
     * @return The cell the player is currently on*/
    public Cell getCurrentCell() {
        return currentCell;
    }

    /** Moves the player to a new cell in the provided row
     * @param newRow - The new row to move to
     * @param newCell - The new cell to move to */
    public void moveTo(Row newRow, Cell newCell) {
        if (newRow != null && newCell != null) {
            this.currentRow = newRow;
            this.currentCell = newCell;
        }
    }

    @Override
    public String toString() {
        return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
    }
}