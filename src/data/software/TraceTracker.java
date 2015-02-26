package data.software;

import data.Software;

public class TraceTracker extends Software{
	private boolean eta = false;
	private boolean delay = false;
	private boolean remaining = false;
	private boolean accurate = false;
	
	public TraceTracker(int level) {
		super(level);
		this.setSize(this.getSize()+((this.getLevel()/2)*this.getSize()));
		this.setEta(this.getLevel() >= 3);
		this.setDelay(this.getLevel() >= 2);
		this.setRemaining(this.getLevel() >= 4);
		this.setAccurate(this.getLevel() >= 5);
		this.setCost(500);
		this.setCost(this.getCost()*this.getLevel());
	}
	
	/**
	 * Returns true if the Tracker gives a Static Estimate of time remaining
	 * @return boolean
	 */
	public boolean isEta(){
		boolean e = this.eta;
		return e;
	}
	
	public void setEta(boolean bool){
		this.eta = bool; 
	}
	
	/**
	 * Returns true if the Tracker displays the delay of the last ping
	 * @return boolean
	 */
	public boolean isDelay(){
		boolean d = this.delay;
		return d;
	}
	
	public void setDelay(boolean bool){
		this.delay = bool; 
	}
	
	/**
	 * Returns True if the Tracker gives a rough estimate of time left until trace
	 * @return boolean
	 */
	public boolean isRemaining(){
		boolean r = this.remaining;
		return r;
	}
	
	public void setRemaining(boolean bool){
		this.remaining = bool; 
	}
	
	/**
	 * Returns true if the Tracker gives an accurate remaining time until trace
	 * @return boolean
	 */
	public boolean isAccurate(){
		boolean a = this.accurate;
		return a;
	}
	
	public void setAccurate(boolean bool){
		this.accurate = bool; 
	}
	
	
}
