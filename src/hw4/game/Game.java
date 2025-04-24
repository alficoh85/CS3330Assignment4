package hw4.game;

import java.util.ArrayList;

import hw4.maze.*;
import hw4.player.*;

/** The Game class makes a new game with a given grid. */
public class Game {
    private Grid grid;
    private boolean escaped;

    /** Parameterized constructor, creates a Game object with a given grid
     * @param grid - The grid to use as the game board */
    public Game(Grid grid) {
        this.grid = grid;
        escaped = false;
    }

    /** Parameterized constructor, creates a Game object with a randomly-generated grid of a given size
     * @param size - The size of the grid to use to start the game */
    public Game(int size) {
        this.grid = Grid.createRandomGrid(size);
        escaped = false;
    }

    /** Accessor method for grid
     * @return The grid currently being used for */
    public Grid getGrid() {
        return grid;
    }
    
    /** Accessor method for escaped
     * @return A boolean telling whether or not the exit has been reached or not */
    public boolean isEscaped() {
		return escaped;
	}

    /** Mutator method for grid
     * @param grid - The grid to set as the new grid for the game
     */
	public void setGrid(Grid grid) {
        this.grid = grid;
    }

	/** Moves a player up, down, left, or right in the grid if possible
	 * @param move - The direction to move, must use the Movement enum
	 * @param player - The player to move in the grid
	 * @return A boolean, true if the movement was successful, and false if the movement was unsuccessful */
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
                        escaped = true;
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

    /** Creates a grid of a given size with rows of Cell objects that are randomly generated
     * @param size - The size of the grid to generate
     * @return A grid made of rows of randomly-generated Cell objects with an exit on the leftmost column */
    public Grid createRandomGrid(int size) {
        return Grid.createRandomGrid(size);
    }
    
    /** A method that returns a string with a visualized version of the grid the game is being played on
     * @param player - The player playing on the grid
     * @return A String with a visualized version of the grid the game is being played on*/
    public String getGridVisualization(Player player) {
    	String visualization = "";
    	if (grid == null) {
    		visualization = null;
    	}
    	else {
    		ArrayList <Row> rows = grid.getRows();
    		for (Row row : rows) {
    			ArrayList<Cell> cells = row.getCells();
    			for (Cell cell : cells) {
    				if (player.getCurrentCell() == cell) {
    					visualization = visualization + "A ";
    				}
    				else {
    					if (cell.getLeft() == CellComponents.EXIT) {
    						visualization = visualization + "E ";
    					}
    					else {
    						visualization = visualization + "S ";
    					}
    				}
    			}
    			visualization = visualization + "\n";
    		}
    	}
		return visualization;
    }
}

