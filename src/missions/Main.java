package missions;

public class Main {
	
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.Random;
	import java.util.Scanner;

	public class NameGenerator {

	 
	 public String getRandomStringFromFile(File f) throws FileNotFoundException {
	  Scanner sc = new Scanner(F);
	  ArrayList<String> strings = new ArrayList<String>();
	  
	  while (sc.hasNext()) {
	   strings.add(sc.nextLine());
	  }
	  
	  Random rand = new Random();
	  int index = rand.nextInt(strings.size());
	  
	  return strings.get(index);
	 }
	 
	 //Generates a name for a company, 
	 //needs to be appended with the type of company (Bank, Corporation, Industries...etc.)
	 public String companyName(){
	 String name = "";
	 int index = getRandomStringFromFile(firstName);
	 int index2 = ThreadLocalRandom.current().nextInt(suffix.size());
	 
	 return name + prefix.get(index) + suffix.get(index2);
	 }
	 
	 //Generates a name for a person
	 public String personName(){
	 String name = "";
	 int index = ThreadLocalRandom.current().nextInt(first.size());
	 int index2 = ThreadLocalRandom.current().nextInt(last.size());
	 
	 return name + first.get(index) + " " + last.get(index2);
	 }
	}
	
	 public static void main(String[] args) {
		 
		 	NameGenerator ng = new NameGenerator() {
		 		String string = ng.getRandomStringFromFile(file);
		 	}

		 }
}
