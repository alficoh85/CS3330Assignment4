package hw4.maze;

import java.util.ArrayList;
import java.util.random.*;

public class Grid {
	private ArrayList<Row> rows;

    public Grid(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Grid [rows=" + rows + "]";
    }

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
                    left = (i == exitRow) ? CellComponents.EXIT : CellComponents.randomExceptExit();
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