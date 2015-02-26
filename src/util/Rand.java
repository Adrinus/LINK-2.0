package util;

import java.util.Random;

public class Rand {
	/**
	 * Returns a pseudo-random number between min and max, inclusive.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 */
	public static int range(int min, int max) {

	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
