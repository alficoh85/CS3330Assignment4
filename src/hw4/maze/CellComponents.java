package hw4.maze;

import java.util.Random;

/**
 * This is an enum with three cell components: wall, aperture, and exit.
 */
public enum CellComponents {
	WALL, APERTURE, EXIT;

	public static CellComponents randomWallOrAperture() {
		Random random = new Random();
		boolean randBoolean = random.nextBoolean();
		if (randBoolean == true) {
			return WALL;
		}
		else {
			return APERTURE;
		}
	}
}