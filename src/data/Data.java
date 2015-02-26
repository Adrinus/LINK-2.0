package data;

public class Data {
	private String name = "";
	private int size = 1;

	public Data(){
	}
	
	/**
	 * Get Name of Software
	 * @return String
	 */
	public String getName(){
		String nom = this.name;
		return nom;
	}
	
	/**
	 * Set Name of Software
	 * @param name String
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Get the Size in GigaQuads of a Software
	 * @return int
	 */
	public int getSize(){
		int size = this.size;
		return size;
	}
	
	/**
	 * Set Size in GigaQuads of a Software
	 * @param size
	 */
	public void setSize(int size){
		this.size = size;
	}
	
}
