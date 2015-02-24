package agents;

public class Agent {
	private String name;
	private boolean online;
	
	public Agent(String name, boolean online) {
		this.name = name;
		this.online = online;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getOnline() {
		return online;
	}
	
	public void setOnline(boolean online) {
		this.online = online;
	}
}
