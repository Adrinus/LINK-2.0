package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NameGenerator {
	private String name = "";
	private List<String> first = new ArrayList<String>();
	private List<String> last = new ArrayList<String>();
	private List<String> prefix = new ArrayList<String>();
	private List<String> suffix = new ArrayList<String>();
	public String NameGenerator(String kind) throws FileNotFoundException{
		Scanner firstNames = new Scanner(new File("src/util/Names/first.txt"));
		while(firstNames.hasNext()){
			first.add(firstNames.next());
		}
		firstNames.close();
		Scanner lastNames = new Scanner(new File("src/util/Names/last.txt"));
		while(lastNames.hasNext()){
			last.add(lastNames.next());
		}
		lastNames.close();
		Scanner prefixes = new Scanner(new File("src/util/Names/prefix.txt"));
		while(prefixes.hasNext()){
			prefix.add(prefixes.next());
		}
		prefixes.close();
		Scanner suffixes = new Scanner(new File("src/util/Names/suffix.txt"));
		while(suffixes.hasNext()){
			suffix.add(suffixes.next());
		}
		suffixes.close();
		if(kind.equals("person")){
			name = person();
		}
		if(kind.equals("comapny")){
			name = company();
		}
		return name;
	}
	//Generates a name for a company, 
	//needs to be appended with the type of company (Bank, Corporation, Industries...etc.)
	private String company(){
	String name = "";
	int index = ThreadLocalRandom.current().nextInt(prefix.size());
	int index2 = ThreadLocalRandom.current().nextInt(suffix.size());
	return name + prefix.get(index) + suffix.get(index2);
	}
	//Generates a name for a person
	private String person(){
	String name = "";
	int index = ThreadLocalRandom.current().nextInt(first.size());
	int index2 = ThreadLocalRandom.current().nextInt(last.size());
	return name + first.get(index) + " " + last.get(index2);
	}
}