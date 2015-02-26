package gameplay;

import gameplay.Network.AddressManager;
import gameplay.Network.Mainframe;
import gameplay.Network.PublicAccess;
import gameplay.Network.Server;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import data.Archives;
import util.NameGenerator;
import util.Rand;

public class Corporation {
	private String name = "";
	private List<Server> servers;
	private String kind = "";
	
	
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
		this.kind = kind;
		this.servers = new ArrayList<Server>();
	}
	
	/**
	 * Returns the Name of the Corporation
	 * @return String
	 */
	public String getName(){
		
		return this.name;
	}
	
	/**
	 * Sets the Corporation's Name
	 * @param name String
	 */
	public void setName(String name){
		
		this.name = name;
	}
	
	/**
	 * Returns the list of Mainframes
	 * @return List<Mainframe>
	 */
	public List<Server> getServers(){
		
		return this.servers;
	}
	
	/**
	 * Adds a Mainframe to the list of Mainframes
	 * @param mainframe
	 */
	public void addServer(Server server){
		
		this.servers.add(server);
	}
	
	/**
	 * Removes a matching mainframe from the list of mainframes
	 * @param mainframe
	 */
	public void removeServer(Server server){
		
		this.servers.remove(server);
	}
	
	/**
	 * Makes a Corporation, populates its netowrk with servers, and fills those servers with random files.
	 * @param kind  String eg: ("Industries", "Research"...etc.)
	 * @param am    Global AddressManager
	 * @return Corporation 
	 */
	public static Corporation makeCorporation(String kind, AddressManager am){
		
		Corporation corp = new Corporation(kind);
		Mainframe mainframe = new Mainframe(corp,am);
		for(int i=0 ; i<5 ; i++){
			Archives arch = new Archives(Rand.range(0,5),corp);
			mainframe.addData(arch);
		}
		@SuppressWarnings("unused")
		PublicAccess publicAccess = new PublicAccess(corp,am);
		return corp;
	}

	public String getKind() {
		return this.kind;
	}
}
