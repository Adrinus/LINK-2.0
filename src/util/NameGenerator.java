package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class NameGenerator {
	private File firstFile = new File("src/util/Names/first.txt");
	private File lastFile = new File("src/util/Names/last.txt");
	private File prefixFile = new File("src/util/Names/prefix.txt");
	private File suffixFile = new File("src/util/Names/suffix.txt");
	private String name = "";
	private List<String> first = new ArrayList<String>();
	private List<String> last = new ArrayList<String>();
	private List<String> prefix = new ArrayList<String>();
	private List<String> suffix = new ArrayList<String>();
	public String NameGenerator(String kind){
		try {
			ArrayList<String> first = (ArrayList<String>) Files.readLines(firstFile, Charsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArrayList<String> last = (ArrayList<String>) Files.readLines(lastFile, Charsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArrayList<String> prefix = (ArrayList<String>) Files.readLines(prefixFile, Charsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArrayList<String> suffix = (ArrayList<String>) Files.readLines(suffixFile, Charsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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