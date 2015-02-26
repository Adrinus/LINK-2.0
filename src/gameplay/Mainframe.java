package gameplay;

import util.Rand;
import gameplay.Network.AddressManager;
import data.Data;
import data.MemoryBank;

public class Mainframe extends Server{
	private MemoryBank mb;
	
	/**
	 * Must be fed a Corporation and the global Address Manager
	 * @param corp   Corporation
	 * @param am     AddressManager
	 */
	public Mainframe(Corporation corp, AddressManager am){
		super(corp);
		this.setName(corp.getName() + " Mainframe");
		corp.addServer(this);
		this.mb = new MemoryBank(255);
		this.setAddress(am.randomAddress());
		this.setMonitor(Rand.range(1, 3));
		this.setPassword(true);
	}
	
	/**
	 * Returns the MemoryBank of the Mainframe
	 * @return MemoryBank
	 */
	public MemoryBank getMemoryBank(){
		return this.mb;
	}
	
	/**
	 * Adds Data to the MemoryBank of the Mainframe
	 * @param data
	 */
	public void addData(Data data){
		this.mb.addData(data);
	}
	
	/**
	 * Removes matching Data from the Mainframe's MemoryBank
	 * @param data
	 */
	public void removeData(Data data){
		for(Data dat : mb.getContents()){
			if(data.equals(dat)){
				mb.removeData(dat);
			}
		}
	}
}
