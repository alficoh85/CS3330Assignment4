package hw4.player;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Row;

public class Player {
    private Row currentRow;
    private Cell currentCell;

    public Player(Row row, Cell cell) {
        this.currentRow = row;
        this.currentCell = cell;
    }

    public Row getCurrentRow() {
        return currentRow;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

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