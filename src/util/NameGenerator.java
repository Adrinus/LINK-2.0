package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NameGenerator {
	private static File firstName = new File("resources/Names/first.txt");
	private static File lastName = new File("resources/Names/last.txt");
	private static File prefixName = new File("resources/Names/prefix.txt");
	private static File suffixName = new File("resources/Names/suffix.txt");
	private static List<String> names = new ArrayList<String>();
 
	private static String getRandomStringFromFile(File f) throws FileNotFoundException{
		Scanner sc = new Scanner(f);
		ArrayList<String> strings = new ArrayList<String>();
  
		while (sc.hasNext()) {
			strings.add(sc.nextLine());
		}
		sc.close();
		return Rand.listString(strings);
	}
	
	/**
	 * Generates a random company name, makes sure no duplicates exist
	 * @return String example: ("SuperMedia")
	 * @throws FileNotFoundException
	 */
	public static String getCompanyName() throws FileNotFoundException{
	int left = 1;
	String name = "";
	while(left > 0){
		String index = getRandomStringFromFile(prefixName);
		String index2 = getRandomStringFromFile(suffixName);
		name = index + index2;
		if(names.isEmpty()){
			left = 0;
		}
		for(String n : names){
			if(!n.equals(name)){
				left = 0;
			}
		}
	}
	return name;
	}
	
	/**
	 * Generates a random person's name, makes sure no duplicates exist
	 * @return String example: ("John Doe")
	 * @throws FileNotFoundException
	 */
	public static String getPersonName() throws FileNotFoundException{
		int left = 1;
		String name = "";
		while(left > 0){
			String index = getRandomStringFromFile(firstName);
			String index2 = getRandomStringFromFile(lastName);
			name = index + " " + index2;
			if(names.isEmpty()){
				left = 0;
			}
			for(String n : names){
				if(!n.equals(name)){
					left = 0;
				}
			}
		}
		return name;
		}
}