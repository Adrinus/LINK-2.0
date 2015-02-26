package data;

import java.util.ArrayList;
import java.util.List;

public class MemoryBank {
	private int capacity = 10;
	private List<Data> contents = new ArrayList<Data>();
	private int free = 10;
	
	public MemoryBank(int capacity){
		this.capacity = capacity;
		this.free = capacity;
	}
	
	/**
	 * Adds a file to the Memory Bank and Calculates the free space.
	 * @param data
	 */
	public void addData(Data data){
		
		this.contents.add(data);
		this.setFree(this.getFree() - data.getSize());
	}
	
	/**
	 * Finds and Removes a matching File from the Memory Banks
	 * @param data
	 */
	public void removeData(Data data){
		
		for(Data dat : this.contents){
			if(data.equals(dat)){
				this.setFree(this.getFree() + data.getSize());
				this.contents.remove(data);
			}
		}
	}
	
	/**
	 * Returns the Total Capacity in GigaQuads the MemoryBank holds
	 * @return int
	 */
	public int getCapacity(){
		
		int capacity = this.capacity;
		
		return capacity;
	}
	
	/**
	 * Sets the Total Capacity in GigaQuads for the MemoryBank and updates the free space
	 * @param capacity
	 */
	public void setCapacity(int capacity){
		
		this.capacity = capacity;
		int total = this.getUsed();
		this.setFree(this.getCapacity() - total);
	}
	
	/**
	 * Returns the amount of Free Space in the Memory Bank
	 * @return int
	 */
	public int getFree(){
		
		int free = this.free;
		
		return free;
	}
	
	/**
	 * Sets the amount of free space in the Memory Banks
	 * @param free
	 */
	public void setFree(int free){
		
		this.free = free;
	}
	
	/**
	 * Returns a list of all Data on the MemoryBank
	 * @return List<Data>
	 */
	public List<Data> getContents(){
		return this.contents;
	}
	
	/**
	 * Returns the amount of capacity currently in use.
	 * @return int
	 */
	public int getUsed(){
		int used = 0;
		for(Data d:contents){
			used = used + d.getSize();
		}
		return used;
	}
}
