package gameplay;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import util.NameGenerator;

public class Corporation {
	private String name = "";
	private List<Mainframe> mainframes;
	
	/**
	 * Makes a new Corporation with a Random Name
	 * @param kind   eg: ("Industries", "Research" ..etc.)
	 */
	public Corporation(String kind){
		try {
			this.name = NameGenerator.getCompanyName() + " " + kind;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not Found! Fuck!");
		}
		this.mainframes = new ArrayList<Mainframe>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public List<Mainframe> getMainframes(){
		return this.mainframes;
	}
	
	public void addMainframe(Mainframe mainframe){
		this.mainframes.add(mainframe);
	}
	
	public void removeMainframe(Mainframe mainframe){
		this.mainframes.remove(mainframe);
	}
}
