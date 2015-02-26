package data;

public class Software extends Data{
	private int cost = 0;
	protected int level = 0;
	
	public Software(int level) {
		this.level = level;
	}

	/**
	 * Gets the Cost in Credits for the Software
	 * @return
	 */
	public int getCost(){
		int c = this.cost;
		return c;
	}
	
	public void setCost(int cost){
		this.cost = cost;
	}
	
	/**
	 * Returns Software Level
	 * @return int
	 */
	public int getLevel(){
		int lvl = this.level;
		return lvl;
	}
	
	/**
	 * Set the Software Level
	 * @param lvl
	 */
	public void setLevel(int lvl){
		this.level = lvl;
	}
}
