package gameplay.Network;

import java.util.ArrayList;
import java.util.List;

import util.Rand;
import gameplay.Corporation;

public class InternalServices extends Server{
	
	private List<String> links;

	public InternalServices(Corporation corp, AddressManager am) {
		super(corp);
		this.setName(corp.getName() + " Internal Services");
		this.setAddress(am.randomAddress());
		this.setMonitor(Rand.range(2, 3));
		this.setPassword(true);
		this.links = new ArrayList<String>();
		for(Server s:corp.getServers()){
			links.add(s.getAddress());
		}
		corp.addServer(this);
		
	}
	
	/**
	 * Removes matching address from list of links
	 * @param address
	 */
	public void removeLink(String address){
		for(String s : this.links){
			if(address.equals(s)){
				this.links.remove(s);
			}
		}
	}
	
	/**
	 * Adds address to list of links
	 * @param address
	 */
	public void addLink(String address){
		this.links.add(address);
	}
	
	/**
	 * Returns a list of addresses
	 * @return List<String>
	 */
	public List<String> getLinks(){
		return this.links;
	}

}
