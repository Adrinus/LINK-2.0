package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NameGenerator {
	private File firstName = new File("resources/Names/first.txt");
	private File lastName = new File("resources/Names/last.txt");
	private File prefixName = new File("resources/Names/prefix.txt");
	private File suffixName = new File("resources/Names/suffix.txt");
 
	private String getRandomStringFromFile(File f) throws FileNotFoundException{
		Scanner sc = new Scanner(f);
		ArrayList<String> strings = new ArrayList<String>();
  
		while (sc.hasNext()) {
			strings.add(sc.nextLine());
		}
		sc.close();
		Random rand = new Random();
		int index = rand.nextInt(strings.size());
		
		return strings.get(index);
	}
	
	/**
	 * Generates a random company name
	 * @return String example: ("SuperMedia")
	 * @throws FileNotFoundException
	 */
	public String getCompanyName() throws FileNotFoundException{
	String index = getRandomStringFromFile(prefixName);
	String index2 = getRandomStringFromFile(suffixName);
	String name = index + index2;
	
	return name;
	}
	
	/**
	 * Generates a random person's name
	 * @return String example: ("John Doe")
	 * @throws FileNotFoundException
	 */
	public String getPersonName() throws FileNotFoundException{
	String index = getRandomStringFromFile(firstName);
	String index2 = getRandomStringFromFile(lastName);
	String name = index + " " + index2;
	return name;
	}
}