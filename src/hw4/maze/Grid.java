package hw4.maze;

import java.util.ArrayList;
import java.util.Random;

/** The Grid class creates a grid using rows of cells. */
public class Grid {
    private ArrayList<Row> rows;

    /** Parameterized constructor, creates a Row object
     * @param rows - The list of rows to make into a grid */
    public Grid(ArrayList<Row> rows) {
        this.rows = rows;
    }

    /** Accessor method for rows
     * @return An ArrayList of Row objects in the grid */
    public ArrayList<Row> getRows() {
        return rows;
    }

    /** 
     * @param rows - The ArrayList of Row objects to set as the new grid */
    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Grid [rows=" + rows + "]";
    }
    
    /** Creates a grid of a given size with rows of Cell objects that are randomly generated
     * @param size - The size of the grid to generate
     * @return A grid made of rows of randomly-generated Cell objects with an exit on the leftmost column */
    public static Grid createRandomGrid(int size) {
        if (size < 3 || size > 7) return null;

        ArrayList<Row> rows = new ArrayList<>();
        Random rand = new Random();
        int exitRow = rand.nextInt(size);

        for (int i = 0; i < size; i++) {
            ArrayList<Cell> cells = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                CellComponents left, right, up, down;

                if (j == 0) {
                    left = (i == exitRow) ? CellComponents.EXIT : CellComponents.randomWallOrAperture();
                } else {
                    left = mirror(cells.get(j - 1).getRight());
                }

                if (i == 0) {
                    up = CellComponents.randomWallOrAperture();
                } else {
                    up = mirror(rows.get(i - 1).getCells().get(j).getDown());
                }

                right = CellComponents.randomWallOrAperture();
                down = CellComponents.randomWallOrAperture();

                if (left != CellComponents.APERTURE && right != CellComponents.APERTURE
                        && up != CellComponents.APERTURE && down != CellComponents.APERTURE) {
                    switch (rand.nextInt(4)) {
                        case 0 -> left = CellComponents.APERTURE;
                        case 1 -> right = CellComponents.APERTURE;
                        case 2 -> up = CellComponents.APERTURE;
                        case 3 -> down = CellComponents.APERTURE;
                    }
                }

                cells.add(new Cell(left, right, up, down));
            }
            rows.add(new Row(cells));
        }

        return new Grid(rows);
    }
    
    private static CellComponents mirror(CellComponents neighborSide) {
        return neighborSide; 
    }
}