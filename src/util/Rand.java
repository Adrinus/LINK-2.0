package util;

import java.util.List;
import java.util.Random;

public class Rand {
	static Random rand = new Random();
	
	/**
	 * Returns a random number between min and max, inclusive.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 */
	public static int range(int min, int max) {

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	
	public static String listString(List<String> list){
		int index = rand.nextInt(list.size());
		return list.get(index);
	}
}
