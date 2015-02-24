package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class NameGenerator {
	private File firstFile = new File("first.txt");
	private File lastFile = new File("last.txt");
	private String name = "";
	private List<String> first = new ArrayList<String>();
	private List<String> last = new ArrayList<String>();
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
		if(kind == "person"){
			name = person();
		}
		return name;
	}
	private String person(){
	//Generate number between 0-size of list
	String name = "";
	int index = ThreadLocalRandom.current().nextInt(first.size());
	int index2 = ThreadLocalRandom.current().nextInt(last.size());
	return name + first.get(index) + " " + last.get(index2);
	}
}