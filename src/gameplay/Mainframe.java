package gameplay;

import gameplay.Network.Address;
import gameplay.Network.AddressManager;
import data.Data;
import data.MemoryBank;

public class Mainframe {
	private String name = "";
	private MemoryBank mb;
	private Corporation corp;
	private Address address;
	
	/**
	 * Must be fed a Corporation and the global Address Manager
	 * @param corp   Corporation
	 * @param am     AddressManager
	 */
	public Mainframe(Corporation corp, AddressManager am){
		this.corp = corp;
		this.name = corp.getName() + " Mainframe";
		corp.addMainframe(this);
		this.mb = new MemoryBank(255);
		this.address = am.randomAddress();
	}
	
	public Address getAddress(){
		return this.address;
	}
	
	public void setAddress(Address address){
		this.address = address;
	}
	
	public MemoryBank getMemoryBank(){
		return this.mb;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void addData(Data data){
		this.mb.addData(data);
	}
	
	public void removeData(Data data){
		for(Data dat: mb.getContents());
	}
}
