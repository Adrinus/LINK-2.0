package data;

public class Archives extends Data{
	private int encryption = 0;
	
	public Archives(int encryption){
		this.encryption = encryption;
		this.setSize(this.getSize()*this.encryption);
	}
	
	/**
	 * Returns the current level of Encryption (1-5)
	 * @return int
	 */
	public int getEncryption(){
		int level = this.encryption;
		return level;
	}
	
	/**
	 * Sets the level of Encryption (1-5)
	 * @param level
	 */
	public void setEncryption(int level){
		this.encryption = level;
	}
		
	
}
