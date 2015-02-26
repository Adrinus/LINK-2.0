package gameplay;

import gameplay.Network.AddressManager;
import gameplay.Network.InternalServices;
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
	private static List<Corporation> corporations = new ArrayList<Corporation>();
	
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
		Corporation.addCorporation(this);
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
		InternalServices i = this.getInternalServices();
		i.addLink(server.getAddress());
	}
	
	/**
	 * Returns the current InternalServices server for the Corporation
	 * @return InternalServices
	 */
	public InternalServices getInternalServices(){
		InternalServices i = null;
		for(Server s : this.servers){
			if(s instanceof InternalServices){
				i = (InternalServices) s;
				return i;
			}
		}
		return i;
	}

	/**
	 * Removes a matching mainframe from the list of mainframes
	 * @param mainframe
	 */
	public void removeServer(Server server){
		
		this.servers.remove(server);
		for(Server s : this.servers){
			if(s instanceof InternalServices){
				InternalServices i = (InternalServices) s;
				i.removeLink(s.getAddress());
			}
		}
	}
	
	/**
	 * Makes a Corporation, populates its network with servers, and fills those servers with random files.
	 * @param kind  String eg: ("Industries", "Research"...etc.)
	 * @param am    Global AddressManager
	 * @return Corporation 
	 */
	@SuppressWarnings("unused")
	public static Corporation makeCorporation(String kind, AddressManager am){
		
		Corporation corp = new Corporation(kind);
		InternalServices internalServices = new InternalServices(corp,am);
		PublicAccess publicAccess = new PublicAccess(corp,am);
		Mainframe mainframe = new Mainframe(corp,am);
		for(int i=0 ; i<5 ; i++){
			Archives arch = new Archives(Rand.range(0,5),corp);
			mainframe.addData(arch);
		}
		return corp;
	}
	
	/**
	 * Returns the kind of Corporation
	 * @return String  eg:"Industries"
	 */
	public String getKind() {
		return this.kind;
	}
	
	/**
	 * Adds a Corporation to the list of Corporations
	 */
	public static void addCorporation(Corporation corp){
		corporations.add(corp);
	}
	
	/**
	 * Removes a matching Corporation from the list of Corporations
	 * @param corp
	 */
	public void removeCorporation(Corporation corp){
		for(Corporation c: corporations){
			if(c.equals(corp)){
				corporations.remove(c);
			}
		}
	}
	
	/**
	 * Returns the list of all Corporations
	 * @return List<Corporation>
	 */
	public static List<Corporation> getCorporations() {
		return corporations;
	}
}
