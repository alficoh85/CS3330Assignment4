package hw4.game;

import java.util.ArrayList;

import hw4.maze.*;
import hw4.player.*;

public class Game {
    private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public Game(int size) {
        this.grid = Grid.createRandomGrid(size);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public boolean play(Movement move, Player player) {
        if (move == null || player == null || grid == null) return false;

        ArrayList<Row> rows = grid.getRows();
        Row row = player.getCurrentRow();
        Cell cell = player.getCurrentCell();
        int rowIndex = rows.indexOf(row);
        int colIndex = row.getCells().indexOf(cell);

        try {
            switch (move) {
                case UP:
                    if (cell.getUp() == CellComponents.APERTURE) {
                        Row newRow = rows.get(rowIndex - 1);
                        player.moveTo(newRow, newRow.getCells().get(colIndex));
                        return true;
                    }
                    break;
                case DOWN:
                    if (cell.getDown() == CellComponents.APERTURE) {
                        Row newRow = rows.get(rowIndex + 1);
                        player.moveTo(newRow, newRow.getCells().get(colIndex));
                        return true;
                    }
                    break;
                case LEFT:
                    if (cell.getLeft() == CellComponents.EXIT) {
                        player.moveTo(null, null); // escape success
                        return true;
                    } else if (cell.getLeft() == CellComponents.APERTURE) {
                        player.moveTo(row, row.getCells().get(colIndex - 1));
                        return true;
                    }
                    break;
                case RIGHT:
                    if (cell.getRight() == CellComponents.APERTURE) {
                        player.moveTo(row, row.getCells().get(colIndex + 1));
                        return true;
                    }
                    break;
            }
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return false;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Game [grid=" + grid + "]";
    }

    public Grid createRandomGrid(int size) {
        return Grid.createRandomGrid(size);
    }
    
    // Make displayBoard method to print the grid visualization
    //Add boolean to detect if you have won and update play method
}