package server;

public class Client {
	
	private int moneys;
	private String nickname;
	private boolean online;
	
	public Client(String nickname) {
		this.nickname = nickname;
	}
	
	public boolean getOnline() {
		return online;
	}
}
