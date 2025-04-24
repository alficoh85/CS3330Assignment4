package hw4.maze;

import java.util.Random;

/** This is an enum with three cell components: wall, aperture, and exit. */
public enum CellComponents {
	WALL, APERTURE, EXIT;

	/** Method to return either a wall or aperture cell component
	 * @return WALL or APERTURE */
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